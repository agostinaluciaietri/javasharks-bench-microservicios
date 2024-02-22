package com.javasharks.microservicios.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountResponse {
    private Long id;
    private String account_number;
    private String account_type;
    private BigDecimal balance;
    public Long clientId;
}
