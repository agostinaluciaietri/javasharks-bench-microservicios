package com.javasharks.microservicios.service;

import com.javasharks.microservicios.entity.Cuenta;
import com.javasharks.microservicios.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CuentaServiceImpl implements ICuentaService{

    @Autowired
    private CuentaRepository cuentaRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Cuenta> findAll() {
        return (List<Cuenta>) cuentaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cuenta findById(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }
}
