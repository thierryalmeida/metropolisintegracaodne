package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;

import com.tralmeida.edza.metropolisintegracaodne.entities.TabelaImportacao;

public class TabelaImportacaoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long tabelaImportacaoId;
	private String nomeTabela;
	
	public TabelaImportacaoDTO() {
	}
	
	public TabelaImportacaoDTO(Long id, String nomeTabela) {
		super();
		this.tabelaImportacaoId = id;
		this.nomeTabela = nomeTabela;
	}
	
	public TabelaImportacaoDTO(TabelaImportacao entity) {
		this.tabelaImportacaoId = entity.getTabelaImportacaoId();
		this.nomeTabela = entity.getNome();
	}

	public Long getTabelaImportacaoId() {
		return tabelaImportacaoId;
	}

	public void setTabelaImportacaoId(Long id) {
		this.tabelaImportacaoId = id;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}
	
}
