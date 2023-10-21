package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;

import com.tralmeida.edza.metropolisintegracaodne.entities.Pais;

public class PaisDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long paisId;
	private String sigla;
	private String nome;
	private String nacionalidade;
	
	public PaisDTO() {
	}
	
	public PaisDTO(Pais entity) {
		this.paisId = entity.getPaisId();
		this.sigla = entity.getSigla();
		this.nome = entity.getNome();
		this.nacionalidade = entity.getNacionalidade();
	}
	
	public PaisDTO(Long paisId, String sigla, String nome, String nacionalidade) {
		super();
		this.paisId = paisId;
		this.sigla = sigla;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
	}

	public Long getPaisId() {
		return paisId;
	}

	public void setPaisId(Long paisId) {
		this.paisId = paisId;
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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
}
