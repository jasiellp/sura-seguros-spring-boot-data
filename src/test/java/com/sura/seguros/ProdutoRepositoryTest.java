package com.sura.seguros;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.sura.seguros.entity.Categoria;
import com.sura.seguros.entity.Produto;
import com.sura.seguros.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProdutoRepositoryTest 
{
	private String sCategoria = "TesteCategoria";
	private String sProduto = "TesteProduto";
	
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProdutoRepository repository;

    @Test
    public void testFindProdutoByName() 
    { 
    	Produto produto = new Produto(sProduto);
    	
        entityManager.persist(produto);

        List<Produto> produtos = repository.findByProduto(sProduto);
        
        assertEquals(1, produtos.size());

        assertThat(produtos).extracting(Produto::getProduto).containsOnly(sProduto);
    }
    
    
    @Test
    public void deleteProdutoByIdProduto() 
    {  	
    	Produto produto = new Produto(sProduto);
    	
        entityManager.persist(produto);

        List<Produto> produtos = repository.findByProduto(sProduto);
        
        assertEquals(1, produtos.size());

        repository.deleteById(produto.getIdProduto());
        
        List<Produto> produtos_ = repository.findByProduto(sProduto);
        
        assertEquals(0, produtos_.size());
    }
    
    @Test
    public void deleteProdutoByProduto() 
    {  	
    	Produto produto = new Produto(sProduto);
    	
        entityManager.persist(produto);

        List<Produto> produtos = repository.findByProduto(sProduto);
        
        assertEquals(1, produtos.size());

        repository.delete(produto);
        
        List<Produto> produtos_ = repository.findByProduto(sProduto);
        
        assertEquals(0, produtos_.size());
    }
    
    @Test
    public void validEntity() 
    {	
    	Categoria categoria = new Categoria();
    	categoria.setCategoria(sCategoria);
    	categoria.setIdCategoria(2L);
    	
    	Produto produto = new Produto(sProduto);
    	produto.setCategoria(categoria);
    	produto.setDescricao("Teste Descricao");
    	produto.setFoto("https://fotos.com.br/tesasad.jpg");
    	produto.setIdProduto(33L);
    	produto.setPreco(33.55);
    	produto.setQuantidade(22L);
    	
    	
    	assertTrue("https://fotos.com.br/tesasad.jpg".equals(produto.getFoto()));
    	assertTrue("Teste Descricao".equals(produto.getDescricao()));
    	assertTrue(33L == produto.getIdProduto());
    	assertTrue(22L == produto.getQuantidade());
    	assertTrue(33.55 == produto.getPreco());
    	
    	assertTrue(2L == produto.getCategoria().getIdCategoria());
    	assertTrue(sCategoria.equals(produto.getCategoria().getCategoria()));
    	
    	 
    	
    }
}
