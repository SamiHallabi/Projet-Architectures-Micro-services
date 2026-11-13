package com.hallabi.customerservice.service;

import com.hallabi.customerservice.entities.Customer;
import com.hallabi.customerservice.repository.CustomerRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    @McpTool(description = "Get all customers")
    public List<Customer> GetAllCustomers() {
        return customerRepository.findAll();
    }

    @McpTool(description = "Find customer by ID")
    public Customer FindCustomerById(@McpToolParam(description = "The customer id") Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not found"));
    }

    @McpTool(description = "Save a new customer")
    public Customer SaveCustomer(@McpToolParam(description = "The customer to save (name,email)") Customer customer) {
        return customerRepository.save(customer);
    }


}
