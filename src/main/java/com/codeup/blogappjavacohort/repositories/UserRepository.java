package com.codeup.blogappjavacohort.repositories;

import com.codeup.blogappjavacohort.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
