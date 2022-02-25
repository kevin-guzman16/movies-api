package com.movies.movies.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.movies.movies.dao.MovieRepository;
import com.movies.movies.dto.TMovie;
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

    public List<TMovie> findAll(){
        List<TMovie> listMovies = new ArrayList<TMovie>();
        movieRepository.findAll().forEach(movie -> listMovies.add(movie.toTransfer()));
        return listMovies;
    }

    public TMovie findById(int theId){
        Optional<Movie> result = movieRepository.findById(theId);
        Movie movie = null;
        if(result.isPresent()){
            movie = result.get();
        }
        return movie.toTransfer();
    }

    public TMovie saveMovie(TMovie movie) {
        return movie;
    }

    public void deleteMovieById(int theId) {
        movieRepository.deleteById(theId);
    }
}
