package com.javasharks.microservicios.service;

import com.javasharks.microservicios.entity.Pago;

import java.util.List;

public interface IPagoService {
    public List<Pago> findAll();
    public Pago findById(Long id);
}