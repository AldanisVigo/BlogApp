package com.codeup.blogappjavacohort.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
        @GetMapping(path = "/posts")
        @ResponseBody
        public String posts() {
            return "Posts Index Page";
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
