package com.sura.seguros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sura.seguros.entity.PedidoItem;

public interface PedidoItemRepository extends CrudRepository<PedidoItem, Long> 
{
    List<PedidoItem> findByName(String name);
}
