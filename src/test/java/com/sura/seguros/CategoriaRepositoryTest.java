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

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoriaRepository repository;

    @Test
    public void testFindByName() 
    {
        entityManager.persist(new Categoria("C++"));

        List<Categoria> categorias = repository.findByCategoria("C++");
        assertEquals(1, categorias.size());

        assertThat(categorias).extracting(Categoria::getCategoria).containsOnly("C++");
    }
    
    @Test
    public void deleteByIdCategory() 
    {
        entityManager.persist(new Categoria("C++"));

        List<Categoria> categorias = repository.findByCategoria("C++");
        assertEquals(1, categorias.size());

        repository.delete(new Categoria("C++"));
        assertEquals(0, categorias.size());
    }
    
    @Test
    public void validEntity() 
    {
    	Categoria categoria = new Categoria();
    	categoria.setCategoria("Categoria Teste");
    	categoria.setIdCategoria(2L);
    	
    	assertTrue(2L == categoria.getIdCategoria());
    	
    }
}
