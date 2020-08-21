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

import com.sura.seguros.entity.Cliente;
import com.sura.seguros.entity.Pedido;
import com.sura.seguros.repository.PedidoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PedidoRepositoryTest 
{
 
	private String sPedido = "TestePedido";
	
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PedidoRepository repository;

    @Test
    public void testFindPedidoByName() 
    { 
    	Pedido pedido = new Pedido(sPedido);
    	
        entityManager.persist(pedido);

        List<Pedido> pedidos = repository.findByName(sPedido);
        
        assertEquals(1, pedidos.size());

        assertThat(pedidos).extracting(Pedido::getName).containsOnly(sPedido);
    }
    
    
    @Test
    public void deletePedidoByIdPedido() 
    {  	
    	Pedido pedido = new Pedido(sPedido);
    	
        entityManager.persist(pedido);

        List<Pedido> pedidos = repository.findByName(sPedido);
        
        assertEquals(1, pedidos.size());

        repository.deleteById(pedido.getIdPedido());
        
        List<Pedido> clientes_ = repository.findByName(sPedido);
        
        assertEquals(0, clientes_.size());
    }
    
    @Test
    public void deletePedidoByPedido() 
    {  	
    	Pedido pedido = new Pedido(sPedido);
    	
        entityManager.persist(pedido);

        List<Pedido> pedidos = repository.findByName(sPedido);
        
        assertEquals(1, pedidos.size());

        repository.delete(pedido);
        
        List<Pedido> pedidos_ = repository.findByName(sPedido);
        
        assertEquals(0, pedidos_.size());
    }
    
    @Test
    public void validEntity() 
    {
    	Cliente cliente = new Cliente(sPedido);
    	cliente.setBairro("Jd Felicidade");
    	cliente.setCep("04343-333");
    	cliente.setCidade("Osasco");
    	cliente.setEmail("teste@teste.com");
    	cliente.setEstado("Minas Gerais");
    	cliente.setRua("Rua : Lucelia Santos");
    	cliente.setSenha("fsdf@$@@$%-333");
    	
    	Pedido pedido = new Pedido(sPedido);
    	
    	
    	pedido.setCliente(cliente);
    	pedido.setIdPedido(44242L);
    	pedido.setName("Camisa do Deus Pele");
    	
    	pedido.setSessao("true");
    	pedido.setStatus("Valido");
    	
    	assertTrue(44242L == (pedido.getIdPedido()));
    	
    	assertTrue("Camisa do Deus Pele".equals(pedido.getName()));
    	assertTrue("true".equals(pedido.getSessao()));
    	assertTrue("Valido".equals(pedido.getStatus()));
    	
    	
    	
    	assertTrue("Jd Felicidade".equals(pedido.getCliente().getBairro()));
    	assertTrue("04343-333".equals(pedido.getCliente().getCep()));
    	assertTrue("Osasco".equals(pedido.getCliente().getCidade()));
    	assertTrue("teste@teste.com".equals(pedido.getCliente().getEmail()));
    	assertTrue("Minas Gerais".equals(pedido.getCliente().getEstado()));
    	assertTrue("Rua : Lucelia Santos".equals(pedido.getCliente().getRua()));
    	assertTrue("fsdf@$@@$%-333".equals(pedido.getCliente().getSenha())); 
    	
    }
}
