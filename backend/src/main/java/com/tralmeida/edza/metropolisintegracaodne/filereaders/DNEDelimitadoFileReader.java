package com.tralmeida.edza.metropolisintegracaodne.filereaders;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.tralmeida.edza.metropolisintegracaodne.entities.Pais;
import com.tralmeida.edza.metropolisintegracaodne.entityassemblers.AddressObjectAssembler;

@SuppressWarnings("rawtypes")
public class DNEDelimitadoFileReader {
	
	private InputStream fileInputStream;
	
	@Autowired
	private AddressObjectAssembler entityAssembler;
	
	public DNEDelimitadoFileReader(InputStream fileInputStream, AddressObjectAssembler entityAssembler) {
		this.fileInputStream = fileInputStream;
		this.entityAssembler = entityAssembler;
	}
	
	@SuppressWarnings("unchecked")
	public void insertEntities(){
		Scanner scanner = new Scanner(fileInputStream,"windows-1252");
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			ArrayList<String> lineData = readLine(line);
			
			Optional<?> entityOptional = entityAssembler.toAssemble(lineData);
			
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
	
}
