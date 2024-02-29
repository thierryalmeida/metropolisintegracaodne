package com.tralmeida.edza.metropolisintegracaodne.factory;

import java.sql.Timestamp;

import com.tralmeida.edza.metropolisintegracaodne.dto.ImportacaoDNEDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.entities.StatusImportacao;
import com.tralmeida.edza.metropolisintegracaodne.entities.TabelaImportacao;
import com.tralmeida.edza.metropolisintegracaodne.enums.StatusImportacaoEnum;

public class Factory {
	
	public static ImportacaoDNE createImportacaoDNE() {
		ImportacaoDNE importacao = new ImportacaoDNE(1L, "Importacao de teste", 
				new Timestamp(System.currentTimeMillis()), createTabelaImportacao(), createStatusImportacao());
		return importacao;
	}
	
	public static TabelaImportacao createTabelaImportacao() {
		return new TabelaImportacao(1L, "cg_pais");
	}
	
	public static ImportacaoDNEDTO createImportacaoDNEDTO() {
		return new ImportacaoDNEDTO(createImportacaoDNE());
	}
	
	public static StatusImportacao createStatusImportacao() {
		return new StatusImportacao(StatusImportacaoEnum.EM_ANDAMENTO.getStatusImportacaoId(), "Em andamento");
	}
}
