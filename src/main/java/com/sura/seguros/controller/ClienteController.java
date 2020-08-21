package com.sura.seguros.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sura.seguros.entity.Cliente;
import com.sura.seguros.repository.ClienteRepository;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController 
{
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping(path="/", produces = "application/json")
    public Iterable<Cliente> consultarTodosClientes() 
    {
        return clienteRepository.findAll();
    }
     
    @GetMapping(path="/cliente", produces = "application/json")
    public Optional<Cliente> consultarCategoriaPeloIdCategoria(@RequestParam Long id_cliente) 
    {
        return clienteRepository.findById(id_cliente);
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> inserirCategoria(@RequestBody Cliente categoria) throws Exception 
    {
       
        //add resource
    	clienteRepository.save(categoria);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id_categoria}")
                                    .buildAndExpand(categoria.getIdCliente())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
