package com.sura.seguros.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sura.seguros.entity.PedidoItem;
import com.sura.seguros.repository.PedidoItemRepository;


@RestController
@RequestMapping(path = "/pedido_item")
public class PedidoItemController 
{
    @Autowired
    private PedidoItemRepository pedidoRepository;
    
    @GetMapping(path="/", produces = "application/json")
    public Iterable<PedidoItem> consultarTodosPedidoItem() 
    {
        return pedidoRepository.findAll();
    }
     
    @GetMapping(path="/item", produces = "application/json")
    public Optional<PedidoItem> consultarPedidoItemPeloIdCategoria(@RequestParam Long id_pedido) 
    {
        return pedidoRepository.findById(id_pedido);
    }
    
    @DeleteMapping(path= "/", consumes = "application/json", produces = "application/json")
    public void deletePedidoItem(@RequestParam Long id_item) throws Exception 
    {
    	pedidoRepository.deleteByIdItem(id_item);
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> inserirPedidoItem(@RequestBody PedidoItem pedido) throws Exception 
    {
       
        //add resource
    	pedidoRepository.save(pedido);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id_item}")
                                    .buildAndExpand(pedido.getIdItem())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
