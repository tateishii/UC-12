package br.com.poo.heranca;

public class ContaCorrente extends ContaBancaria {
	private double limite;
	private double limiteInicial;
	
    public ContaCorrente() {}
    
    public ContaCorrente(double limite) {
    	this.limite = limite;
    	limiteInicial = limite;
    	
    }
    
    
    public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public ContaCorrente(Long numeroBanco, int agencia, Long numeConta, String titular, double saldo,double limite) {
    	super.setNumeroBanco(numeroBanco);
    	super.setAgencia(agencia);
    	super.setNumeroConta(numeConta);
    	super.setTitular(titular);
    	super.setSaldo(saldo);
    	this.limite = limite;
    	limiteInicial = limite;
    }
     
    @Override
    public String sacar(double valor) {
    	String msg = "";
    	
    	if(limite+super.getSaldo() <= valor) {
    		msg = "Saldo insulficiente";
    	}
    	else if(super.getSaldo() <valor) {
    		
    		this.limite = this.limite - (valor - super.getSaldo());
    		super.setSaldo(0);
    		msg = "Saque realizado. \n Seu limite atual é"+
    		this.limite+"\nSeu saldo é 0";
    		}
    	    else {
    	    	super.setSaldo(super.getSaldo()-valor);
    	    	msg = "Saque realizado. \nSeu novo saldo é: "+super.getSaldo();
    	    }
    	    return msg;
    }
    
    @Override
    public String depositar(double valor) {
    	
    	String msg = "";
    	if (limiteInicial != limite) {
    		limite += limiteInicial - limite;
    		super.setSaldo(valor - (limiteInicial - limite));
    		msg = "Depósito realizado.\n e seu limite atual é: "
    		+super.getSaldo()+"\n e seu limite atual é "+
    				limite;
    		
    		 }
    	else {
    		super.setSaldo(super.getSaldo()+valor);
    		msg = "Depósito realizado.\nSeu saldo é: "+super.getSaldo();
    	}
    	return msg;
    	
    }
    
}
