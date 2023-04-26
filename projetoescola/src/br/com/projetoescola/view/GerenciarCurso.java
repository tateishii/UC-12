package br.com.projetoescola.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.projetoescola.dao.CRUDCurso;
import br.com.projetoescola.domain.Curso;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GerenciarCurso extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextArea txtDescricao;
	private JLabel lblTitulo;
	private JLabel lblDescricao;
	private JLabel lblDataInicio;
	private JLabel lblDataTermino;
	private JLabel lblHorarioInicio;
	private JLabel lblHorarioTermino;
	private JButton btnCadastrar;
	private JButton btnAtualizarCurso;
	private JButton btnConsultar;
	private JButton btnDeletarCurso;
	private JLabel lblLiceu;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataTermino;
	private JFormattedTextField txtHorarioInicio;
	private JFormattedTextField txtHorarioTermino;
	private Long id= null;
	
	MaskFormatter di;
	MaskFormatter dt;
	MaskFormatter hi;
	MaskFormatter ht;
	CRUDCurso cc= new CRUDCurso();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarCurso frame = new GerenciarCurso();
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
	public GerenciarCurso() {
		
		try {
		setTitle("Gerenciar Cursos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 634);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		carregarTabela();
		
		txtDescricao = new JTextArea();
		txtDescricao.setBounds(100, 188, 556, 98);
		contentPane.add(txtDescricao);
		
		lblTitulo = new JLabel("Título:");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTitulo.setBounds(10, 132, 101, 32);
		contentPane.add(lblTitulo);
		
		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDescricao.setBounds(10, 208, 101, 32);
		contentPane.add(lblDescricao);
		
		di = new MaskFormatter("##-##-####");
		di.setPlaceholderCharacter('_');
		
		lblDataInicio = new JLabel("Data Início:");
		lblDataInicio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDataInicio.setBounds(184, 132, 97, 32);
		contentPane.add(lblDataInicio);
		
		
		
		lblDataTermino = new JLabel("Data Término:");
		lblDataTermino.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDataTermino.setBounds(420, 132, 118, 32);
		contentPane.add(lblDataTermino);
		
		
		lblHorarioInicio = new JLabel("Horário Início:");
		lblHorarioInicio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblHorarioInicio.setBounds(10, 297, 111, 32);
		contentPane.add(lblHorarioInicio);
		
		
		
		
		
		lblHorarioTermino = new JLabel("Horário Término:");
		lblHorarioTermino.setFont(new Font("Arial", Font.PLAIN, 16));
		lblHorarioTermino.setBounds(258, 297, 124, 32);
		contentPane.add(lblHorarioTermino);
		
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(22, 357, 124, 39);
		contentPane.add(btnCadastrar);
		
		btnAtualizarCurso = new JButton("Atualizar Curso");
		btnAtualizarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Curso cadCurso = new Curso();
				if(txtTitulo.getText().trim().equals("")
					|| txtDescricao.getText().trim().equals("")
					|| txtDataInicio.getText().trim().equals("")
					|| txtDataTermino.getText().trim().equals("")
					|| txtDataInicio.getText().trim().equals("")
					|| txtHorarioInicio.getText().trim().equals("")
					|| txtHorarioTermino.getText().trim().equals("")
					){
			JOptionPane.showMessageDialog(null, 
					"Você deve preecher todos os campos",
			        "Erro!", 
			        JOptionPane.ERROR_MESSAGE);
		}
		else {
			cadCurso.setTitulo(txtTitulo.getText());
			cadCurso.setDescricao(txtDescricao.getText());
			cadCurso.setDatainicio(Date.valueOf(txtDataInicio.getText()));
			cadCurso.setDatatermino(Date.valueOf(txtDataTermino.getText()));
			cadCurso.setHorarioinicio(txtHorarioInicio.getText());
			cadCurso.setHorariotermino(txtHorarioTermino.getText());
			cadCurso.setIdCurso(id);
			
			JOptionPane.showMessageDialog(null, cc.atualizar(cadCurso).getTitulo()+"Foi atualizado");
			carregarTabela();
			
			limparCampos();
		}
				
				
				
				
				
			}
		});
		btnAtualizarCurso.setBounds(156, 357, 146, 39);
		contentPane.add(btnAtualizarCurso);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(324, 357, 124, 39);
		contentPane.add(btnConsultar);
		
		btnDeletarCurso = new JButton("Deletar Curso");
		btnDeletarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(id.equals(null)) {
					JOptionPane.showMessageDialog(null, "Selecione um curso para apagar");
				}
				else {
					
					if(JOptionPane.showConfirmDialog(null, "Você realmente deseja apagar este curso?","Atenção",JOptionPane.QUESTION_MESSAGE)==0) {
						
					}
					Curso cr= new Curso();
					cr.setIdCurso(id);
					JOptionPane.showMessageDialog(null, cc.apagar(cr));
					carregarTabela();
					limparCampos();
				}
			}
		});
		btnDeletarCurso.setBounds(481, 357, 163, 39);
		contentPane.add(btnDeletarCurso);
		
		lblLiceu = new JLabel("");
		lblLiceu.setIcon(new ImageIcon("D:\\Java\\Diego\\POO\\src\\br\\com\\poo\\images\\Liceu.png"));
		lblLiceu.setBounds(10, 11, 230, 112);
		contentPane.add(lblLiceu);
		
		di = new MaskFormatter("####-##-##");
		di.setPlaceholderCharacter('_');
		
		txtDataInicio = new JFormattedTextField(di);
		txtDataInicio.setBounds(274, 134, 97, 26);
		contentPane.add(txtDataInicio);
		
		dt = new MaskFormatter("####-##-##");
		dt.setPlaceholderCharacter('_');
		
		txtDataTermino = new JFormattedTextField(dt);
		txtDataTermino.setBounds(548, 134, 97, 26);
		contentPane.add(txtDataTermino);
		
		hi = new MaskFormatter("##h##min");
		hi.setPlaceholderCharacter('_');

		txtHorarioInicio = new JFormattedTextField(hi);
		txtHorarioInicio.setBounds(124, 305, 97, 26);
		contentPane.add(txtHorarioInicio);
		
		ht = new MaskFormatter("##h##min");
		ht.setPlaceholderCharacter('_');

		txtHorarioTermino = new JFormattedTextField(ht);
		txtHorarioTermino.setBounds(392, 303, 97, 26);
		contentPane.add(txtHorarioTermino);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Curso cadCurso = new Curso();
				if(txtTitulo.getText().trim().equals("")
					|| txtDescricao.getText().trim().equals("")
					|| txtDataInicio.getText().trim().equals("")
					|| txtDataTermino.getText().trim().equals("")
					|| txtDataInicio.getText().trim().equals("")
					|| txtHorarioInicio.getText().trim().equals("")
					|| txtHorarioTermino.getText().trim().equals("")
					){
			JOptionPane.showMessageDialog(null, 
					"Você deve preecher todos os campos",
			        "Erro!", 
			        JOptionPane.ERROR_MESSAGE);
		}
		else {
			cadCurso.setTitulo(txtTitulo.getText());
			cadCurso.setDescricao(txtDescricao.getText());
			cadCurso.setDatainicio(Date.valueOf(txtDataInicio.getText()));
			cadCurso.setDatatermino(Date.valueOf(txtDataTermino.getText()));
			cadCurso.setHorarioinicio(txtHorarioInicio.getText());
			cadCurso.setHorariotermino(txtHorarioTermino.getText());
			
			JOptionPane.showMessageDialog(null, cc.gravar(cadCurso));
			carregarTabela();
			
			limparCampos();
		}
			}
		});
	}
	catch(Exception e){
		e.printStackTrace();
		
	}
 }

