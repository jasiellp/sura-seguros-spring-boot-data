package com.sura.seguros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sura.seguros.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> 
{
    List<Produto> findByProduto(String produto);
}
