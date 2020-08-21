package com.sura.seguros.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PedidoItem 
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idItem; 
    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;
   

	@ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;
    
    private Long quantidade;
    private Double valor;
    private Double subtotal;
    private String produto_nome;

    public PedidoItem() 
    {
    }

    public PedidoItem(String produto) 
    {
        this.produto_nome = produto;
    }

    @Override
    public String toString() 
    {
        return "PedidoItem{ " +
                "idItem=" + idItem +
                ", produto='" + produto_nome + '\'' +
                
                ", idProduto=" + produto +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", subtotal=" + subtotal +
                '}';
    }
    
    public Pedido getPedido()
   	{
   		return pedido;
   	}

   	public void setPedido(Pedido pedido)
   	{
   		this.pedido = pedido;
   	}

   	public void setProduto(Produto produto)
   	{
   		this.produto = produto;
   	}
    
    public Produto getProduto()
	{
		return produto;
	}

	public Long getIdItem()
	{
		return idItem;
	}

	public void setIdItem(Long idItem)
	{
		this.idItem = idItem;
	} 
	
	public Long getQuantidade()
	{
		return quantidade;
	}

	public void setQuantidade(Long quantidade)
	{
		this.quantidade = quantidade;
	}

	public Double getValor()
	{
		return valor;
	}

	public void setValor(Double valor)
	{
		this.valor = valor;
	}

	public Double getSubtotal()
	{
		return subtotal;
	}

	public void setSubtotal(Double subtotal)
	{
		this.subtotal = subtotal;
	}

	public String getProdutoName()
	{
		return produto_nome;
	}

	public void setProdutoNome(String produto_nome)
	{
		this.produto_nome = produto_nome;
	}

 
}
