package br.com.poo.estruturaarray;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Padaria extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigoProduto;
	private JTextField textCodigoBarras;
	private JTextField textDescricao;
	private JTextField textQuantidade;
	private JTextField textValorUnitario;
	private JTextField textSubtotal;
	private JTextField textTotalItem;
	private JTextArea textNota;
	private String cabecalho;
	private int item;
	private double valorPagar;
	private JLabel lblValorPagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Padaria frame = new Padaria();
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
	public Padaria() {
		valorPagar =0.0;
		item = 1;
		
		
		
		cabecalho = "\t\t\tPadaria\n\t\t\tDoces Pães"+
		            "\n\t\tAv. Gustavo Moura, 551 - Vista Alegre"+
				    "\n\t\t    CEP: 30140-140"+
				    "\nCNPJ: 28.663.093/0001-53"+
                    "\nIE: 003.044314.0006"+
				    "\nIM: 1.046.973/001-0"+
                    "\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"+
                    "\n\t\t\tCUPOM FISCAL"+
                    "\n Item\tCódigo\tDescrição\t\t\tQTD\tVL.Unit.\tVL.Total"+
		            "\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
		
		
		String[][] produtos = {
				
				{"2023","Pão Francês","13.00","17032023"},
				{"2024","Pão de Leite","15.00","14032024"},
				{"2025","Torta de Frango","50.00","17032025"},
				{"2026","Leite Integral A","5.00","17032026"},
				{"2027","Manteiga","5.00","17032027"},
				{"2028","Bolo","20.00","17032027"},
				{"2029","Bauru","12.00","17032027"},
				{"2030","Suco de Laranja","7.00","17032030"}
		};		
		
		
		
		setResizable(false);
		setTitle("Janela Padaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlesquerdo = new JPanel();
		pnlesquerdo.setBackground(new Color(35, 63, 171));
		pnlesquerdo.setBounds(0, 0, 800, 700);
		contentPane.add(pnlesquerdo);
		pnlesquerdo.setLayout(null);
		
		JLabel lblCodigoProduto = new JLabel("Código do Produto");
		lblCodigoProduto.setForeground(new Color(255, 255, 255));
		lblCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodigoProduto.setBounds(83, 310, 171, 42);
		pnlesquerdo.add(lblCodigoProduto);
		
		JLabel lblCódigoBarras = new JLabel("Código de Barras");
		lblCódigoBarras.setForeground(new Color(255, 255, 255));
		lblCódigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCódigoBarras.setBounds(322, 310, 171, 42);
		pnlesquerdo.add(lblCódigoBarras);
		
		textCodigoProduto = new JTextField();
		textCodigoProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
			for(int linha= 0; linha < produtos.length ; linha++) {
				if(textCodigoProduto.getText().equals(produtos[linha][0])) {
					textCodigoBarras.setText(produtos[linha][3]);
					textDescricao.setText(produtos[linha][1]);
					textValorUnitario.setText(produtos[linha][2]);
					break;
				}
			}
			}
		});
		textCodigoProduto.setBounds(73, 357, 181, 30);
		pnlesquerdo.add(textCodigoProduto);
		textCodigoProduto.setColumns(10);
		
		textCodigoBarras = new JTextField();
		textCodigoBarras.setColumns(10);
		textCodigoBarras.setBounds(312, 357, 181, 30);
		pnlesquerdo.add(textCodigoBarras);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 391, 780, 2);
		pnlesquerdo.add(separator);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescricao.setBounds(83, 398, 171, 42);
		pnlesquerdo.add(lblDescricao);
		
		textDescricao = new JTextField();
		textDescricao.setColumns(10);
		textDescricao.setBounds(73, 445, 717, 30);
		pnlesquerdo.add(textDescricao);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 486, 780, 2);
		pnlesquerdo.add(separator_1);
		
		JLabel lblValorUnitario = new JLabel("Valor Unitario");
		lblValorUnitario.setForeground(Color.WHITE);
		lblValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValorUnitario.setBounds(83, 494, 171, 42);
		pnlesquerdo.add(lblValorUnitario);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuantidade.setBounds(332, 499, 171, 42);
		pnlesquerdo.add(lblQuantidade);
		
		textQuantidade = new JTextField();
		textQuantidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				
				textTotalItem.setText(""+
						 Double.parseDouble(textQuantidade.getText()) *
				         Double.parseDouble(textValorUnitario.getText())
		                 );
				      
				textSubtotal.setText("R$"+
						 Double.parseDouble(textQuantidade.getText()) *
				         Double.parseDouble(textValorUnitario.getText())
		                 );
				      
			}
		});
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(322, 541, 181, 30);
		pnlesquerdo.add(textQuantidade);
		
		JLabel lblTotalItem = new JLabel("Total Item");
		lblTotalItem.setForeground(Color.WHITE);
		lblTotalItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotalItem.setBounds(564, 494, 171, 42);
		pnlesquerdo.add(lblTotalItem);
		
		textTotalItem = new JTextField();
		textTotalItem.setColumns(10);
		textTotalItem.setBounds(554, 541, 181, 30);
		pnlesquerdo.add(textTotalItem);
		
		textValorUnitario = new JTextField();
		textValorUnitario.setColumns(10);
		textValorUnitario.setBounds(83, 541, 181, 30);
		pnlesquerdo.add(textValorUnitario);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 582, 780, 2);
		pnlesquerdo.add(separator_1_1);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setForeground(Color.WHITE);
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSubtotal.setBounds(83, 582, 171, 42);
		pnlesquerdo.add(lblSubtotal);
		
		textSubtotal = new JTextField();
		textSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textSubtotal.setColumns(10);
		textSubtotal.setBounds(237, 598, 289, 69);
		pnlesquerdo.add(textSubtotal);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			   cabecalho+="\n"+item+"\t"+textCodigoProduto.getText()+
					   "\t"+textDescricao.getText()+
					   "\t\t\t"+textQuantidade.getText()+
					   "\t"+textValorUnitario.getText()+
					   "\t"+textTotalItem.getText();
			   
			   textNota.setText(cabecalho);
			   item++;
			   
			   valorPagar += Double.parseDouble(textTotalItem.getText());
			   lblValorPagar.setText("R$"+valorPagar);
							  
			}
		});
		btnIncluir.setBounds(636, 598, 125, 42);
		pnlesquerdo.add(btnIncluir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Padaria.class.getResource("/br/com/poo/images/Padaria.png")));
		lblNewLabel.setBounds(0, 0, 800, 337);
		pnlesquerdo.add(lblNewLabel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 0, 800, 300);
		
		/*
		 * Para ajustar a imagem aqo tamanho da label, foi necessário aplicar o comando
		 * new ImageIcon para definir a scala no elemento getImage.
		 * O tamanho da imagem foi ajustado para largura da label(lbl.getWidth) e altura da
		 * label (lbl.getHeight) e para finalizar, foi alterado a forma de fechamento da
		 * imagem quando a tela fecha, foi setado o valor para suaviazação(image.SCALE_SMOOTH)
		 */
		lblLogo.setIcon(new ImageIcon(new ImageIcon(Padaria.class.getResource("/br/com/poo/images/Padaria.png")).getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));
		
		
		JPanel pnlDireito = new JPanel();
		pnlDireito.setBounds(810, 0, 774, 700);
		contentPane.add(pnlDireito);
		pnlDireito.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 774, 700);
		pnlDireito.add(scrollPane);
		
	    textNota = new JTextArea();
		scrollPane.setViewportView(textNota);
		textNota.setText(cabecalho);
		
		JPanel pnlBase = new JPanel();
		pnlBase.setBounds(0, 700, 1584, 161);
		contentPane.add(pnlBase);
		pnlBase.setLayout(null);
		
		JLabel lblValor = new JLabel("Valor a Pagar:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblValor.setBounds(26, 11, 270, 115);
		pnlBase.add(lblValor);
		
		lblValorPagar = new JLabel("New label");
		lblValorPagar.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblValorPagar.setBounds(325, 37, 363, 62);
		pnlBase.add(lblValorPagar);
		lblValorPagar.setText("R$"+valorPagar);
	}
}
