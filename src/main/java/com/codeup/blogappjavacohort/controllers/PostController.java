package com.codeup.blogappjavacohort.controllers;

import com.codeup.blogappjavacohort.models.Post;
import com.codeup.blogappjavacohort.models.User;
import com.codeup.blogappjavacohort.repositories.PostRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping(path = "/posts")
    public String posts(Model model) {
        List<Post> posts = postRepository.findAll().stream().toList();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping(path = "/posts/show")
    public String showPost(Model model, @RequestParam("post_id") long postId, HttpServletRequest req) {
        Post myPost = new Post(
                "Test title",
                "test body",
                (User) req.getSession().getAttribute("user")
        );
        model.addAttribute("post", myPost);
        return "posts/show";
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public String post(@PathVariable("id") Integer post_id) {
        return "Viewing single post with id " + post_id;
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
        postRepository.save(new Post(
                title,content,
                (User) req.getSession().getAttribute("user")
        ));
        return "redirect:/posts";
    }
}
