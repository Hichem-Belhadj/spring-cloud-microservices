package com.hbtheme.customerservice.repositories;

import com.hbtheme.customerservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
