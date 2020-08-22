package com.sura.seguros.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto 
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduto;
    
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    private Long quantidade;
    private Double preco;
    private String descricao;
    private String foto;
    private String produto;
     
    public Produto() 
    { }

    public Produto(String produto) 
    {
        this.produto = produto;
    }

    @Override
    public String toString() 
    {
        return "Produto{ " +
                "idProduto=" + idProduto +
                ", produto='" + produto + '\'' +
                '}';
    }

    public Long getIdProduto() 
    {
        return this.idProduto;
    }

    public void setIdProduto(Long idProduto) 
    {
        this.idProduto = idProduto;
    }

    public String getProduto() 
    {
        return this.produto;
    }

    public void setProduto(String produto) 
    {
        this.produto = produto;
    }
    

	public Double getPreco() 
	{
		return preco;
	}

	public void setPreco(Double preco) 
	{
		this.preco = preco;
	}

	public Long getQuantidade() 
	{
		return quantidade;
	}

	public void setQuantidade(Long quantidade) 
	{
		this.quantidade = quantidade;
	}

	public String getDescricao() 
	{
		return descricao;
	}

	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}

	public String getFoto() 
	{
		return foto;
	}

	public void setFoto(String foto) 
	{
		this.foto = foto;
	}
	public Categoria getCategoria()
	{
		return categoria;
	}

	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
	}

}
