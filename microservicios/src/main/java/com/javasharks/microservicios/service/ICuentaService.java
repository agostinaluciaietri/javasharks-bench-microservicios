package com.javasharks.microservicios.service;


import com.javasharks.microservicios.entity.Cuenta;

import java.util.List;

public interface ICuentaService {
    public List<Cuenta> findAll();
    public Cuenta findById(Long id);
}