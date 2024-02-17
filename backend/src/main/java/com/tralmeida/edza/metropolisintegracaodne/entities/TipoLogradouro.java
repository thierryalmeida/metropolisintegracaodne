package com.tralmeida.edza.metropolisintegracaodne.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "cg_tipologradouro")
public class TipoLogradouro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long tipoLogradouroId;
	private String sigla;
	private String descricao;
	
	public TipoLogradouro() {
	}
	
	public TipoLogradouro(Long tipoLogradouroId, String sigla, String descricao) {
		super();
		this.tipoLogradouroId = tipoLogradouroId;
		this.sigla = sigla;
		this.descricao = descricao;
	}


	public Long getTipoLogradouroId() {
		return tipoLogradouroId;
	}

	public void setTipoLogradouroId(Long tipoLogradouroId) {
		this.tipoLogradouroId = tipoLogradouroId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoLogradouroId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoLogradouro other = (TipoLogradouro) obj;
		return Objects.equals(tipoLogradouroId, other.tipoLogradouroId);
	}
}
