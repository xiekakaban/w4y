package com.st.w4y.entity;

import java.util.List;

/**
 * Created by ruantianbo on 2017/11/9.
 */


public class M4YMusicItem {

    private String id;
    private String name;
    private String link;
    private String singer;
    private String album;
    private String cover;

    private String lyric;
    private int totalComment;

    private List<M4YComment> commentList;

    public M4YMusicItem() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public int getTotalComment() {
        return totalComment;
    }

    public void setTotalComment(int totalComment) {
        this.totalComment = totalComment;
    }

    public List<M4YComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<M4YComment> commentList) {
        this.commentList = commentList;
    }
}
