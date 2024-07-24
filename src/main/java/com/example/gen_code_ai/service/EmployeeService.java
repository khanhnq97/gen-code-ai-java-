package com.example.gen_code_ai.service;

import com.example.gen_code_ai.dto.EmployeeRequest;
import com.example.gen_code_ai.dto.EmployeeResponse;
import com.example.gen_code_ai.entity.Employee;
import com.example.gen_code_ai.exception.EmployeeNotFoundException;
import com.example.gen_code_ai.repository.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired private EmployeeRepository employeeRepository;

  public List<EmployeeResponse> getAllEmployees() {
    return employeeRepository.findAll().stream()
        .map(this::convertEntityToResponse)
        .collect(Collectors.toList());
  }

  public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
    Employee employee = convertRequestToEntity(employeeRequest);
    Employee savedEmployee = employeeRepository.save(employee);
    return convertEntityToResponse(savedEmployee);
  }

  public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest) {
    Employee existingEmployee =
        employeeRepository
            .findById(employeeRequest.getEmployeeId())
            .orElseThrow(
                () ->
                    new EmployeeNotFoundException(
                        "Employee not found with id: " + employeeRequest.getEmployeeId()));

    Employee updatedEmployee = updateEmployeeFromRequest(existingEmployee, employeeRequest);
    Employee updatedEmployeeSaved = employeeRepository.save(updatedEmployee);
    return convertEntityToResponse(updatedEmployeeSaved);
  }

  public EmployeeResponse getEmployeeById(Long id) {
    Employee employee =
        employeeRepository
            .findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    return convertEntityToResponse(employee);
  }

  public void deleteEmployee(Long id) {
    if (!employeeRepository.existsById(id)) {
      throw new EmployeeNotFoundException("Employee not found with id: " + id);
    }
    employeeRepository.deleteById(id);
  }

  // todo: need update passwordEncoder

  private Employee updateEmployeeFromRequest(Employee employee, EmployeeRequest request) {
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
  // todo: need update passwordEncoder
  private Employee convertRequestToEntity(EmployeeRequest request) {
    Employee employee = new Employee();
    employee.setName(request.getName());
    employee.setEmail(request.getEmail());
    employee.setPhone(request.getPhone());
    employee.setPosition(request.getPosition());
    employee.setPassword(request.getPassword());
    return employee;
  }

  // convert employee entity to employee response
  private EmployeeResponse convertEntityToResponse(Employee employee) {
    EmployeeResponse response = new EmployeeResponse();
    response.setEmployeeId(employee.getId());
    response.setName(employee.getName());
    response.setEmail(employee.getEmail());
    response.setPhone(employee.getPhone());
    response.setPosition(employee.getPosition());
    return response;
  }
}
