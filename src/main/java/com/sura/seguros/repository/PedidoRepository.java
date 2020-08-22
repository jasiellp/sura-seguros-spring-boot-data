package com.sura.seguros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sura.seguros.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> 
{
    List<Pedido> findByName(String name);
    
    @Transactional
    void deleteByIdPedido(Long idPedido);
}
