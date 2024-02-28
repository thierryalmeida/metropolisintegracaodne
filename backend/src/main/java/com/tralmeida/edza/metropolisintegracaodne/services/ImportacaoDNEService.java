package com.tralmeida.edza.metropolisintegracaodne.services;

import java.sql.Timestamp;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tralmeida.edza.metropolisintegracaodne.dto.ImportacaoDNEDTO;
import com.tralmeida.edza.metropolisintegracaodne.dto.StatusImportacaoDTO;
import com.tralmeida.edza.metropolisintegracaodne.dto.TabelaImportacaoDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.entities.StatusImportacao;
import com.tralmeida.edza.metropolisintegracaodne.entityassemblers.AddressObjectAssembler;
import com.tralmeida.edza.metropolisintegracaodne.enums.StatusImportacaoEnum;
import com.tralmeida.edza.metropolisintegracaodne.enums.TableEnum;
import com.tralmeida.edza.metropolisintegracaodne.filereaders.DNEDelimitadoFileReader;
import com.tralmeida.edza.metropolisintegracaodne.repositories.ImportacaoDNERepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.StatusImportacaoRepository;
import com.tralmeida.edza.metropolisintegracaodne.repositories.TabelaImportacaoRepository;
import com.tralmeida.edza.metropolisintegracaodne.services.exceptions.AddressEntityNotFoundException;

@Service
public class ImportacaoDNEService {
	
	@Autowired
	private ImportacaoDNERepository repository;
	
	@Autowired
	private TabelaImportacaoRepository tabelaImportacaoRepository;
	
	@Autowired
	private StatusImportacaoRepository statusImportacaoRepository;
	
	@Autowired
	private PaisService paisAssembler;
	
	@Autowired
	private UnidadeFederativaService ufAssembler;
	
	@Autowired
	private MunicipioService municipioAssembler;
	
	@Autowired
	private BairroService bairroAssembler;
	
	@Autowired
	private LogradouroService logradouroAssembler;
	
	@Transactional(readOnly = true)
	public Page<ImportacaoDNEDTO> findAll(Pageable pageable){
		Page<ImportacaoDNE> page = repository.findAll(pageable);
		return page.map(x -> new ImportacaoDNEDTO(x));
	}
	
	public ImportacaoDNEDTO importData(ImportacaoDNEDTO dto, MultipartFile multipartFile){
		ImportacaoDNE entity = insert(dto);
		
		AddressObjectAssembler<?> entityAssembler = getAddressEntityAssemblerByIdTabela(dto.getTabelaImportacaoDTO().getTabelaImportacaoId());
		DNEDelimitadoFileReader fileReader = new DNEDelimitadoFileReader(multipartFile, entityAssembler, entity.getImportacaoId());
		
		try {
			fileReader.insertEntities();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entity.setRegistrosLidos(fileReader.getLinesRead());
		entity.setRegistrosImportados(fileReader.getImportedLines());
		
		boolean totalEqualsImported = fileReader.getTotalLines().equals(fileReader.getImportedLines());
		boolean someLineRead = !(fileReader.getLinesRead().compareTo(0L) > 0);;
		boolean someImportedLine = !(fileReader.getImportedLines().compareTo(0L) > 0);  
		
		StatusImportacaoEnum status = StatusImportacaoEnum.ERRO;
		if(totalEqualsImported) {
			status = StatusImportacaoEnum.SUCESSO;
		} else if(someLineRead && someImportedLine) {
			status = StatusImportacaoEnum.INCOMPLETA;
		}
		entity.setStatusImportacao(new StatusImportacao(status.getStatusImportacaoId(), null));
		entity = repository.saveAndFlush(entity);
		
		return new ImportacaoDNEDTO(entity);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private ImportacaoDNE insert(ImportacaoDNEDTO dto) {
		ImportacaoDNE entity = copyDTOToEntity(dto);
		entity.setDataImportacao(new Timestamp(System.currentTimeMillis()));
		entity = repository.saveAndFlush(entity);
		
		return entity;
	}
	
	private ImportacaoDNE copyDTOToEntity(ImportacaoDNEDTO dto) {
		ImportacaoDNE entity = new ImportacaoDNE();
		entity.setDescricao(dto.getDescricao());
		entity.setDataImportacao(dto.getDataImportacao());
		entity.setRegistrosLidos(dto.getRegistrosLidos());
		entity.setRegistrosImportados(dto.getRegistrosImportados());
		entity.setStatusImportacao(statusImportacaoRepository.getReferenceById(dto.getStatusImportacaoDTO().getStatusImportacaoId()));
		entity.setTabelaImportacao(tabelaImportacaoRepository.getReferenceById(dto.getTabelaImportacaoDTO().getTabelaImportacaoId()));
		
		return entity;
	}
	
	private AddressObjectAssembler<?> getAddressEntityAssemblerByIdTabela(Long idTabela) throws AddressEntityNotFoundException{
		HashMap<Long, AddressObjectAssembler<?>> assemblerMap = new HashMap<>();
		assemblerMap.put(TableEnum.TABELA_PAIS.getTabelaImportacaoId(), paisAssembler);
		assemblerMap.put(TableEnum.TABELA_UF.getTabelaImportacaoId(), ufAssembler);
		assemblerMap.put(TableEnum.TABELA_MUNICIPIO.getTabelaImportacaoId(), municipioAssembler);
		assemblerMap.put(TableEnum.TABELA_BAIRRO.getTabelaImportacaoId(), bairroAssembler);
		assemblerMap.put(TableEnum.TABELA_LOGRADOURO.getTabelaImportacaoId(), logradouroAssembler);
		
		AddressObjectAssembler<?> assembler = assemblerMap.get(idTabela);
		if(assembler != null) {
			return assembler;
		} else {
			throw new AddressEntityNotFoundException("Address entity with ID "+idTabela+" not found.");
		}
	}
}
