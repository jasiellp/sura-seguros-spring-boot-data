package com.sura.seguros.repository;

import java.util.List;
 

import org.springframework.data.repository.CrudRepository;

import com.sura.seguros.entity.Categoria;
import org.springframework.transaction.annotation.Transactional;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> 
{
    List<Categoria> findByCategoria(String categoria);
    
    @Transactional
    void deleteByIdCategoria(Long idCategoria);
}
