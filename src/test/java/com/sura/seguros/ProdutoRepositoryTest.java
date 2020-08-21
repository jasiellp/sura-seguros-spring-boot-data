package com.sura.seguros;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.sura.seguros.entity.Produto;
import com.sura.seguros.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProdutoRepositoryTest 
{

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProdutoRepository repository;

    @Test
    public void testFindByName() 
    {

        entityManager.persist(new Produto("C++"));

        List<Produto> Produtos = repository.findByName("C++");
        assertEquals(1, Produtos.size());

        assertThat(Produtos).extracting(Produto::getName).containsOnly("C++");
        


    }

}
