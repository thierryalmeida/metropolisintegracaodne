package com.tralmeida.edza.metropolisintegracaodne.filereaders;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.tralmeida.edza.metropolisintegracaodne.entityassemblers.AddressObjectAssembler;
import com.tralmeida.edza.metropolisintegracaodne.enums.ImportFile;

@SuppressWarnings("rawtypes")
public class DNEDelimitadoFileReader {
	
	private MultipartFile file;
	
	@Autowired
	private AddressObjectAssembler entityAssembler;
	
	public DNEDelimitadoFileReader(MultipartFile file, AddressObjectAssembler entityAssembler) {
		this.file = file;
		this.entityAssembler = entityAssembler;
	}
	
	@SuppressWarnings("unchecked")
	public void insertEntities() throws IOException{
		Scanner scanner = new Scanner(file.getInputStream(),"windows-1252");
		
		ImportFile importFile = detectImportFile();
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			ArrayList<String> lineData = readLine(line);
			
			Optional<?> entityOptional = entityAssembler.toAssemble(lineData, importFile);
			
			if(entityOptional.isPresent()) {
				entityAssembler.saveAndMerge(entityOptional.get());
			}
		}
		scanner.close();
	}
	
	private ArrayList<String> readLine(String line){
		String[] substrings = line.split("@");
		return new ArrayList<String>(List.of(substrings));
	}
	
	private ImportFile detectImportFile() {
		try {
			return ImportFile.valueOf(file.getOriginalFilename().toUpperCase().replace(".TXT",""));
		} catch(Exception e) {
			return null;
		}
	}
}
