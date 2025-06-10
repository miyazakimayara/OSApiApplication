/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.miyazaki.OSApiApplication.api.controller;

import br.com.miyazaki.OSApiApplication.domain.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjatb
 */
@RestController
public class ClienteController {
    
    List<Cliente> listaClientes;
    
    @GetMapping("/clientes")
    public List<Cliente> listas(){
        
        listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente(1, "KGe", "kge@teste.com", "11-99999-9999"));
        listaClientes.add(new Cliente(1, "Mayara", "mayara@teste.com", "11-88888-8888"));
        listaClientes.add(new Cliente(1, "Mafe", "mafe@teste.com", "11-77777-7777"));
        
        return listaClientes;
    }
}
