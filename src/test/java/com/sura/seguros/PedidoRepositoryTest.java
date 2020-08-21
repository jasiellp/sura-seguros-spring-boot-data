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

import com.sura.seguros.entity.Pedido;
import com.sura.seguros.repository.PedidoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PedidoRepositoryTest 
{

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PedidoRepository repository;

    @Test
    public void testFindByName() 
    {

        entityManager.persist(new Pedido("C++"));

        List<Pedido> Pedidos = repository.findByName("C++");
        assertEquals(1, Pedidos.size());

        assertThat(Pedidos).extracting(Pedido::getName).containsOnly("C++");
        


    }

}
