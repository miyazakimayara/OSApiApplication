/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.miyazaki.OSApiApplication.api.controller;

import br.com.miyazaki.OSApiApplication.domain.model.Cliente;
import br.com.miyazaki.OSApiApplication.domain.repository.ClienteRepository;
import br.com.miyazaki.OSApiApplication.domain.service.ClienteService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjatb
 */
@RestController
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/clientes")
    public List<Cliente> listas(){
        return clienteRepository.findAll();
        //return clienteRepository.findByNome("maiara");
    }
    
    @PutMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> atualizar(@Valid@PathVariable Long clienteID,
                                             @RequestBody Cliente cliente){
        
        if (!clienteRepository.existsById(clienteID)){
            return ResponseEntity.notFound().build();
        }
        
        cliente.setId(clienteID);
        cliente = clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }
    
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid@RequestBody Cliente cliente){
        
        return clienteService.salvar(cliente);
    }
    
    @DeleteMapping("/clientes/{clienteID}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteID){
        
        if (!clienteRepository.existsById(clienteID)){
            return ResponseEntity.notFound().build();
        }
        
        clienteService.excluir(clienteID);
        return ResponseEntity.noContent().build();
    }
}
