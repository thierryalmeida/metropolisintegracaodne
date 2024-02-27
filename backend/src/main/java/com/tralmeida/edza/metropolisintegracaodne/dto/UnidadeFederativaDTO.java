package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;

import com.tralmeida.edza.metropolisintegracaodne.entities.Pais;
import com.tralmeida.edza.metropolisintegracaodne.entities.UnidadeFederativa;

public class UnidadeFederativaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long ufId;
	private String sigla;
	private String nome;
	private Integer oficial;
	private Long cepIni;
	private Long cepFim;
	private PaisDTO pais;
	
	private Long importacaoId;
	
	public UnidadeFederativaDTO() {
	}
	
	public UnidadeFederativaDTO(UnidadeFederativa entity) {
		this.ufId = entity.getUfId();
		this.sigla = entity.getSigla();
		this.nome = entity.getNome();
		this.oficial = entity.getOficial();
		this.cepIni = entity.getCepIni();
		this.cepFim = entity.getCepFim();
	}
	
	public UnidadeFederativaDTO(UnidadeFederativa entity, Pais pais) {
		this(entity);
		this.pais = new PaisDTO(pais);
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

	public Long getImportacaoId() {
		return importacaoId;
	}

	public void setImportacaoId(Long importacaoId) {
		this.importacaoId = importacaoId;
	}
}
