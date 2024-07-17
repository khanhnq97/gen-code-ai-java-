package com.example.gen_code_ai.controller;

import com.example.gen_code_ai.dto.EmployeeRequest;
import com.example.gen_code_ai.dto.EmployeeResponse;
import com.example.gen_code_ai.exception.EmployeeAlreadyExistsException;
import com.example.gen_code_ai.exception.EmployeeNotFoundException;
import com.example.gen_code_ai.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public ResponseEntity<List<EmployeeResponse>> getEmployees() {
        List<EmployeeResponse> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    public ResponseEntity<EmployeeResponse> createEmployee(EmployeeRequest employeeRequest) {
        EmployeeResponse createdEmployee = employeeService.createEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    public ResponseEntity<EmployeeResponse> updateEmployee(EmployeeRequest employeeRequest) {
        try {
            EmployeeResponse updatedEmployee = employeeService.updateEmployee(employeeRequest);
            return ResponseEntity.ok(updatedEmployee);
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (EmployeeAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<EmployeeResponse> getEmployeeById(String id) {
        try {
            EmployeeResponse employee = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteEmployee(String id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}