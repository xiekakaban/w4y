package com.st.w4y.crawler;

import com.st.w4y.util.SecurityUtil;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * Created by ruantianbo on 2017/11/9.
 */
public class CrawlerMain {

    public static void main(String[] args){
        CrawlerMain crawlerMain = new CrawlerMain();
        crawlerMain.start();
    }

    public void start(){
        String key = "Yes";
        if(showMsg(key)){
            fetchData();
        }else{
            System.out.println("Permission Denied");
        }
    }

    private void fetchData(){

        try {
            System.out.println("Start fetch Data...");
            Thread.sleep(500);
            System.out.println("End...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean showMsg(String key){

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

}
