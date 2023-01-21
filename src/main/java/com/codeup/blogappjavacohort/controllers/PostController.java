package com.codeup.blogappjavacohort.controllers;

import com.codeup.blogappjavacohort.models.Post;
import com.codeup.blogappjavacohort.models.User;
import com.codeup.blogappjavacohort.repositories.PostRepository;
import com.codeup.blogappjavacohort.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/posts")
    public String posts(Model model) {
        List<Post> posts = postRepository.findAll().stream().toList();
        model.addAttribute("posts", posts);
        return "posts/index";
    }


    @GetMapping(path = "/posts/show")
    public String displayPosts(@RequestParam long postid, Model model){
        System.out.println("postid = " + postid);
        Post post = postRepository.findById(postid).get();
        model.addAttribute("post",post);
        return "/posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String create() {
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String createPost(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest req) {
        Optional<User> firstUser = userRepository.findById(1L);
        //TODO: Get the user from the session
        firstUser.ifPresent(user -> postRepository.save(new Post(
                title, content,
                user
        )));
        return "redirect:/posts";
    }
}
