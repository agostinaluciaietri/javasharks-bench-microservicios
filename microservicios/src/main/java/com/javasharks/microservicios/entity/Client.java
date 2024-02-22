package com.javasharks.microservicios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="client")
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 2238679474050290576L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name must not be empty")
    @Column(unique = true)
    private String name;
    @NotBlank(message = "DNI may not be empty")
    @Column(unique=true)
    @Size(max = 8, min = 8, message = "DNI must be 8 digits long.")
    private String dni;
    /*
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Account> accounts;*/
}
