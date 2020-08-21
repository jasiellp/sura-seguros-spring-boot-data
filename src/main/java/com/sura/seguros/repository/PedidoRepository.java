package com.sura.seguros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sura.seguros.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> 
{
    List<Pedido> findByName(String name);
}
