package com.movies.movies.dao;

import com.movies.movies.entity.Movie;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepositoryImplementation<Movie, Integer> {
    
}
