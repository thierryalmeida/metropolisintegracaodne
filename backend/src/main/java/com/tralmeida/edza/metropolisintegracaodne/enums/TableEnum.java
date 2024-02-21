package com.tralmeida.edza.metropolisintegracaodne.enums;

public enum TableEnum {
	
	TABELA_PAIS(1L),
	TABELA_UF(2L),
	TABELA_MUNICIPIO(3L),
	TABELA_BAIRRO(4L),
	TABELA_LOGRADOURO(5L);
	
	private Long tabelaImportacaoId;

	TableEnum(Long tabelaImportacaoId) {
		this.tabelaImportacaoId = tabelaImportacaoId;
	}
	
	public Long getTabelaImportacaoId() {
		return tabelaImportacaoId;
	}
}
