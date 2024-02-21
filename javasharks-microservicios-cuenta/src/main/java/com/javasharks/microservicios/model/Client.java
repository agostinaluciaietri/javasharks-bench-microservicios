package com.javasharks.microservicios.model;

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
    @Column(name="id")
    private Long id;
    @NotBlank(message = "Name must not be empty")
    @Column(unique = true)
    private String name;
    @NotBlank(message = "DNI may not be empty")
    @Column(unique=true)
    @Size(max = 8, min = 8, message = "DNI must be 8 digits long.")
    private String dni;


   // @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<Account> accounts;
}
