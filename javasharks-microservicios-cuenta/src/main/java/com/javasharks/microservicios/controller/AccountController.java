package com.javasharks.microservicios.controller;

import com.javasharks.microservicios.model.Account;
import com.javasharks.microservicios.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccountsRT() {
        List<Account> accounts = accountService.getAllAccountsRT();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/accounts/accountById/{id}")
    public ResponseEntity<Account> getAccountByIdRT(@PathVariable Long id) {
        Account account = accountService.getAccountByIdRT(id);
        if(account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/accounts/create")
    public ResponseEntity<String> saveAccount(@Valid @RequestBody Account account)  {
        URI uri = accountService.saveAccountRT(account);
        return ResponseEntity.ok(uri.toString());
    }

    /* original
    @GetMapping("/accounts")
    public List<Account> findAllAccounts() {
        return accountService.findAllAccounts();
    }
    */

    /* original
    @GetMapping("accounts/accountById/{id}")
    public Optional<Account> findAccountById(@PathVariable Long id) {
        return Optional.ofNullable(accountService.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found, id: " + id)));
    }
    */


    /* original
    @PostMapping("/accounts/create")
    public ResponseEntity<Account> saveAccount(@Valid @RequestBody Account account)  {
        /*Account savedAccount = accountService.saveAccount(account);
        return ResponseEntity.ok(savedAccount);
        /*
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Account> response = restTemplate.postForEntity(
                "http://localhost:8082/api/accounts/create",
                account,
                Account.class
                );
        Account createdAccount = response.getBody();
        return ResponseEntity.ok(createdAccount);
    }
    */
}
