package com.javasharks.microservicios.repository;

import com.javasharks.microservicios.entity.Transaccion;
import org.springframework.data.repository.CrudRepository;

public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {
}
