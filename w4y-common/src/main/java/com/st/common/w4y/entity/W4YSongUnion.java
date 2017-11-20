package com.st.common.w4y.entity;

/**
 * Created by ruantianbo on 2017/11/9.
 */
public class W4YSongUnion {
    private String id;
    private String title;
    private String link;
    private W4YUser creater;
    private int star;

    public W4YSongUnion() {
    }

    public W4YSongUnion(String id, String title, String link, W4YUser creater, int star) {
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

    public W4YUser getCreater() {
        return creater;
    }

    public void setCreater(W4YUser creater) {
        this.creater = creater;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setStarByString(String starStr){
        int wanIndex = starStr.indexOf("万");

        if(wanIndex != -1){
            this.star = Integer.parseInt(starStr.substring(0,wanIndex))*10000;
        } else{
            this.star = Integer.parseInt(starStr);
        }
    }
}
