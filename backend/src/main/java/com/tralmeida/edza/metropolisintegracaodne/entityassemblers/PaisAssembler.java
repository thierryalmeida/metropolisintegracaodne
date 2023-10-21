package com.tralmeida.edza.metropolisintegracaodne.entityassemblers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tralmeida.edza.metropolisintegracaodne.dto.PaisDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.Pais;
import com.tralmeida.edza.metropolisintegracaodne.services.PaisService;

@Component
public class PaisAssembler implements AddressObjectAssembler<PaisDTO>{

	@Autowired
	private PaisService service;
	
	@Override
	public Optional<PaisDTO> toAssemble(List<String> fields) {
		PaisDTO pais = new PaisDTO();
		pais.setNome(fields.get(2));
		pais.setSigla(fields.get(0));
		return Optional.of(pais);
	}

	@Override
	public boolean save(PaisDTO pais) {
		return service.save(pais) != null;
	}
}
