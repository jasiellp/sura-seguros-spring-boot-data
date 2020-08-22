package com.sura.seguros.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCliente;
	

	private String name;
	private String email;
	private String senha;
	private String rua;
	private String cidade;
	private String bairro;
	private String cep;
	private String estado;

	public Cliente()
	{
	}

	public Cliente(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Cliente{ " +
						"idCliente=" + idCliente + 
						", name='" + name + '\'' +
						", email='" + email + '\'' +
						", senha='" + senha + '\'' +
						", rua='" + rua + '\'' +
						", cidade='" + cidade + '\'' +
						", bairro='" + bairro + '\'' +
						", cep='" + cep + '\'' +
						", estado='" + estado + '\'' +
						
						'}';
	} 
	
	public Long getIdCliente()
	{
		return idCliente;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public String getRua()
	{
		return rua;
	}

	public void setRua(String rua)
	{
		this.rua = rua;
	}

	public String getCidade()
	{
		return cidade;
	}

	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}

	public String getBairro()
	{
		return bairro;
	}

	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}

	public String getCep()
	{
		return cep;
	}

	public void setCep(String cep)
	{
		this.cep = cep;
	}

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
	}

}
