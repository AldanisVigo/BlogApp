package com.codeup.blogappjavacohort.models;

import jakarta.persistence.*;
import lombok.*;
import com.codeup.blogappjavacohort.models.User;
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String content;

    @ManyToOne
    private User owner;

    public Post(String title, String body, User owner){
        this.title = title;
        this.content = body;
        this.owner = owner;
    }

    public Post() {

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
