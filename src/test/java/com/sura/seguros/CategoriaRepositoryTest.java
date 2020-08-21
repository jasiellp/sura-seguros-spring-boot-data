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
import com.sura.seguros.repository.CategoriaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoriaRepositoryTest 
{
 
	private String sCategoria = "TesteCategoria";
	
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoriaRepository repository;

    @Test
    public void testFindByName() 
    { 
    	Categoria categoria = new Categoria(sCategoria);
    	
        entityManager.persist(categoria);

        List<Categoria> categorias = repository.findByCategoria(sCategoria);
        
        assertEquals(1, categorias.size());

        assertThat(categorias).extracting(Categoria::getCategoria).containsOnly(sCategoria);
    }
    
    
    @Test
    public void deleteByIdCategory() 
    {  	
    	Categoria categoria = new Categoria(sCategoria);
    	
        entityManager.persist(categoria);

        List<Categoria> categorias = repository.findByCategoria(sCategoria);
        
        assertEquals(1, categorias.size());

        repository.deleteById(categoria.getIdCategoria());
        
        List<Categoria> categorias_ = repository.findByCategoria(sCategoria);
        
        assertEquals(0, categorias_.size());
    }
    
    @Test
    public void deleteByCategory() 
    {  	
    	Categoria categoria = new Categoria(sCategoria);
    	
        entityManager.persist(categoria);

        List<Categoria> categorias = repository.findByCategoria(sCategoria);
        
        assertEquals(1, categorias.size());

        repository.delete(categoria);
        
        List<Categoria> categorias_ = repository.findByCategoria(sCategoria);
        
        assertEquals(0, categorias_.size());
    }
    
    @Test
    public void validEntity() 
    {
    	Categoria categoria = new Categoria();
    	categoria.setCategoria(sCategoria);
    	categoria.setIdCategoria(2L);
    	
    	assertTrue(2L == categoria.getIdCategoria());
    	
    	assertTrue(sCategoria.equals(categoria.getCategoria()));
    	
    }
}
