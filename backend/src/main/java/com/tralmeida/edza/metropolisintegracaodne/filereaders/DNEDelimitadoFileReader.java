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
	
	private Long importacaoId;
	private Long totalLines;
	private Long linesRead;
	private Long importedLines;
	private Long errorLines;
	
	private String errors;
	
	public DNEDelimitadoFileReader(MultipartFile file, AddressObjectAssembler entityAssembler, Long importacaoId) {
		this.file = file;
		this.entityAssembler = entityAssembler;
		this.importacaoId = importacaoId;
	}
	
	@SuppressWarnings("unchecked")
	public void insertEntities() throws IOException{
		Scanner scanner = new Scanner(file.getInputStream(),"windows-1252");
		this.importedLines = 0L;
		this.linesRead = 0L;
		this.totalLines = 0L;
		this.errorLines = 0L;
		
		StringBuffer errorsBuffer = new StringBuffer();
		
		ImportFile importFile = detectImportFile();
		while(scanner.hasNextLine()) {
			totalLines++;
			String line = scanner.nextLine();
			Optional<?> entityOptional = Optional.empty();
			
			try {
				ArrayList<String> lineData = readLine(line);
				entityOptional = entityAssembler.toAssemble(lineData, importFile, importacaoId);
				linesRead++;
			} catch (Exception e) {
				errorLines++;
				String readingError = "Erro ao ler linha "+totalLines+": "+line;
				System.out.println(readingError);
				errorsBuffer.append(readingError).append("\n");
			}
			
			if(entityOptional.isPresent()) {
				try {
					if(entityAssembler.saveAndMerge(entityOptional.get())) {
						importedLines++;
					}
				} catch(Exception e){
					errorLines++;
					String importError = "Erro ao importar linha "+totalLines+": "+line;
					System.out.println(importError);
					errorsBuffer.append(importError).append("\n");
				}
			}
		}
		scanner.close();
		this.errors = errorsBuffer.toString();
		System.out.println("Leitura do arquivo finalizada");
	}
	
	private ArrayList<String> readLine(String line){
		System.out.println("Lendo linha: "+line);
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

	public Long getTotalLines() {
		return totalLines;
	}

	public Long getLinesRead() {
		return linesRead;
	}
	
	public Long getImportedLines() {
		return importedLines;
	}
	
	public Long getErrorLines() {
		return errorLines;
	}
	
	public String getErrors() {
		return errors;
	}
}
