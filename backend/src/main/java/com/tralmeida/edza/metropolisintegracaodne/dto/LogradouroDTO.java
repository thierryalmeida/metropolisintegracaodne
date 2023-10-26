package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.tralmeida.edza.metropolisintegracaodne.entities.Logradouro;

public class LogradouroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer logradouroId;
	private Integer codigo;
	private String nome;
	private Integer oficial;
	private Integer tipoLogradouroId;
	private Integer tituloLogradouroId;
	private String nome_Anterior;
	private String tpImovel;
	private Integer logradouroFinalId;
	private String nomeAnterior;
	private String numeroDocumentoLegal;
	private Timestamp dataDocumentoLegal;
	private Integer limiteMetrico;
	private Boolean logradouroOficial;
	private Integer logradouroInicialId;
	private Integer logradouroGeoId;
	private String cep;
	private String complemento;
	private Integer migracao_codigoCorreios;
	private Timestamp dtInclusao;
	private Timestamp dtAtualizacao;
	private Integer usuarioId;
	
	private MunicipioDTO municipio;
	
	public LogradouroDTO() {
	}
	
	public LogradouroDTO(Logradouro entity) {
		super();
		this.logradouroId = entity.getLogradouroId();
		this.codigo = entity.getCodigo();
		this.nome = entity.getNome();
		this.oficial = entity.getOficial();
		this.tipoLogradouroId = entity.getTipoLogradouroId();
		this.tituloLogradouroId = entity.getTituloLogradouroId();
		this.nome_Anterior = entity.getNome_Anterior();
		this.tpImovel = entity.getTpImovel();
		this.logradouroFinalId = entity.getLogradouroFinalId();
		this.nomeAnterior = entity.getNomeAnterior();
		this.numeroDocumentoLegal = entity.getNumeroDocumentoLegal();
		this.dataDocumentoLegal = entity.getDataDocumentoLegal();
		this.limiteMetrico = entity.getLimiteMetrico();
		this.logradouroOficial = entity.getLogradouroOficial();
		this.logradouroInicialId = entity.getLogradouroInicialId();
		this.logradouroGeoId = entity.getLogradouroGeoId();
		this.cep = entity.getCep();
		this.complemento = entity.getComplemento();
		this.migracao_codigoCorreios = entity.getMigracao_codigoCorreios();
		this.dtInclusao = entity.getDtInclusao();
		this.dtAtualizacao = entity.getDtAtualizacao();
		this.usuarioId = entity.getUsuarioId();
		this.municipio = new MunicipioDTO(entity.getMunicipio());
	}
	
	public LogradouroDTO(Integer logradouroId, Integer codigo, String nome, Integer oficial, Integer tipoLogradouroId,
			Integer tituloLogradouroId, String nome_Anterior, String tpImovel, Integer logradouroFinalId,
			String nomeAnterior, String numeroDocumentoLegal, Timestamp dataDocumentoLegal, Integer limiteMetrico,
			Boolean logradouroOficial, Integer logradouroInicialId, Integer logradouroGeoId, String cep,
			String complemento, Integer migracao_codigoCorreios, Timestamp dtInclusao, Timestamp dtAtualizacao,
			Integer usuarioId, MunicipioDTO municipio) {
		super();
		this.logradouroId = logradouroId;
		this.codigo = codigo;
		this.nome = nome;
		this.oficial = oficial;
		this.tipoLogradouroId = tipoLogradouroId;
		this.tituloLogradouroId = tituloLogradouroId;
		this.nome_Anterior = nome_Anterior;
		this.tpImovel = tpImovel;
		this.logradouroFinalId = logradouroFinalId;
		this.nomeAnterior = nomeAnterior;
		this.numeroDocumentoLegal = numeroDocumentoLegal;
		this.dataDocumentoLegal = dataDocumentoLegal;
		this.limiteMetrico = limiteMetrico;
		this.logradouroOficial = logradouroOficial;
		this.logradouroInicialId = logradouroInicialId;
		this.logradouroGeoId = logradouroGeoId;
		this.cep = cep;
		this.complemento = complemento;
		this.migracao_codigoCorreios = migracao_codigoCorreios;
		this.dtInclusao = dtInclusao;
		this.dtAtualizacao = dtAtualizacao;
		this.usuarioId = usuarioId;
		this.municipio = municipio;
	}

}
