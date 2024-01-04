package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;

import com.tralmeida.edza.metropolisintegracaodne.entities.Bairro;

public class BairroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long bairroId;
	
	private String nome;
	private String cep;
	private String oficial;
	private String tpImovel;
	private String grupoBairro;
	private String tipo;
	private String cepInicial;
	private String cepFinal;
	
	private MunicipioDTO municipio;
	
	public BairroDTO() {
	}
	
	public BairroDTO(Bairro entity) {
		super();
		this.bairroId = entity.getBairroId();
		this.nome = entity.getNome();
		this.cep = entity.getCep();
		this.oficial = entity.getOficial();
		this.tpImovel = entity.getTpImovel();
		this.grupoBairro = entity.getGrupoBairro();
		this.tipo = entity.getTipo();
		this.cepInicial = entity.getCepInicial();
		this.cepFinal = entity.getCepFinal();
		this.municipio = new MunicipioDTO(entity.getMunicipio());
	}
	
	public BairroDTO(Long bairroId, String nome, String cep, String oficial, String tpImovel, String grupoBairro,
			String tipo, String cepInicial, String cepFinal, MunicipioDTO municipio) {
		super();
		this.bairroId = bairroId;
		this.nome = nome;
		this.cep = cep;
		this.oficial = oficial;
		this.tpImovel = tpImovel;
		this.grupoBairro = grupoBairro;
		this.tipo = tipo;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
		this.municipio = municipio;
	}

	public Long getBairroId() {
		return bairroId;
	}

	public void setBairroId(Long bairroId) {
		this.bairroId = bairroId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getOficial() {
		return oficial;
	}

	public void setOficial(String oficial) {
		this.oficial = oficial;
	}

	public String getTpImovel() {
		return tpImovel;
	}

	public void setTpImovel(String tpImovel) {
		this.tpImovel = tpImovel;
	}

	public String getGrupoBairro() {
		return grupoBairro;
	}

	public void setGrupoBairro(String grupoBairro) {
		this.grupoBairro = grupoBairro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCepInicial() {
		return cepInicial;
	}

	public void setCepInicial(String cepInicial) {
		this.cepInicial = cepInicial;
	}

	public String getCepFinal() {
		return cepFinal;
	}

	public void setCepFinal(String cepFinal) {
		this.cepFinal = cepFinal;
	}

	public MunicipioDTO getMunicipioDTO() {
		return municipio;
	}

	public void setMunicipioDTO(MunicipioDTO municipio) {
		this.municipio = municipio;
	}
}
