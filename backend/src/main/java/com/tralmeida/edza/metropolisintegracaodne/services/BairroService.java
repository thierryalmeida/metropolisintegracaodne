package com.tralmeida.edza.metropolisintegracaodne.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.dto.BairroDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.Bairro;
import com.tralmeida.edza.metropolisintegracaodne.entities.Municipio;
import com.tralmeida.edza.metropolisintegracaodne.entityassemblers.AddressObjectAssembler;
import com.tralmeida.edza.metropolisintegracaodne.enums.ImportFile;
import com.tralmeida.edza.metropolisintegracaodne.repositories.BairroRepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.MunicipioRepository;
import com.tralmeida.edza.metropolisintegracaodne.util.ParseUtil;

@Service
public class BairroService implements AddressObjectAssembler<BairroDTO>{
	
	@Autowired
	private BairroRepository repository;
	
	@Autowired
	private MunicipioRepository municipioRepository;

	@Override
	public Optional<BairroDTO> toAssemble(List<String> fields, ImportFile importFile) {
		BairroDTO dto = new BairroDTO();
		if(importFile.equals(ImportFile.LOG_BAIRRO)) {
			dto.setBairroId(ParseUtil.parseStringToLong(fields.get(0)));
			dto.setNome(fields.get(3));
			
			return Optional.of(dto);
		} else if (importFile.equals(ImportFile.LOG_FAIXA_BAIRRO)) {
			dto.setBairroId(ParseUtil.parseStringToLong(fields.get(0)));
			dto.setCepInicial(fields.get(1));
			dto.setCepFinal(fields.get(2));
			
			return Optional.of(dto);
		} else {
			return Optional.empty();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean saveAndMerge(BairroDTO entityDTO) {
		Optional<Bairro> optional = repository.findById(entityDTO.getBairroId());
		
		Bairro entity = new Bairro();
		if(optional.isPresent()) {
			entity = mergeEntityToUpdate(entityDTO, optional.get());
		} else {
			entity = getEntityByDTO(entityDTO);
		}
		entity = repository.saveAndFlush(entity);
		
		return new BairroDTO(entity) != null;
	}

	private Bairro mergeEntityToUpdate(BairroDTO newBairro, Bairro oldBairro) {
		if(newBairro.getCep() != null) {
			oldBairro.setCep(newBairro.getCep());
		}
		if(newBairro.getCepFinal() != null) {
			oldBairro.setCepFinal(newBairro.getCepFinal());
		}
		if(newBairro.getCepInicial() != null) {
			oldBairro.setCepInicial(newBairro.getCepInicial());
		}
		if(newBairro.getBairroId() != null) {
			oldBairro.setBairroId(newBairro.getBairroId());
		}
		if(newBairro.getNome() != null) {
			oldBairro.setNome(newBairro.getNome());
		}
		if(newBairro.getOficial() != null) {
			oldBairro.setOficial(newBairro.getOficial());
		}
		if(newBairro.getGrupoBairro() != null) {
			oldBairro.setGrupoBairro(newBairro.getGrupoBairro());
		}
		if(newBairro.getTipo() != null) {
			oldBairro.setTipo(newBairro.getTipo());
		}
		if(newBairro.getTpImovel() != null) {
			oldBairro.setTpImovel(newBairro.getTpImovel());
		}
		if(newBairro.getMunicipioDTO() != null && newBairro.getMunicipioDTO().getMunicipioId() != null) {
			Optional<Municipio> municipio = municipioRepository.findById(newBairro.getMunicipioDTO().getMunicipioId());
			oldBairro.setMunicipio(municipio.get());
		}
		return oldBairro;
	}

	private Bairro getEntityByDTO(BairroDTO entityDTO) {
		Bairro entity = new Bairro();
		
		entity.setCep(entityDTO.getCep());
		entity.setCepFinal(entityDTO.getCepFinal());
		entity.setCepInicial(entityDTO.getCepInicial());
		entity.setBairroId(entityDTO.getBairroId());
		entity.setNome(entityDTO.getNome());
		entity.setOficial(entityDTO.getOficial());
		entity.setGrupoBairro(entityDTO.getGrupoBairro());
		entity.setTipo(entityDTO.getTipo());
		entity.setTpImovel(entityDTO.getTpImovel());
		
		if(entityDTO.getMunicipioDTO() != null && entityDTO.getMunicipioDTO().getMunicipioId() != null) {
			Optional<Municipio> municipio = municipioRepository.findById(entityDTO.getMunicipioDTO().getMunicipioId());
			entity.setMunicipio(municipio.get());
		}
		return entity;
	}

}