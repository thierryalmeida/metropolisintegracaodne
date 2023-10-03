package com.tralmeida.edza.metropolisintegracaodne.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.entities.TabelaImportacao;

@RestController
@RequestMapping(value = "/importar")
public class ImportacaoDNEController {
	
	@GetMapping
	public ResponseEntity<List <ImportacaoDNE>> findAll(){
		List<ImportacaoDNE> importacoes = new ArrayList<>();
		importacoes.add(new ImportacaoDNE(1L, "Importacao de Teste", new Timestamp(System.currentTimeMillis()), new TabelaImportacao(1L, "cg_pais", null)));
		return ResponseEntity.ok(importacoes);
	}
}
