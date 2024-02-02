package com.javasharks.microservicios.service;

import com.javasharks.microservicios.entity.Cliente;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;


public interface IClienteService {

    public List<Cliente> findAll();
    public Optional<Cliente> findById(Long id);
    List<Cliente> findByNombre(String nombre);

    public Cliente saveCliente(Cliente cliente);
    void deleteCliente(Long id);
    Cliente updateCliente(@Valid Cliente cliente, Long id);
}
