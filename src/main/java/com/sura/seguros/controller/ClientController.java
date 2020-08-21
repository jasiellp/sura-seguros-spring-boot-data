package com.sura.seguros.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sura.seguros.entity.Cliente;
import com.sura.seguros.repository.ClienteRepository;

@RestController
@RequestMapping(path = "/cliente")
public class ClientController 
{
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping(path="/", produces = "application/json")
    public Iterable<Cliente> getClientes() 
    {
        return clienteRepository.findAll();
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addCliente( @RequestBody Cliente client) throws Exception 
    {       
       
        //add resource
    	clienteRepository.save(client);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id_cliente}")
                                    .buildAndExpand(client.getIdCliente())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
