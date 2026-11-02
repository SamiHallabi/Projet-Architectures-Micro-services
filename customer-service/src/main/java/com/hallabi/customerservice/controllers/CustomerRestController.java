package com.hallabi.customerservice.controllers;

import com.hallabi.customerservice.entities.Customer;
import com.hallabi.customerservice.repository.CustomerRepository;
import com.hallabi.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {

    private  CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customers")
    public List<Customer> GetAllCustomers() {
        return customerService.GetAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer FindCustomerById(@PathVariable Long id) {
        return customerService.FindCustomerById(id);
    }

    @PostMapping("/customers")
    public Customer SaveCustomer(@RequestBody Customer customer) {
        return customerService.SaveCustomer(customer);
    }
}
