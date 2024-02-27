package com.hbtheme.accountservice.controllers;

import com.hbtheme.accountservice.clients.CustomerClient;
import com.hbtheme.accountservice.models.BankAccount;
import com.hbtheme.accountservice.models.Customer;
import com.hbtheme.accountservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class BankAccountController {
    private final BankAccountRepository bankAccountRepository;
    private final CustomerClient customerClient;

    public BankAccountController(BankAccountRepository bankAccountRepository, CustomerClient customerClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerClient = customerClient;
    }

    @GetMapping()
    public List<BankAccount> getAccounts() {
        List<BankAccount> accounts = bankAccountRepository.findAll();
        accounts.forEach(acc -> {
            acc.setCustomer(customerClient.findCustomerById(acc.getCustomerId()));
        });
        return accounts;
    }

    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
