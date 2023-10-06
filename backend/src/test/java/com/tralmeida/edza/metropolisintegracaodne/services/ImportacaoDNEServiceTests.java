package com.tralmeida.edza.metropolisintegracaodne.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tralmeida.edza.metropolisintegracaodne.dto.ImportacaoDNEDTO;
import com.tralmeida.edza.metropolisintegracaodne.repositories.ImportacaoDNERepository;

@ExtendWith(SpringExtension.class)
public class ImportacaoDNEServiceTests {
	
	@InjectMocks
	private ImportacaoDNEService service;
	
	@Mock
	private ImportacaoDNERepository repository;
	
	@BeforeEach
	void setUp() throws Exception{
		
	}
	
	@Test
	public void findAllPagedShouldReturnPage() {
		Pageable pageable = PageRequest.of(0, 15);
		Page<ImportacaoDNEDTO> result = service.findAll(pageable);
		
		Assertions.assertNotNull(result);
	}
}
