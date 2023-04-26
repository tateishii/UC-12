package br.com.projetoescola.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoescola.domain.Sistemachamados;

public class CRUDSistemachamados extends Conexao implements CRUD<Sistemachamados>{
	
	@Override
	public String gravar(Sistemachamados obj) {
		String msg = "";
		
		try {
			abrirconexao();
			String sql= "Insert into curso(titulo,descricao,datainicio,datatermino,horarioinicio,horariotermino)values(?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			//passar os parametros para os pontos de interrogação
			pst.setString(1, obj.getNomepessoa());
			pst.setString(2, obj.getDepartamento());
			pst.setString(3, obj.getDescricao());
			pst.setDate(4, obj.getDataabertura());
			pst.setString(5, obj.getNomefuncionario());
			pst.setDate(6, obj.getDataresolução());
			
			/*
			 * Quando executamos a consulta usando o comando executeUpdate ele
			 * retorna um número que pode ser 1 ou 0(zero), sendo 1 quando o
			 * dado é inserido e 0(zero) quando o dado não é inserido
			 **/
			int i = pst.executeUpdate();
			
			if(i>0) {
				msg = "Curso cadastrado com sucesso!";
			}
			else {
				msg = "Não foi possível cadastrar";
			}
          }
          catch(SQLException se) {
        	  msg = "Erro de sql -> "+se.getMessage();
        	  }
		  catch(Exception e) {
			  msg= "Erro inesperado ->" + e.getMessage();
		  }
		finally {
			fecharConexao(); }
		return msg;
			
		}
	
		
			
		
			

	


	@Override
	public List<Sistemachamados> listar() {
     List<Sistemachamados> lstSistemachamados = new ArrayList<Sistemachamados>();
		
		try {
			abrirconexao();
			String sql = "Select *From Sistemachamados";
			//preparar a consulta para ser executada
			pst = conn.prepareStatement(sql);

			/*
			 * O comando executeQuery é utilizado para executar comandos
			 * de select.
			 * O retorno do executeQuery é um ResultSet, portante é
			 * necessário que haja uma variável do tipo ResultSet
			 * para guardar o retorno de execução. Estamos usando
			 * a variável rs que foi declarada na classe Conexao
			 */
			
			 rs = pst.executeQuery();
			 /*
				 * Enquanto houver dados na tabela de banco dados o laço continua a 
				 * buscar os dados. O comando next() do rs captura dados da tabela e
				 * adiciona em novo curso
				 */
			 while(rs.next()) {
					Sistemachamados sistemachamados = new Sistemachamados();
					
					sistemachamados.setIdchamados(rs.getLong(1));
					sistemachamados.setNomepessoa(rs.getString(2));
				    sistemachamados.setDepartamento(rs.getString(3));
					sistemachamados.setDescricao(rs.getString(4));
					sistemachamados.setDataabertura(rs.getDate(5));
					sistemachamados.setNomefuncionario(rs.getString(6));
					sistemachamados.setDataresolução(rs.getDate(7));
				
					
					//adiciona um novo sitema chamados na lista de chamados.
					lstSistemachamados.add(sistemachamados);
					
				}
				
				
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				fecharConexao();
			}
			return lstSistemachamados;
	}
	
	

	@Override
	public List<Sistemachamados> listar(Sistemachamados obj) {
		/*
		 * Vamos criar uma lista de cursos, onde sua implementação é 
		 * um array de cursos no formato de uma lista de cursos. Assim
		 * teremos linhas e colunas para os cursos
		 */
		
		List<Sistemachamados> lstSistemachamados = new ArrayList<Sistemachamados>();
		
		try {
			abrirconexao();
			
			String sql= "";
			if(obj.getIdchamados()!=null) {
				sql = "Select *From Sistemachamados WHERE idchamados="+obj.getIdchamados();
			}
			else if(obj.getNomepessoa()!=null) {
				sql = "Select *From Sistemachamados WHERE nome pessoa like%"+obj.getNomepessoa()+"%";
				}
			else if(obj.getDepartamento()!=null) {
				sql = "Select *From Sistemachamados WHERE departamento like %"+obj.getDepartamento();

			}
			else {
				sql = "Select * From Sistemachamados";
			}
				
				
				
			String SQL = "Select *From Sistemachamados";
			//preparar a consulta para ser executada
			pst = conn.prepareStatement(sql);
			
			/*
			 * O comando executeQuery é utilizado para executar comandos
			 * de select.
			 * O retorno do executeQuery é um ResultSet, portante é
			 * necessário que haja uma variável do tipo ResultSet
			 * para guardar o retorno de execução. Estamos usando
			 * a variável rs que foi declarada na classe Conexao
			 */
			rs = pst.executeQuery();
			
			/*
			 * Enquanto houver dados na tabela de banco dados o laço continua a 
			 * buscar os dados. O comando next() do rs captura dados da tabela e
			 * adiciona em novo curso
			 */
			while(rs.next()) {
				Sistemachamados sistemachamados = new Sistemachamados();
				
				sistemachamados.setNomepessoa(rs.getString(1));
				sistemachamados.setDepartamento(rs.getString(2));
				sistemachamados.setDescricao(rs.getString(3));
				sistemachamados.setDataabertura(rs.getDate(4));
				sistemachamados.setNomefuncionario(rs.getString(5));
				sistemachamados.setDataresolução(rs.getDate(6));
				
				
				//adiciona um novo curso na lista de curso.
				lstSistemachamados.add(sistemachamados);
				
			}
			
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fecharConexao();
		}
		return lstSistemachamados;
	}
	

	@Override
	public Sistemachamados atualizar(Sistemachamados obj) {
       Sistemachamados sistemachamados = new Sistemachamados();
		
		try {
			abrirconexao();
			String sql = "UPDATE chamados SET nome pessoa=?,departamento=?,descricao=?,dataabertura=?,nome funcionario=?,data resolução=? WHERE idchamados=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,obj.getNomepessoa());
			pst.setString(2,obj.getDepartamento());
			pst.setString(3,obj.getDescricao());
			pst.setDate(4,obj.getDataabertura());
			pst.setString(5,obj.getNomefuncionario());
			pst.setDate(6,obj.getDataresolução());
			pst.setLong(7,obj.getIdchamados());
			
			int i = pst.executeUpdate();
			if(i > 0) {
				sistemachamados = obj;
			}
			else {
				//exibir mensagem de erro mesmo sem retorno de String
				throw new Exception("Não foi possível atualizar");
				
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return sistemachamados;
	}
	


	@Override
	public String apagar(Sistemachamados obj) {
           String msg= "";
		
		try {
			abrirconexao();
			String sql="Delete From chamados WHERE idchamados=?";
			pst= conn.prepareStatement(sql);
			pst.setLong(1, obj.getIdchamados());
			int i = pst.executeUpdate();
			if(i>0) {
				msg= "Chamado apagado";
			}
			else {
				msg= "Não foi possível apagar o chamado ";
			}
		}
		catch(SQLException se) {
			msg= "Erro na consulta";
		}
		return msg;
	}

}
		
	
 


