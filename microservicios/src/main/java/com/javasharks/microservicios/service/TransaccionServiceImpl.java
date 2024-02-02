package com.javasharks.microservicios.service;

import com.javasharks.microservicios.entity.Transaccion;
import com.javasharks.microservicios.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransaccionServiceImpl implements ITransaccionService{

    @Autowired
    private TransaccionRepository transaccionRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Transaccion> findAll() {
        return (List<Transaccion>) transaccionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Transaccion findById(Long id) {
        return transaccionRepository.findById(id).orElse(null);
    }
}
