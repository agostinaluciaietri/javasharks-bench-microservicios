package com.javasharks.microservicios.entity;

import jakarta.persistence.*;
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
@Table(name="cuenta")
public class Cuenta implements Serializable {

    @Serial
    private static final long serialVersionUID = -6133872728162194891L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Transaccion> transacciones;
}
