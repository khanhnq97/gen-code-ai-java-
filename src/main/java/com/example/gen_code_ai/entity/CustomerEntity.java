package com.example.gen_code_ai.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String membershipStatus;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" + "id='" + customerId + '\'' + ", name='" + name + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", password='" + password + '\'' + ", membershipStatus=" + membershipStatus + '}';
    }
}

