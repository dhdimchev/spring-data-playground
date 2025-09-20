package com.dimchev.spring_jdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Post {
    @Id
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void addComment(Comment comment){
        comment.post = this;
        comments.add(comment);
    }
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    private Set<Comment> comments = new HashSet<>();

    public AggregateReference<Author, Integer> getAuthor() {
        return author;
    }

    private AggregateReference<Author, Integer> author;

    public Post(String title, String content, AggregateReference<Author, Integer> author){
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.author = author;

    }
   public Integer getId() {
        return id;
   }
   public void setId(Integer id) {
        this.id = id;
   }
}

