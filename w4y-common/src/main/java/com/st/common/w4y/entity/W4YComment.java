package com.st.common.w4y.entity;

import java.util.Date;

/**
 * Created by ruantianbo on 2017/11/9.
 */
public class W4YComment {
    private String id;
    private String content;
    private W4YUser commentBy;
    private String star;
    private Date commentTime;

    public W4YComment() {
    }

    public W4YComment(String content, W4YUser commentBy, String star, Date commentTime) {
        this.content = content;
        this.commentBy = commentBy;
        this.star = star;
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public W4YUser getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(W4YUser commentBy) {
        this.commentBy = commentBy;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}
