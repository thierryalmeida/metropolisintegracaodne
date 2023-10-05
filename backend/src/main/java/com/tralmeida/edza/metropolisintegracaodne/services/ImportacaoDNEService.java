package com.tralmeida.edza.metropolisintegracaodne.services;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.dto.ImportacaoDNEDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.entities.TabelaImportacao;
import com.tralmeida.edza.metropolisintegracaodne.repositories.ImportacaoDNERepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.TabelaImportacaoRepository;

@Service
public class ImportacaoDNEService {
	
	@Autowired
	private ImportacaoDNERepository repository;
	
	@Autowired
	private TabelaImportacaoRepository tabelaImportacaoRepository;
	
	@Transactional(readOnly = true)
	public Page<ImportacaoDNEDTO> findAll(Pageable pageable){
		Page<ImportacaoDNE> page = repository.findAll(pageable);
		return page.map(x -> new ImportacaoDNEDTO(x));
	}
	
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
