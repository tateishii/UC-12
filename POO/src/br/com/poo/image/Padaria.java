package br.com.poo.image;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Padaria extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtCodigoBarras;
	private JTextField txtDescricao;
	private JTextField txtValorUnitario;
	private JTextField txtQuantidade;
	private JTextField txtTotalItem;
	private JTextField txtSubtotal;
	private JTextArea  txtNota;
	private String 	   cabecalho;
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
		
		valorPagar = 0.0;
		item = 1;
		
		cabecalho = "\t\t\t     Padaria Doce Pães"+
					"\n\t\t                 Av. Magrones Matui, 666 - Vista Triste"+
					"\n\t\t                      CEP: 06080-666 - Matuiland - ML"+
					"\n\t\t                           CNPJ: 62.312.123/9991-89"+
					"\n\t\t\t      IE: 223.123424.4446"+
					"\n\t\t\t        IM: 3.656.765/551-8"+
					"\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"+
					"\n\t\t\t            CUPOM FISCAL"+
					"\n\nItem\tCodigo\tDescrição\t\t\tQTD\tVL.Unit.\t\tVL.Total"+
				    "\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
	
	
		
		
		String[][] produtos = {
			
				{"2023", "Pão Francês", "13.00", "17032023"},
				{"2024", "Pão de Leite", "15.00", "17032024"},
				{"2025", "Torta de Franco", "50.00", "17032025"},
				{"2026", "Leite Integral", "5.00", "17032026"},
				{"2027", "Manteiga", "5.00", "17032027"},
				{"2028", "Bolo", "20.00", "17032028"},
				{"2029", "Bauru", "12.00", "17032029"},
				{"2030", "Coca-Cola", "15.00", "17032030"}
				
				
		};
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1617, 868);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlEsquerdo = new JPanel();
		pnlEsquerdo.setBounds(0, 0, 800, 700);
		pnlEsquerdo.setBackground(new Color(128, 64, 0));
		contentPane.add(pnlEsquerdo);
		pnlEsquerdo.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(190, 0, 484, 300);
		
		/*
		 * Para ajudar a iamgem ao tamanho da Label, foi necessário aplicar o comando
		 * nem ImageIcon para definir a scala no elemento getImage.
		 * o tamanho da imagem foi de ajustado para largura da label(lbl.getWidth) e altura da
		 * label (lbl.getHeight) e para finalizar, foi alterado a forma de fechamento da
		 * imagem quando a tela fecha, foi setado o valor para suavização(image.SCALE_SMOOTH)
		 * 
		 * */
		
		
		lblLogo.setIcon(new ImageIcon(Padaria.class.getResource("/br/com/poo/image/Icone.png")));
		
		pnlEsquerdo.add(lblLogo);
		
		JLabel lblCodigoProduto = new JLabel("Código do Produto:");
		lblCodigoProduto.setFont(new Font("Arial", Font.ITALIC, 20));
		lblCodigoProduto.setBounds(10, 311, 186, 33);
		pnlEsquerdo.add(lblCodigoProduto);
		
		JLabel lblCodigoBarras = new JLabel("Código de Barras:");
		lblCodigoBarras.setFont(new Font("Arial", Font.ITALIC, 20));
		lblCodigoBarras.setBounds(435, 311, 186, 33);
		pnlEsquerdo.add(lblCodigoBarras);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost (FocusEvent e) {
				
				for (int linha = 0 ; linha < produtos.length ; linha++) {
					
					
					
					for (int coluna = 0 ; coluna < produtos[0].length ; coluna++) {
						if (txtCodigoProduto.getText().equals(produtos[linha][0])) {
							txtCodigoBarras.setText(produtos[linha][3]);
							txtDescricao.setText(produtos[linha][1]);
							txtValorUnitario.setText(produtos[linha][2]);
							break;
						 }
				    	}
					}
				}
				
			
			}
	);

		
		
		txtCodigoProduto.setFont(new Font("Arial", Font.ITALIC, 20));
		txtCodigoProduto.setForeground(new Color(0, 0, 0));
		txtCodigoProduto.setBackground(Color.WHITE);
		txtCodigoProduto.setBounds(10, 343, 214, 30);
		pnlEsquerdo.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setForeground(new Color(0, 0, 0));
		txtCodigoBarras.setFont(new Font("Arial", Font.ITALIC, 20));
		txtCodigoBarras.setColumns(10);
		txtCodigoBarras.setBackground(Color.WHITE);
		txtCodigoBarras.setBounds(435, 343, 239, 30);
		pnlEsquerdo.add(txtCodigoBarras);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 384, 780, 2);
		pnlEsquerdo.add(separator);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setFont(new Font("Arial", Font.ITALIC, 20));
		lblDescricao.setBounds(10, 397, 186, 33);
		pnlEsquerdo.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setForeground(new Color(0, 0, 0));
		txtDescricao.setFont(new Font("Arial", Font.ITALIC, 20));
		txtDescricao.setColumns(10);
		txtDescricao.setBackground(Color.WHITE);
		txtDescricao.setBounds(10, 429, 780, 30);
		pnlEsquerdo.add(txtDescricao);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 469, 780, 2);
		pnlEsquerdo.add(separator_1);
		
		JLabel lblValorUnitario = new JLabel("Valor Unitario");
		lblValorUnitario.setFont(new Font("Arial", Font.ITALIC, 20));
		lblValorUnitario.setBounds(10, 472, 186, 33);
		pnlEsquerdo.add(lblValorUnitario);
		
		txtValorUnitario = new JTextField();
		txtValorUnitario.setForeground(new Color(0, 0, 0));
		txtValorUnitario.setFont(new Font("Arial", Font.ITALIC, 20));
		txtValorUnitario.setColumns(10);
		txtValorUnitario.setBackground(Color.WHITE);
		txtValorUnitario.setBounds(10, 504, 214, 30);
		pnlEsquerdo.add(txtValorUnitario);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial", Font.ITALIC, 20));
		lblQuantidade.setBounds(267, 470, 186, 33);
		pnlEsquerdo.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				txtTotalItem.setText(""+
						Double.parseDouble(txtQuantidade.getText())*
						Double.parseDouble(txtValorUnitario.getText())
						);
				txtSubtotal.setText("R$"+
						Double.parseDouble(txtQuantidade.getText())*
						Double.parseDouble(txtValorUnitario.getText())
						);
				
			}
		});
		txtQuantidade.setForeground(new Color(0, 0, 0));
		txtQuantidade.setFont(new Font("Arial", Font.ITALIC, 20));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBackground(Color.WHITE);
		txtQuantidade.setBounds(267, 502, 214, 30);
		pnlEsquerdo.add(txtQuantidade);
		
		JLabel lblTotalItem = new JLabel("Total Item");
		lblTotalItem.setFont(new Font("Arial", Font.ITALIC, 20));
		lblTotalItem.setBounds(523, 470, 186, 33);
		pnlEsquerdo.add(lblTotalItem);
		
		txtTotalItem = new JTextField();
		txtTotalItem.setForeground(new Color(0, 0, 0));
		txtTotalItem.setFont(new Font("Arial", Font.ITALIC, 20));
		txtTotalItem.setColumns(10);
		txtTotalItem.setBackground(Color.WHITE);
		txtTotalItem.setBounds(523, 502, 214, 30);
		pnlEsquerdo.add(txtTotalItem);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 542, 780, 2);
		pnlEsquerdo.add(separator_1_1);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setFont(new Font("Arial", Font.ITALIC, 25));
		lblSubtotal.setBounds(10, 562, 186, 33);
		pnlEsquerdo.add(lblSubtotal);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setForeground(new Color(0, 0, 0));
		txtSubtotal.setFont(new Font("Arial", Font.BOLD, 35));
		txtSubtotal.setColumns(10);
		txtSubtotal.setBackground(Color.WHITE);
		txtSubtotal.setBounds(183, 562, 270, 89);
		pnlEsquerdo.add(txtSubtotal);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cabecalho+="\n"+item+"\t"+txtCodigoProduto.getText()+
						"\t"+txtDescricao.getText()+
						"\t\t\t"+txtQuantidade.getText()+
						"\t"+txtValorUnitario.getText()+
						"\t\t"+txtTotalItem.getText();
							
				
				txtNota.setText(cabecalho);
				item++;
				
				valorPagar += Double.parseDouble(txtTotalItem.getText());
				lblValorPagar.setText("R$" +valorPagar);
				
			}
		});
		btnIncluir.setBackground(SystemColor.activeCaption);
		btnIncluir.setFont(new Font("Arial", Font.BOLD, 30));
		btnIncluir.setBounds(481, 566, 243, 80);
		pnlEsquerdo.add(btnIncluir);
		
		JPanel pnlDireito = new JPanel();
		pnlDireito.setBounds(810, 0, 774, 700);
		pnlDireito.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(pnlDireito);
		pnlDireito.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 774, 700);
		pnlDireito.add(scrollPane);
		
		txtNota = new JTextArea();
		scrollPane.setViewportView(txtNota);
		txtNota.setText(cabecalho);
		
		JPanel pnlBase = new JPanel();
		pnlBase.setBounds(0, 710, 1584, 150);
		pnlBase.setBackground(new Color(255, 128, 64));
		contentPane.add(pnlBase);
		pnlBase.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor a Pagar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 47));
		lblNewLabel.setBounds(812, 11, 313, 82);
		pnlBase.add(lblNewLabel);
		
		lblValorPagar = new JLabel("New label");
		lblValorPagar.setFont(new Font("Tahoma", Font.PLAIN, 47));
		lblValorPagar.setBounds(1162, 11, 412, 82);
		pnlBase.add(lblValorPagar);
		lblValorPagar.setText("R$"+valorPagar);
	}
}
