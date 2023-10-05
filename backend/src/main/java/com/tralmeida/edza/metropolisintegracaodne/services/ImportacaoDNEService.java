package com.tralmeida.edza.metropolisintegracaodne.services;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.dto.ImportacaoDNEDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.repositories.ImportacaoDNERepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.TabelaImportacaoRepository;

@Service
public class ImportacaoDNEService {
	
	@Autowired
	private ImportacaoDNERepository repository;
	
	@Autowired
	private TabelaImportacaoRepository tabelaImportacaoRepository;
	
	@Transactional
	public ImportacaoDNEDTO insert(ImportacaoDNEDTO dto){
		ImportacaoDNE entity = copyDTOToEntity(dto);
		entity.setDataImportacao(new Timestamp(System.currentTimeMillis()));
		entity = repository.save(entity);
		
		return new ImportacaoDNEDTO(entity);
	}
	
	private ImportacaoDNE copyDTOToEntity(ImportacaoDNEDTO dto) {
		ImportacaoDNE entity = new ImportacaoDNE();
		entity.setDescricao(dto.getDescricao());
		entity.setTabelaImportacao(tabelaImportacaoRepository.getReferenceById(dto.getTabelaImportacaoDTO().getId()));
		
		return entity;
	}
}
