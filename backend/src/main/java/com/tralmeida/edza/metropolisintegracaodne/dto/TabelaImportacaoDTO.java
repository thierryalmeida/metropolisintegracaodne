package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;

import com.tralmeida.edza.metropolisintegracaodne.entities.TabelaImportacao;

public class TabelaImportacaoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nomeTabela;
	
	public TabelaImportacaoDTO() {
	}
	
	public TabelaImportacaoDTO(Long id, String nomeTabela) {
		super();
		this.id = id;
		this.nomeTabela = nomeTabela;
	}
	
	public TabelaImportacaoDTO(TabelaImportacao entity) {
		this.id = entity.getId();
		this.nomeTabela = entity.getNomeTabela();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}
	
}
