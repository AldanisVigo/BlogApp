package com.codeup.blogappjavacohort.controllers;

import com.codeup.blogappjavacohort.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
        @GetMapping(path = "/posts")
        public String posts(Model model) {
            List<Post> twoPosts = new ArrayList<>(){{
                add(new Post("Test Post One","This is test post one."));
                add(new Post("Test Post Two", "This is test post two."));
            }};

            model.addAttribute("posts",twoPosts);

            return "posts/index";
        }

        @GetMapping(path = "/posts/show")
        public String showPost(Model model,@RequestParam("post_id") long postId) {
            Post myPost = new Post("Test title","test body");
            model.addAttribute("post",myPost);
            return "posts/show";
        }

        @GetMapping(path = "/posts/{id}")
        @ResponseBody
        public String post(@PathVariable("id") Integer post_id){
            return "Viewing single post with id " + post_id;
        }

        @GetMapping(path = "/posts/create")
        @ResponseBody
        public String create(){
            return "Form creating posts";
        }

        @PostMapping(path = "/posts/create")
        @ResponseBody
        public String createPost(){
            return "Create posts processing route";
        }
}
