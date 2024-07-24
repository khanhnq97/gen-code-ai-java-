package com.example.gen_code_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * BookingDetailResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-23T11:54:56.445739+07:00[Asia/Ho_Chi_Minh]")
public class BookingDetailResponse {

  private Long bookingId;

  private CustomerResponse customer;

  private ShowtimeResponse showtime;

  private TheaterResponse theater;

  private MovieResponse movie;

  @Valid
  private List<@Valid SeatResponse> seats;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime bookingDate;

  private Double totalAmount;

  private Double ticketPrice;

  public BookingDetailResponse bookingId(Long bookingId) {
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

  public BookingDetailResponse customer(CustomerResponse customer) {
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

  public BookingDetailResponse showtime(ShowtimeResponse showtime) {
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

  public BookingDetailResponse theater(TheaterResponse theater) {
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

  public BookingDetailResponse movie(MovieResponse movie) {
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

  public BookingDetailResponse seats(List<@Valid SeatResponse> seats) {
    this.seats = seats;
    return this;
  }

  public BookingDetailResponse addSeatsItem(SeatResponse seatsItem) {
    if (this.seats == null) {
      this.seats = new ArrayList<>();
    }
    this.seats.add(seatsItem);
    return this;
  }

  /**
   * Get seats
   * @return seats
  */
  @Valid 
  @Schema(name = "seats", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("seats")
  public List<@Valid SeatResponse> getSeats() {
    return seats;
  }

  public void setSeats(List<@Valid SeatResponse> seats) {
    this.seats = seats;
  }

  public BookingDetailResponse bookingDate(OffsetDateTime bookingDate) {
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

  public BookingDetailResponse totalAmount(Double totalAmount) {
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

  public BookingDetailResponse ticketPrice(Double ticketPrice) {
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
    BookingDetailResponse bookingDetailResponse = (BookingDetailResponse) o;
    return Objects.equals(this.bookingId, bookingDetailResponse.bookingId) &&
        Objects.equals(this.customer, bookingDetailResponse.customer) &&
        Objects.equals(this.showtime, bookingDetailResponse.showtime) &&
        Objects.equals(this.theater, bookingDetailResponse.theater) &&
        Objects.equals(this.movie, bookingDetailResponse.movie) &&
        Objects.equals(this.seats, bookingDetailResponse.seats) &&
        Objects.equals(this.bookingDate, bookingDetailResponse.bookingDate) &&
        Objects.equals(this.totalAmount, bookingDetailResponse.totalAmount) &&
        Objects.equals(this.ticketPrice, bookingDetailResponse.ticketPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, customer, showtime, theater, movie, seats, bookingDate, totalAmount, ticketPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingDetailResponse {\n");
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    showtime: ").append(toIndentedString(showtime)).append("\n");
    sb.append("    theater: ").append(toIndentedString(theater)).append("\n");
    sb.append("    movie: ").append(toIndentedString(movie)).append("\n");
    sb.append("    seats: ").append(toIndentedString(seats)).append("\n");
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

