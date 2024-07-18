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
 * Showtime
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-17T16:53:19.237975+07:00[Asia/Ho_Chi_Minh]")
public class Showtime {

  private Long showtimeId;

  private Long movieId;

  private Long theaterId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startTime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endTime;

  private Double price;

  public Showtime showtimeId(Long showtimeId) {
    this.showtimeId = showtimeId;
    return this;
  }

  /**
   * Unique identifier for the showtime
   * @return showtimeId
  */
  
  @Schema(name = "showtimeId", description = "Unique identifier for the showtime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("showtimeId")
  public Long getShowtimeId() {
    return showtimeId;
  }

  public void setShowtimeId(Long showtimeId) {
    this.showtimeId = showtimeId;
  }

  public Showtime movieId(Long movieId) {
    this.movieId = movieId;
    return this;
  }

  /**
   * ID of the movie being shown
   * @return movieId
  */
  
  @Schema(name = "movieId", description = "ID of the movie being shown", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("movieId")
  public Long getMovieId() {
    return movieId;
  }

  public void setMovieId(Long movieId) {
    this.movieId = movieId;
  }

  public Showtime theaterId(Long theaterId) {
    this.theaterId = theaterId;
    return this;
  }

  /**
   * ID of the theater where the showtime is taking place
   * @return theaterId
  */
  
  @Schema(name = "theaterId", description = "ID of the theater where the showtime is taking place", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("theaterId")
  public Long getTheaterId() {
    return theaterId;
  }

  public void setTheaterId(Long theaterId) {
    this.theaterId = theaterId;
  }

  public Showtime startTime(OffsetDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Start time of the showtime
   * @return startTime
  */
  @Valid 
  @Schema(name = "startTime", description = "Start time of the showtime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startTime")
  public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public Showtime endTime(OffsetDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * End time of the showtime
   * @return endTime
  */
  @Valid 
  @Schema(name = "endTime", description = "End time of the showtime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endTime")
  public OffsetDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }

  public Showtime price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Ticket price for the showtime
   * @return price
  */
  
  @Schema(name = "price", description = "Ticket price for the showtime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Showtime showtime = (Showtime) o;
    return Objects.equals(this.showtimeId, showtime.showtimeId) &&
        Objects.equals(this.movieId, showtime.movieId) &&
        Objects.equals(this.theaterId, showtime.theaterId) &&
        Objects.equals(this.startTime, showtime.startTime) &&
        Objects.equals(this.endTime, showtime.endTime) &&
        Objects.equals(this.price, showtime.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(showtimeId, movieId, theaterId, startTime, endTime, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Showtime {\n");
    sb.append("    showtimeId: ").append(toIndentedString(showtimeId)).append("\n");
    sb.append("    movieId: ").append(toIndentedString(movieId)).append("\n");
    sb.append("    theaterId: ").append(toIndentedString(theaterId)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

