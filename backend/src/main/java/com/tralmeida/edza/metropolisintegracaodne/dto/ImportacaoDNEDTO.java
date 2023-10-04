package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;

public class ImportacaoDNEDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	private Timestamp dataImportacao;
	private TabelaImportacaoDTO tabelaImportacaoDTO;
	
	public ImportacaoDNEDTO() {
	}
	
	public ImportacaoDNEDTO(Long id, String descricao, Timestamp dataImportacao,
			TabelaImportacaoDTO tabelaImportacaoDTO) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataImportacao = dataImportacao;
		this.tabelaImportacaoDTO = tabelaImportacaoDTO;
	}
	
	public ImportacaoDNEDTO(ImportacaoDNE entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.dataImportacao = entity.getDataImportacao();
		this.tabelaImportacaoDTO = new TabelaImportacaoDTO(entity.getTabelaImportacao());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Timestamp getDataImportacao() {
		return dataImportacao;
	}

	public void setDataImportacao(Timestamp dataImportacao) {
		this.dataImportacao = dataImportacao;
	}

	public TabelaImportacaoDTO getTabelaImportacaoDTO() {
		return tabelaImportacaoDTO;
	}

	public void setTabelaImportacaoDTO(TabelaImportacaoDTO tabelaImportacaoDTO) {
		this.tabelaImportacaoDTO = tabelaImportacaoDTO;
	}
	
	
}
