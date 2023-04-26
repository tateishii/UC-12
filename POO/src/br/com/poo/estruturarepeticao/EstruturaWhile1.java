package br.com.poo.estruturarepeticao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EstruturaWhile1 extends JFrame {
   private JPanel contentPane;
	private JTextField txtInicial;
	private JTextField txtFinal;
	private JTextField txtResultado;
    String dados = "";
    int i;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstruturaWhile1 frame = new EstruturaWhile1();
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
	public EstruturaWhile1() {
		setResizable(false);
		setBackground(new Color(0, 0, 0));
		setTitle("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 307);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Número Inicial");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(10, -3, 198, 62);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-11, 59, -15, 14);
		contentPane.add(lblNewLabel);
		
		txtInicial = new JTextField();
		txtInicial.setBounds(179, 22, 46, 36);
		contentPane.add(txtInicial);
		txtInicial.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Número Inicial");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(9, 59, 160, 32);
		contentPane.add(lblNewLabel_2);
		
		txtFinal = new JTextField();
		txtFinal.setBounds(179, 71, 46, 36);
		contentPane.add(txtFinal);
		txtFinal.setColumns(10);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 160, 88);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				i = Integer.parseInt(txtFinal.getText());
				
				while(i <= Integer.parseInt(txtFinal.getText())) {
					dados += i +"\n";
					i++;
				}
				
				txtResultado.setText(dados);
				txtInicial.setText("");
				txtFinal.setText("");
				dados = "";
			}
		});
		btnExecutar.setForeground(new Color(0, 0, 0));
		btnExecutar.setFont(new Font("Arial", Font.PLAIN, 23));
		btnExecutar.setBounds(19, 102, 142, 41);
		contentPane.add(btnExecutar);
	}
}
