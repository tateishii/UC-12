package br.com.poo.classes.heranca;

public class Funcionarios extends PessoaFisica {
	
	private String cargo;
	private String setor;
	
	public Funcionarios () {}
	
	public Funcionarios (String cargo, String setor) {
		this.cargo = cargo;
		this.setor = setor;
	}
	
	public String getCargo() {
	return cargo;
	
	}
	
	public void setCargo(String cargo){
		this.cargo = cargo;
	}
	
	public String getSetor() {
		return setor;
	}
	
	
	public void getSetor (String setor) {
		this.setor = setor;
	}	
}
