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

import com.sura.seguros.entity.PedidoItem;
import com.sura.seguros.repository.PedidoItemRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PedidoItemRepositoryTest 
{

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PedidoItemRepository repository;

    @Test
    public void testFindByName() 
    {

        entityManager.persist(new PedidoItem("C++"));

        List<PedidoItem> PedidoItems = repository.findByName("C++");
        assertEquals(1, PedidoItems.size());

        assertThat(PedidoItems).extracting(PedidoItem::getName).containsOnly("C++");
        


    }

}
