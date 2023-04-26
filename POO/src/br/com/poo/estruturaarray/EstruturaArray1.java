package br.com.poo.estruturaarray;

public class EstruturaArray1 {

	private static final int i = 0;

	public static void main(String[] args) {
		
		String[] cidades= {"leme", "Campinas", "Atibaia", "Vinhedo"};
          
		System.out.println(cidades[1]);
		
				for(int i=0; i <=3; i++) {
				System.out.println(cidades[i]);
		}
	
        System.out.println(cidades.length); 
	}
	    
}

