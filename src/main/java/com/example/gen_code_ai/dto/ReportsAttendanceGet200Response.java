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
 * ReportsAttendanceGet200Response
 */

@JsonTypeName("_reports_attendance_get_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-17T10:31:45.710274+07:00[Asia/Ho_Chi_Minh]")
public class ReportsAttendanceGet200Response {

  private BigDecimal totalAttendance;

  @Valid
  private Map<String, BigDecimal> attendanceByMovie = new HashMap<>();

  public ReportsAttendanceGet200Response totalAttendance(BigDecimal totalAttendance) {
    this.totalAttendance = totalAttendance;
    return this;
  }

  /**
   * Total number of movie attendees
   * @return totalAttendance
  */
  @Valid 
  @Schema(name = "totalAttendance", description = "Total number of movie attendees", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAttendance")
  public BigDecimal getTotalAttendance() {
    return totalAttendance;
  }

  public void setTotalAttendance(BigDecimal totalAttendance) {
    this.totalAttendance = totalAttendance;
  }

  public ReportsAttendanceGet200Response attendanceByMovie(Map<String, BigDecimal> attendanceByMovie) {
    this.attendanceByMovie = attendanceByMovie;
    return this;
  }

  public ReportsAttendanceGet200Response putAttendanceByMovieItem(String key, BigDecimal attendanceByMovieItem) {
    if (this.attendanceByMovie == null) {
      this.attendanceByMovie = new HashMap<>();
    }
    this.attendanceByMovie.put(key, attendanceByMovieItem);
    return this;
  }

  /**
   * Attendance breakdown by movie
   * @return attendanceByMovie
  */
  @Valid 
  @Schema(name = "attendanceByMovie", description = "Attendance breakdown by movie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("attendanceByMovie")
  public Map<String, BigDecimal> getAttendanceByMovie() {
    return attendanceByMovie;
  }

  public void setAttendanceByMovie(Map<String, BigDecimal> attendanceByMovie) {
    this.attendanceByMovie = attendanceByMovie;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportsAttendanceGet200Response reportsAttendanceGet200Response = (ReportsAttendanceGet200Response) o;
    return Objects.equals(this.totalAttendance, reportsAttendanceGet200Response.totalAttendance) &&
        Objects.equals(this.attendanceByMovie, reportsAttendanceGet200Response.attendanceByMovie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalAttendance, attendanceByMovie);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportsAttendanceGet200Response {\n");
    sb.append("    totalAttendance: ").append(toIndentedString(totalAttendance)).append("\n");
    sb.append("    attendanceByMovie: ").append(toIndentedString(attendanceByMovie)).append("\n");
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

