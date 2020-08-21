package com.sura.seguros.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PedidoItem 
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idItem; 
	private Long idPedido;
    private Long idProduto;
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
                ", idPedido=" + idPedido +
                ", idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", subtotal=" + subtotal +
                '}';
    }
    
    public Long getIdItem()
	{
		return idItem;
	}

	public void setIdItem(Long idItem)
	{
		this.idItem = idItem;
	}

	public Long getIdPedido()
	{
		return idPedido;
	}

	public void setIdPedido(Long idPedido)
	{
		this.idPedido = idPedido;
	}

	public Long getIdProduto()
	{
		return idProduto;
	}

	public void setIdProduto(Long idProduto)
	{
		this.idProduto = idProduto;
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
