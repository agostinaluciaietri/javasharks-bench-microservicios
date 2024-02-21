package com.javasharks.microservicios;

import com.javasharks.microservicios.model.Account;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Component
public class AccountClient {

    private final RestTemplate restTemplate;

    public AccountClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Account getAccountByIdRT(Long id) {
        return restTemplate.getForObject("http://localhost:8082/api/accounts/accountsByClient/{id}" + id.toString(), Account.class);
    }

    public List<Account> getAllAccountsRT() {
        ResponseEntity<Account[]> responseEntity = restTemplate.getForEntity("http://localhost:8082/api/accounts", Account[].class);
        Account[] accountArr = responseEntity.getBody();
        assert accountArr != null;
        return Arrays.asList(accountArr);
    }
    public URI saveAccountRT(Long id) {
        return restTemplate.postForLocation("http://localhost:8082/api/accounts/create", Account.class);
    }
}
