package com.tralmeida.edza.metropolisintegracaodne.dto;

import com.tralmeida.edza.metropolisintegracaodne.entities.StatusImportacao;

public class StatusImportacaoDTO {
	private static final long serialVersionUID = 1L;
	
	private Long statusImportacaoId;
	private String descricao;

	public StatusImportacaoDTO() {
	} 
	
	public StatusImportacaoDTO(Long id, String descricao) {
		super();
		this.statusImportacaoId = id;
		this.descricao = descricao;
	}
	
	public StatusImportacaoDTO(StatusImportacao entity) {
		this.statusImportacaoId = entity.getStatusImportacaoId();
		this.descricao = entity.getDescricao();
	}

	public Long getStatusImportacaoId() {
		return statusImportacaoId;
	}

	public void setStatusImportacaoId(Long id) {
		this.statusImportacaoId = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
