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
	private Integer bairroId;
	
	private String nome;
	private String cep;
	private String oficial;
	private String tpImovel;
	private String grupoBairro;
	private String tipo;
	private String cepInicial;
	private String cepFinal;
	
	@ManyToOne
	@JoinColumn(name = "municipioid")
	private Municipio municipio;
	
	public Bairro() {
	}

	public Bairro(Integer bairroId, String nome, String cep, String oficial, String tpImovel, String grupoBairro,
			String tipo, String cepInicial, String cepFinal, Municipio municipio) {
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

	public Integer getBairroId() {
		return bairroId;
	}

	public void setBairroId(Integer bairroId) {
		this.bairroId = bairroId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getOficial() {
		return oficial;
	}

	public void setOficial(String oficial) {
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

	public String getCepInicial() {
		return cepInicial;
	}

	public void setCepInicial(String cepInicial) {
		this.cepInicial = cepInicial;
	}

	public String getCepFinal() {
		return cepFinal;
	}

	public void setCepFinal(String cepFinal) {
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
