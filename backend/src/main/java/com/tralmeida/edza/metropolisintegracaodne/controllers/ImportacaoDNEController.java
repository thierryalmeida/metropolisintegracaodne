package com.tralmeida.edza.metropolisintegracaodne.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tralmeida.edza.metropolisintegracaodne.dto.ImportacaoDNEDTO;
import com.tralmeida.edza.metropolisintegracaodne.dto.TabelaImportacaoDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.entities.TabelaImportacao;
import com.tralmeida.edza.metropolisintegracaodne.services.ImportacaoDNEService;

@RestController
@RequestMapping(value = "/importar")
public class ImportacaoDNEController {
	
	@Autowired
	private ImportacaoDNEService service;
	
	@GetMapping
	public ResponseEntity<Page <ImportacaoDNEDTO>> findAll(Pageable pageable){
		Page<ImportacaoDNEDTO> imports = service.findAll(pageable);
		return ResponseEntity.ok(imports);
	}
	
	@PostMapping
	public ResponseEntity<ImportacaoDNEDTO> importFromFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam("idTabela") Long idTabela,
			@RequestParam("descricao") String descricao){
		ImportacaoDNEDTO dto = getDTO(idTabela, descricao);
		dto = service.insert(dto, file);
		return ResponseEntity.created(null).body(dto);
	}
	
	private ImportacaoDNEDTO getDTO(Long idTabela, String descricao) {
		ImportacaoDNEDTO dto = new ImportacaoDNEDTO();
		dto.setDescricao(descricao);
		dto.setTabelaImportacaoDTO(new TabelaImportacaoDTO());
		dto.getTabelaImportacaoDTO().setId(idTabela);
		
		return dto;
	}
}
