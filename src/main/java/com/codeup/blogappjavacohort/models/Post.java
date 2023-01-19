package com.codeup.blogappjavacohort.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Post implements Serializable {
    @Id
    private long id;

    private String title;

    private String body;
}
