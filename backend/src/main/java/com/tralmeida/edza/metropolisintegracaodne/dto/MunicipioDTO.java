package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

public class MunicipioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long municipioId;
	
	private String nome;
	private Long codigo;
	private Long cep;
	private Integer oficial;
	
	private Long cepInicial;
	private Long cepFinal;
	private Long codigoTom;
	
	private UnidadeFederativaDTO uf;
	
	public MunicipioDTO() {
	}

	public MunicipioDTO(Long municipioId, String nome, Long codigo, Long cep, Integer oficial, Long cepInicial,
			Long cepFinal, Long codigoTom, UnidadeFederativaDTO uf) {
		super();
		this.municipioId = municipioId;
		this.nome = nome;
		this.codigo = codigo;
		this.cep = cep;
		this.oficial = oficial;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
		this.codigoTom = codigoTom;
		this.uf = uf;
	}

	public Long getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Long municipioId) {
		this.municipioId = municipioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public Long getCodigoTom() {
		return codigoTom;
	}

	public void setCodigoTom(Long codigoTom) {
		this.codigoTom = codigoTom;
	}

	public UnidadeFederativaDTO getUf() {
		return uf;
	}

	public void setUf(UnidadeFederativaDTO uf) {
		this.uf = uf;
	}
}
