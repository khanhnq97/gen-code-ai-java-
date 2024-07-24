package com.example.gen_code_ai.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * CustomerRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-23T11:54:56.445739+07:00[Asia/Ho_Chi_Minh]")
public class CustomerRequest {

  private Long customerId;

  private String name;

  private String email;

  private String phone;

  private String password;

  private String avatar;

  /**
   * Customer's membership status
   */
  public enum MembershipStatusEnum {
    BASIC("Basic"),
    
    PREMIUM("Premium");

    private String value;

    MembershipStatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MembershipStatusEnum fromValue(String value) {
      for (MembershipStatusEnum b : MembershipStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private MembershipStatusEnum membershipStatus;

  public CustomerRequest customerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Unique identifier for the customer
   * @return customerId
  */
  
  @Schema(name = "customerId", description = "Unique identifier for the customer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customerId")
  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public CustomerRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Customer's full name
   * @return name
  */
  
  @Schema(name = "name", description = "Customer's full name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Customer's email address
   * @return email
  */
  @jakarta.validation.constraints.Email
  @Schema(name = "email", description = "Customer's email address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CustomerRequest phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Customer's phone number
   * @return phone
  */
  
  @Schema(name = "phone", description = "Customer's phone number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public CustomerRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Customer's password (should be encrypted)
   * @return password
  */
  
  @Schema(name = "password", description = "Customer's password (should be encrypted)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public CustomerRequest avatar(String avatar) {
    this.avatar = avatar;
    return this;
  }

  /**
   * Customer's avatar
   * @return avatar
  */
  
  @Schema(name = "avatar", description = "Customer's avatar", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avatar")
  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public CustomerRequest membershipStatus(MembershipStatusEnum membershipStatus) {
    this.membershipStatus = membershipStatus;
    return this;
  }

  /**
   * Customer's membership status
   * @return membershipStatus
  */
  
  @Schema(name = "membershipStatus", description = "Customer's membership status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("membershipStatus")
  public MembershipStatusEnum getMembershipStatus() {
    return membershipStatus;
  }

  public void setMembershipStatus(MembershipStatusEnum membershipStatus) {
    this.membershipStatus = membershipStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerRequest customerRequest = (CustomerRequest) o;
    return Objects.equals(this.customerId, customerRequest.customerId) &&
        Objects.equals(this.name, customerRequest.name) &&
        Objects.equals(this.email, customerRequest.email) &&
        Objects.equals(this.phone, customerRequest.phone) &&
        Objects.equals(this.password, customerRequest.password) &&
        Objects.equals(this.avatar, customerRequest.avatar) &&
        Objects.equals(this.membershipStatus, customerRequest.membershipStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, name, email, phone, password, avatar, membershipStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerRequest {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
    sb.append("    membershipStatus: ").append(toIndentedString(membershipStatus)).append("\n");
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

