package com.javasharks.microservicios.repository;

import com.javasharks.microservicios.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

public interface CuentaRepository extends CrudRepository<Cuenta, Long> {
}
