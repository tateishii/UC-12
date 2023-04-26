package br.com.poo.objetos;

import java.io.BufferedReader;

/*
 * Este arquivo de java realizar um acesso remoto via ssh em um servidor linux(Fedora Server)
 * Para realizar esta operação foi necessário a utilização de uma bibliotec chamada,
 * jsch(Java Security Channel). Esta biblioteca foi baixada pelo site: http://www.jcraft.com/jsch/
 * */

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class AcessoSSH {
	
	/*
	 * Para o acesso a máquina remota(linux) foi definido como
	 * constante os seguintes abaixo
	 * 
	 **/
    private static final String REMOTE_HOST = "127.0.0.1";
	private static final String REMOTE_USER = "senac";
	private static final String REMOTE_PASSWORD = "senac@123";
	private static final int REMOTE_PORT = 2222;
	/*
	 * Para a sessão e o canal(channel) foi definido um tempo de execução de
	 * 10000 milisegundos, ou seja, 10 segundos
	 **/
	private static final int SESSION_TIMEOUT = 10000;
	private static final int CHANNEL_TIMEOUT = 10000;
	
	public static void main(String[] args) {
		
		//O comando que será executado remotaneamente no servidor.
		String comando = "python3 /home/senac/Python/populacao.py";
		
		//Tipando a variável sessao para abrir a sessão ssh com o servidor linux
		Session sessao = null;
		try {
			/*
			 * Criação do objeto config para criar as configurações de acesso ao
			 * servidor
			 */
			Properties config = new Properties();
			
			//Foi setada a configuração restrita para checagem da chave de ciptografia com o no(não)
			//isso faz com que não haja a verificação da chave de ciptografia
			//muito usado quando não se tem a chave.
			config.put("StrictHostKeyChecking", "no");
			
			//Criando o objeto Jsch(Java Security channel)
			JSch jsch = new JSch();
			
			//Setar o arquivo que contém a chave de ciptografia para acesso SSH.
			jsch.setKnownHosts("/home/senac/.ssh/nome_arquivo_chave");
			
			//Comando para abrir a sessão remota com o servidor linux. Foram passados:
			// Nome Usuário, Ip do Servidor e porta de comunicação nesta ordem
			sessao = jsch.getSession(REMOTE_USER, REMOTE_HOST,REMOTE_PORT);
			
			//Setando a senha do servidor remoto
        	sessao.setPassword(REMOTE_PASSWORD);
        	
        	//Foi setado a configuração para a sessao não verificar a existência da chave
        	//de acesso.
			sessao.setConfig(config);
			
			//Passando o tempo de execução da sessão
			sessao.connect(SESSION_TIMEOUT);
			
			/*
			 * Criando o elemento que representa o cananl de execução de comandos. O comando
			 * sessao.openChannel, nos diz que quando a sessão for aberta também será aberto um
			 * canal para passagem dos comandos que serão executados(exec) no servidor
			 * remoto 
			 **/
			ChannelExec channelExec = (ChannelExec) sessao.openChannel("exec");
			
			/*
			 * O comando channel.Exec.setCommand aponta o comando que deve ser executado no servidor
			 * remoto. Este comando foi definido na declaraçaõ de variável String comando.
			 **/
			
			channelExec.setCommand(comando);
			
			/*
			 * Quando há algum erro inesperado na execuçãi do channelExec será exibido no sysout
			 **/
	
			channelExec.setErrStream(System.err);
			
			/*
			 * O comando InputStream realiza uma entrada de dados por meio do canal criado. Também permite
			 * obter os dados que estão entrando no canal como comando getInputStream()
			 **/
			
			InputStream in = channelExec.getInputStream();

			/*
			 * Estabelece a conexão com o canal e passa o tempo em que o canal fica aberto para a passagem
			 * de dados.
			 **/
			channelExec.connect(CHANNEL_TIMEOUT);
			
			
			/*
			 * Os dados serão passados e recebido por bytes e não diretamente com Strings ou Números(inteiros,reais)
			 * para que esta ação seja feita, criamos uma array de bytes para realizar a transação
			 **/
			
			byte[] tmp = new byte[1024];
			
			/*
			 * Enquanto for possível executar ao laço(while(true)) ele deve
			 * verificar se há dados em in, portanto temos o comando in.variable(disponível) se é
			 * maior que 0. Sendo positivo ele deve executar todas as linhas disponíveis que retornaram.
			 * Se o retorno de dados resultou em mais linhas maiores que 0(zero), esta linhas deveram
			 * ser apresentadas no terminal. O uso do comando new String(tmp,0,i) faz a conversão de bytes
			 * que estão vindo como resposta e a variável i conta a quantidade de linhas que retorna
			 **/
			
			while(true) {
				while(in.available()>0) {
					int i = in.read(tmp,0,1024);
					if( i < 0 ) break;
					System.out.println(new String(tmp,0,i));
				}
				
				/*
				 * Se o canal estiver fechado, mas mesmo assim tiver dados em in, o laço deve continuar,
				 * ou seja, volta ao inicio e executa tudo outra vez
				 * Caso não haja mais nada a ser exibido em tela, o canal é fechado e é exibida a mensagem
				 * de canal fechado
				 **/
				
				if(channelExec.isClosed()) {
					if(in.available() > 0) continue;
					System.out.println("Saída do processo - Encerrado "
										+channelExec.getExitStatus());
					break;
				}
				try {
					//Demora 1 segundo e repete o laço outra vez até o canal ser desconectado
					Thread.sleep(1000);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			channelExec.disconnect();//Desconectar o canal
			
			Process pr = Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application//chrome.exe http://127.0.0.1:5500/grafico.html");
			BufferedReader leitor = new BufferedReader(new InputStreamReader(pr.getInputStream()));

		}
			catch(JSchException jsex) {
				jsex.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		finally {
			if(sessao != null) {
				sessao.disconnect();//desconectar o canal
			}
				
		}
		
	}

}

