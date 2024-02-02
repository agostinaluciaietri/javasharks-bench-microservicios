package com.javasharks.microservicios.service;

import com.javasharks.microservicios.entity.Cliente;
import com.javasharks.microservicios.exception.CampoNullException;
import com.javasharks.microservicios.exception.ClienteNotFoundException;
import com.javasharks.microservicios.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClienteServiceImpl implements IClienteService{


    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id); //.orElseThrow(() -> new ClienteNotFoundException("El cliente con id: " + id + " no ha sido encontrado."));
    }

    @Override
    public List<Cliente> findByNombre(String nombre) {
        return null;
    }

    /*
    @Override
    public List<Cliente> findByNombre(String nombre) {
        @Query("select c from Cliente c where c.nombre = :nombre")
        Stream<Cliente> findByEmailReturnStream(@Param("email") String email);
    }*/

    @Override
    @Transactional(readOnly = false)
    //@ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional(readOnly=false)
    public void deleteCliente(Long id) {
        /*Optional<Cliente> clienteOrNull = clienteRepository.findById(id);
        if(clienteOrNull.isPresent()) {*/
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new ClienteNotFoundException("El cliente no ha sido encontrado, id: " + id);
        }
    }

    @Override
    public Cliente updateCliente(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            cliente.setNombre(cliente.getNombre());
            cliente.setDni(cliente.getDni());
            clienteRepository.save(cliente);
            return cliente;
        } else {
            throw new ClienteNotFoundException("El cliente no ha sido encontrado, id: " + id);
        }
    }

}
