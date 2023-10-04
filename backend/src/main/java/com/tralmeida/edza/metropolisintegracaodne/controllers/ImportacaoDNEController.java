package com.tralmeida.edza.metropolisintegracaodne.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tralmeida.edza.metropolisintegracaodne.entities.ImportacaoDNE;
import com.tralmeida.edza.metropolisintegracaodne.entities.TabelaImportacao;

@RestController
@RequestMapping(value = "/importar")
public class ImportacaoDNEController {
	
	@GetMapping
	public ResponseEntity<List <ImportacaoDNE>> findAll(){
		List<ImportacaoDNE> imports = new ArrayList<>();
		imports.add(new ImportacaoDNE(1L, "Importacao de Teste", new Timestamp(System.currentTimeMillis()), new TabelaImportacao(1L, "cg_pais", null)));
		return ResponseEntity.ok(imports);
	}
	
	@PostMapping
	public ResponseEntity<ImportacaoDNE> importFromFile(@RequestParam("file") MultipartFile file){
		/*
		 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();
         
        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);
         
        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + filecode);
         
        return new ResponseEntity<>(response, HttpStatus.OK);
        */
		return ResponseEntity.created(null).body(null);
	}
}
