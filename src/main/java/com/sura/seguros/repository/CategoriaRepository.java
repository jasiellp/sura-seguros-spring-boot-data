package com.sura.seguros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sura.seguros.entity.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> 
{
	
	List<Categoria> findByCategoria(String name);
	
    @Transactional
    void deleteByIdCategoria(Long idCategoria);
}
