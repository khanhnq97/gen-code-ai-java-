package com.example.gen_code_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * SeatResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-23T11:54:56.445739+07:00[Asia/Ho_Chi_Minh]")
public class SeatResponse {

  private Long seatId;

  private String rowNum;

  private Integer seatNumber;

  public SeatResponse seatId(Long seatId) {
    this.seatId = seatId;
    return this;
  }

  /**
   * Unique identifier for the seat
   * @return seatId
  */
  
  @Schema(name = "seatId", description = "Unique identifier for the seat", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("seatId")
  public Long getSeatId() {
    return seatId;
  }

  public void setSeatId(Long seatId) {
    this.seatId = seatId;
  }

  public SeatResponse rowNum(String rowNum) {
    this.rowNum = rowNum;
    return this;
  }

  /**
   * Row of the seat
   * @return rowNum
  */
  
  @Schema(name = "row_num", description = "Row of the seat", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("row_num")
  public String getRowNum() {
    return rowNum;
  }

  public void setRowNum(String rowNum) {
    this.rowNum = rowNum;
  }

  public SeatResponse seatNumber(Integer seatNumber) {
    this.seatNumber = seatNumber;
    return this;
  }

  /**
   * Seat number of the seat
   * @return seatNumber
  */
  
  @Schema(name = "seat_number", description = "Seat number of the seat", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("seat_number")
  public Integer getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(Integer seatNumber) {
    this.seatNumber = seatNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SeatResponse seatResponse = (SeatResponse) o;
    return Objects.equals(this.seatId, seatResponse.seatId) &&
        Objects.equals(this.rowNum, seatResponse.rowNum) &&
        Objects.equals(this.seatNumber, seatResponse.seatNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seatId, rowNum, seatNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeatResponse {\n");
    sb.append("    seatId: ").append(toIndentedString(seatId)).append("\n");
    sb.append("    rowNum: ").append(toIndentedString(rowNum)).append("\n");
    sb.append("    seatNumber: ").append(toIndentedString(seatNumber)).append("\n");
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

