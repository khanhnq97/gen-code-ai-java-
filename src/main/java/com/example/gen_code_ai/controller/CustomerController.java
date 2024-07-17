package com.example.gen_code_ai.controller;

import com.example.gen_code_ai.dto.CustomerRequest;
import com.example.gen_code_ai.dto.CustomerResponse;
import com.example.gen_code_ai.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public ResponseEntity<List<CustomerResponse>> getCustomers() {
        List<CustomerResponse> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest request) {
        CustomerResponse createdCustomer = customerService.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    public ResponseEntity<CustomerResponse> getCustomerById(String id) {
        CustomerResponse customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    public ResponseEntity<CustomerResponse> updateCustomer(CustomerRequest request) {
        CustomerResponse updatedCustomer = customerService.updateCustomer(request);
        return ResponseEntity.ok(updatedCustomer);
    }

    public ResponseEntity<Void> deleteCustomer(String id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
