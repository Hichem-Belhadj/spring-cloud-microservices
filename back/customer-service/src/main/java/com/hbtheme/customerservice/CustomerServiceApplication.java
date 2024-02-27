package com.hbtheme.customerservice;

import com.hbtheme.customerservice.config.GlobalConfig;
import com.hbtheme.customerservice.models.Customer;
import com.hbtheme.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customers = List.of(
                Customer.builder()
                        .firstName("Hichem")
                        .lastName("BEL-HADJ")
                        .email("hich@gmail.com")
                        .build(),
                 Customer.builder()
                        .firstName("Zohra")
                        .lastName("BEL-HADJ")
                        .email("zoh@gmail.com")
                        .build(),
                Customer.builder()
                        .firstName("Jasmine")
                        .lastName("BEL-HADJ")
                        .email("jass@gmail.com")
                        .build(),
                Customer.builder()
                        .firstName("Jessim")
                        .lastName("BEL-HADJ")
                        .email("jess@gmail.com")
                        .build()
            );

            customerRepository.saveAll(customers);
        };
    }

}
