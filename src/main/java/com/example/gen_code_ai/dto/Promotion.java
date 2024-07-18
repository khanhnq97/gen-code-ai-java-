package com.example.gen_code_ai.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
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
 * Promotion
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-19T00:56:02.813115+07:00[Asia/Ho_Chi_Minh]")
public class Promotion {

  private Integer promotionId;

  private String name;

  private String description;

  private BigDecimal discountPercent;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endDate;

  /**
   * Default constructor
   * @deprecated Use {@link Promotion#Promotion(Integer, String, String, BigDecimal, OffsetDateTime, OffsetDateTime)}
   */
  @Deprecated
  public Promotion() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Promotion(Integer promotionId, String name, String description, BigDecimal discountPercent, OffsetDateTime startDate, OffsetDateTime endDate) {
    this.promotionId = promotionId;
    this.name = name;
    this.description = description;
    this.discountPercent = discountPercent;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Promotion promotionId(Integer promotionId) {
    this.promotionId = promotionId;
    return this;
  }

  /**
   * Unique identifier for the promotion
   * @return promotionId
  */
  @NotNull 
  @Schema(name = "promotionId", example = "1", description = "Unique identifier for the promotion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("promotionId")
  public Integer getPromotionId() {
    return promotionId;
  }

  public void setPromotionId(Integer promotionId) {
    this.promotionId = promotionId;
  }

  public Promotion name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the promotion
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Summer Sale", description = "Name of the promotion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Promotion description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the promotion
   * @return description
  */
  @NotNull 
  @Schema(name = "description", example = "Get 20% off all items!", description = "Description of the promotion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Promotion discountPercent(BigDecimal discountPercent) {
    this.discountPercent = discountPercent;
    return this;
  }

  /**
   * Discount percentage offered by the promotion (0-1)
   * @return discountPercent
  */
  @NotNull @Valid 
  @Schema(name = "discountPercent", example = "0.2", description = "Discount percentage offered by the promotion (0-1)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("discountPercent")
  public BigDecimal getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(BigDecimal discountPercent) {
    this.discountPercent = discountPercent;
  }

  public Promotion startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Start date of the promotion (ISO 8601 format)
   * @return startDate
  */
  @NotNull @Valid 
  @Schema(name = "startDate", example = "2024-07-15T00:00Z", description = "Start date of the promotion (ISO 8601 format)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startDate")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public Promotion endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * End date of the promotion (ISO 8601 format)
   * @return endDate
  */
  @NotNull @Valid 
  @Schema(name = "endDate", example = "2024-08-31T23:59:59Z", description = "End date of the promotion (ISO 8601 format)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("endDate")
  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Promotion promotion = (Promotion) o;
    return Objects.equals(this.promotionId, promotion.promotionId) &&
        Objects.equals(this.name, promotion.name) &&
        Objects.equals(this.description, promotion.description) &&
        Objects.equals(this.discountPercent, promotion.discountPercent) &&
        Objects.equals(this.startDate, promotion.startDate) &&
        Objects.equals(this.endDate, promotion.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(promotionId, name, description, discountPercent, startDate, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Promotion {\n");
    sb.append("    promotionId: ").append(toIndentedString(promotionId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountPercent: ").append(toIndentedString(discountPercent)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

