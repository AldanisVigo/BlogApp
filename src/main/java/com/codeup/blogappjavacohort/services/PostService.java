package com.codeup.blogappjavacohort.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page findAll(Pageable pageable);
}
