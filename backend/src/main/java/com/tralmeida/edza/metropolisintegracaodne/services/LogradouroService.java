package com.tralmeida.edza.metropolisintegracaodne.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tralmeida.edza.metropolisintegracaodne.constants.ConstantesEndereco;
import com.tralmeida.edza.metropolisintegracaodne.dto.BairroDTO;
import com.tralmeida.edza.metropolisintegracaodne.dto.BairroLogradouroDTO;
import com.tralmeida.edza.metropolisintegracaodne.dto.LogradouroDTO;
import com.tralmeida.edza.metropolisintegracaodne.dto.MunicipioDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.entities.Logradouro;
import com.tralmeida.edza.metropolisintegracaodne.entities.Municipio;
import com.tralmeida.edza.metropolisintegracaodne.entities.TipoLogradouro;
import com.tralmeida.edza.metropolisintegracaodne.entityassemblers.AddressObjectAssembler;
import com.tralmeida.edza.metropolisintegracaodne.enums.ImportFile;
import com.tralmeida.edza.metropolisintegracaodne.repositories.LogradouroRepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.MunicipioRepository;
import com.tralmeida.edza.metropolisintegracaodne.util.ParseUtil;

@Service
public class LogradouroService implements AddressObjectAssembler<LogradouroDTO>{
	
	@Autowired
	LogradouroRepository repository;
	
	@Autowired
	MunicipioRepository municipioRepository;
	
	@Autowired
	BairroLogradouroService bairroLogradouroService;
	
	@Autowired
	TipoLogradouroService tipoLogradouroService;

	@Override
	public Optional<LogradouroDTO> toAssemble(List<String> fields, ImportFile importFile, Long importacaoId) {
		LogradouroDTO dto = new LogradouroDTO();
		if(importFile.toString().substring(0, 14).equals("LOG_LOGRADOURO")) {
			dto.setLogradouroId(ParseUtil.parseStringToLong(fields.get(0)));
			dto.setMunicipioDTO(new MunicipioDTO());
			dto.getMunicipioDTO().setMunicipioId(ParseUtil.parseStringToLong(fields.get(2)));
			dto.setBairroId(ParseUtil.parseStringToLong(fields.get(3)));
			dto.setNome(fields.get(5));
			dto.setComplemento(fields.get(6));
			dto.setCep(ParseUtil.parseStringToLong(fields.get(7)));
			dto.setOficial(ConstantesEndereco.OFICIAL);
			dto.setCodigo(ParseUtil.parseStringToLong(fields.get(0)));
			dto.setDtAtualizacao(new Timestamp(System.currentTimeMillis()));
			dto.setImportacaoId(importacaoId);
			
			TipoLogradouro tipo = tipoLogradouroService.specialFindByDescricao(fields.get(8));
			dto.setTipoLogradouroId(tipo.getTipoLogradouroId());
			
			return Optional.of(dto);
		}
		return Optional.empty();
	}

