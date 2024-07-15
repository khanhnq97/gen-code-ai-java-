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
 * MoviesIdPut500Response
 */

@JsonTypeName("_movies__id__put_500_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-15T11:36:25.960018+07:00[Asia/Ho_Chi_Minh]")
public class MoviesIdPut500Response {

  private String message;

  public MoviesIdPut500Response message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Generic error message
   * @return message
  */
  
  @Schema(name = "message", description = "Generic error message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    MoviesIdPut500Response moviesIdPut500Response = (MoviesIdPut500Response) o;
    return Objects.equals(this.message, moviesIdPut500Response.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoviesIdPut500Response {\n");
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

