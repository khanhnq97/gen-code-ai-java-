package com.example.gen_code_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * BookingsPut422Response
 */

@JsonTypeName("_bookings_put_422_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-17T16:18:39.559993+07:00[Asia/Ho_Chi_Minh]")
public class BookingsPut422Response {

  private String message;

  public BookingsPut422Response message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Error message indicating insufficient tickets
   * @return message
  */
  
  @Schema(name = "message", description = "Error message indicating insufficient tickets", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingsPut422Response bookingsPut422Response = (BookingsPut422Response) o;
    return Objects.equals(this.message, bookingsPut422Response.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingsPut422Response {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

