package com.codeup.blogappjavacohort.services;

import com.codeup.blogappjavacohort.repositories.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    @Override
    public Page findAll(Pageable pageable) {
        Page currentPage = postRepository.findAll(pageable);
        return currentPage;
    }
}
