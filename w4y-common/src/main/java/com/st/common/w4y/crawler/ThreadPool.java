package com.st.common.w4y.crawler;

import java.util.LinkedList;

/**
 * Created by ruantianbo on 2017/11/13.
 */
public class ThreadPool implements Pool {

    private boolean isShutDown = false;
    private LinkedList<Executor> pool ;
    public ThreadPool(int size) {
        isShutDown = false;
        pool = new LinkedList<Executor>();
        for(int i=0;i<size;i++){
            Executor executor = new ExecutorImpl();
            pool.add(executor);//add it to pool

            ((ExecutorImpl)executor).start();//先启动，在run方法中使用lock.wait等待启动通知
        }
    }

    public Executor getExecutor() {
        Executor ret = null;
        synchronized (pool){
            if(pool.size()>0){
                ret = pool.removeFirst();
            }else{
                try {
                    pool.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ret = pool.removeFirst();
            }
        }
        return ret;
    }

    public void destroy() {
        synchronized (pool){
            isShutDown = true;
            StringBuffer sb = new StringBuffer();
            for (Executor e : pool){
                ExecutorImpl executorImpl = ((ExecutorImpl)e);
                ((ExecutorImpl)e).startTask();
                sb.append("Thread "+executorImpl.getId()+" has bean excuted "+ executorImpl.getCount()+" times").append("\n");
            }
            System.out.println(sb);
            pool.notifyAll();
            pool.clear();


        }
    }


    class ExecutorImpl extends Thread implements Executor{
        private int count;
        private Object lock = new Object();
        private Task task;
        public ExecutorImpl(){}

        public void setTask(Task task) {
            this.task = task;
        }

        public Task getTask() {
            return task;
        }

        public void startTask() {
            //获取lock 锁表示启动线程执行。
            synchronized (lock){
                lock.notifyAll();
            }
        }
        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            while(!isShutDown){
                //startTask是启动同通知
                synchronized (lock){
                    try{
                        lock.wait();
                        if(isShutDown){
                            System.out.println("Thread "+Thread.currentThread().getId()+" is stop");
                            return;
                        }
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                    System.out.println("Thread :" + Thread.currentThread().getId() + " is execute - " + getTask().hashCode());
                    getTask().execute(); //执行
                    count++;
                    synchronized (pool) {
                        pool.addFirst(ExecutorImpl.this);
                        pool.notifyAll();
                    }
                }
            }
            System.out.println("Thread :" + Thread.currentThread().getId()+"is shutdown");
        }
    }


}
