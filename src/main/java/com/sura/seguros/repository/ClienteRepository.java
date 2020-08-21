package com.sura.seguros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sura.seguros.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> 
{
    List<Cliente> findByName(String name);
}
