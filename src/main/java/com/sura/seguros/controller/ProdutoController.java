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

import com.sura.seguros.entity.Produto;
import com.sura.seguros.repository.ProdutoRepository;


@RestController
@RequestMapping(path = "/pedido_item")
public class ProdutoController 
{
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @GetMapping(path="/", produces = "application/json")
    public Iterable<Produto> consultarTodosClientes() 
    {
        return produtoRepository.findAll();
    }
     
    @GetMapping(path="/item", produces = "application/json")
    public Optional<Produto> consultarCategoriaPeloIdCategoria(@RequestParam Long id_Produto) 
    {
        return produtoRepository.findById(id_Produto);
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> inserirCategoria(@RequestBody Produto produto) throws Exception 
    {
       
        //add resource
    	produtoRepository.save(produto);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id_categoria}")
                                    .buildAndExpand( produto.getIdProduto())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
