package com.example.gen_code_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * BookingResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-23T11:54:56.445739+07:00[Asia/Ho_Chi_Minh]")
public class BookingResponse {

  private Long bookingId;

  private CustomerResponse customer;

  private ShowtimeResponse showtime;

  private TheaterResponse theater;

  private MovieResponse movie;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime bookingDate;

  private Double totalAmount;

  private Double ticketPrice;

  public BookingResponse bookingId(Long bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  /**
   * Unique identifier for the booking
   * @return bookingId
  */
  
  @Schema(name = "bookingId", description = "Unique identifier for the booking", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bookingId")
  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public BookingResponse customer(CustomerResponse customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  */
  @Valid 
  @Schema(name = "customer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customer")
  public CustomerResponse getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerResponse customer) {
    this.customer = customer;
  }

  public BookingResponse showtime(ShowtimeResponse showtime) {
    this.showtime = showtime;
    return this;
  }

  /**
   * Get showtime
   * @return showtime
  */
  @Valid 
  @Schema(name = "showtime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("showtime")
  public ShowtimeResponse getShowtime() {
    return showtime;
  }

  public void setShowtime(ShowtimeResponse showtime) {
    this.showtime = showtime;
  }

  public BookingResponse theater(TheaterResponse theater) {
    this.theater = theater;
    return this;
  }

  /**
   * Get theater
   * @return theater
  */
  @Valid 
  @Schema(name = "theater", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("theater")
  public TheaterResponse getTheater() {
    return theater;
  }

  public void setTheater(TheaterResponse theater) {
    this.theater = theater;
  }

  public BookingResponse movie(MovieResponse movie) {
    this.movie = movie;
    return this;
  }

  /**
   * Get movie
   * @return movie
  */
  @Valid 
  @Schema(name = "movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("movie")
  public MovieResponse getMovie() {
    return movie;
  }

  public void setMovie(MovieResponse movie) {
    this.movie = movie;
  }

  public BookingResponse bookingDate(OffsetDateTime bookingDate) {
    this.bookingDate = bookingDate;
    return this;
  }

  /**
   * Date and time the booking was made
   * @return bookingDate
  */
  @Valid 
  @Schema(name = "bookingDate", description = "Date and time the booking was made", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bookingDate")
  public OffsetDateTime getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(OffsetDateTime bookingDate) {
    this.bookingDate = bookingDate;
  }

  public BookingResponse totalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * Total amount paid for the booking
   * @return totalAmount
  */
  
  @Schema(name = "totalAmount", description = "Total amount paid for the booking", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAmount")
  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public BookingResponse ticketPrice(Double ticketPrice) {
    this.ticketPrice = ticketPrice;
    return this;
  }

  /**
   * Ticket price for the showtime
   * @return ticketPrice
  */
  
  @Schema(name = "ticketPrice", description = "Ticket price for the showtime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ticketPrice")
  public Double getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(Double ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingResponse bookingResponse = (BookingResponse) o;
    return Objects.equals(this.bookingId, bookingResponse.bookingId) &&
        Objects.equals(this.customer, bookingResponse.customer) &&
        Objects.equals(this.showtime, bookingResponse.showtime) &&
        Objects.equals(this.theater, bookingResponse.theater) &&
        Objects.equals(this.movie, bookingResponse.movie) &&
        Objects.equals(this.bookingDate, bookingResponse.bookingDate) &&
        Objects.equals(this.totalAmount, bookingResponse.totalAmount) &&
        Objects.equals(this.ticketPrice, bookingResponse.ticketPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, customer, showtime, theater, movie, bookingDate, totalAmount, ticketPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingResponse {\n");
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    showtime: ").append(toIndentedString(showtime)).append("\n");
    sb.append("    theater: ").append(toIndentedString(theater)).append("\n");
    sb.append("    movie: ").append(toIndentedString(movie)).append("\n");
    sb.append("    bookingDate: ").append(toIndentedString(bookingDate)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    ticketPrice: ").append(toIndentedString(ticketPrice)).append("\n");
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

