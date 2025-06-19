package com.example.model;

import java.util.Date;

public class Blog {
    private int id;
    private String title;
    private String content;
    private String author;
    private Date createTime;

    public Blog() {
    }

    public Blog(String title, String content, String author, Date createTime) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createTime = createTime;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}