package com.hbtheme.accountservice.repositories;

import com.hbtheme.accountservice.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
