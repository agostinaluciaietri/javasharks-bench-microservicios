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
@Table(name="cliente")
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 2238679474050290576L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nombre es un campo obligatorio")
    private String nombre;
    @NotBlank(message = "DNI es un campo obligatorio")
    @Size(max = 8, min = 8, message = "El DNI debe tener sólo 8 dígitos.")
    private String dni;
    /*@NotBlank(message = "CBU es un campo obligatorio")
    @Size(max = 22, min = 22, message = "El CBU debe tener sólo 22 dígitos.")
    private String cbu;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;
    */
}
