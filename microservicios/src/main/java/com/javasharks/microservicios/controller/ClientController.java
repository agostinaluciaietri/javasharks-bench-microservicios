package com.javasharks.microservicios.controller;

import com.javasharks.microservicios.entity.Client;
import com.javasharks.microservicios.exception.ClientNotFoundException;
import com.javasharks.microservicios.service.ClientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class ClientController {

    private final ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> listClients() {
        return clientService.findAll();
    }

    @GetMapping("/clients/search/id/{id}")
    public Client clientById(@PathVariable Long id) {
        return clientService.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client not found, id: " + id));
    }

    @GetMapping("/clients/search/name/{name}")
    public Client clientByName(@PathVariable String name) {
        return clientService.findByName(name)
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
    }

    @PostMapping("/clients/create")
    public ResponseEntity<Client> saveClient(@Valid @RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);
        return ResponseEntity.ok(savedClient);
    }

    @DeleteMapping("/clients/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.ok("Client (id: " + id + ") has been deleted successfully.");
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found, id: " + id);
        }
    }

    @PutMapping("/clients/update/{id}")
    public ResponseEntity<String> updateClient(@PathVariable("id") Long id, @Valid @RequestBody Client client) {
            clientService.updateClient(client, id);
            return ResponseEntity.ok("Client updated successfully, id: " + id);
    }
}
