package com.tralmeida.edza.metropolisintegracaodne.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cg_bairro")
public class Bairro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long bairroId;
	
	private String nome;
	private Long cep;
	private Integer oficial;
	private String tpImovel;
	private String grupoBairro;
	private String tipo;
	private Long cepInicial;
	private Long cepFinal;
	
	@ManyToOne
	@JoinColumn(name = "municipioid")
	private Municipio municipio;
	
	public Bairro() {
	}

	public Bairro(Long bairroId, String nome, Long cep, Integer oficial, String tpImovel, String grupoBairro,
			String tipo, Long cepInicial, Long cepFinal, Municipio municipio) {
		super();
		this.bairroId = bairroId;
		this.nome = nome;
		this.cep = cep;
		this.oficial = oficial;
		this.tpImovel = tpImovel;
		this.grupoBairro = grupoBairro;
		this.tipo = tipo;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
		this.municipio = municipio;
	}

	public Long getBairroId() {
		return bairroId;
	}

	public void setBairroId(Long bairroId) {
		this.bairroId = bairroId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public Integer getOficial() {
		return oficial;
	}

	public void setOficial(Integer oficial) {
		this.oficial = oficial;
	}

	public String getTpImovel() {
		return tpImovel;
	}

	public void setTpImovel(String tpImovel) {
		this.tpImovel = tpImovel;
	}

	public String getGrupoBairro() {
		return grupoBairro;
	}

	public void setGrupoBairro(String grupoBairro) {
		this.grupoBairro = grupoBairro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getCepInicial() {
		return cepInicial;
	}

	public void setCepInicial(Long cepInicial) {
		this.cepInicial = cepInicial;
	}

	public Long getCepFinal() {
		return cepFinal;
	}

	public void setCepFinal(Long cepFinal) {
		this.cepFinal = cepFinal;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairroId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bairro other = (Bairro) obj;
		return Objects.equals(bairroId, other.bairroId);
	}
}
