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

public class UnidadeFederativaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long ufId;
	private String sigla;
	private String nome;
	private Integer oficial;
	private Long cepIni;
	private Long cepFim;
	private PaisDTO pais;
	
	public UnidadeFederativaDTO() {
	}
	
	public UnidadeFederativaDTO(Long ufId, String sigla, String nome, Integer oficial, Long cepIni, Long cepFim,
			PaisDTO pais) {
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

	public PaisDTO getPaisDTO() {
		return pais;
	}

	public void setPaisDTO(PaisDTO pais) {
		this.pais = pais;
	}
}
