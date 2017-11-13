package com.st.w4y.entity;

/**
 * Created by ruantianbo on 2017/11/9.
 */
public class M4YSongUnion {
    private String id;
    private String title;
    private String link;
    private M4YUser creater;
    private int star;

    public M4YSongUnion() {
    }

    public M4YSongUnion(String id, String title, String link, M4YUser creater, int star) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.creater = creater;
        this.star = star;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public M4YUser getCreater() {
        return creater;
    }

    public void setCreater(M4YUser creater) {
        this.creater = creater;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
