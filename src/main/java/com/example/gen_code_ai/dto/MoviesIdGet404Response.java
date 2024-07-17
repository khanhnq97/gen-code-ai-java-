package com.example.gen_code_ai.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * MoviesIdGet404Response
 */

@JsonTypeName("_movies__id__get_404_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-16T16:48:15.086559+07:00[Asia/Ho_Chi_Minh]")
public class MoviesIdGet404Response {

  private String message;

  public MoviesIdGet404Response message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Error message indicating movie not found
   * @return message
  */
  
  @Schema(name = "message", description = "Error message indicating movie not found", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    MoviesIdGet404Response moviesIdGet404Response = (MoviesIdGet404Response) o;
    return Objects.equals(this.message, moviesIdGet404Response.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoviesIdGet404Response {\n");
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

