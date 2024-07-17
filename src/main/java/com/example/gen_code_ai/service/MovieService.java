package com.example.gen_code_ai.service;

import com.example.gen_code_ai.dto.MovieRequest;
import com.example.gen_code_ai.entity.Movie;
import com.example.gen_code_ai.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<com.example.gen_code_ai.dto.Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return convertMovieEntityListToMovieList(movies);
    }

    public com.example.gen_code_ai.dto.Movie createMovie(MovieRequest movieRequest) {
        Movie movie = convertMovieRequestToMovieEntity(movieRequest);
        // Map properties from movieRequest to movie
        return convertMovieEntityToMovie(movieRepository.save(movie));
    }

    public com.example.gen_code_ai.dto.Movie getMovieById(String id) {
        return convertMovieEntityToMovie(movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found")));
    }

    public com.example.gen_code_ai.dto.Movie updateMovie(com.example.gen_code_ai.dto.Movie movie) {
        Movie movieEntity = movieRepository.findById(movie.getMovieId()).orElseThrow(() -> new RuntimeException("Movie not found"));
        // Map properties from movie to movieEntity
        movieEntity.setTitle(movie.getTitle());
        movieEntity.setDirector(movie.getDirector());
        movieEntity.setCast(movie.getCast());
        movieEntity.setGenre(movie.getGenre());
        movieEntity.setDescription(movie.getDescription());
        movieEntity.setDuration(movie.getDuration());
        movieEntity.setReleaseDate(movie.getReleaseDate());
        return convertMovieEntityToMovie(movieRepository.save(movieEntity));
    }

    public void deleteMovie(String id) {
        com.example.gen_code_ai.dto.Movie movie = getMovieById(id);
        movieRepository.delete(convertMovieToMovieEntity(movie));
    }

    // convertMovieEntityListToMovieList
    private List<com.example.gen_code_ai.dto.Movie> convertMovieEntityListToMovieList(List<Movie> movies) {
        List<com.example.gen_code_ai.dto.Movie> moviesList = new ArrayList<>();
        for (Movie movieEntity : movies) {
            com.example.gen_code_ai.dto.Movie movie = new com.example.gen_code_ai.dto.Movie();
            // Map properties from movieEntity to movie
            movie.setMovieId(movieEntity.getMovieId());
            movie.setMovieId(movieEntity.getMovieId());
            movie.setTitle(movieEntity.getTitle());
            movie.setDirector(movieEntity.getDirector());
            movie.setCast(movieEntity.getCast());
            movie.setGenre(movieEntity.getGenre());
            movie.setDescription(movieEntity.getDescription());
            movie.setDuration(movieEntity.getDuration());
            movie.setReleaseDate(movieEntity.getReleaseDate());
            moviesList.add(movie);
        }
        return moviesList;
    }

    // convertMovieEntityToMovie
    private com.example.gen_code_ai.dto.Movie convertMovieEntityToMovie(Movie movieEntity) {
        com.example.gen_code_ai.dto.Movie movie = new com.example.gen_code_ai.dto.Movie();
        // Map properties from movieEntity to movie
        movie.setMovieId(movieEntity.getMovieId());
        movie.setMovieId(movieEntity.getMovieId());
        movie.setTitle(movieEntity.getTitle());
        movie.setDirector(movieEntity.getDirector());
        movie.setCast(movieEntity.getCast());
        movie.setGenre(movieEntity.getGenre());
        movie.setDescription(movieEntity.getDescription());
        movie.setDuration(movieEntity.getDuration());
        movie.setReleaseDate(movieEntity.getReleaseDate());
        return movie;
    }

    // convertMovieToMovieEntity
    private Movie convertMovieToMovieEntity(com.example.gen_code_ai.dto.Movie movie) {
        Movie movieEntity = new Movie();
        // Map properties from movie to movieEntity
        movieEntity.setMovieId(movie.getMovieId());
        movieEntity.setMovieId(movie.getMovieId());
        movieEntity.setTitle(movie.getTitle());
        movieEntity.setDirector(movie.getDirector());
        movieEntity.setCast(movie.getCast());
        movieEntity.setGenre(movie.getGenre());
        movieEntity.setDescription(movie.getDescription());
        movieEntity.setDuration(movie.getDuration());
        movieEntity.setReleaseDate(movie.getReleaseDate());
        return movieEntity;
    }

    // convertMovieRequestToMovieEntity
    private Movie convertMovieRequestToMovieEntity(MovieRequest movieRequest) {
        Movie movie = new Movie();
        // Map properties from movieRequest to movieEntity
        movie.setTitle(movieRequest.getTitle());
        movie.setDirector(movieRequest.getDirector());
        movie.setCast(movieRequest.getCast());
        movie.setGenre(movieRequest.getGenre());
        movie.setDescription(movieRequest.getDescription());
        movie.setDuration(movieRequest.getDuration());
        movie.setReleaseDate(movieRequest.getReleaseDate());
        return movie;
    }
}