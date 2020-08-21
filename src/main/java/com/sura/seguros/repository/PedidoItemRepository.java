package com.sura.seguros.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sura.seguros.entity.PedidoItem;

public interface PedidoItemRepository extends CrudRepository<PedidoItem, Long> 
{ 	  
    @Transactional
    void deleteByIdItem(Long idItem);
    
    
}
