package br.com.projetoescola.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.projetoescola.util.AcessoSSH;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GerenciarChamados extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNomesolicitante = new JLabel("Nome do solicitante");
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarChamados frame = new GerenciarChamados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GerenciarChamados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAbrirgrafico = new JButton("Abrir gráfico");
		btnAbrirgrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AcessoSSH assh = new AcessoSSH();
				assh.executar();
			}
		});
		btnAbrirgrafico.setBounds(467, 284, 143, 55);
		contentPane.add(btnAbrirgrafico);
		lblNomesolicitante.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNomesolicitante.setBounds(10, 70, 162, 31);
		contentPane.add(lblNomesolicitante);
		
		JLabel lblDepartamentosolicitado = new JLabel("Departamento solicitado");
		lblDepartamentosolicitado.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDepartamentosolicitado.setBounds(10, 144, 289, 31);
		contentPane.add(lblDepartamentosolicitado);
		
		JLabel lbldataderesolucao = new JLabel("Data de resolução");
		lbldataderesolucao.setFont(new Font("Arial", Font.PLAIN, 18));
		lbldataderesolucao.setBounds(409, 144, 153, 31);
		contentPane.add(lbldataderesolucao);
		
		JLabel lblSolicitacaodechamados = new JLabel("Solicitação de Chamados");
		lblSolicitacaodechamados.setFont(new Font("Arial", Font.PLAIN, 26));
		lblSolicitacaodechamados.setBounds(163, 11, 312, 31);
		contentPane.add(lblSolicitacaodechamados);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDescricao.setBounds(10, 242, 289, 31);
		contentPane.add(lblDescricao);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(257, 75, 143, -7);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(10, 97, 620, 49);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
