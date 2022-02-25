package com.movies.movies.dao;

import com.movies.movies.entity.User;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Integer>{
    
}
