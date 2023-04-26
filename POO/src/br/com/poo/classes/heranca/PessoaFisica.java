package br.com.poo.classes.heranca;

public abstract class PessoaFisica extends Pessoa {
	private String nome;
	private String cpf;
	
	public PessoaFisica() {
		
	}
	
	public String getNome() {
		return nome;
	
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void getCpf (String cpf) {
		this.cpf = cpf;
	}

}
