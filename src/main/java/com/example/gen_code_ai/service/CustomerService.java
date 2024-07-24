package com.example.gen_code_ai.service;

import com.example.gen_code_ai.dto.CustomerRequest;
import com.example.gen_code_ai.dto.CustomerResponse;
import com.example.gen_code_ai.entity.Customer;
import com.example.gen_code_ai.exception.CustomerAlreadyExistsException;
import com.example.gen_code_ai.exception.CustomerNotFoundException;
import com.example.gen_code_ai.repository.CustomerRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
    this.customerRepository = customerRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public List<CustomerResponse> getAllCustomers() {
    return customerRepository.findAll().stream()
        .map(this::convertEntityToResponse)
        .collect(Collectors.toList());
  }

  public CustomerResponse createCustomer(CustomerRequest request) {
    if (customerRepository.findByEmail(request.getEmail()).isPresent()) {
      throw new CustomerAlreadyExistsException("Customer with this email already exists");
    }
    Customer customer = convertRequestToEntity(request);
    Customer savedCustomer = customerRepository.save(customer);
    return convertEntityToResponse(savedCustomer);
  }

  public CustomerResponse getCustomerById(Long id) {
    Customer customer =
        customerRepository
            .findById(id)
            .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    return convertEntityToResponse(customer);
  }

  public CustomerResponse updateCustomer(CustomerRequest request) {
    Customer customer =
        customerRepository
            .findById(request.getCustomerId())
            .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

    customer.setName(request.getName());
    customer.setEmail(request.getEmail());
    customer.setPhone(request.getPhone());
    customer.setPassword(request.getPassword());
    customer.setAvatar(request.getAvatar());
    // todo: need update logic to get membership status
    customer.setMembershipStatus(CustomerResponse.MembershipStatusEnum.BASIC.getValue());

    Customer updatedCustomer = customerRepository.save(customer);
    return convertEntityToResponse(updatedCustomer);
  }

  public void deleteCustomer(Long id) {
    if (!customerRepository.existsById(id)) {
      throw new CustomerNotFoundException("Customer not found");
    }
    customerRepository.deleteById(id);
  }

  // convertcustomerentitytocustomerresponse
  private CustomerResponse convertEntityToResponse(Customer customer) {
    CustomerResponse response = new CustomerResponse();
    response.setCustomerId(customer.getCustomerId());
    response.setName(customer.getName());
    response.setEmail(customer.getEmail());
    response.setPhone(customer.getPhone());
    response.setAvatar(customer.getAvatar());
    // todo: need update logic to get membership status
    response.setMembershipStatus(CustomerResponse.MembershipStatusEnum.BASIC);
    return response;
  }

  // convert customer request to customer entity
  private Customer convertRequestToEntity(CustomerRequest request) {
    Customer customer = new Customer();
    customer.setName(request.getName());
    customer.setEmail(request.getEmail());
    customer.setPhone(request.getPhone());
    customer.setPassword((request.getPassword()));
    customer.setAvatar(request.getAvatar());
    // todo: need update logic to get membership status
    customer.setMembershipStatus(CustomerResponse.MembershipStatusEnum.BASIC.getValue());
    return customer;
  }
}
