package com.codeup.blogappjavacohort.repositories;

import com.codeup.blogappjavacohort.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
