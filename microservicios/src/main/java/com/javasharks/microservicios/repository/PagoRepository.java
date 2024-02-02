package com.javasharks.microservicios.repository;

import com.javasharks.microservicios.entity.Pago;
import org.springframework.data.repository.CrudRepository;

public interface PagoRepository extends CrudRepository<Pago, Long> {
}
