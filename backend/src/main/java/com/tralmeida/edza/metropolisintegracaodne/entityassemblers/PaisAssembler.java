package com.tralmeida.edza.metropolisintegracaodne.entityassemblers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tralmeida.edza.metropolisintegracaodne.entities.Pais;
import com.tralmeida.edza.metropolisintegracaodne.services.PaisService;

public class PaisAssembler implements AddressEntityAssembler<Pais>{

	@Autowired
	private PaisService service;
	
	@Override
	public Optional<Pais> toAssemble(List<String> fields) {
		Pais pais = new Pais();
		pais.setNome(fields.get(3));
		pais.setSigla(fields.get(1));
		return Optional.of(pais);
	}

	@Override
	public boolean save(Pais entity) {
		service.saveEntity(entity);
		return service.saveEntity(entity) != null;
	}

}
