package com.tralmeida.edza.metropolisintegracaodne.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tralmeida.edza.metropolisintegracaodne.dto.ImportacaoDNEDTO;
import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.factory.Factory;
import com.tralmeida.edza.metropolisintegracaodne.repositories.ImportacaoDNERepository;

@ExtendWith(SpringExtension.class)
public class ImportacaoDNEServiceTests {
	
	@InjectMocks
	private ImportacaoDNEService service;
	
	@Mock
	private ImportacaoDNERepository repository;
	
	private ImportacaoDNE importacao;
	private PageImpl<ImportacaoDNE> page;
	private ImportacaoDNEDTO importacaoDTO;
	
	@BeforeEach
	void setUp() throws Exception{
		importacao = Factory.createImportacaoDNE();
		page = new PageImpl<>(List.of(importacao));
		importacaoDTO = Factory.createImportacaoDNEDTO();
		
		Mockito.when(repository.findAll((Pageable)any())).thenReturn(page);
		Mockito.when(repository.save(any())).thenReturn(importacao);
	}
	
	@Test
	public void findAllPagedShouldReturnPage() {
		Pageable pageable = PageRequest.of(0, 15);
		Page<ImportacaoDNEDTO> result = service.findAll(pageable);
		
		Assertions.assertNotNull(result);
	}
	
	@Test
	public void insertShouldReturnDTOWhenMultipartFileIsNotNull() {
		
	}
}
