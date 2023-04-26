package br.com.poo.estruturaif1;

import java.util.Scanner;

public class Estruturaif1{
	public static void main(String args[]) {
		System.out.println("============ Valor Par ou Impar ============");
		System.out.println("\nEntre com um  valor númerico:");
		//declaração da variável númerica 
		int numero;
		//Permite a entrada de dados via teclado pelo terminal
		Scanner entrada = new Scanner(System.in);
		numero = entrada.nextInt();
		
		//vamos testar se o número digitado é par ou ímpar
		if(numero % 2 == 0) {
			System.out.println("O número: "+numero+" é Par");
					
		}
		else { 
			System.out.println("O número: "+numero+" é Impar");
		}
	}
}