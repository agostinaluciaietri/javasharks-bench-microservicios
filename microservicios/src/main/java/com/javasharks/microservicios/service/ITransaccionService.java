package com.javasharks.microservicios.service;

import com.javasharks.microservicios.entity.Transaccion;

import java.util.List;

public interface ITransaccionService {
    public List<Transaccion> findAll();
    public Transaccion findById(Long id);
}