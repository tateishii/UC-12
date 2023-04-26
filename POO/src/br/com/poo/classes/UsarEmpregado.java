package br.com.poo.classes;

public class UsarEmpregado {
	
	public static void main(String[]args) {
		
		Empregado wagner = new Empregado();
		
		System.out.println(wagner.salvar());
		wagner.mensagem("Olá Wagner");
		
		Setor vendas = new Setor();
		System.out.println(vendas.salvar());
		
		vendas.mensagem("Novo setor para a empresa");
		
	}

}
