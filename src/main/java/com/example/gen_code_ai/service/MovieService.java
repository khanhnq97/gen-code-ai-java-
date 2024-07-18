package com.example.gen_code_ai.service;

import com.example.gen_code_ai.dto.MovieRequest;
import com.example.gen_code_ai.dto.MovieResponse;
import com.example.gen_code_ai.entity.MovieEntity;
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

    public List<MovieResponse> getAllMovies() {
        List<MovieEntity> movies = movieRepository.findAll();
        return convertMovieEntityListToMovieList(movies);
    }

    public MovieResponse createMovie(MovieRequest movieRequest) {
        MovieEntity movie = convertMovieRequestToMovieEntity(movieRequest);
        MovieEntity savedMovie = movieRepository.save(movie);
        return convertMovieEntityToMovieResponse(savedMovie);
    }

    public MovieResponse getMovieById(Integer id) {
        return convertMovieEntityToMovieResponse(movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found")));
    }

    public MovieResponse updateMovie(MovieRequest movie) {
        MovieEntity movieEntity = movieRepository.findById(movie.getMovieId()).orElseThrow(() -> new RuntimeException("Movie not found"));
        // Map properties from movie to movieEntity
        movieEntity.setTitle(movie.getTitle());
        movieEntity.setDirector(movie.getDirector());
        movieEntity.setCast(movie.getCast());
        movieEntity.setGenre(movie.getGenre());
        movieEntity.setDescription(movie.getDescription());
        movieEntity.setDuration(movie.getDuration());
        movieEntity.setReleaseDate(movie.getReleaseDate());
        return convertMovieEntityToMovieResponse(movieRepository.save(movieEntity));
    }

    public void deleteMovie(Integer id) {
        MovieResponse movie = getMovieById(id);
        movieRepository.delete(convertMovieToMovieEntity(movie));
    }

    // convertMovieEntityListToMovieList
    private List<MovieResponse> convertMovieEntityListToMovieList(List<MovieEntity> movies) {
        List<MovieResponse> moviesList = new ArrayList<>();
        for (MovieEntity movieEntity : movies) {
            MovieResponse movie = new MovieResponse();
            // Map properties from movieEntity to movie
            movie.setMovieId(movieEntity.getId());
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
    private MovieResponse convertMovieEntityToMovieResponse(MovieEntity movieEntity) {
        MovieResponse movie = new MovieResponse();
        // Map properties from movieEntity to movie
        movie.setMovieId(movieEntity.getId());
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
    private MovieEntity convertMovieToMovieEntity(MovieResponse movie) {
        MovieEntity movieEntity = new MovieEntity();
        // Map properties from movie to movieEntity
        movieEntity.setId(movie.getMovieId());
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
    private MovieEntity convertMovieRequestToMovieEntity(MovieRequest movieRequest) {
        MovieEntity movie = new MovieEntity();
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