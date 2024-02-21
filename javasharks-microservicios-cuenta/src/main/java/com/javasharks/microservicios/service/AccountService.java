package com.javasharks.microservicios.service;

import com.javasharks.microservicios.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {
    //public List<Account> findAllAccounts();
    //Optional<Account> findById(Long id);
    //Account saveAccount(Account account);

    // resttemplate
    Account getAccountByIdRT(Long id);
    List<Account> getAllAccountsRT();
    URI saveAccountRT(Account account);
}
