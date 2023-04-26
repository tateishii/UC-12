package br.com.poo.objetos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaConta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaConta frame = new JanelaConta();
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
	public JanelaConta() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 96);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPoupanca = new JButton("Poupança");
		btnPoupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JanelaPoupanca jp= new JanelaPoupanca();
				jp.setVisible(true);
			}
		});
		btnPoupanca.setFont(new Font("Arial", Font.PLAIN, 18));
		btnPoupanca.setBounds(10, 11, 121, 38);
		contentPane.add(btnPoupanca);
		
		JButton btnCorrente = new JButton("Corrente");
		btnCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JanelaCorrente jc= new JanelaCorrente();
				jc.setVisible(true);
				
			}
		});
		btnCorrente.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCorrente.setBounds(180, 11, 113, 38);
		contentPane.add(btnCorrente);
	}
}
