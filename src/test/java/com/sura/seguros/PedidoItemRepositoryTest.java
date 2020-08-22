package com.sura.seguros;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.sura.seguros.entity.Categoria;
import com.sura.seguros.entity.Cliente;
import com.sura.seguros.entity.Pedido;
import com.sura.seguros.entity.PedidoItem;
import com.sura.seguros.entity.Produto;
import com.sura.seguros.repository.PedidoItemRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PedidoItemRepositoryTest 
{
	private String sCliente = "TesteCliente";
	private String sPedido = "TestesPedido";
	
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PedidoItemRepository repository;

    @Test
    public void testFindPedidoItemByProduto() 
    { 
    	PedidoItem pedido = new PedidoItem(sPedido);
    	
    	Produto produto = new Produto("ProdutoTeste33");
    	Categoria categoria = new Categoria();
    	categoria.setCategoria("TesteCategoria44");
    	categoria.setIdCategoria(2L);
    	produto.setCategoria(categoria);
    	produto.setDescricao("Teste Descricao");
    	produto.setFoto("https://fotos.com.br/tesasad.jpg");
    	produto.setIdProduto(33L);
    	produto.setPreco(33.55);
    	produto.setQuantidade(22L);
    	pedido.setProduto(produto);
    	 
        entityManager.persist(pedido);

        Optional<PedidoItem> pedidos = repository.findById(pedido.getIdItem());
        
        assertTrue(pedidos.get().equals(pedido));

        //assertThat(pedidos.get()).extracting(PedidoItem::getProdutoName).containsOnly(sPedido);
    }
    
    
    @Test
    public void deletePedidoItemByIdProduto() 
    {  	
    	PedidoItem pedido = new PedidoItem(sPedido);
    	
    	Produto produto = new Produto("ProdutoTeste33");
    	Categoria categoria = new Categoria();
    	categoria.setCategoria("TesteCategoria44");
    	categoria.setIdCategoria(2L);
    	produto.setCategoria(categoria);
    	produto.setDescricao("Teste Descricao");
    	produto.setFoto("https://fotos.com.br/tesasad.jpg");
    	produto.setIdProduto(33L);
    	produto.setPreco(33.55);
    	produto.setQuantidade(22L);
    	pedido.setProduto(produto);
    	
    	
        entityManager.persist(pedido);

        Optional<PedidoItem> pedidos = repository.findById(pedido.getIdItem());

        assertTrue(pedidos.get().equals(pedido));

        repository.deleteById(pedido.getIdItem());
        
       // List<PedidoItem> pedidos_ = repository.findByProdutoNome(produto.getProduto());
        
        // assertEquals(0, pedidos_.size());
    }
    
    @Test
    public void deletePedidoItemByProduto() 
    {  	

    	PedidoItem pedido = new PedidoItem(sPedido);
    	
    	Produto produto = new Produto("ProdutoTeste33");
    	Categoria categoria = new Categoria();
    	categoria.setCategoria("TesteCategoria44");
    	categoria.setIdCategoria(2L);
    	produto.setCategoria(categoria);
    	produto.setDescricao("Teste Descricao");
    	produto.setFoto("https://fotos.com.br/tesasad.jpg");
    	produto.setIdProduto(33L);
    	produto.setPreco(33.55);
    	produto.setQuantidade(22L);
    	pedido.setProduto(produto);
    	
    	
        entityManager.persist(pedido);

        Optional<PedidoItem> pedidos = repository.findById(pedido.getIdItem());
        
        // assertEquals(1, pedidos.size());

        // repository.delete(pedido);
        
        // List<PedidoItem> pedidos_ = repository.findByProdutoNome(produto.getProduto());
        
        // assertEquals(0, pedidos_.size());
    }
    
    @Test
    public void validEntity() 
    { 
    	 
    	Categoria categoria = new Categoria();
    	categoria.setCategoria("TesteCategoria44");
    	categoria.setIdCategoria(2L);
    	
    	Produto produto = new Produto("ProdutoTeste33");
    	produto.setCategoria(categoria);
    	produto.setDescricao("Teste Descricao");
    	produto.setFoto("https://fotos.com.br/tesasad.jpg");
    	produto.setIdProduto(33L);
    	produto.setPreco(33.55);
    	produto.setQuantidade(22L);
    	
    	
    	PedidoItem pedidoItem = new PedidoItem(sPedido);
    	pedidoItem.setProduto(produto);
    	

    	assertTrue("https://fotos.com.br/tesasad.jpg".equals(pedidoItem.getProduto().getFoto()));
    	assertTrue("Teste Descricao".equals(pedidoItem.getProduto().getDescricao()));
    	assertTrue(33L == pedidoItem.getProduto().getIdProduto());
    	assertTrue(22L == pedidoItem.getProduto().getQuantidade());
    	assertTrue(33.55 == pedidoItem.getProduto().getPreco());
    	assertTrue(2L == pedidoItem.getProduto().getCategoria().getIdCategoria());
    	assertTrue("TesteCategoria44".equals(pedidoItem.getProduto().getCategoria().getCategoria()));
    	
    	
    	pedidoItem.setIdItem(4234234L);
    	assertTrue(4234234L == pedidoItem.getIdItem());
    	
    	
    	
    	
    	Cliente cliente = new Cliente(sCliente);
    	cliente.setBairro("Jd Felicidade");
    	cliente.setCep("04343-333");
    	cliente.setCidade("Osasco");
    	cliente.setEmail("teste@teste.com");
    	cliente.setEstado("Minas Gerais");
    	cliente.setRua("Rua : Lucelia Santos");
    	cliente.setSenha("fsdf@$@@$%-333");
    	
    	
    	
    	
    	Pedido pedido = new Pedido(sPedido);
    	pedido.setCliente(cliente);
    	 
    	pedido.setIdPedido(22L);
    	pedido.setName("Camisa do Deus Pele");
    	pedido.setSessao("true");
    	pedido.setStatus("Valido");
    	
    	
    	pedidoItem.setPedido(pedido);
    	
    	pedidoItem.setProdutoNome("Camisa do Deus Pele");
    	pedidoItem.setQuantidade(65L);
    	pedidoItem.setValor(32.75);
    	pedidoItem.setSubtotal(25.55);
    	
    	
    	assertTrue("Camisa do Deus Pele".equals(pedidoItem.getProdutoName()));
    	assertTrue(32.75 == (pedidoItem.getValor()));
    	assertTrue(65L == (pedidoItem.getQuantidade()));
    	assertTrue(25.55 == (pedidoItem.getSubtotal()));
    	
    	assertTrue("Jd Felicidade".equals(pedidoItem.getPedido().getCliente().getBairro()));
    	assertTrue("04343-333".equals(pedidoItem.getPedido().getCliente().getCep()));
    	assertTrue("Osasco".equals(pedidoItem.getPedido().getCliente().getCidade()));
    	assertTrue("teste@teste.com".equals(pedidoItem.getPedido().getCliente().getEmail()));
    	assertTrue("Minas Gerais".equals(pedidoItem.getPedido().getCliente().getEstado()));
    	assertTrue("Rua : Lucelia Santos".equals(pedidoItem.getPedido().getCliente().getRua()));
    	assertTrue("fsdf@$@@$%-333".equals(pedidoItem.getPedido().getCliente().getSenha())); 
    	
    	
    	
    	assertTrue(22L == (pedidoItem.getPedido().getIdPedido()));
    	
    	assertTrue("Camisa do Deus Pele".equals(pedidoItem.getPedido().getName()));
    	assertTrue("true".equals(pedidoItem.getPedido().getSessao()));
    	assertTrue("Valido".equals(pedidoItem.getPedido().getStatus()));
    	
    	assertTrue("Jd Felicidade".equals(pedidoItem.getPedido().getCliente().getBairro()));
    	assertTrue("04343-333".equals(pedidoItem.getPedido().getCliente().getCep()));
    	assertTrue("Osasco".equals(pedidoItem.getPedido().getCliente().getCidade()));
    	assertTrue("teste@teste.com".equals(pedidoItem.getPedido().getCliente().getEmail()));
    	assertTrue("Minas Gerais".equals(pedidoItem.getPedido().getCliente().getEstado()));
    	assertTrue("Rua : Lucelia Santos".equals(pedidoItem.getPedido().getCliente().getRua()));
    	assertTrue("fsdf@$@@$%-333".equals(pedidoItem.getPedido().getCliente().getSenha())); 
    	
    }
}
