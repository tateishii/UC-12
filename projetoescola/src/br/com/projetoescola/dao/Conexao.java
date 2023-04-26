package br.com.projetoescola.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A classe Conexao é destinada a abrir  conexao com o banco de dados<br>
 * Nesta classe você encontrará os seguinte métodos:<br>
 * <ul>
 * <lib><b>abrirConexao:</b> Abre a conexão com o banco escoladv</li>
 * <li><b>fecharConexao:</b> Fecha a conexão com o banco escoladb</li>
 * </ul>
 * @author Diego Gomes
 * 
 *
 */
public abstract class Conexao {
	
	/*
	 * As propriedades(Atributos) da classe Conexao foram setados como
	 * protected, pois haverá um processo de herança desta classe e assim
	 * será possível passar os dados para as subclasses(classes filhas).
	 * O comando Connection é uma classe que permite establecer a
	 * conexão com o banco de dados.Foi setado para esta classe a variável
	 * conn com o valor inicial nulo. Assim ela começa com algo e depois
	 * será instânciada.
	 * Já o comando PreparedStatement é utilizado para executar os 
	 * comandos de SQL, tais como: Insert, Update, Select, Delete, dentre
	 * outras. A variável do prepared foi criada como pst e seu valor
	 * inicial é null.
	 * O comando ResultSet é destinado a guardar os resultados do 
	 * comando Select do mysql. A variável rs foi inicializada com o valor null.
	 */
	
	protected Connection conn = null;
	protected PreparedStatement pst = null;
	protected ResultSet rs = null;
	
	/**
	 * O método <b>abrirConexao</b> abre a conexão com o banco de dados
	 * escoladb que está no servidor MySQL, que sua vez está no
	 * container(docker).
	 */
	
    public void abrirconexao() {
    	/*
    	 * Os comandos try(tentar) ... catch(capturar), são utilizados
    	 * para realizar o tratamento de erros, onde o try, você tenta
    	 * executar algo e caso dê erro o comando catch, captura
    	 * automaticamente o erro e o trata de acordo com o comando
    	 * printStackTrace, exibindo a pilha(Stack) de erros
    	 */
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    		/*
    		 * Na lnha abaixo é passado para o comando getConnection a
    		 * url de conexao com o banco de dados(ip,porta,banco de dados),
    		 * o usuário e a senha. TimeZone foi definido como true
    		 */
    		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:6556/escoladb","root","senac@123");
    		}
    	catch(SQLException se) {
    		se.printStackTrace();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	
    }
}
public void fecharConexao() {
	try {
		conn.close();
	}
	catch(Exception se) {
		se.printStackTrace();
	}
	}
}