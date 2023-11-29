package com.tralmeida.edza.metropolisintegracaodne.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.dto.PaisDTO;
import com.tralmeida.edza.metropolisintegracaodne.dto.UnidadeFederativaDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.Pais;
import com.tralmeida.edza.metropolisintegracaodne.entities.UnidadeFederativa;
import com.tralmeida.edza.metropolisintegracaodne.entityassemblers.AddressObjectAssembler;
import com.tralmeida.edza.metropolisintegracaodne.enums.ImportFile;
import com.tralmeida.edza.metropolisintegracaodne.repositories.PaisRepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.UnidadeFederativaRepository;
import com.tralmeida.edza.metropolisintegracaodne.util.ParseUtil;

@Service
public class UnidadeFederativaService implements AddressObjectAssembler<UnidadeFederativaDTO>{
	
	@Autowired
	private UnidadeFederativaRepository repository;
	
	@Autowired
	private PaisRepository paisRepository;

	@Override
	public Optional<UnidadeFederativaDTO> toAssemble(List<String> fields, ImportFile importFile) {
		UnidadeFederativaDTO ufDTO = new UnidadeFederativaDTO();
		if(importFile.equals(ImportFile.LOG_FAIXA_UF)) {
			ufDTO.setSigla(fields.get(0));
			ufDTO.setCepIni(ParseUtil.parseStringToLong(fields.get(1)));
			ufDTO.setCepFim(ParseUtil.parseStringToLong(fields.get(2)));
			ufDTO.setPaisDTO(new PaisDTO());
			
			return Optional.of(ufDTO);
		}else {
			return Optional.empty();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean saveAndMerge(UnidadeFederativaDTO entityDTO) {
		UnidadeFederativa entity = repository.findBySigla(entityDTO.getSigla());
		
		if(entity != null) {
			entity = mergeEntityToUpdate(entityDTO, entity);
		} else {
			entity = getEntityByDTO(entityDTO);
		}
		return new UnidadeFederativaDTO(repository.saveAndFlush(entity)) != null;
	}
	
	private UnidadeFederativa mergeEntityToUpdate(UnidadeFederativaDTO newUf, UnidadeFederativa oldUf) {
		if(newUf.getSigla() != null) {
			oldUf.setSigla(newUf.getSigla());
		}
		if(newUf.getCepIni() != null) {
			oldUf.setCepIni(newUf.getCepIni());
		}
		if(newUf.getCepFim() != null) {
			oldUf.setCepFim(newUf.getCepFim());
		}
		if(newUf.getNome() != null) {
			oldUf.setNome(newUf.getNome());
		}
		if(newUf.getOficial() != null) {
			oldUf.setOficial(newUf.getOficial());
		}
		if(newUf.getUfId() != null) {
			oldUf.setUfId(newUf.getUfId());
		}
		if(newUf.getPaisDTO() != null && newUf.getPaisDTO().getPaisId() != null) {
			Pais pais = paisRepository.findBySigla(newUf.getPaisDTO().getSigla());
			oldUf.setPais(pais);
		}
		return oldUf;
	}
	
	private UnidadeFederativa getEntityByDTO(UnidadeFederativaDTO dto) {
		UnidadeFederativa entity = new UnidadeFederativa();
		entity.setCepIni(dto.getCepIni());
		entity.setCepFim(dto.getCepFim());
		entity.setSigla(dto.getSigla());
		return entity;
	}

}
