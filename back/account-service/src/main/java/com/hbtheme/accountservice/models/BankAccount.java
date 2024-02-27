package com.hbtheme.accountservice.models;

import com.hbtheme.accountservice.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class BankAccount {
    @Id
    private String id;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.ORDINAL)
    private AccountType type;
    private Long customerId;
    @Transient
    private Customer customer;
}
