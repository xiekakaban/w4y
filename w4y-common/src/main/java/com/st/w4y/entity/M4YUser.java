package com.st.w4y.entity;

/**
 * Created by ruantianbo on 2017/11/9.
 */
public class M4YUser {
    private String id;
    private String name;
    private String url;

    public M4YUser() {
    }

    public M4YUser(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