private void carregarTabela() {
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 407, 646, 177);
	contentPane.add(scrollPane);
	
	String[] cabecalho = {
			"Id Curso",
			"Título do Curso",
			"Descrição do Curso",
			"Data de Início",
			"Data de Término",
			"Horário de Início",
			"Horário de Término"
	};
	
	
	
	Object [][] dados = new Object[cc.listar().size()][7];
	
	for(int i=0 ; i < dados.length ; i++) {
			dados[i][0] = cc.listar().get(i).getIdCurso();
			dados[i][1] = cc.listar().get(i).getTitulo();
			dados[i][2] = cc.listar().get(i).getDescricao();
			dados[i][3] = cc.listar().get(i).getDatainicio();
			dados[i][4] = cc.listar().get(i).getDatatermino();
			dados[i][5] = cc.listar().get(i).getHorarioinicio();
			dados[i][6] = cc.listar().get(i).getHorariotermino();
			
	}
	
	DefaultTableModel model = new DefaultTableModel(dados, cabecalho);	
	
    JTable table = new JTable(model);
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
					
					txtTitulo.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
					txtDescricao.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),2)));
					txtDataInicio.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),3)));
					txtDataTermino.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),4)));
					txtHorarioInicio.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),5)));
					txtHorarioTermino.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),6)));
					
					id = Long.parseLong(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
		}
	});
	scrollPane.setViewportView(table);
	txtTitulo = new JTextField();
	txtTitulo.setBounds(73, 134, 101, 32);
	contentPane.add(txtTitulo);
	txtTitulo.setColumns(10);
}

private void limparCampos() {
	
	txtTitulo.setText("");
	txtDescricao.setText("");
	txtDataInicio.setText("");
	txtDataTermino.setText("");
	txtHorarioInicio.setText("");
	txtHorarioTermino.setText("");
}




}
