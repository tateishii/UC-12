package br.com.projetoescola.domain;

import java.sql.Date;

public class Sistemachamados {
	
	private Long idchamados;
	private String nomepessoa;
	private String departamento;
	private String descricao;
	private Date dataabertura;
	private Date dataresolução;
	private String nomefuncionario;
	
	public Sistemachamados() {
		this.idchamados = idchamados;
		this.nomepessoa = nomepessoa;
		this.departamento = departamento;
		this.descricao = descricao;
		this.dataabertura = dataabertura;
		this.dataresolução = dataresolução;
		this.nomefuncionario = nomefuncionario;
	}
	public Long getIdchamados() {
		return idchamados;
	}
	public void setIdchamados(Long idchamados) {
		this.idchamados = idchamados;
	}
	public String getNomepessoa() {
		return nomepessoa;
	}
	public void setNomepessoa(String nomepessoa) {
		this.nomepessoa = nomepessoa;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataabertura() {
		return dataabertura;
	}
	public void setDataabertura(Date dataabertura) {
		this.dataabertura = dataabertura;
	}
	public Date getDataresolução() {
		return dataresolução;
	}
	public void setDataresolução(Date dataresolução) {
		this.dataresolução = dataresolução;
	}
	public String getNomefuncionario() {
		return nomefuncionario;
	}
	public void setNomefuncionario(String nomefuncionario) {
		this.nomefuncionario = nomefuncionario;
	}

		
	}
	
	
	
	


