package com.hbtheme.accountservice.clients;

import com.hbtheme.accountservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerClient {

    @GetMapping("/api/v1/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/api/v1/customers")
    List<Customer> getAllCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception) {
        return Customer.builder()
                .id(id)
                .firstName("Not Available")
                .lastName("Not Available")
                .email("Not Available")
                .build();
    }
}
