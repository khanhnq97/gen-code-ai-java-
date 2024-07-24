package com.example.gen_code_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Booking
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-17T11:01:02.954251+07:00[Asia/Ho_Chi_Minh]")
public class Booking {

  private Long bookingId;

  private Long customerId;

  private Long showtimeId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime bookingDate;

  private Double totalAmount;

  public Booking bookingId(Long bookingId) {
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

  public Booking customerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * ID of the customer who made the booking
   * @return customerId
  */
  
  @Schema(name = "customerId", description = "ID of the customer who made the booking", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customerId")
  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Booking showtimeId(Long showtimeId) {
    this.showtimeId = showtimeId;
    return this;
  }

  /**
   * ID of the showtime associated with the booking
   * @return showtimeId
  */
  
  @Schema(name = "showtimeId", description = "ID of the showtime associated with the booking", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("showtimeId")
  public Long getShowtimeId() {
    return showtimeId;
  }

  public void setShowtimeId(Long showtimeId) {
    this.showtimeId = showtimeId;
  }

  public Booking bookingDate(OffsetDateTime bookingDate) {
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

  public Booking totalAmount(Double totalAmount) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking booking = (Booking) o;
    return Objects.equals(this.bookingId, booking.bookingId) &&
        Objects.equals(this.customerId, booking.customerId) &&
        Objects.equals(this.showtimeId, booking.showtimeId) &&
        Objects.equals(this.bookingDate, booking.bookingDate) &&
        Objects.equals(this.totalAmount, booking.totalAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, customerId, showtimeId, bookingDate, totalAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Booking {\n");
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    showtimeId: ").append(toIndentedString(showtimeId)).append("\n");
    sb.append("    bookingDate: ").append(toIndentedString(bookingDate)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
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

