package com.tralmeida.edza.metropolisintegracaodne.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cg_uf")
public class UnidadeFederativa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ufId;
	
	private String sigla;
	private String nome;
	private Integer oficial;
	private Long cepIni;
	private Long cepFim;
	
	@ManyToOne
	@JoinColumn(name = "paisid")
	private Pais pais;
	
	public UnidadeFederativa() {
	}
	
	public UnidadeFederativa(Long ufId, String sigla, String nome, Integer oficial, Long cepIni, Long cepFim,
			Pais pais) {
		super();
		this.ufId = ufId;
		this.sigla = sigla;
		this.nome = nome;
		this.oficial = oficial;
		this.cepIni = cepIni;
		this.cepFim = cepFim;
		this.pais = pais;
	}

	public Long getUfId() {
		return ufId;
	}

	public void setUfId(Long ufId) {
		this.ufId = ufId;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getOficial() {
		return oficial;
	}

	public void setOficial(Integer oficial) {
		this.oficial = oficial;
	}

	public Long getCepIni() {
		return cepIni;
	}

	public void setCepIni(Long cepIni) {
		this.cepIni = cepIni;
	}

	public Long getCepFim() {
		return cepFim;
	}

	public void setCepFim(Long cepFim) {
		this.cepFim = cepFim;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sigla, ufId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeFederativa other = (UnidadeFederativa) obj;
		return Objects.equals(sigla, other.sigla);
	}

}