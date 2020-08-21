package com.sura.seguros.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sura.seguros.entity.Categoria;
import com.sura.seguros.repository.CategoriaRepository;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController 
{
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @GetMapping(path="/", produces = "application/json")
    public Iterable<Categoria> getAllCategory() 
    {
        return categoriaRepository.findAll();
    }
    
    @GetMapping(path="/", produces = "application/json")
    public Iterable<Categoria> getCategoryByCategoria(@RequestBody String categoria) 
    {
        return categoriaRepository.findByCategoria(categoria);
    }
    
    @GetMapping(path="/", produces = "application/json")
    public Optional<Categoria> getCategoryByIdCategoria(@RequestBody Long Idcategoria) 
    {
        return categoriaRepository.findById(Idcategoria);
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addCliente(@RequestBody Categoria categoria) throws Exception 
    {
       
        //add resource
    	categoriaRepository.save(categoria);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id_categoria}")
                                    .buildAndExpand(categoria.getIdCategoria())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
