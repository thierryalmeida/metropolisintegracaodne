package com.tralmeida.edza.metropolisintegracaodne.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.dto.MunicipioDTO;
import com.tralmeida.edza.metropolisintegracaodne.dto.UnidadeFederativaDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.entities.Municipio;
import com.tralmeida.edza.metropolisintegracaodne.entities.UnidadeFederativa;
import com.tralmeida.edza.metropolisintegracaodne.entityassemblers.AddressObjectAssembler;
import com.tralmeida.edza.metropolisintegracaodne.enums.ImportFile;
import com.tralmeida.edza.metropolisintegracaodne.repositories.MunicipioRepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.UnidadeFederativaRepository;
import com.tralmeida.edza.metropolisintegracaodne.util.ParseUtil;
import com.tralmeida.edza.metropolisintegracaodne.util.TimeUtil;

@Service
public class MunicipioService implements AddressObjectAssembler<MunicipioDTO>{
	
	@Autowired
	private MunicipioRepository repository;
	
	@Autowired
	private UnidadeFederativaRepository ufRepository;

	@Override
	public Optional<MunicipioDTO> toAssemble(List<String> fields, ImportFile importFile, Long importacaoId) {
		MunicipioDTO dto = new MunicipioDTO();
	    dto.setDtAtualizacao(new Timestamp(TimeUtil.getCurrentTimeInMillis()));
		dto.setImportacaoId(importacaoId);
		
		if(importFile.equals(ImportFile.LOG_LOCALIDADE)) {
			dto.setMunicipioId(ParseUtil.parseStringToLong(fields.get(0)));
			dto.setUf(new UnidadeFederativaDTO());
			dto.getUf().setSigla(fields.get(1));
			dto.setNome(fields.get(2));
			dto.setCep(ParseUtil.parseStringToLong(fields.get(3)));
			dto.setOficial(1);
			
			return Optional.of(dto);
		} else if (importFile.equals(ImportFile.LOG_FAIXA_LOCALIDADE)) {
			dto.setMunicipioId(ParseUtil.parseStringToLong(fields.get(0)));
			dto.setCepInicial(ParseUtil.parseStringToLong(fields.get(1)));
			dto.setCepFinal(ParseUtil.parseStringToLong(fields.get(2)));
			
			return Optional.of(dto);
		} else {
			return Optional.empty();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean saveAndMerge(MunicipioDTO entityDTO) {
		Optional<Municipio> optional = repository.findById(entityDTO.getMunicipioId());
		
		Municipio entity = new Municipio();
		if(optional.isPresent()) {
			entity = mergeEntityToUpdate(entityDTO, optional.get());
		} else {
			entity = getEntityByDTO(entityDTO);
		}
		entity = repository.saveAndFlush(entity);
		
		return new MunicipioDTO(entity) != null;
	}

	private Municipio mergeEntityToUpdate(MunicipioDTO newMunicipio, Municipio oldMunicipio) {
		if(newMunicipio.getCep() != null) {
			oldMunicipio.setCep(newMunicipio.getCep());
		}
		if(newMunicipio.getCepFinal() != null) {
			oldMunicipio.setCepFinal(newMunicipio.getCepFinal());
		}
		if(newMunicipio.getCepInicial() != null) {
			oldMunicipio.setCepInicial(newMunicipio.getCepInicial());
		}
		if(newMunicipio.getCodigo() != null) {
			oldMunicipio.setCodigo(newMunicipio.getCodigo());
		}
		if(newMunicipio.getCodigoTom() != null) {
			oldMunicipio.setCodigoTom(newMunicipio.getCodigoTom());
		}
		if(newMunicipio.getMunicipioId() != null) {
			oldMunicipio.setMunicipioId(newMunicipio.getMunicipioId());
		}
		if(newMunicipio.getNome() != null) {
			oldMunicipio.setNome(newMunicipio.getNome());
		}
		if(newMunicipio.getOficial() != null) {
			oldMunicipio.setOficial(newMunicipio.getOficial());
		}
	    if(newMunicipio.getDtInclusao() != null) {
			oldMunicipio.setDtInclusao(newMunicipio.getDtInclusao());
		}
		oldMunicipio.setDtAtualizacao(newMunicipio.getDtAtualizacao());
		oldMunicipio.setImportacaoDNE(new ImportacaoDNE());
		oldMunicipio.getImportacaoDNE().setImportacaoId(newMunicipio.getImportacaoId());
		
		if(newMunicipio.getUf() != null && newMunicipio.getUf().getSigla() != null) {
			UnidadeFederativa uf = ufRepository.findBySigla(newMunicipio.getUf().getSigla());
			oldMunicipio.setUf(uf);
		}
		return oldMunicipio;
	}

	private Municipio getEntityByDTO(MunicipioDTO entityDTO) {
		Municipio entity = new Municipio();
		
		entity.setCep(entityDTO.getCep());
		entity.setCepFinal(entityDTO.getCepFinal());
		entity.setCepInicial(entityDTO.getCepInicial());
		entity.setCodigo(entityDTO.getCodigo());
		entity.setCodigoTom(entityDTO.getCodigoTom());
		entity.setMunicipioId(entityDTO.getMunicipioId());
		entity.setNome(entityDTO.getNome());
		entity.setOficial(entityDTO.getOficial());
	 	entity.setDtAtualizacao(entityDTO.getDtAtualizacao());
		entity.setDtInclusao(entityDTO.getDtAtualizacao());
		entity.setImportacaoDNE(new ImportacaoDNE());
		entity.getImportacaoDNE().setImportacaoId(entityDTO.getImportacaoId());
		
		if(entityDTO.getUf() != null && entityDTO.getUf().getSigla() != null) {
			UnidadeFederativa uf = ufRepository.findBySigla(entityDTO.getUf().getSigla());
			entity.setUf(uf);
		}
		return entity;
	}

}
