package com.codeup.blogappjavacohort.models;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import com.codeup.blogappjavacohort.models.User;
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @ManyToOne
    @NotNull
    private User owner;

    public Post(@NotNull String title, @NotNull String body, @NotNull User owner){
        this.title = title;
        this.content = body;
        this.owner = owner;
    }

    public Post() {

    }


    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    @NotNull
    public String getContent() {
        return content;
    }

    public void setContent(@NotNull String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    public User getOwner() {
        return owner;
    }

    public void setOwner(@NotNull User owner) {
        this.owner = owner;
    }
}
