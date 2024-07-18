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
 * BookingRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-18T12:52:09.357085+07:00[Asia/Ho_Chi_Minh]")
public class BookingRequest {

  private Integer bookingId;

  private Integer customerId;

  private Integer showtimeId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime bookingDate;

  private Double totalAmount;

  private Double ticketPrice;

  public BookingRequest bookingId(Integer bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  /**
   * Unique identifier for the booking
   * @return bookingId
  */
  
  @Schema(name = "bookingId", description = "Unique identifier for the booking", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bookingId")
  public Integer getBookingId() {
    return bookingId;
  }

  public void setBookingId(Integer bookingId) {
    this.bookingId = bookingId;
  }

  public BookingRequest customerId(Integer customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * ID of the customer who made the booking
   * @return customerId
  */
  
  @Schema(name = "customerId", description = "ID of the customer who made the booking", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customerId")
  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public BookingRequest showtimeId(Integer showtimeId) {
    this.showtimeId = showtimeId;
    return this;
  }

  /**
   * ID of the showtime associated with the booking
   * @return showtimeId
  */
  
  @Schema(name = "showtimeId", description = "ID of the showtime associated with the booking", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("showtimeId")
  public Integer getShowtimeId() {
    return showtimeId;
  }

  public void setShowtimeId(Integer showtimeId) {
    this.showtimeId = showtimeId;
  }

  public BookingRequest bookingDate(OffsetDateTime bookingDate) {
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

  public BookingRequest totalAmount(Double totalAmount) {
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

  public BookingRequest ticketPrice(Double ticketPrice) {
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
    BookingRequest bookingRequest = (BookingRequest) o;
    return Objects.equals(this.bookingId, bookingRequest.bookingId) &&
        Objects.equals(this.customerId, bookingRequest.customerId) &&
        Objects.equals(this.showtimeId, bookingRequest.showtimeId) &&
        Objects.equals(this.bookingDate, bookingRequest.bookingDate) &&
        Objects.equals(this.totalAmount, bookingRequest.totalAmount) &&
        Objects.equals(this.ticketPrice, bookingRequest.ticketPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, customerId, showtimeId, bookingDate, totalAmount, ticketPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingRequest {\n");
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    showtimeId: ").append(toIndentedString(showtimeId)).append("\n");
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

