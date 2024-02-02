package com.javasharks.microservicios.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="transaccion")
public class Transaccion implements Serializable {

    @Serial
    private static final long serialVersionUID = -3190354198050100191L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
    private double monto;
    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pago_id", unique = true, nullable = false)
    private Pago pago;
    @Enumerated(EnumType.STRING)
    private TIPO_TRANSACCION tipo_transaccion;
}
