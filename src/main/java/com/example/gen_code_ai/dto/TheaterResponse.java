package com.example.gen_code_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * TheaterResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-23T11:54:56.445739+07:00[Asia/Ho_Chi_Minh]")
public class TheaterResponse {

  private Long theaterId;

  private String name;

  private Integer capacity;

  public TheaterResponse theaterId(Long theaterId) {
    this.theaterId = theaterId;
    return this;
  }

  /**
   * Unique identifier for the theater
   * @return theaterId
  */
  
  @Schema(name = "theaterId", description = "Unique identifier for the theater", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("theaterId")
  public Long getTheaterId() {
    return theaterId;
  }

  public void setTheaterId(Long theaterId) {
    this.theaterId = theaterId;
  }

  public TheaterResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the theater
   * @return name
  */
  
  @Schema(name = "name", description = "Name of the theater", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TheaterResponse capacity(Integer capacity) {
    this.capacity = capacity;
    return this;
  }

  /**
   * Capacity of the theater
   * @return capacity
  */
  
  @Schema(name = "capacity", description = "Capacity of the theater", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("capacity")
  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TheaterResponse theaterResponse = (TheaterResponse) o;
    return Objects.equals(this.theaterId, theaterResponse.theaterId) &&
        Objects.equals(this.name, theaterResponse.name) &&
        Objects.equals(this.capacity, theaterResponse.capacity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(theaterId, name, capacity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TheaterResponse {\n");
    sb.append("    theaterId: ").append(toIndentedString(theaterId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
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

