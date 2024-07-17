package com.example.gen_code_ai.service;

import com.example.gen_code_ai.dto.EmployeeRequest;
import com.example.gen_code_ai.dto.EmployeeResponse;
import com.example.gen_code_ai.entity.EmployeeEntity;
import com.example.gen_code_ai.exception.EmployeeNotFoundException;
import com.example.gen_code_ai.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream().map(this::convertEntityToResponse).collect(Collectors.toList());
    }

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employee = convertRequestToEntity(employeeRequest);
        EmployeeEntity savedEmployee = employeeRepository.save(employee);
        return convertEntityToResponse(savedEmployee);
    }

    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity existingEmployee = employeeRepository.findById(employeeRequest.getEmployeeId()).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + employeeRequest.getEmployeeId()));

        EmployeeEntity updatedEmployee = updateEmployeeFromRequest(existingEmployee, employeeRequest);
        EmployeeEntity updatedEmployeeSaved = employeeRepository.save(updatedEmployee);
        return convertEntityToResponse(updatedEmployeeSaved);
    }

    public EmployeeResponse getEmployeeById(String id) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        return convertEntityToResponse(employee);
    }

    public void deleteEmployee(String id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    //todo: need update passwordEncoder

    private EmployeeEntity updateEmployeeFromRequest(EmployeeEntity employee, EmployeeRequest request) {
        // Update employee properties from request
        // Be careful not to update the id
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setPosition(request.getPosition());
        employee.setPassword(request.getPassword());
        return employee;
    }


    // convert employee request to employee entity
    //todo: need update passwordEncoder
    private EmployeeEntity convertRequestToEntity(EmployeeRequest request) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setPosition(request.getPosition());
        employee.setPassword(request.getPassword());
        return employee;
    }

    // convert employee entity to employee response
    private EmployeeResponse convertEntityToResponse(EmployeeEntity employee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setEmployeeId(employee.getId());
        response.setName(employee.getName());
        response.setEmail(employee.getEmail());
        response.setPhone(employee.getPhone());
        response.setPosition(employee.getPosition());
        return response;
    }
}
