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
@Table(name="pago")
public class Pago implements Serializable {

    @Serial
    private static final long serialVersionUID = 5142258359714846156L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medioPago;
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
    private Long emisorId;
    @OneToOne(mappedBy = "pago")
    private Transaccion transaccion;
}