	@Override
	public boolean saveAndMerge(LogradouroDTO entityDTO) {
		LogradouroDTO dto = saveAndMergeLogradouro(entityDTO);
		verifyAndSaveBairroLogradouro(entityDTO.getBairroId(), dto.getLogradouroId(), entityDTO.getImportacaoId());

		return dto != null;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private LogradouroDTO saveAndMergeLogradouro(LogradouroDTO entityDTO) {
		Optional<Logradouro> optional = repository.findById(entityDTO.getLogradouroId());
		
		Logradouro entity = new Logradouro();
		if(optional.isPresent()) {
			entity = mergeEntityToUpdate(entityDTO, optional.get());
		} else {
			entity = getEntityByDTO(entityDTO);
		}
		entity = repository.saveAndFlush(entity);
		
		return new LogradouroDTO(entity);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void verifyAndSaveBairroLogradouro(Long bairroId, Long logradouroId, Long importacaoId) {
		if(!bairroLogradouroService.existsByBairroIdAndLogradouroId(bairroId, logradouroId)) {
			BairroLogradouroDTO bairroLogradouroDTO = new BairroLogradouroDTO();
			bairroLogradouroDTO.setBairro(new BairroDTO());
			bairroLogradouroDTO.getBairro().setBairroId(bairroId);
			bairroLogradouroDTO.setLogradouro(new LogradouroDTO());
			bairroLogradouroDTO.getLogradouro().setLogradouroId(logradouroId);
			
			bairroLogradouroService.saveAndFlush(bairroLogradouroDTO);
		}
	}
	
	private Logradouro mergeEntityToUpdate(LogradouroDTO newLogradouro, Logradouro oldLogradouro) {
		if(newLogradouro.getCep() != null) {
			oldLogradouro.setCep(newLogradouro.getCep());
		}
		if(newLogradouro.getLogradouroId() != null) {
			oldLogradouro.setLogradouroId(newLogradouro.getLogradouroId());
		}
		if(newLogradouro.getNome() != null) {
			oldLogradouro.setNome(newLogradouro.getNome());
		}
		if(newLogradouro.getOficial() != null) {
			oldLogradouro.setOficial(newLogradouro.getOficial());
		}
		if(newLogradouro.getTpImovel() != null) {
			oldLogradouro.setTpImovel(newLogradouro.getTpImovel());
		}
		if(newLogradouro.getLogradouroOficial() != null) {
			oldLogradouro.setLogradouroOficial(newLogradouro.getLogradouroOficial());
		}
		if(newLogradouro.getCodigo() != null) {
			oldLogradouro.setCodigo(newLogradouro.getCodigo());
		}
		if(newLogradouro.getComplemento() != null) {
			oldLogradouro.setComplemento(newLogradouro.getComplemento());
		}
		if(newLogradouro.getDataDocumentoLegal() != null) {
			oldLogradouro.setDataDocumentoLegal(newLogradouro.getDataDocumentoLegal());
		}
		if(newLogradouro.getDtInclusao() != null) {
			oldLogradouro.setDtInclusao(newLogradouro.getDtInclusao());
		}
		if(newLogradouro.getLimiteMetrico() != null) {
			oldLogradouro.setLimiteMetrico(newLogradouro.getLimiteMetrico());
		}
		if(newLogradouro.getLogradouroFinalId() != null) {
			oldLogradouro.setLogradouroFinalId(newLogradouro.getLogradouroFinalId());
		}
		if(newLogradouro.getLogradouroGeoId() != null) {
			oldLogradouro.setLogradouroGeoId(newLogradouro.getLogradouroGeoId());
		}
		if(newLogradouro.getLogradouroInicialId() != null) {
			oldLogradouro.setLogradouroInicialId(newLogradouro.getLogradouroInicialId());
		}
		if(newLogradouro.getMigracao_codigoCorreios() != null) {
			oldLogradouro.setMigracao_codigoCorreios(newLogradouro.getMigracao_codigoCorreios());
		}
		if(newLogradouro.getNome_Anterior() != null) {
			oldLogradouro.setNome_Anterior(newLogradouro.getNome_Anterior());
		}
		if(newLogradouro.getNomeAnterior() != null) {
			oldLogradouro.setNomeAnterior(newLogradouro.getNomeAnterior());
		}
		if(newLogradouro.getTipoLogradouroId() != null) {
			oldLogradouro.setTipoLogradouroId(newLogradouro.getTipoLogradouroId());
		}
		if(newLogradouro.getTituloLogradouroId() != null) {
			oldLogradouro.setTituloLogradouroId(newLogradouro.getTituloLogradouroId());
		}
		if(newLogradouro.getUsuarioId() != null) {
			oldLogradouro.setUsuarioId(newLogradouro.getUsuarioId());
		}
		oldLogradouro.setDtAtualizacao(newLogradouro.getDtAtualizacao());
		oldLogradouro.setImportacaoDNE(new ImportacaoDNE());
		oldLogradouro.getImportacaoDNE().setImportacaoId(newLogradouro.getImportacaoId());
		
		if(newLogradouro.getMunicipioDTO() != null && newLogradouro.getMunicipioDTO().getMunicipioId() != null) {
			Optional<Municipio> municipio = municipioRepository.findById(newLogradouro.getMunicipioDTO().getMunicipioId());
			oldLogradouro.setMunicipio(municipio.get());
		}
		return oldLogradouro;
	}
	
	private Logradouro getEntityByDTO(LogradouroDTO entityDTO) {
		Logradouro entity = new Logradouro();
		
		entity.setCep(entityDTO.getCep());
		entity.setLogradouroId(entityDTO.getLogradouroId());
		entity.setNome(entityDTO.getNome());
		entity.setOficial(entityDTO.getOficial());
		entity.setTpImovel(entityDTO.getTpImovel());
		entity.setLogradouroOficial(entityDTO.getLogradouroOficial());
		entity.setCodigo(entityDTO.getCodigo());
		entity.setComplemento(entityDTO.getComplemento());
		entity.setDataDocumentoLegal(entityDTO.getDataDocumentoLegal());
		entity.setDtAtualizacao(entityDTO.getDtAtualizacao());
		entity.setDtInclusao(entityDTO.getDtAtualizacao());
		entity.setLimiteMetrico(entityDTO.getLimiteMetrico());
		entity.setLogradouroFinalId(entityDTO.getLogradouroFinalId());
		entity.setLogradouroGeoId(entityDTO.getLogradouroGeoId());
		entity.setLogradouroInicialId(entityDTO.getLogradouroInicialId());
		entity.setMigracao_codigoCorreios(entityDTO.getMigracao_codigoCorreios());
		entity.setNome_Anterior(entityDTO.getNome_Anterior());
		entity.setNomeAnterior(entityDTO.getNomeAnterior());
		entity.setTipoLogradouroId(entityDTO.getTipoLogradouroId());
		entity.setTituloLogradouroId(entityDTO.getTituloLogradouroId());
		entity.setUsuarioId(entityDTO.getUsuarioId());
		entity.setImportacaoDNE(new ImportacaoDNE());
		entity.getImportacaoDNE().setImportacaoId(entityDTO.getImportacaoId());
		
		if(entityDTO.getMunicipioDTO() != null && entityDTO.getMunicipioDTO().getMunicipioId() != null) {
			Optional<Municipio> municipio = municipioRepository.findById(entityDTO.getMunicipioDTO().getMunicipioId());
			entity.setMunicipio(municipio.get());
		}
		return entity;
	}
}
