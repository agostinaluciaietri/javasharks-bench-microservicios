package com.javasharks.microservicios.service;

import com.javasharks.microservicios.model.Account;
import com.javasharks.microservicios.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    private RestTemplate restTemplate;

    /*
    @Autowired
    private ModelMapper mapper;
    */

    public AccountServiceImpl(AccountRepository accountRepository,RestTemplateBuilder restTemplateBuilder) {
        this.accountRepository = accountRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    public Account getAccountByIdRT(Long id) {
        return restTemplate.getForObject("http://localhost:8082/api/accounts/accountsByClient/{id}" + id.toString(), Account.class);
    }

    public List<Account> getAllAccountsRT() {
        ResponseEntity<Account[]> responseEntity = restTemplate.getForEntity("http://localhost:8082/api/accounts", Account[].class);
        Account[] accountArr = responseEntity.getBody();
        return Arrays.asList(accountArr);
    }
    public URI saveAccountRT(Account account) {
        return restTemplate.postForLocation("http://localhost:8082/api/accounts/create", account);
    }

    /*
    // original
    @Override
    @Transactional(readOnly = false)
        public List<Account> findAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }*/

    /* original
    @Override
    @Transactional(readOnly = false)
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }
    */

    /* original
    @Override
    @Transactional(readOnly = false)
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
     */


    /*
    @Override
    public Account findById(Long id) {
        ResponseEntity<Account> responseEntity = restTemplate.getForEntity("http://localhost:8082/api/accounts/accountsByClient/{id}", Account.class, id);
        Account account = responseEntity.getBody();
        return account;
    }*/

    /*
    @Override
    public String accountNumberGenerator() {
        if(accountRepository.count() == 0) {
            return "0000000001";
        } else {
            return null;
        }
    }*/

    /*
    @Override
    public List<Account> findAllAccounts() {
        //ParameterizedTypeReference<List<Account>> responseType = new ParameterizedTypeReference<List<Account>>() {
        //};
        Account[] accounts = restTemplate.getForObject("http://localhost:8082/api/accounts", Account[].class);
        assert accounts != null;
        return Arrays.asList(accounts);
        /*List<Account> accounts = new ArrayList<>();
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Account>> response =
                template.exchange("http://localhost:8082/api/accounts", accounts, Account.class);
        return accounts;
    }
    @Override
    public Account findById(Long id) {
        ResponseEntity<Account> responseEntity = restTemplate.getForEntity("http://localhost:8082/api/accounts/accountsByClient/{id}", Account.class, id);
        Account account = responseEntity.getBody();
        return account;
    }*/

    /*@Override
    public Account saveAccount(Account account) {
        restTemplate.postForObject("http://localhost:8082/api/accounts/create", newUser, User.class);
        return account;
    }*/

   /* @PostMapping(value = "/unicornsByEntity",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)*/
    /*public Account saveAccount(@RequestBody Account account) {
        Account createdAccount = new Account();
        restTemplate.postForEntity(
                "http://localhost:8082/api/accounts/create",
                createdAccount,
                Account.class);
        return createdAccount;
    }*/

    /*
    public Account saveAccount(Account account) {
        Account createdAccount = new Account();
        ResponseEntity<Account> response = restTemplate.postForEntity(
                "http://localhost:8082/api/accounts/create",
                createdAccount,
                Account.class);
        return response.getBody();
    }*/
}
