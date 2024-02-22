package com.javasharks.microservicios.repository;

import com.javasharks.microservicios.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    // por qué pide crearlo en repository? acá no van declaraciones de métodos, pero sí en IClientService.
    Optional<Client> findByName(String name);
}
