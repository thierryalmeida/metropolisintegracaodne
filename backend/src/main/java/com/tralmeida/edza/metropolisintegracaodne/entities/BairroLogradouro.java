package com.tralmeida.edza.metropolisintegracaodne.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cg_bairrologradouro")
public class BairroLogradouro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer bairroogradouroId;
	
	@ManyToOne
	@JoinColumn(name = "bairroId")
	private Bairro bairro;
	
	@ManyToOne
	@JoinColumn(name = "logradouroId")
	private Logradouro logradouro;
	
	public BairroLogradouro() {
	}

	public BairroLogradouro(Integer bairroogradouroId, Bairro bairro, Logradouro logradouro) {
		super();
		this.bairroogradouroId = bairroogradouroId;
		this.bairro = bairro;
		this.logradouro = logradouro;
	}

	public Integer getBairroogradouroId() {
		return bairroogradouroId;
	}

	public void setBairroogradouroId(Integer bairroogradouroId) {
		this.bairroogradouroId = bairroogradouroId;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairroogradouroId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BairroLogradouro other = (BairroLogradouro) obj;
		return Objects.equals(bairroogradouroId, other.bairroogradouroId);
	}
}
