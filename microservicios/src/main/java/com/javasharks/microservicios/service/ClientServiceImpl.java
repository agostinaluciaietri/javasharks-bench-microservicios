package com.javasharks.microservicios.service;

import com.javasharks.microservicios.entity.Client;
import com.javasharks.microservicios.exception.ClientNotFoundException;
import com.javasharks.microservicios.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService {


    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Optional<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = false)
    //@ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional(readOnly=false)
    public void deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new ClientNotFoundException("Client not found, id: " + id);
        }
    }

    @Override
    @Transactional(readOnly=false)
    public Client updateClient(@Valid @RequestBody Client client, @PathVariable Long id) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            client.setName(client.getName());
            client.setDni(client.getDni());
            clientRepository.save(client);
            return client;
        } else {
            throw new ClientNotFoundException("Client not found, id: " + id);
        }
    }

}
