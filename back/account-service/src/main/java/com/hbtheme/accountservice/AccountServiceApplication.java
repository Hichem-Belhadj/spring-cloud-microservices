package com.hbtheme.accountservice;

import com.hbtheme.accountservice.clients.CustomerClient;
import com.hbtheme.accountservice.enums.AccountType;
import com.hbtheme.accountservice.models.BankAccount;
import com.hbtheme.accountservice.models.Customer;
import com.hbtheme.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerClient customerClient) {
        return args -> {
            customerClient.getAllCustomers().forEach(c->{
                List<BankAccount> accounts = List.of(
                        BankAccount.builder()
                                .id(UUID.randomUUID().toString())
                                .currency("EUR")
                                .balance(Math.random()+65432)
                                .createdAt(LocalDate.now())
                                .type(AccountType.CURRENT_ACCOUNT)
                                .customerId(c.getId())
                                .build(),
                        BankAccount.builder()
                                .id(UUID.randomUUID().toString())
                                .currency("EUR")
                                .balance(Math.random()+65432)
                                .createdAt(LocalDate.now())
                                .type(AccountType.SAVING_ACCOUNT)
                                .customerId(c.getId())
                                .build()
                );

                bankAccountRepository.saveAll(accounts);
            });
        };
    }
}
