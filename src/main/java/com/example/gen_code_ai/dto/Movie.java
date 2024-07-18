package com.example.gen_code_ai.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Movie
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-17T15:03:07.891567+07:00[Asia/Ho_Chi_Minh]")
public class Movie {

  private String movieId;

  private String title;

  private String description;

  private Integer duration;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime releaseDate;

  private String genre;

  private String director;

  private String cast;

  public Movie movieId(String movieId) {
    this.movieId = movieId;
    return this;
  }

  /**
   * Unique identifier for the movie
   * @return movieId
  */
  
  @Schema(name = "movieId", description = "Unique identifier for the movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("movieId")
  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public Movie title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Title of the movie
   * @return title
  */
  
  @Schema(name = "title", description = "Title of the movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Movie description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the movie
   * @return description
  */
  
  @Schema(name = "description", description = "Description of the movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Movie duration(Integer duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Duration of the movie in minutes
   * @return duration
  */
  
  @Schema(name = "duration", description = "Duration of the movie in minutes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("duration")
  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Movie releaseDate(OffsetDateTime releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  /**
   * Release date of the movie
   * @return releaseDate
  */
  @Valid 
  @Schema(name = "releaseDate", description = "Release date of the movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("releaseDate")
  public OffsetDateTime getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(OffsetDateTime releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Movie genre(String genre) {
    this.genre = genre;
    return this;
  }

  /**
   * Genre of the movie
   * @return genre
  */
  
  @Schema(name = "genre", description = "Genre of the movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("genre")
  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Movie director(String director) {
    this.director = director;
    return this;
  }

  /**
   * Director of the movie
   * @return director
  */
  
  @Schema(name = "director", description = "Director of the movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("director")
  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public Movie cast(String cast) {
    this.cast = cast;
    return this;
  }

  /**
   * List of actors in the movie
   * @return cast
  */
  
  @Schema(name = "cast", description = "List of actors in the movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cast")
  public String getCast() {
    return cast;
  }

  public void setCast(String cast) {
    this.cast = cast;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Movie movie = (Movie) o;
    return Objects.equals(this.movieId, movie.movieId) &&
        Objects.equals(this.title, movie.title) &&
        Objects.equals(this.description, movie.description) &&
        Objects.equals(this.duration, movie.duration) &&
        Objects.equals(this.releaseDate, movie.releaseDate) &&
        Objects.equals(this.genre, movie.genre) &&
        Objects.equals(this.director, movie.director) &&
        Objects.equals(this.cast, movie.cast);
  }

  @Override
  public int hashCode() {
    return Objects.hash(movieId, title, description, duration, releaseDate, genre, director, cast);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Movie {\n");
    sb.append("    movieId: ").append(toIndentedString(movieId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("    director: ").append(toIndentedString(director)).append("\n");
    sb.append("    cast: ").append(toIndentedString(cast)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

