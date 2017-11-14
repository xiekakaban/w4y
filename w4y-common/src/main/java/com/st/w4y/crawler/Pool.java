package com.st.w4y.crawler;

/**
 * Created by ruantianbo on 2017/11/13.
 */
public interface Pool {
    Executor getExecutor();
    void destroy();
}
