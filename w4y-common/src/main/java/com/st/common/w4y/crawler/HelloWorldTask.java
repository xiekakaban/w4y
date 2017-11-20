package com.st.common.w4y.crawler;

/**
 * Created by ruantianbo on 2017/11/15.
 */
public class HelloWorldTask implements Task<String> {
    private String result;
    private String url;

    public HelloWorldTask(String url) {
        this.url = url;
    }

    public void execute() {
        result = "Task fetch "+ url +" is in execute";
    }

    public String getResult() {
        return result;
    }
}
