package com.example.gen_code_ai.controller;

import com.example.gen_code_ai.dto.MovieRequest;
import com.example.gen_code_ai.dto.MovieResponse;
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
    public ResponseEntity<List<MovieResponse>> getMovies() {
        List<MovieResponse> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @Override
    public ResponseEntity<MovieResponse> createMovie(MovieRequest movieRequest) {
        MovieResponse createdMovie = movieService.createMovie(movieRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @Override
    public ResponseEntity<MovieResponse> getMovieById(Integer id) {
        MovieResponse movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }


    @Override
    public ResponseEntity<MovieResponse> updateMovie(MovieRequest movie) {
        MovieResponse updatedMovie = movieService.updateMovie(movie);
        return ResponseEntity.ok(updatedMovie);
    }

    @Override
    public ResponseEntity<Void> deleteMovie(Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
