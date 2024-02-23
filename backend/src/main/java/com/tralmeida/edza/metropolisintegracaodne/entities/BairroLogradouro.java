package com.tralmeida.edza.metropolisintegracaodne.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "cg_bairrologradouro")
public class BairroLogradouro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@TableGenerator(name = "seq_metropolis", table = "seq_block",
			pkColumnName = "name", valueColumnName = "idx", pkColumnValue = "public.cg_bairrologradouro.bairrologradouroid",
			initialValue = 0, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_metropolis")
	private Long bairroLogradouroId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bairroId")
	private Bairro bairro;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "logradouroId")
	private Logradouro logradouro;
	
	public BairroLogradouro() {
	}

	public BairroLogradouro(Long bairroLogradouroId, Bairro bairro, Logradouro logradouro) {
		super();
		this.bairroLogradouroId = bairroLogradouroId;
		this.bairro = bairro;
		this.logradouro = logradouro;
	}

	public Long getBairroLogradouroId() {
		return bairroLogradouroId;
	}

	public void setBairroogradouroId(Long bairroLogradouroId) {
		this.bairroLogradouroId = bairroLogradouroId;
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
		return Objects.hash(bairroLogradouroId);
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
		return Objects.equals(bairroLogradouroId, other.bairroLogradouroId);
	}
}
