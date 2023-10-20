package com.tralmeida.edza.metropolisintegracaodne.entityassemblers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tralmeida.edza.metropolisintegracaodne.entities.Pais;
import com.tralmeida.edza.metropolisintegracaodne.services.PaisService;
import com.tralmeida.edza.metropolisintegracaodne.services.exceptions.AddressEntityNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Component
public class PaisAssembler implements AddressEntityAssembler<Pais>{

	@Autowired
	private PaisService service;
	
	@Override
	public Optional<Pais> toAssemble(List<String> fields) {
		Pais pais = new Pais();
		pais.setNome(fields.get(2));
		pais.setSigla(fields.get(0));
		return Optional.of(pais);
	}

	@Override
	public boolean save(Pais entity) {
		/*Pais oldEntity = service.getBySigla(entity.getSigla());
		if(oldEntity != null) {
			entity = mergeEntityToUpdate(entity, oldEntity);
		}*/
		return service.saveEntity(entity) != null;
	}
	
	private Pais mergeEntityToUpdate(Pais newEntity, Pais oldEntity) {
		if(newEntity.getNacionalidade() != null) {
			oldEntity.setNacionalidade(newEntity.getNacionalidade());
		}
		if(newEntity.getNome() != null) {
			oldEntity.setNome(newEntity.getNome());
		}
		if(newEntity.getPaisId() != null) {
			oldEntity.setPaisId(newEntity.getPaisId());
		}
		if(newEntity.getSigla() != null) {
			oldEntity.setSigla(newEntity.getSigla());
		}
		return oldEntity;
	}

}
