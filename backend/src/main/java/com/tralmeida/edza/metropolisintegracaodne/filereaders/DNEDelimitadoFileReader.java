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
	
	private Long linesRead;
	
	public DNEDelimitadoFileReader(MultipartFile file, AddressObjectAssembler entityAssembler) {
		this.file = file;
		this.entityAssembler = entityAssembler;
	}
	
	@SuppressWarnings("unchecked")
	public Long insertEntities() throws IOException{
		Scanner scanner = new Scanner(file.getInputStream(),"windows-1252");
		Long importedLines = 0L;
		this.linesRead = 0L;
		
		ImportFile importFile = detectImportFile();
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			ArrayList<String> lineData = readLine(line);
			
			Optional<?> entityOptional = Optional.empty();
			
			try {
				entityOptional = entityAssembler.toAssemble(lineData, importFile);
				linesRead++;
			} catch (Exception e) {
				System.out.println("Erro ao ler linha: "+line);
			}
			
			if(entityOptional.isPresent()) {
				try {
					if(entityAssembler.saveAndMerge(entityOptional.get())) {
						importedLines++;
					}
				} catch(Exception e){
					System.out.println("Erro ao importar linha: "+line);
				}
			}
		}
		scanner.close();
		return importedLines;
	}
	
	private ArrayList<String> readLine(String line){
		String[] substrings = line.split("@");
		return new ArrayList<String>(List.of(substrings));
	}
	
	private ImportFile detectImportFile() {
		try {
			String fileName = file.getOriginalFilename();
			System.out.println("File name: "+fileName);
			return ImportFile.valueOf(fileName.toUpperCase().replace(".TXT",""));
		} catch(Exception e) {
			return null;
		}
	}

	public Long getLinesRead() {
		return linesRead;
	}
}
