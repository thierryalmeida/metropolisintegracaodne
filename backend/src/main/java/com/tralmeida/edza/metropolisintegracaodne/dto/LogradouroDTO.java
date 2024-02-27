package com.tralmeida.edza.metropolisintegracaodne.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.tralmeida.edza.metropolisintegracaodne.entities.Logradouro;

public class LogradouroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long logradouroId;
	private Long codigo;
	private String nome;
	private Integer oficial;
	private Long tipoLogradouroId;
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
	private Long cep;
	private String complemento;
	private Integer migracao_codigoCorreios;
	private Timestamp dtInclusao;
	private Timestamp dtAtualizacao;
	private Integer usuarioId;
	
	private Long bairroId;
	private Long importacaoId;
	
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
	
	public LogradouroDTO(Long logradouroId, Long codigo, String nome, Integer oficial, Long tipoLogradouroId,
			Integer tituloLogradouroId, String nome_Anterior, String tpImovel, Integer logradouroFinalId,
			String nomeAnterior, String numeroDocumentoLegal, Timestamp dataDocumentoLegal, Integer limiteMetrico,
			Boolean logradouroOficial, Integer logradouroInicialId, Integer logradouroGeoId, Long cep,
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

	public Long getLogradouroId() {
		return logradouroId;
	}

	public void setLogradouroId(Long logradouroId) {
		this.logradouroId = logradouroId;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getOficial() {
		return oficial;
	}

	public void setOficial(Integer oficial) {
		this.oficial = oficial;
	}

	public Long getTipoLogradouroId() {
		return tipoLogradouroId;
	}

	public void setTipoLogradouroId(Long tipoLogradouroId) {
		this.tipoLogradouroId = tipoLogradouroId;
	}

	public Integer getTituloLogradouroId() {
		return tituloLogradouroId;
	}

	public void setTituloLogradouroId(Integer tituloLogradouroId) {
		this.tituloLogradouroId = tituloLogradouroId;
	}

	public String getNome_Anterior() {
		return nome_Anterior;
	}

	public void setNome_Anterior(String nome_Anterior) {
		this.nome_Anterior = nome_Anterior;
	}

	public String getTpImovel() {
		return tpImovel;
	}

	public void setTpImovel(String tpImovel) {
		this.tpImovel = tpImovel;
	}

	public Integer getLogradouroFinalId() {
		return logradouroFinalId;
	}

	public void setLogradouroFinalId(Integer logradouroFinalId) {
		this.logradouroFinalId = logradouroFinalId;
	}

	public String getNomeAnterior() {
		return nomeAnterior;
	}

	public void setNomeAnterior(String nomeAnterior) {
		this.nomeAnterior = nomeAnterior;
	}

	public String getNumeroDocumentoLegal() {
		return numeroDocumentoLegal;
	}

	public void setNumeroDocumentoLegal(String numeroDocumentoLegal) {
		this.numeroDocumentoLegal = numeroDocumentoLegal;
	}

	public Timestamp getDataDocumentoLegal() {
		return dataDocumentoLegal;
	}

	public void setDataDocumentoLegal(Timestamp dataDocumentoLegal) {
		this.dataDocumentoLegal = dataDocumentoLegal;
	}

	public Integer getLimiteMetrico() {
		return limiteMetrico;
	}

	public void setLimiteMetrico(Integer limiteMetrico) {
		this.limiteMetrico = limiteMetrico;
	}

	public Boolean getLogradouroOficial() {
		return logradouroOficial;
	}

	public void setLogradouroOficial(Boolean logradouroOficial) {
		this.logradouroOficial = logradouroOficial;
	}

	public Integer getLogradouroInicialId() {
		return logradouroInicialId;
	}

	public void setLogradouroInicialId(Integer logradouroInicialId) {
		this.logradouroInicialId = logradouroInicialId;
	}

	public Integer getLogradouroGeoId() {
		return logradouroGeoId;
	}

	public void setLogradouroGeoId(Integer logradouroGeoId) {
		this.logradouroGeoId = logradouroGeoId;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getMigracao_codigoCorreios() {
		return migracao_codigoCorreios;
	}

	public void setMigracao_codigoCorreios(Integer migracao_codigoCorreios) {
		this.migracao_codigoCorreios = migracao_codigoCorreios;
	}

	public Timestamp getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Timestamp dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public Timestamp getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Timestamp dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public MunicipioDTO getMunicipioDTO() {
		return municipio;
	}

	public void setMunicipioDTO(MunicipioDTO municipio) {
		this.municipio = municipio;
	}

	public Long getBairroId() {
		return bairroId;
	}

	public void setBairroId(Long bairroId) {
		this.bairroId = bairroId;
	}

	public Long getImportacaoId() {
		return importacaoId;
	}

	public void setImportacaoId(Long importacaoId) {
		this.importacaoId = importacaoId;
	}
}
