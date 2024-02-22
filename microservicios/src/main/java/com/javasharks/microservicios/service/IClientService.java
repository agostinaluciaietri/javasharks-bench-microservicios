package com.javasharks.microservicios.service;

import com.javasharks.microservicios.entity.Client;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;


public interface IClientService {

    public List<Client> findAll();
    public Optional<Client> findById(Long id);
    public Optional<Client> findByName(String nombre);
    public Client saveClient(Client client);
    void deleteClient(Long id);
    Client updateClient(@Valid Client client, Long id);
}
