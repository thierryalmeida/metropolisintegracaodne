package com.tralmeida.edza.metropolisintegracaodne.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.dto.PaisDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.Pais;
import com.tralmeida.edza.metropolisintegracaodne.entityassemblers.AddressObjectAssembler;
import com.tralmeida.edza.metropolisintegracaodne.repositories.PaisRepository;

@Service
public class PaisService implements AddressObjectAssembler<PaisDTO>{
	
	@Autowired
	private PaisRepository repository;
	
	@Override
	public Optional<PaisDTO> toAssemble(List<String> fields) {
		PaisDTO pais = new PaisDTO();
		pais.setNome(fields.get(2));
		pais.setSigla(fields.get(0));
		return Optional.of(pais);
	}
	
	@Override
	@Transactional
	public boolean saveAndMerge(PaisDTO pais) {
		Pais entity = repository.findBySigla(pais.getSigla());
		
		if(entity != null) {
			entity = mergeEntityToUpdate(pais, entity);
		} else {
			entity = getEntityByDTO(pais);
		}
		return new PaisDTO(repository.saveAndFlush(entity)) != null;
	}
	
	private Pais mergeEntityToUpdate(PaisDTO newPais, Pais oldPais) {
		if(newPais.getNacionalidade() != null) {
			oldPais.setNacionalidade(newPais.getNacionalidade());
		}
		if(newPais.getNome() != null) {
			oldPais.setNome(newPais.getNome());
		}
		if(newPais.getPaisId() != null) {
			oldPais.setPaisId(newPais.getPaisId());
		}
		if(newPais.getSigla() != null) {
			oldPais.setSigla(newPais.getSigla());
		}
		return oldPais;
	}
	
	private Pais getEntityByDTO(PaisDTO dto) {
		Pais entity = new Pais();
		entity.setPaisId(dto.getPaisId());
		entity.setSigla(dto.getSigla());
		entity.setNome(dto.getNome());
		entity.setNacionalidade(dto.getNacionalidade());
		
		return entity;
	}
	
}
