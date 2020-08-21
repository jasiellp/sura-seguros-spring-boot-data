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

import com.sura.seguros.entity.Pedido;
import com.sura.seguros.repository.PedidoRepository;


@RestController
@RequestMapping(path = "/pedido")
public class PedidoController 
{
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping(path="/", produces = "application/json")
    public Iterable<Pedido> consultarTodosClientes() 
    {
        return pedidoRepository.findAll();
    }
     
    @GetMapping(path="/pedido", produces = "application/json")
    public Optional<Pedido> consultarPedidoPeloIdCategoria(@RequestParam Long id_pedido) 
    {
        return pedidoRepository.findById(id_pedido);
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> inserirPedido(@RequestBody Pedido pedido) throws Exception 
    {
       
        //add resource
    	pedidoRepository.save(pedido);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id_pedido}")
                                    .buildAndExpand(pedido.getIdPedido())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
