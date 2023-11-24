package com.tralmeida.edza.metropolisintegracaodne.services;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tralmeida.edza.metropolisintegracaodne.dto.ImportacaoDNEDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.entityassemblers.AddressObjectAssembler;
import com.tralmeida.edza.metropolisintegracaodne.enums.TableEnum;
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
	
	@Autowired
	private UnidadeFederativaService ufAssembler;
	
	@Autowired
	private MunicipioService municipioAssembler;
	
	@Transactional(readOnly = true)
	public Page<ImportacaoDNEDTO> findAll(Pageable pageable){
		Page<ImportacaoDNE> page = repository.findAll(pageable);
		return page.map(x -> new ImportacaoDNEDTO(x));
	}
	
	@Transactional
	public ImportacaoDNEDTO insert(ImportacaoDNEDTO dto, MultipartFile multipartFile){
		try {
			AddressObjectAssembler<?> entityAssembler = getAddressEntityAssemblerByIdTabela(dto.getTabelaImportacaoDTO().getId());
			DNEDelimitadoFileReader fileReader = new DNEDelimitadoFileReader(multipartFile, entityAssembler);
			fileReader.insertEntities();
		} catch (Exception e) {
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
		HashMap<Long, AddressObjectAssembler<?>> assemblerMap = new HashMap<>();
		assemblerMap.put(TableEnum.ID_TABELA_PAIS, paisAssembler);
		assemblerMap.put(TableEnum.ID_TABELA_UF, ufAssembler);
		assemblerMap.put(TableEnum.ID_TABELA_MUNICIPIO, municipioAssembler);
		
		AddressObjectAssembler<?> assembler = assemblerMap.get(idTabela);
		if(assembler != null) {
			return assembler;
		} else {
			throw new AddressEntityNotFoundException("Address entity with ID "+idTabela+" not found.");
		}
	}
}
