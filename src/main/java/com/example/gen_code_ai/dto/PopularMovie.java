package com.example.gen_code_ai.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PopularMovie
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-18T12:52:09.357085+07:00[Asia/Ho_Chi_Minh]")
public class PopularMovie {

  private Integer movieId;

  private String movieTitle;

  private BigDecimal attendanceCount;

  public PopularMovie movieId(Integer movieId) {
    this.movieId = movieId;
    return this;
  }

  /**
   * Unique identifier for the movie
   * @return movieId
  */
  
  @Schema(name = "movieId", description = "Unique identifier for the movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("movieId")
  public Integer getMovieId() {
    return movieId;
  }

  public void setMovieId(Integer movieId) {
    this.movieId = movieId;
  }

  public PopularMovie movieTitle(String movieTitle) {
    this.movieTitle = movieTitle;
    return this;
  }

  /**
   * Title of the movie
   * @return movieTitle
  */
  
  @Schema(name = "movieTitle", description = "Title of the movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("movieTitle")
  public String getMovieTitle() {
    return movieTitle;
  }

  public void setMovieTitle(String movieTitle) {
    this.movieTitle = movieTitle;
  }

  public PopularMovie attendanceCount(BigDecimal attendanceCount) {
    this.attendanceCount = attendanceCount;
    return this;
  }

  /**
   * Total attendance for the movie
   * @return attendanceCount
  */
  @Valid 
  @Schema(name = "attendanceCount", description = "Total attendance for the movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("attendanceCount")
  public BigDecimal getAttendanceCount() {
    return attendanceCount;
  }

  public void setAttendanceCount(BigDecimal attendanceCount) {
    this.attendanceCount = attendanceCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PopularMovie popularMovie = (PopularMovie) o;
    return Objects.equals(this.movieId, popularMovie.movieId) &&
        Objects.equals(this.movieTitle, popularMovie.movieTitle) &&
        Objects.equals(this.attendanceCount, popularMovie.attendanceCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(movieId, movieTitle, attendanceCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PopularMovie {\n");
    sb.append("    movieId: ").append(toIndentedString(movieId)).append("\n");
    sb.append("    movieTitle: ").append(toIndentedString(movieTitle)).append("\n");
    sb.append("    attendanceCount: ").append(toIndentedString(attendanceCount)).append("\n");
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

