package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;

public class ImportacaoDNEDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long importacaoId;
	private String descricao;
	private Timestamp dataImportacao;
	private TabelaImportacaoDTO tabelaImportacaoDTO;
	private Long registrosLidos;
	private Long registrosImportados;
	
	public ImportacaoDNEDTO() {
	}
	
	public ImportacaoDNEDTO(Long id, String descricao, Timestamp dataImportacao, Long registrosImportados,
			Long registrosLidos, TabelaImportacaoDTO tabelaImportacaoDTO) {
		super();
		this.importacaoId = id;
		this.descricao = descricao;
		this.dataImportacao = dataImportacao;
		this.tabelaImportacaoDTO = tabelaImportacaoDTO;
		this.registrosImportados = registrosImportados;
		this.registrosLidos = registrosLidos;
	}
	
	public ImportacaoDNEDTO(ImportacaoDNE entity) {
		this.importacaoId = entity.getImportacaoId();
		this.descricao = entity.getDescricao();
		this.dataImportacao = entity.getDataImportacao();
		this.tabelaImportacaoDTO = new TabelaImportacaoDTO(entity.getTabelaImportacao());
		this.registrosImportados = entity.getRegistrosImportados();
		this.registrosLidos = entity.getRegistrosLidos();
	}

	public Long getImportacaoId() {
		return importacaoId;
	}

	public void setImportacaoId(Long id) {
		this.importacaoId = id;
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
	
	public Long getRegistrosLidos() {
		return registrosLidos;
	}

	public void setRegistrosLidos(Long registrosLidos) {
		this.registrosLidos = registrosLidos;
	}

	public Long getRegistrosImportados() {
		return registrosImportados;
	}

	public void setRegistrosImportados(Long registrosImportados) {
		this.registrosImportados = registrosImportados;
	}
}
