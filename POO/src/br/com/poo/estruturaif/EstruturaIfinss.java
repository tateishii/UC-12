package br.com.poo.estruturaif;

import java.util.Scanner;

public class EstruturaIfinss {

	public static void main(String[] args) {
	    double salario;
	    Scanner entrada = new Scanner(System.in);
	    
	    System.out.println("Digite o seu salário:");
	    salario= entrada.nextDouble();
	    
	    if(salario <= 1302 ) {
	    
	     System.out.println("\nReceberá:"+(salario*7.5)/100);
	    }
	     else if (salario <= 2571.29) {
	    	
		     System.out.println("\nReceberá:" +(salario*9)/100);
	     }
	     else if (salario <=3856.94) {
	    	 System.out.println("\nReceberá:" +(salario*12)/100);
	     }
	     else if (salario <=7507.49) {
	    	 System.out.println("\nReceberá:" +(salario*14)/100);
	     }
	    
	     else {
	    	 System.out.println("\nValor digitado não existe");
	     }
	}

}
