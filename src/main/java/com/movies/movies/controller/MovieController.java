package com.movies.movies.controller;

import java.util.List;

import com.movies.movies.entity.Movie;
import com.movies.movies.services.MovieService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MovieController {
    
    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getAll(){
        return this.movieService.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getById(@PathVariable int id) {
        return this.movieService.findById(id);
    }

    /*@PostMapping("/login")
    public User login(@RequestBody User user) {
        
    }*/

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        movie.setId(0);
        movieService.saveMovie(movie);

        return movie;
    }

    @PutMapping("/movies")
    @ResponseStatus( code = HttpStatus.OK, reason = "Guardado exitosamente")
    public Movie updateMovie(@RequestBody Movie movie) { 
        movieService.saveMovie(movie);
        return movie;
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus( code = HttpStatus.OK, reason = "Se ha eliminado con exito")
    public void deleteMovie(@PathVariable int id) {
        movieService.deleteMovieById(id);
    }
}
