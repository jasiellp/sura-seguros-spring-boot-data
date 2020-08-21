package com.sura.seguros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sura.seguros.entity.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> 
{
    List<Categoria> findByName(String name);
}
