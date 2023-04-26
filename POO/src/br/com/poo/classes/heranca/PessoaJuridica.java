package br.com.poo.classes.heranca;

public class PessoaJuridica extends Pessoa {
	
	private String razaoSocial;
	private String cnpj;
	
	public PessoaJuridica() {}
	
	public PessoaJuridica (String razaoSocial, String cnpj) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void getRazaoSocial (String razaoSocial) {
		this.razaoSocial = razaoSocial;
		}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void getCnpj (String cnpj) {
		this.cnpj = cnpj;
		}
		
	}

