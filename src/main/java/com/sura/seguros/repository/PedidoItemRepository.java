package com.sura.seguros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sura.seguros.entity.PedidoItem;

public interface PedidoItemRepository extends CrudRepository<PedidoItem, Long> 
{
    List<PedidoItem> findByProduto(String name);
    
    @Transactional
    void deleteByIdItem(Long idItem);
}
