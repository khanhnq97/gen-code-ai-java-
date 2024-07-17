package com.example.gen_code_ai.controller;

import com.example.gen_code_ai.dto.Movie;
import com.example.gen_code_ai.dto.MovieRequest;
import com.example.gen_code_ai.service.MovieService;
import com.example.gen_code_ai.web.MoviesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController implements MoviesApi {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @Override
    public ResponseEntity<Movie> createMovie(MovieRequest movieRequest) {
        Movie createdMovie = movieService.createMovie(movieRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @Override
    public ResponseEntity<Movie> getMovieById(String id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }


    @Override
    public ResponseEntity<Movie> updateMovie(Movie movie) {
        Movie updatedMovie = movieService.updateMovie(movie);
        return ResponseEntity.ok(updatedMovie);
    }

    @Override
    public ResponseEntity<Void> deleteMovie(String id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
