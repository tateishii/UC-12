package br.com.poo.objetos;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.poo.heranca.ContaPoupanca;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPoupanca extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroBanco;
	private JTextField txtAgencia;
	private JTextField txtNumeroConta;
	private JTextField txtTitular;
	private JTextField txtSaldo;
	private JTextField txtRendimento;
	private JTextField txtValor;
	private JButton btnVerificarSaldo;
	private ContaPoupanca cp;
	private JButton btnDepositar;
	private JButton btnSacar;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public JanelaPoupanca() {
		
		cp = new ContaPoupanca();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 528, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, cp.depositar(Double.parseDouble(txtValor.getText())));
			}
		});
		btnDepositar.setBounds(209, 237, 89, 23);
		contentPane.add(btnDepositar);
		
		btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, cp.sacar(Double.parseDouble(txtValor.getText())));
			}
		});
		btnSacar.setBounds(387, 237, 89, 23);
		contentPane.add(btnSacar);
		
		JLabel lblNumerodoBanco = new JLabel("Número do Banco:");
		lblNumerodoBanco.setBounds(10, 11, 113, 23);
		contentPane.add(lblNumerodoBanco);
		
		txtNumeroBanco = new JTextField();
		txtNumeroBanco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
		
				if(txtNumeroBanco.getText().equals("") || txtNumeroBanco.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,"Número banco obrigatório");
					txtNumeroBanco.setFocusable(true);
					txtNumeroBanco.requestFocus();
				}
			}
		});
		txtNumeroBanco.setBounds(10, 45, 86, 20);
		contentPane.add(txtNumeroBanco);
		txtNumeroBanco.setColumns(10);
		
		JLabel lblAgencia = new JLabel("Agência:");
		lblAgencia.setBounds(10, 76, 101, 23);
		contentPane.add(lblAgencia);
		
		txtAgencia = new JTextField();
		txtAgencia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAgencia.getText().equals("") || txtAgencia.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,"Número Agência obrigatório");
					txtAgencia.setFocusable(true);
					txtAgencia.requestFocus();
				}
			}
		});
		txtAgencia.setColumns(10);
		txtAgencia.setBounds(10, 110, 113, 20);
		contentPane.add(txtAgencia);
		
		JLabel lblConta = new JLabel("Conta:");
		lblConta.setBounds(139, 11, 101, 23);
		contentPane.add(lblConta);
		
		txtNumeroConta = new JTextField();
		txtNumeroConta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNumeroConta.getText().equals("") || txtNumeroConta.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,"Número Conta obrigatório");
					txtNumeroConta.setFocusable(true);
					txtNumeroConta.requestFocus();
				}
			}
		});
		txtNumeroConta.setColumns(10);
		txtNumeroConta.setBounds(124, 45, 101, 20);
		contentPane.add(txtNumeroConta);
		
		JLabel lblTitular = new JLabel("Titular:");
		lblTitular.setBounds(10, 141, 101, 23);
		contentPane.add(lblTitular);
		
		txtTitular = new JTextField();
		txtTitular.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTitular.getText().equals("") || txtTitular.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,"Número Titular obrigatório");
					txtTitular.setFocusable(true);
					txtTitular.requestFocus();
				}
			}
		});
		txtTitular.setColumns(10);
		txtTitular.setBounds(10, 174, 492, 20);
		contentPane.add(txtTitular);
		
		JLabel lblSaldo = new JLabel("Saldo Inicial:");
		lblSaldo.setBounds(293, 11, 101, 23);
		contentPane.add(lblSaldo);
		
		txtSaldo = new JTextField();
		txtSaldo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSaldo.getText().equals("") || txtSaldo.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,"Número Saldo Inicial obrigatório");
					txtSaldo.setFocusable(true);
					txtSaldo.requestFocus();
				}
			}
		});
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(276, 45, 156, 20);
		contentPane.add(txtSaldo);
		
		JLabel lblRendimento = new JLabel("Rendimento:");
		lblRendimento.setBounds(293, 76, 101, 23);
		contentPane.add(lblRendimento);
		
		txtRendimento = new JTextField();
		txtRendimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtRendimento.getText().equals("") || txtRendimento.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,"Número Rendimento obrigatório");
					txtRendimento.setFocusable(true);
					txtRendimento.requestFocus();
				}
				btnVerificarSaldo.setText("Abrir Conta");
				btnVerificarSaldo.setEnabled(true);
			}
		});
		txtRendimento.setColumns(10);
		txtRendimento.setBounds(276, 110, 156, 20);
		contentPane.add(txtRendimento);
		
		txtValor = new JTextField();
		txtValor.setText("Valor:");
		txtValor.setBounds(10, 271, 156, 125);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		btnVerificarSaldo = new JButton("Verificar Saldo");
		btnVerificarSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(btnVerificarSaldo.getText().equals("Abrir Conta")) {
					cp.setNumeroBanco(Long.parseLong(txtNumeroBanco.getText()));
					cp.setAgencia(Integer.parseInt(txtAgencia.getText()));
					cp.setNumeroConta(Long.parseLong(txtNumeroConta.getText()));
					cp.setTitular(txtTitular.getText());
					cp.setSaldo(Double.parseDouble(txtSaldo.getText()));
					cp.setRendimento(Double.parseDouble(txtRendimento.getText()));
					
					//Vamos trocar o texto do botão
					btnVerificarSaldo.setText("Verificar Saldo");
					
					//desabilitar as caixa de texto
					txtNumeroBanco.setEnabled(false);
					txtAgencia.setEnabled(false);
					txtNumeroConta.setEnabled(false);
					txtTitular.setEnabled(false);
					txtSaldo.setEnabled(false);
					txtRendimento.setEnabled(false);
					
					//habilitar os botões sacar e depositar
					btnDepositar.setEnabled(true);
					btnSacar.setEnabled(true);
					txtValor.setEnabled(true);
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Seu dado é R$"+cp.getSaldo());
				}
				
				
			}
		});
		btnVerificarSaldo.setBounds(24, 237, 113, 23);
		contentPane.add(btnVerificarSaldo);
	}
}
