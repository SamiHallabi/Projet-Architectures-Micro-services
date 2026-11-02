package com.hallabi.customerservice.service;

import com.hallabi.customerservice.entities.Customer;
import com.hallabi.customerservice.repository.CustomerRepository;
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

    public List<Customer> GetAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer FindCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not found"));
    }

    public Customer SaveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


}
