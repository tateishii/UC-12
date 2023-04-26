package br.com.poo.estruturaswitch;

import javax.swing.JOptionPane;

public class EstruturaSwitch3 extends JOptionPane {

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null,"Ola bom dia!", "Sistema", JOptionPane.INFORMATION_MESSAGE);
		String cargo = JOptionPane.showInputDialog("Digite um cargo");
		String rs;
		switch(cargo) {
		case "Diretor":
		    rs= "R$ 20.000";
		break;
		case "Gerente":
			rs = "R$15.000";
	    break;
		case "Secretária":
		    rs = "R$ 8.000";
		break;
		case "Analista":
		    rs = "R$ 7.000";
		break;
		case "Assistente":
		    rs = "R$ 4.000";
		break;
		case "Estágiario":
		    rs = "R$ 1.500";
		break;
		default:
			rs = "Cargo inexistente ";
		
		}
		JOptionPane.showMessageDialog(null, rs, "Resposta", JOptionPane.INFORMATION_MESSAGE);
		}
}		
		