package com.sura.seguros.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategoria;
    private String categoria;

    public Categoria() 
    { }

    public Categoria(String categoria) 
    {
        this.categoria = categoria;
    }

    @Override
    public String toString() 
    {
        return "Categoria { " +
                " idCategoria=" + this.idCategoria +", "+
                " categoria='" + this.categoria + '\'' +
                '}';
    }

    public Long getIdCategoria() 
    {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) 
    {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() 
    {
        return this.categoria;
    }

    public void setCategoria(String categoria) 
    {
        this.categoria = categoria;
    }
}
