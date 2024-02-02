package com.javasharks.microservicios.service;

import com.javasharks.microservicios.entity.Pago;
import com.javasharks.microservicios.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagoServiceImpl implements IPagoService{

    @Autowired
    private PagoRepository pagoRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Pago> findAll() {
        return (List<Pago>) pagoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pago findById(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }
}
