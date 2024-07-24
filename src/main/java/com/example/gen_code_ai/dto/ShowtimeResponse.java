package com.example.gen_code_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * ShowtimeResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-23T11:54:56.445739+07:00[Asia/Ho_Chi_Minh]")
public class ShowtimeResponse {

  private Long showtimeId;

  private Long movieId;

  private Long theaterId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startTime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endTime;

  private Double price;

  public ShowtimeResponse showtimeId(Long showtimeId) {
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

  public ShowtimeResponse movieId(Long movieId) {
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

  public ShowtimeResponse theaterId(Long theaterId) {
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

  public ShowtimeResponse startTime(OffsetDateTime startTime) {
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

  public ShowtimeResponse endTime(OffsetDateTime endTime) {
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

  public ShowtimeResponse price(Double price) {
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
    ShowtimeResponse showtimeResponse = (ShowtimeResponse) o;
    return Objects.equals(this.showtimeId, showtimeResponse.showtimeId) &&
        Objects.equals(this.movieId, showtimeResponse.movieId) &&
        Objects.equals(this.theaterId, showtimeResponse.theaterId) &&
        Objects.equals(this.startTime, showtimeResponse.startTime) &&
        Objects.equals(this.endTime, showtimeResponse.endTime) &&
        Objects.equals(this.price, showtimeResponse.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(showtimeId, movieId, theaterId, startTime, endTime, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShowtimeResponse {\n");
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

