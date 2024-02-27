package com.tralmeida.edza.metropolisintegracaodne.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.dto.BairroLogradouroDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.BairroLogradouro;
import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.repositories.BairroLogradouroRepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.BairroRepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.ImportacaoDNERepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.LogradouroRepository;

@Service
public class BairroLogradouroService {
	
	@Autowired
	BairroLogradouroRepository repository;
	
	@Autowired
	BairroRepository bairroRepository;
	
	@Autowired
	LogradouroRepository logradouroRepository;
	
	@Autowired
	ImportacaoDNERepository importacaoDNERepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public BairroLogradouro saveAndFlush(BairroLogradouroDTO bairroLogradouroDTO) {
		BairroLogradouro entity = getEntityByDTO(bairroLogradouroDTO);
		return repository.saveAndFlush(entity);
	}
	
	public boolean existsByBairroIdAndLogradouroId(Long bairroId, Long logradouroId) {
		BairroLogradouro bairroLogradouro = repository.findByBairroAndLogradouro(bairroId, logradouroId);
		return bairroLogradouro != null;
	}
	
	private BairroLogradouro getEntityByDTO(BairroLogradouroDTO dto) {
		BairroLogradouro entity = new BairroLogradouro();
		entity.setBairro(bairroRepository.getReferenceById(dto.getBairro().getBairroId()));
		entity.setLogradouro(logradouroRepository.getReferenceById(dto.getLogradouro().getLogradouroId()));
		entity.setImportacaoDNE(importacaoDNERepository.getReferenceById(dto.getImportacaoId()));
		//entity.setImportacaoDNE(new ImportacaoDNE());
		//entity.getImportacaoDNE().setImportacaoId(dto.getImportacaoId());
		
		return entity;
	}
}
