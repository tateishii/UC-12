package br.com.poo.estruturaif;

import java.util.Scanner;

public class EstruturaIf1 {

	public static void main(String[] args) {
		
		System.out.println("================= Valor Par ou Ímpar ================= ");
		System.out.println("\nEntre com um valor numérico: ");
		
		//Declaação da variável numérica
		
		int numero;
		
		//System.in permite a entrada de dados via teclado pelo terminal
		Scanner entrada = new Scanner(System.in);
		numero = entrada.nextInt();
		
		
		//Vamos testar se o número digitado é par ou ímpar
		if(numero % 2 == 0) {
			System.out.println("O número: " + numero + " é PAR!");
		}
		else {
			System.out.println("O número: " + numero + " é ÍMPAR!");
		}
	}

}
