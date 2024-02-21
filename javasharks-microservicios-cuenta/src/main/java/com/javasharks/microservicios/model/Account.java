package com.javasharks.microservicios.model;

import com.javasharks.microservicios.service.AccountServiceImpl;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Entity
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @GeneratedValue
    @Column(name="account_number", unique = true)
    private String account_number;
    @Column(name="account_type")
    private ACCOUNT_TYPE account_type;
    @Column(name="balance")
    private BigDecimal balance;
    /*@ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;*/
    @Column(name="client_id")
    public Long clientId;

    public static String accountNumberGenerator() {
        long aux = (long) (Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);
        return (String.format("%010d", aux));
    }

    public Account() {
        //this.account_number = new AccountServiceImpl.accountNumberGenerator();
        this.balance = BigDecimal.valueOf(0.0);
        this.account_number = accountNumberGenerator();
    }

}
