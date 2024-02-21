package com.tralmeida.edza.metropolisintegracaodne.enums;

public enum StatusImportacaoEnum {
	SUCESSO(1L),
	EM_ANDAMENTO(2L),
	ERRO(3L),
	INCOMPLETA(4L);
	
	private Long statusImportacaoId;

	StatusImportacaoEnum(Long statusImportacaoId) {
		this.statusImportacaoId = statusImportacaoId;
	}
	
	public Long getStatusImportacaoId() {
		return statusImportacaoId;
	}
}
