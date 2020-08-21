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
    private Produto idProduto;
    
    private Long quantidade;
    private Double valor;
    private Double subtotal;
    private String produto;

    public PedidoItem() 
    {
    }

    public PedidoItem(String produto) 
    {
        this.produto = produto;
    }

    @Override
    public String toString() 
    {
        return "PedidoItem{ " +
                "idItem=" + idItem +
                ", produto='" + produto + '\'' +
                
                ", idProduto=" + idProduto +
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

   	public void setIdProduto(Produto idProduto)
   	{
   		this.idProduto = idProduto;
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

	public String getProduto()
	{
		return produto;
	}

	public void setProduto(String produto)
	{
		this.produto = produto;
	}

 
}
