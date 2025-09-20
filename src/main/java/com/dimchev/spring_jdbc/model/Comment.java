package com.dimchev.spring_jdbc.model;

import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;

public class Comment {

    private String name;
    private String content;
    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;

    @Transient
    Post post;

    public Comment(String name, String content){
        this.name = name;
        this.content = content;
        this.publishedAt = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return publishedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.publishedAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
