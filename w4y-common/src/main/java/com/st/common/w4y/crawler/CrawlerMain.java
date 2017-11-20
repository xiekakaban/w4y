package com.st.common.w4y.crawler;

import com.google.gson.Gson;
import com.st.common.w4y.entity.W4YUser;
import com.st.common.w4y.entity.W4YSongUnion;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;


/**
 * Created by ruantianbo on 2017/11/9.
 */
public class CrawlerMain {
    private static final String USERAGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
    //  https://music.163.com/#/discover/playlist/
    public static void main(String[] args){
        CrawlerMain crawlerMain = new CrawlerMain();
        crawlerMain.start();

    }

    public void start(){
        String key = "Yes";
        if(showMsg(key)){
            fetchAllSongUnionUrl();
        }else{
            System.out.println("Permission Denied");
        }
    }

    private void fetchAllSongUnionUrl(){
        //cpu 密集型 线程池大小为 核心数当1倍，IO 密集型 线程池大小为核心数当1.5-2.0
        //这边只创建 核心数相同 线程池
        //使用 LinkedBlockingQueue 来管理 任务队列
        //Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
        ExtendThreadPoolExecutor extendPool = new ExtendThreadPoolExecutor(5);
        try {
            String content = getHttp("http://music.163.com/discover/playlist/?cat=%E5%8D%8E%E8%AF%AD");
            Document doc = Jsoup.parse(content);
            Elements SongUnions = doc.select("ul#m-pl-container>li");
            List<W4YSongUnion> w4YSongUnions = new ArrayList<W4YSongUnion>();
            for (Element songUnionItem : SongUnions){
                W4YSongUnion w4YSongUnion = new W4YSongUnion();
                W4YUser m4YUser = new W4YUser();
                w4YSongUnion.setTitle(songUnionItem.select("a.msk").first().attr("title"));
                w4YSongUnion.setLink(songUnionItem.select("a.msk").first().attr("href"));
                w4YSongUnion.setStarByString(songUnionItem.select("span.nb").first().text());
                m4YUser.setName(songUnionItem.select("a.nm.nm-icn.f-thide.s-fc3").first().attr("title"));
                m4YUser.setUrl(songUnionItem.select("a.nm.nm-icn.f-thide.s-fc3").first().attr("href"));
                w4YSongUnion.setCreater(m4YUser);
                w4YSongUnions.add(w4YSongUnion);
            }
            Gson gson =  new Gson();
            System.out.println(gson.toJson(w4YSongUnions));


        } catch (Exception e) {
            System.out.println("error");
        }

    }

    private String getHttp(String url, String... params) throws Exception{
        HttpClient httpClient = HttpClients.custom().setUserAgent(USERAGENT).build();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);

        String content = EntityUtils.toString(response.getEntity());

        return content;

    }

//    private String postHttp(String url,String... params){
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//    }





    class M4YSongUnionUrlCallable implements Callable<List<W4YSongUnion>>{
        private String url;
        public M4YSongUnionUrlCallable(String url){
            this.url = url;
        }
        public List<W4YSongUnion> call() throws Exception {
            List<W4YSongUnion> w4YSongUnionList = new ArrayList<W4YSongUnion>();
            CloseableHttpClient httpClient = HttpClients.createDefault();
//            try{
//
//            }
            return w4YSongUnionList;
        }
    }





    private boolean showMsg(String key){
        // 1 是否更新 SongUnion list， 那就读取url 与数据库中当数据进行对比
        // 2 是否通过 SongUnion url 获取 歌曲名
        // 3 是否通过 歌曲名获取 comment
        System.out.println("*************************************************************");
        System.out.println("**Here you need to be very carefully, now I will fetch data**");
        //当通过new java.util.Scanner(System.in)创建一个Scanner，控制台会一直等待输入，直到敲回车键结束
        System.out.println("**Please Enter key: "+key);
        System.out.println("*************************************************************");
        Scanner sc = new Scanner(System.in);
        if(sc.nextLine().equals(key)){
            return true;
        }else{
            return false;
        }
    }

    //    private void fetchData(){
//        List<Task> taskList = new ArrayList<Task>();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        for(int i=0;i<1000;i++){
//            taskList.add(new HelloWorldTask("http://www"+dateFormat.format(new Date())+(int)(Math.random()*1000)+".com"));
//        }
//
//        Pool pool = new ThreadPool(2);
//
//        for(Task taskItem : taskList){
//            Executor e = pool.getExecutor();
//            e.setTask(taskItem);
//            e.startTask();
//        }
//
//        pool.destroy();
//    }

}
