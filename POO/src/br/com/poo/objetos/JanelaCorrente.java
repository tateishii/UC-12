package br.com.poo.objetos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.heranca.ContaCorrente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class JanelaCorrente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroBanco;
	private JTextField txtAgencia;
	private JTextField txtNumeroConta;
	private JTextField txtTitular;
	private JTextField txtSaldo;
	private JTextField txtLimite;
	private ContaCorrente corrente;
	private JTextArea txtResultado;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public JanelaCorrente() {
		
		corrente = new ContaCorrente();
		
		setResizable(false);
		setTitle("Janela Conta Corrente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1010, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(35, 35, 35));
		pnlMenu.setBounds(0, 0, 200, 579);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		JLabel lblOperacoes = new JLabel("Operações");
		lblOperacoes.setIcon(new ImageIcon(JanelaCorrente.class.getResource("/br/com/poo/images/logobanco.png")));
		lblOperacoes.setForeground(new Color(255, 255, 255));
		lblOperacoes.setFont(new Font("Arial", Font.PLAIN, 20));
		lblOperacoes.setBounds(10, 11, 163, 33);
		pnlMenu.add(lblOperacoes);
		
		JLabel lblAbrirConta = new JLabel("Abrir Conta");
		
		lblAbrirConta.setIcon(new ImageIcon(JanelaCorrente.class.getResource("/br/com/poo/images/logo abrir conta.png")));
		lblAbrirConta.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAbrirConta.setForeground(new Color(255, 255, 255));
		lblAbrirConta.setBounds(10, 67, 142, 33);
		pnlMenu.add(lblAbrirConta);
		
		JLabel lbLVerificarSaldo = new JLabel("Verificar Saldo");
		
		lbLVerificarSaldo.setEnabled(false);
		lbLVerificarSaldo.setIcon(new ImageIcon(JanelaCorrente.class.getResource("/br/com/poo/images/logo verificar saldo.png")));
		lbLVerificarSaldo.setFont(new Font("Arial", Font.PLAIN, 16));
		lbLVerificarSaldo.setForeground(new Color(255, 255, 255));
		lbLVerificarSaldo.setBounds(10, 106, 163, 21);
		pnlMenu.add(lbLVerificarSaldo);
		
		JLabel lblDepositar = new JLabel("Depositar");
		
		lblDepositar.setEnabled(false);
		lblDepositar.setIcon(new ImageIcon(JanelaCorrente.class.getResource("/br/com/poo/images/logo  depositar e sacar.png")));
		lblDepositar.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDepositar.setForeground(new Color(255, 255, 255));
		lblDepositar.setBounds(10, 148, 113, 33);
		pnlMenu.add(lblDepositar);
		
		JLabel lblSacar = new JLabel("Sacar");
		lblSacar.setEnabled(false);
		lblSacar.setIcon(new ImageIcon(JanelaCorrente.class.getResource("/br/com/poo/images/logo  depositar e sacar.png")));
		lblSacar.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSacar.setForeground(new Color(255, 255, 255));
		lblSacar.setBounds(10, 184, 113, 33);
		pnlMenu.add(lblSacar);
		
		JLabel lblAbelFerreira = new JLabel("Abel Ferreira");
		lblAbelFerreira.setIcon(new ImageIcon(JanelaCorrente.class.getResource("/br/com/poo/images/Abel Ferreira.png")));
		lblAbelFerreira.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAbelFerreira.setForeground(new Color(0, 128, 0));
		lblAbelFerreira.setBounds(28, 527, 145, 41);
		pnlMenu.add(lblAbelFerreira);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(210, 11, 290, 559);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNumeroBanco = new JLabel("Número Banco");
		lblNumeroBanco.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNumeroBanco.setBounds(10, 11, 134, 28);
		panel.add(lblNumeroBanco);
		
		txtNumeroBanco = new JTextField();
		txtNumeroBanco.setBounds(10, 50, 270, 37);
		panel.add(txtNumeroBanco);
		txtNumeroBanco.setColumns(10);
		
		JLabel lblAgencia = new JLabel("Agência");
		lblAgencia.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAgencia.setBounds(10, 111, 134, 28);
		panel.add(lblAgencia);
		
		txtAgencia = new JTextField();
		txtAgencia.setColumns(10);
		txtAgencia.setBounds(10, 150, 270, 37);
		panel.add(txtAgencia);
		
		JLabel lblNumeroConta = new JLabel("Número da Conta");
		lblNumeroConta.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNumeroConta.setBounds(10, 209, 134, 28);
		panel.add(lblNumeroConta);
		
		txtNumeroConta = new JTextField();
		txtNumeroConta.setColumns(10);
		txtNumeroConta.setBounds(10, 248, 270, 37);
		panel.add(txtNumeroConta);
		
		JLabel lblTitular = new JLabel("Titular");
		lblTitular.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTitular.setBounds(10, 296, 134, 28);
		panel.add(lblTitular);
		
		txtTitular = new JTextField();
		txtTitular.setColumns(10);
		txtTitular.setBounds(10, 335, 270, 37);
		panel.add(txtTitular);
		
		JLabel lblVerificarSaldo = new JLabel("Saldo");
		lblVerificarSaldo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblVerificarSaldo.setBounds(10, 382, 134, 28);
		panel.add(lblVerificarSaldo);
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(10, 421, 270, 37);
		panel.add(txtSaldo);
		
		JLabel lblLimite = new JLabel("Limite");
		lblLimite.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLimite.setBounds(10, 469, 134, 28);
		panel.add(lblLimite);
		
		txtLimite = new JTextField();
		txtLimite.setColumns(10);
		txtLimite.setBounds(10, 508, 270, 37);
		panel.add(txtLimite);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(508, 11, 476, 559);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		//Comandos para os botoes
		lblAbrirConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (
						txtNumeroBanco.getText().trim().equals("") ||
				        txtAgencia.getText().trim().equals("") ||
		                txtNumeroConta.getText().trim().equals("") ||
                        txtTitular.getText().trim().equals("") ||
                        txtSaldo.getText().trim().equals("") ||
                        txtLimite.getText().trim().equals("")) {
                      JOptionPane.showMessageDialog(null,
                    		  "Os campos devem sepreenchidos",
                    		  "Erro",JOptionPane.ERROR_MESSAGE);
                        }
                        
                        
			
			
                        else {
                        	
                        	corrente.setNumeroBanco(Long.parseLong(txtNumeroBanco.getText()));
                        	corrente.setAgencia(Integer.parseInt(txtAgencia.getText()));
                        	corrente.setNumeroConta(Long.parseLong(txtNumeroConta.getText()));
                        	corrente.setTitular(txtTitular.getText());
                        	corrente.setSaldo(Long.parseLong(txtSaldo.getText()));
                        	corrente.setLimite(Long.parseLong(txtLimite.getText()));
                        	
                        	//habilitar os botões de saque, saldo e deposito
                        	lblVerificarSaldo.setEnabled(true);
                        	lblSacar.setEnabled(true);
                        	lblDepositar.setEnabled(true);
                        	
                        	//desabilitar as caixas com os dados da conta
                        	txtNumeroBanco.setEnabled(false);
                        	txtNumeroConta.setEnabled(false);
                        	txtAgencia.setEnabled(false);
                        	txtTitular.setEnabled(false);
                        	txtSaldo.setEnabled(false);
                        	txtLimite.setEnabled(false);
                        	txtResultado.setText("A conta foi aberta com sucesso");


                        	
                        }
				
			}
		});
		
		
		
		
		lbLVerificarSaldo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtResultado.setText(txtResultado.getText()+"\n"+corrente.verificarSaldo());
			}
		});
		
		
		lblDepositar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String valor = JOptionPane.showInputDialog("Digite o valor do depósito");
				txtResultado.setText(txtResultado.getText()+"\n\n"+corrente.depositar(Double.parseDouble(valor)));
				
			}
		});
		
		lblSacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String valor = JOptionPane.showInputDialog("Digite o valor do depósito");
				txtResultado.setText(txtResultado.getText()+"\n\n"+corrente.sacar(Double.parseDouble(valor)));
				
			}
		});
	}
}
