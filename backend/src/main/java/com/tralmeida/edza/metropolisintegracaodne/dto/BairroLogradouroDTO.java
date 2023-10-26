package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;

import com.tralmeida.edza.metropolisintegracaodne.entities.BairroLogradouro;

public class BairroLogradouroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer bairroogradouroId;
	private BairroDTO bairro;
	private LogradouroDTO logradouro;
	
	public BairroLogradouroDTO() {
	}
	
	public BairroLogradouroDTO(BairroLogradouro entity) {
		this.bairroogradouroId = entity.getBairroogradouroId();
		this.bairro = new BairroDTO(entity.getBairro());
		this.logradouro = new LogradouroDTO(entity.getLogradouro());
	}
	
	public BairroLogradouroDTO(Integer bairroogradouroId, BairroDTO bairro, LogradouroDTO logradouro) {
		super();
		this.bairroogradouroId = bairroogradouroId;
		this.bairro = bairro;
		this.logradouro = logradouro;
	}

	public Integer getBairroogradouroId() {
		return bairroogradouroId;
	}

	public void setBairroogradouroId(Integer bairroogradouroId) {
		this.bairroogradouroId = bairroogradouroId;
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
}
