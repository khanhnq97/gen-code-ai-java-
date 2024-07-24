/*
Giải thích:

@Entity: Đánh dấu class này là một JPA entity.
@Table(name = "Employees"): Chỉ định tên bảng trong cơ sở dữ liệu.
@Id: Đánh dấu trường employeeId là khóa chính.
@GeneratedValue(strategy = GenerationType.IDENTITY): Chỉ định cách tạo giá trị cho khóa chính, ở đây sử dụng auto-increment.
@Column: Được sử dụng để chỉ định các thuộc tính của cột như tên, có thể null hay không, độ dài tối đa, unique, ...
Các getter và setter được tạo cho tất cả các trường để cho phép truy cập và sửa đổi dữ liệu.
Một constructor mặc định (không tham số) và một constructor với tất cả các trường (trừ id) được tạo.

Lưu ý:

Tôi đã sử dụng Integer thay vì int cho employeeId để cho phép giá trị null (có thể hữu ích trong một số trường hợp).
Password được lưu trữ dưới dạng VARCHAR(255). Trong thực tế, bạn nên mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu.
Bạn có thể cần thêm các annotations khác hoặc điều chỉnh class này tùy thuộc vào yêu cầu cụ thể của ứng dụng của bạn.*/

package com.example.gen_code_ai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "position", length = 50)
    private String position;

    @Column(name = "password", length = 255)
    private String password;

    public Long getId() {
        return employeeId;
    }

    public void setId(Long id) {
        this.employeeId = id;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" + "employeeId='" + employeeId + '\'' + ", name='" + name + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", position='" + position + '\'' + ", password='" + password + '\'' + '}';
    }
}


