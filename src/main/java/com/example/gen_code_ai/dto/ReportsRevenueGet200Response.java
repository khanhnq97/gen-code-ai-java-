package com.example.gen_code_ai.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ReportsRevenueGet200Response
 */

@JsonTypeName("_reports_revenue_get_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-18T12:52:09.357085+07:00[Asia/Ho_Chi_Minh]")
public class ReportsRevenueGet200Response {

  private BigDecimal totalRevenue;

  @Valid
  private Map<String, BigDecimal> revenueByMovie = new HashMap<>();

  public ReportsRevenueGet200Response totalRevenue(BigDecimal totalRevenue) {
    this.totalRevenue = totalRevenue;
    return this;
  }

  /**
   * Total revenue generated
   * @return totalRevenue
  */
  @Valid 
  @Schema(name = "totalRevenue", description = "Total revenue generated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalRevenue")
  public BigDecimal getTotalRevenue() {
    return totalRevenue;
  }

  public void setTotalRevenue(BigDecimal totalRevenue) {
    this.totalRevenue = totalRevenue;
  }

  public ReportsRevenueGet200Response revenueByMovie(Map<String, BigDecimal> revenueByMovie) {
    this.revenueByMovie = revenueByMovie;
    return this;
  }

  public ReportsRevenueGet200Response putRevenueByMovieItem(String key, BigDecimal revenueByMovieItem) {
    if (this.revenueByMovie == null) {
      this.revenueByMovie = new HashMap<>();
    }
    this.revenueByMovie.put(key, revenueByMovieItem);
    return this;
  }

  /**
   * Revenue breakdown by movie
   * @return revenueByMovie
  */
  @Valid 
  @Schema(name = "revenueByMovie", description = "Revenue breakdown by movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("revenueByMovie")
  public Map<String, BigDecimal> getRevenueByMovie() {
    return revenueByMovie;
  }

  public void setRevenueByMovie(Map<String, BigDecimal> revenueByMovie) {
    this.revenueByMovie = revenueByMovie;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportsRevenueGet200Response reportsRevenueGet200Response = (ReportsRevenueGet200Response) o;
    return Objects.equals(this.totalRevenue, reportsRevenueGet200Response.totalRevenue) &&
        Objects.equals(this.revenueByMovie, reportsRevenueGet200Response.revenueByMovie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalRevenue, revenueByMovie);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportsRevenueGet200Response {\n");
    sb.append("    totalRevenue: ").append(toIndentedString(totalRevenue)).append("\n");
    sb.append("    revenueByMovie: ").append(toIndentedString(revenueByMovie)).append("\n");
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

