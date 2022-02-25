package com.movies.movies.services;

import java.util.List;
import java.util.Optional;

import com.movies.movies.dao.MovieRepository;
import com.movies.movies.entity.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    @Autowired
    private MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Movie findById(int theId){
        Optional<Movie> result = movieRepository.findById(theId);
        Movie movie = null;
        if(result.isPresent()){
            movie = result.get();
        }
        return movie;
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovieById(int theId) {
        movieRepository.deleteById(theId);
    }
}
