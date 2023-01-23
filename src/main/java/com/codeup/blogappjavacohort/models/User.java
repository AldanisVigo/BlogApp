package com.codeup.blogappjavacohort.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false, length = 255)
    private String username;

    @Column(unique = true,nullable = false, length = 255)
    private String password;

    @Column(unique = true, nullable = false, length = 255)
    private String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    List<Post> posts;

    //Copy constructor
    public User(User copy){
        this.id = copy.id;
        this.username = copy.username;
        this.password = copy.password;
        this.email = copy.email;
    }

}
