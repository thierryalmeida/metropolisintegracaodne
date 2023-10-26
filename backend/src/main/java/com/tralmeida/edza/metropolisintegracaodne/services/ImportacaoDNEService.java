package com.tralmeida.edza.metropolisintegracaodne.services;

import java.io.IOException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tralmeida.edza.metropolisintegracaodne.constants.TableConstants;
import com.tralmeida.edza.metropolisintegracaodne.dto.ImportacaoDNEDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.entityassemblers.AddressObjectAssembler;
import com.tralmeida.edza.metropolisintegracaodne.filereaders.DNEDelimitadoFileReader;
import com.tralmeida.edza.metropolisintegracaodne.repositories.ImportacaoDNERepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.TabelaImportacaoRepository;
import com.tralmeida.edza.metropolisintegracaodne.services.exceptions.AddressEntityNotFoundException;

@Service
public class ImportacaoDNEService {
	
	@Autowired
	private ImportacaoDNERepository repository;
	
	@Autowired
	private TabelaImportacaoRepository tabelaImportacaoRepository;
	
	@Autowired
	private PaisService paisAssembler;
	
	@Transactional(readOnly = true)
	public Page<ImportacaoDNEDTO> findAll(Pageable pageable){
		Page<ImportacaoDNE> page = repository.findAll(pageable);
		return page.map(x -> new ImportacaoDNEDTO(x));
	}
	
	@Transactional
	public ImportacaoDNEDTO insert(ImportacaoDNEDTO dto, MultipartFile multipartFile){
		try {
			AddressObjectAssembler<?> entityAssembler = getAddressEntityAssemblerByIdTabela(dto.getTabelaImportacaoDTO().getId());
			DNEDelimitadoFileReader fileReader = new DNEDelimitadoFileReader(multipartFile.getInputStream(), entityAssembler);
			fileReader.insertEntities();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImportacaoDNE entity = copyDTOToEntity(dto);
		entity.setDataImportacao(new Timestamp(System.currentTimeMillis()));
		entity = repository.save(entity);
		
		return new ImportacaoDNEDTO(entity);
	}
	
	private ImportacaoDNE copyDTOToEntity(ImportacaoDNEDTO dto) {
		ImportacaoDNE entity = new ImportacaoDNE();
		entity.setDescricao(dto.getDescricao());
		entity.setTabelaImportacao(tabelaImportacaoRepository.getReferenceById(dto.getTabelaImportacaoDTO().getId()));
		
		return entity;
	}
	
	private AddressObjectAssembler<?> getAddressEntityAssemblerByIdTabela(Long idTabela) throws AddressEntityNotFoundException{
		if(idTabela.equals(TableConstants.ID_TABELA_PAIS)) {
			return this.paisAssembler;
		} else {
			throw new AddressEntityNotFoundException("Address entity with ID "+idTabela+" not found.");
		}
	}
}
