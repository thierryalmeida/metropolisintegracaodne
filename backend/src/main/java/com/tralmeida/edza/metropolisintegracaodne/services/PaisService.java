package com.tralmeida.edza.metropolisintegracaodne.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.dto.PaisDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.Pais;
import com.tralmeida.edza.metropolisintegracaodne.repositories.PaisRepository;

@Service
public class PaisService{
	
	@Autowired
	private PaisRepository repository;
	
	@Transactional
	public PaisDTO getReferenceToSave(String sigla){
		Pais entity = null;
		try{
			entity = repository.getReferenceById(sigla);
		} catch (Exception e) {
			System.out.println("País com o id "+sigla+" não encontrado.");
			return null;
		}
		return new PaisDTO(entity);
	}
	
	@Transactional
	public Pais saveEntity(PaisDTO pais) {
		return repository.saveAndFlush(getEntityByDTO(pais));
	}
	
	private Pais getEntityByDTO(PaisDTO dto) {
		Pais entity = new Pais();
		entity.setPaisId(dto.getPaisId());
		entity.setSigla(dto.getSigla());
		entity.setNome(dto.getNome());
		entity.setNacionalidade(dto.getNacionalidade());
		
		return entity;
	}
	
	@Transactional
	public PaisDTO save(PaisDTO pais) {
		Pais entity = null;
		Optional<Pais> entityOptional = repository.findById(pais.getSigla());
		
		if(entityOptional.isPresent()) {
			entity = mergeEntityToUpdate(pais, entityOptional.get());
		} else {
			entity = getEntityByDTO(pais);
		}
		return new PaisDTO(repository.saveAndFlush(entity));
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

}
