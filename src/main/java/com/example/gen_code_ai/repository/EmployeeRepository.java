package com.example.gen_code_ai.repository;

import com.example.gen_code_ai.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
