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

import com.sura.seguros.entity.Categoria;
import com.sura.seguros.repository.CategoriaRepository;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController 
{
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @GetMapping(path="/", produces = "application/json")
    public Iterable<Categoria> consultarTodasCategorias() 
    {
        return categoriaRepository.findAll();
    }
     
    @GetMapping(path="/categoria", produces = "application/json")
    public Optional<Categoria> consultarCategoriaPeloIdCategoria(@RequestParam Long id_categoria) 
    {
        return categoriaRepository.findById(id_categoria);
    }
    
    @DeleteMapping(path= "/", consumes = "application/json", produces = "application/json")
    public void deleteCategoria(@RequestParam Long id_categoria) throws Exception 
    {
    	categoriaRepository.deleteByIdCategoria(id_categoria);
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> inserirCategoria(@RequestBody Categoria categoria) throws Exception 
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
