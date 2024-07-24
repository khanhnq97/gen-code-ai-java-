package com.example.gen_code_ai.service;

import com.example.gen_code_ai.dto.MovieRequest;
import com.example.gen_code_ai.dto.MovieResponse;
import com.example.gen_code_ai.entity.Movie;
import com.example.gen_code_ai.repository.MovieRepository;
import com.example.gen_code_ai.utils.DateTimeUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private final MovieRepository movieRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<MovieResponse> getAllMovies() {
    List<Movie> movies = movieRepository.findAll();
    return convertMovieEntityListToMovieList(movies);
  }

  public MovieResponse createMovie(MovieRequest movieRequest) {
    Movie movie = convertMovieRequestToMovieEntity(movieRequest);
    Movie savedMovie = movieRepository.save(movie);
    return convertMovieEntityToMovieResponse(savedMovie);
  }

  public MovieResponse getMovieById(Long id) {
    return convertMovieEntityToMovieResponse(
        movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found")));
  }

  public MovieResponse updateMovie(MovieRequest movie) {
    Movie movieEntity =
        movieRepository
            .findById(movie.getMovieId())
            .orElseThrow(() -> new RuntimeException("Movie not found"));
    // Map properties from movie to movieEntity
    movieEntity.setTitle(movie.getTitle());
    movieEntity.setDirector(movie.getDirector());
    movieEntity.setCast(movie.getCast());
    movieEntity.setGenre(movie.getGenre());
    movieEntity.setDescription(movie.getDescription());
    movieEntity.setDuration(movie.getDuration());
    movieEntity.setReleaseDate(DateTimeUtil.convertToLocalDateTime(movie.getReleaseDate()));
    return convertMovieEntityToMovieResponse(movieRepository.save(movieEntity));
  }

  public void deleteMovie(Long id) {
    MovieResponse movie = getMovieById(id);
    movieRepository.delete(convertMovieToMovieEntity(movie));
  }

  // convertMovieEntityListToMovieList
  private List<MovieResponse> convertMovieEntityListToMovieList(List<Movie> movies) {
    List<MovieResponse> moviesList = new ArrayList<>();
    for (Movie movieEntity : movies) {
      MovieResponse movie = new MovieResponse();
      // Map properties from movieEntity to movie
      // movie.setMovieId(movieEntity.getId());
      movie.setTitle(movieEntity.getTitle());
      movie.setDirector(movieEntity.getDirector());
      movie.setCast(movieEntity.getCast());
      movie.setGenre(movieEntity.getGenre());
      movie.setDescription(movieEntity.getDescription());
      movie.setDuration(movieEntity.getDuration());
      movie.setReleaseDate(DateTimeUtil.convertToOffsetDateTime(movieEntity.getReleaseDate()));
      moviesList.add(movie);
    }
    return moviesList;
  }

  // convertMovieEntityToMovie
  private MovieResponse convertMovieEntityToMovieResponse(Movie movieEntity) {
    MovieResponse movie = new MovieResponse();
    // Map properties from movieEntity to movie
    // movie.setMovieId(movieEntity.getId());
    movie.setTitle(movieEntity.getTitle());
    movie.setDirector(movieEntity.getDirector());
    movie.setCast(movieEntity.getCast());
    movie.setGenre(movieEntity.getGenre());
    movie.setDescription(movieEntity.getDescription());
    movie.setDuration(movieEntity.getDuration());
    movie.setReleaseDate(DateTimeUtil.convertToOffsetDateTime(movieEntity.getReleaseDate()));
    return movie;
  }

  // convertMovieToMovieEntity
  private Movie convertMovieToMovieEntity(MovieResponse movie) {
    Movie movieEntity = new Movie();
    // Map properties from movie to movieEntity
    // movieEntity.setId(movie.getMovieId());
    movieEntity.setTitle(movie.getTitle());
    movieEntity.setDirector(movie.getDirector());
    movieEntity.setCast(movie.getCast());
    movieEntity.setGenre(movie.getGenre());
    movieEntity.setDescription(movie.getDescription());
    movieEntity.setDuration(movie.getDuration());
    movieEntity.setReleaseDate(DateTimeUtil.convertToLocalDateTime(movie.getReleaseDate()));
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
    movie.setReleaseDate(DateTimeUtil.convertToLocalDateTime(movieRequest.getReleaseDate()));
    return movie;
  }
}
