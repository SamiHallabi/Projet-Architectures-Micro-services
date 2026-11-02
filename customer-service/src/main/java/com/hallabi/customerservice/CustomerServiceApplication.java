package com.hallabi.customerservice;

import com.hallabi.customerservice.entities.Customer;
import com.hallabi.customerservice.repository.CustomerRepository;
import com.hallabi.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService) {
		return args -> {
			List<String> names = List.of("Sami", "Mohammed", "yasser");

			names.forEach(name -> {
				customerService.SaveCustomer(Customer.builder()
						.name(name)
						.email(name+"@gmail.com")
						.build());
			});
		};
	}

}
