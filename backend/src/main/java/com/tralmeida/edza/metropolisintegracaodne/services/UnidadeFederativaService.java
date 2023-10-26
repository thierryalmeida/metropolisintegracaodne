package com.tralmeida.edza.metropolisintegracaodne.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tralmeida.edza.metropolisintegracaodne.dto.UnidadeFederativaDTO;
import com.tralmeida.edza.metropolisintegracaodne.entityassemblers.AddressObjectAssembler;

@Service
public class UnidadeFederativaService implements AddressObjectAssembler<UnidadeFederativaDTO>{

	@Override
	public Optional<UnidadeFederativaDTO> toAssemble(List<String> fields) {
		UnidadeFederativaDTO ufDTO = new UnidadeFederativaDTO();
		ufDTO.setSigla(fields.get(0));
		ufDTO.setCepIni(Long.parseLong(fields.get(1)));
		ufDTO.setCepFim(Long.parseLong(fields.get(2)));
		return Optional.of(ufDTO);
	}

	@Override
	public boolean saveAndMerge(UnidadeFederativaDTO entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
