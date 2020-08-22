package com.sura.seguros.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido 
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;
   

	@ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    private Date data;
    private String name;
    private String status;
    private String sessao;
    
    
    public Pedido() 
    {
    }

    public Pedido(String name) 
    {
        this.name = name;
    }

    @Override
    public String toString() 
    {
        return "Pedido{ " +
                " idPedido=" + idPedido +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                 
                ", status='" + status + '\'' +
                ", sessao='" + sessao + '\'' +
                '}';
    }
 
    
    public Long getIdPedido()
   	{
   		return idPedido;
   	}

   	public void setIdPedido(Long idPedido)
   	{
   		this.idPedido = idPedido;
   	}

   	public Cliente getCliente()
   	{
   		return cliente;
   	}

   	public void setCliente(Cliente cliente)
   	{
   		this.cliente = cliente;
   	}
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    public Date getData()
   	{
   		return data;
   	}

   	public void setData(Date data)
   	{
   		this.data = data;
   	}
 

   	public String getStatus()
   	{
   		return status;
   	}

   	public void setStatus(String status)
   	{
   		this.status = status;
   	}

   	public String getSessao()
   	{
   		return sessao;
   	}

   	public void setSessao(String sessao)
   	{
   		this.sessao = sessao;
   	}
}
