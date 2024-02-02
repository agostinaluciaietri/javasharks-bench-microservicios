package com.javasharks.microservicios.controller;

import com.javasharks.microservicios.entity.Cliente;
import com.javasharks.microservicios.exception.ClienteNotFoundException;
import com.javasharks.microservicios.service.ClienteServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class ClienteController {

    private final ClienteServiceImpl clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente clienteById(@PathVariable Long id) {
        return clienteService.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("El cliente no ha sido encontrado. id: " + id));
    }

    @PostMapping("/clientes/crear")
    public ResponseEntity<Cliente> saveCliente(@Valid @RequestBody Cliente cliente) {
        Cliente clienteGuardado = clienteService.saveCliente(cliente);
        return ResponseEntity.ok(clienteGuardado);
    }

    @DeleteMapping("/clientes/eliminar/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        try {
            clienteService.deleteCliente(id);
            return ResponseEntity.ok("El cliente con id: " + id + " ha sido eliminado correctamente.");
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente no ha sido encontrado. id: " + id);
        }
    }

    @PutMapping("/clientes/actualizar/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable("id") Long id, @Valid @RequestBody Cliente cliente) {
            clienteService.updateCliente(cliente, id);
            return ResponseEntity.ok("El cliente ha sido actualizado correctamente. id: " + id);
    }
}
