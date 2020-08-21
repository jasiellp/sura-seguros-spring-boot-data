package com.sura.seguros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sura.seguros.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> 
{
    List<Cliente> findByName(String name);
    
    @Transactional
    void deleteByIdCliente(Long idCliente);
}
