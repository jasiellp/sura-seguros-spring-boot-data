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
import com.sura.seguros.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProdutoRepositoryTest 
{
 
	private String sCliente = "TesteCliente";
	
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClienteRepository repository;

    @Test
    public void testFindByName() 
    { 
    	Cliente cliente = new Cliente(sCliente);
    	
        entityManager.persist(cliente);

        List<Cliente> clientes = repository.findByName(sCliente);
        
        assertEquals(1, clientes.size());

        assertThat(clientes).extracting(Cliente::getName).containsOnly(sCliente);
    }
    
    
    @Test
    public void deleteByIdCategory() 
    {  	
    	Cliente cliente = new Cliente(sCliente);
    	
        entityManager.persist(cliente);

        List<Cliente> clientes = repository.findByName(sCliente);
        
        assertEquals(1, clientes.size());

        repository.deleteById(cliente.getIdCliente());
        
        List<Cliente> clientes_ = repository.findByName(sCliente);
        
        assertEquals(0, clientes_.size());
    }
    
    @Test
    public void deleteByCategory() 
    {  	
    	Cliente cliente = new Cliente(sCliente);
    	
        entityManager.persist(cliente);

        List<Cliente> categorias = repository.findByName(sCliente);
        
        assertEquals(1, categorias.size());

        repository.delete(cliente);
        
        List<Cliente> categorias_ = repository.findByName(sCliente);
        
        assertEquals(0, categorias_.size());
    }
    
    @Test
    public void validEntity() 
    {
    	Cliente cliente = new Cliente(sCliente);
    	cliente.setBairro("Jd Felicidade");
    	cliente.setCep("04343-333");
    	cliente.setCidade("Osasco");
    	cliente.setEmail("teste@teste.com");
    	cliente.setEstado("Minas Gerais");
    	cliente.setRua("Rua : Lucelia Santos");
    	cliente.setSenha("fsdf@$@@$%-333");
    	
    	assertTrue("Jd Felicidade".equals(cliente.getBairro()));
    	assertTrue("04343-333".equals(cliente.getCep()));
    	assertTrue("Osasco".equals(cliente.getCidade()));
    	assertTrue("teste@teste.com".equals(cliente.getEmail()));
    	assertTrue("Minas Gerais".equals(cliente.getEstado()));
    	assertTrue("Rua : Lucelia Santos".equals(cliente.getRua()));
    	assertTrue("fsdf@$@@$%-333".equals(cliente.getSenha())); 
    	
    }
}
