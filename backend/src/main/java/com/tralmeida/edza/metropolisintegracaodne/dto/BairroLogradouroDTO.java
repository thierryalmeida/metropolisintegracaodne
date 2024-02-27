package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;

import com.tralmeida.edza.metropolisintegracaodne.entities.BairroLogradouro;

public class BairroLogradouroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long bairroLogradouroId;
	private BairroDTO bairro;
	private LogradouroDTO logradouro;
	
	private Long importacaoId;
	
	public BairroLogradouroDTO() {
	}
	
	public BairroLogradouroDTO(BairroLogradouro entity) {
		this.bairroLogradouroId = entity.getBairroLogradouroId();
		this.bairro = new BairroDTO(entity.getBairro());
		this.logradouro = new LogradouroDTO(entity.getLogradouro());
	}
	
	public BairroLogradouroDTO(Long bairroLogradouroId, BairroDTO bairro, LogradouroDTO logradouro) {
		super();
		this.bairroLogradouroId = bairroLogradouroId;
		this.bairro = bairro;
		this.logradouro = logradouro;
	}

	public Long getBairroLogradouroId() {
		return bairroLogradouroId;
	}

	public void setBairroogradouroId(Long bairroLogradouroId) {
		this.bairroLogradouroId = bairroLogradouroId;
	}

	public BairroDTO getBairro() {
		return bairro;
	}

	public void setBairro(BairroDTO bairro) {
		this.bairro = bairro;
	}

	public LogradouroDTO getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(LogradouroDTO logradouro) {
		this.logradouro = logradouro;
	}

	public Long getImportacaoId() {
		return importacaoId;
	}

	public void setImportacaoId(Long importacaoId) {
		this.importacaoId = importacaoId;
	}
}
