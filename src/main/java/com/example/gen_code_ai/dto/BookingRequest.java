package com.example.gen_code_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * BookingRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-23T11:54:56.445739+07:00[Asia/Ho_Chi_Minh]")
public class BookingRequest {

  private JsonNullable<Long> bookingId = JsonNullable.undefined();

  private Long customerId;

  private Long showtimeId;

  private Long theaterId;

  @Valid
  private List<Long> seatIds = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link BookingRequest#BookingRequest(Long, Long, Long, List<Long>)}
   */
  @Deprecated
  public BookingRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BookingRequest(Long customerId, Long showtimeId, Long theaterId, List<Long> seatIds) {
    this.customerId = customerId;
    this.showtimeId = showtimeId;
    this.theaterId = theaterId;
    this.seatIds = seatIds;
  }

  public BookingRequest bookingId(Long bookingId) {
    this.bookingId = JsonNullable.of(bookingId);
    return this;
  }

  /**
   * Unique identifier for the booking
   * @return bookingId
  */
  
  @Schema(name = "bookingId", description = "Unique identifier for the booking", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bookingId")
  public JsonNullable<Long> getBookingId() {
    return bookingId;
  }

  public void setBookingId(JsonNullable<Long> bookingId) {
    this.bookingId = bookingId;
  }

  public BookingRequest customerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * ID of the customer who made the booking
   * @return customerId
  */
  @NotNull 
  @Schema(name = "customerId", description = "ID of the customer who made the booking", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customerId")
  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public BookingRequest showtimeId(Long showtimeId) {
    this.showtimeId = showtimeId;
    return this;
  }

  /**
   * ID of the showtime associated with the booking
   * @return showtimeId
  */
  @NotNull 
  @Schema(name = "showtimeId", description = "ID of the showtime associated with the booking", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("showtimeId")
  public Long getShowtimeId() {
    return showtimeId;
  }

  public void setShowtimeId(Long showtimeId) {
    this.showtimeId = showtimeId;
  }

  public BookingRequest theaterId(Long theaterId) {
    this.theaterId = theaterId;
    return this;
  }

  /**
   * ID of the theater where the showtime is taking place
   * @return theaterId
  */
  @NotNull 
  @Schema(name = "theaterId", description = "ID of the theater where the showtime is taking place", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("theaterId")
  public Long getTheaterId() {
    return theaterId;
  }

  public void setTheaterId(Long theaterId) {
    this.theaterId = theaterId;
  }

  public BookingRequest seatIds(List<Long> seatIds) {
    this.seatIds = seatIds;
    return this;
  }

  public BookingRequest addSeatIdsItem(Long seatIdsItem) {
    if (this.seatIds == null) {
      this.seatIds = new ArrayList<>();
    }
    this.seatIds.add(seatIdsItem);
    return this;
  }

  /**
   * Get seatIds
   * @return seatIds
  */
  @NotNull 
  @Schema(name = "seatIds", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("seatIds")
  public List<Long> getSeatIds() {
    return seatIds;
  }

  public void setSeatIds(List<Long> seatIds) {
    this.seatIds = seatIds;
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
    return equalsNullable(this.bookingId, bookingRequest.bookingId) &&
        Objects.equals(this.customerId, bookingRequest.customerId) &&
        Objects.equals(this.showtimeId, bookingRequest.showtimeId) &&
        Objects.equals(this.theaterId, bookingRequest.theaterId) &&
        Objects.equals(this.seatIds, bookingRequest.seatIds);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(bookingId), customerId, showtimeId, theaterId, seatIds);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingRequest {\n");
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    showtimeId: ").append(toIndentedString(showtimeId)).append("\n");
    sb.append("    theaterId: ").append(toIndentedString(theaterId)).append("\n");
    sb.append("    seatIds: ").append(toIndentedString(seatIds)).append("\n");
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

