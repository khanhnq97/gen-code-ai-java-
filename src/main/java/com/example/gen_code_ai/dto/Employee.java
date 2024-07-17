package com.example.gen_code_ai.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Employee
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-17T09:23:28.630196+07:00[Asia/Ho_Chi_Minh]")
public class Employee {

  private Long employeeId;

  private String name;

  private String email;

  private String phone;

  private String position;

  private String password;

  public Employee employeeId(Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  /**
   * Unique identifier for the employee
   * @return employeeId
  */
  
  @Schema(name = "employeeId", description = "Unique identifier for the employee", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("employeeId")
  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public Employee name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Employee's full name
   * @return name
  */
  
  @Schema(name = "name", description = "Employee's full name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Employee email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Employee's email address
   * @return email
  */
  @jakarta.validation.constraints.Email
  @Schema(name = "email", description = "Employee's email address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Employee phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Employee's phone number
   * @return phone
  */
  
  @Schema(name = "phone", description = "Employee's phone number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Employee position(String position) {
    this.position = position;
    return this;
  }

  /**
   * Employee's job position
   * @return position
  */
  
  @Schema(name = "position", description = "Employee's job position", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("position")
  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Employee password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Employee's password (should be encrypted)
   * @return password
  */
  
  @Schema(name = "password", description = "Employee's password (should be encrypted)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.employeeId, employee.employeeId) &&
        Objects.equals(this.name, employee.name) &&
        Objects.equals(this.email, employee.email) &&
        Objects.equals(this.phone, employee.phone) &&
        Objects.equals(this.position, employee.position) &&
        Objects.equals(this.password, employee.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeId, name, email, phone, position, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

