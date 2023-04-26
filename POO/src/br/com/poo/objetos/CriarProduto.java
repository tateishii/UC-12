package br.com.poo.objetos;

import br.com.poo.classes.Produto;

public class CriarProduto {

	public static void main(String[] args) {
				
		Produto prod = new Produto();
		prod.setId(10);
		prod.setNome("Sabão");
		
		
		prod.cadastrar();
		prod.listar();
		
	}

}

