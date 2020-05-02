package br.com.cadastro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import br.com.cadastro.dao.LeitorDAO;
import br.com.cadastro.model.Leitor;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAluno;
	private JMenu mnNotasEFaltas;
	private JMenu mnAjuda;
	private JMenuItem mntmSalvar;
	private JMenuItem mntmAlterar;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmExcluir;
	private JMenuItem mntmSair;
	private JMenuItem mntmSalvar_1;
	private JMenuItem mntmAlterar_1;
	private JMenuItem mntmExcluir_1;
	private JMenuItem mntmConsultar_1;
	private JMenuItem mntmSobre;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblRgm;
	private JTextField txtRgm;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblDataDeNacimento;
	private JTextField txtData;
	private JLabel lblCpf;
	private JTextField txtCpf;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblEnd;
	private JTextField txtEnd;
	private JLabel lblMunicipil;
	private JTextField txtMunicipil;
	private JLabel lblUf;
	private JComboBox cbmUf;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private JLabel lblCursos;
	private JLabel lblCompo;
	private JLabel lblPerldo;
	private JComboBox cbmCurso;
	private JComboBox cbmCampo;
	private JRadioButton rdbtMatutino;
	private JRadioButton rdbtVespetino;
	private JRadioButton rdbtNoturno;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JLabel lblRgm_1;
	private JTextField txtRgmNotaFalta;
	private JLabel txtNomeAluno;
	private JLabel txtCursoAluno;
	private JLabel lblDiciplina;
	private JLabel lblS;
	private JComboBox cbmDiciplina;
	private JComboBox cbmSemestre;
	private JLabel lblRgm_2;
	private JTextField txtRgmBoletin;
	private JLabel lblNota;
	private JComboBox cbmNota;
	private JLabel lblFalta;
	private JTextField txtFalta;
	private JLabel txtNomeBoletim;
	private JLabel lblDiciplina_1;
	private JLabel lblS_1;
	private JLabel lblNota_1;
	private JLabel lblFalta_1;
	private JComboBox cbmDisciplinaBoleim;
	private JLabel textNotaBoletim;
	private JComboBox cbmSemestreBoletim;
	private JLabel txtFaltaBoletim;
	private JLabel lblNome_1;
	private Leitor leitor;
	private LeitorDAO dao;
	private JButton btnConsultar;
	private JButton btnNovo;
	private JMenuItem mntmNovo;
	private JMenuItem mntmNovo_1;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 326);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 516, 21);
		contentPane.add(menuBar);
		
		mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);
		
		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//=====salvar dados pessoal=================
				try {
					//criei o objeto leitor para pegar os dado da tela
					leitor = new Leitor();
					leitor.setRgmLeitor(Integer.parseInt(txtRgm.getText()));
					leitor.setNomeLeitor(txtNome.getText());
					leitor.setDataNacimentoLeitor(txtData.getText());
					leitor.setCpfLeitor(Integer.parseInt(txtCpf.getText()));
					leitor.setEmalLeitor(txtEmail.getText());
					leitor.setEnderecoLeitor(txtEnd.getText());
					leitor.setMunicipilLeitor(txtMunicipil.getText());
					leitor.setUfLeitor((String) cbmUf.getSelectedItem());
					leitor.setCelularLeitor(txtCelular.getText());
					
					//aqui ele vai abri a conexão
					dao = new LeitorDAO();
					
					dao.salvarDadosPessoal(leitor);
					JOptionPane.showMessageDialog(null,"Salvo com Sucesso ");
					}catch(Exception e0) {
						JOptionPane.showMessageDialog(null,"Erro ao Gravar "+e0.getMessage());
					}
				}
				
			
		});
		
		mntmNovo = new JMenuItem("Novo");
		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=========nova nota e falta =====================
				
				txtRgm.setText(null);
				cbmUf.setSelectedIndex(0);
				txtNome.setText(null);
				txtData.setText(null);
				txtCpf.setText(null);
				txtEmail.setText(null);
				txtMunicipil.setText(null);
				txtCelular.setText(null);
				txtEnd.setText(null);
			}
		});
		mnAluno.add(mntmNovo);
		mnAluno.add(mntmSalvar);
		
		mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=====Altera Daos Pessoal========================
				
				try {
					//criei o objeto leitor para pegar os dado da tela
					leitor = new Leitor();
					leitor.setRgmLeitor(Integer.parseInt(txtRgm.getText()));
					leitor.setNomeLeitor(txtNome.getText());
					leitor.setDataNacimentoLeitor(txtData.getText());
					leitor.setCpfLeitor(Integer.parseInt(txtCpf.getText()));
					leitor.setEmalLeitor(txtEmail.getText());
					leitor.setEnderecoLeitor(txtEnd.getText());
					leitor.setMunicipilLeitor(txtMunicipil.getText());
					leitor.setUfLeitor((String) cbmUf.getSelectedItem());
					leitor.setCelularLeitor(txtCelular.getText());
					
					//aqui ele vai abri a conexão
					dao = new LeitorDAO();
					
					dao.alterarDadoPessoal(leitor);
					JOptionPane.showMessageDialog(null,"Alterado Com Sucesso.");
					}catch(Exception e0) {
						JOptionPane.showMessageDialog(null,"Erro ao alterar"+e0.getMessage());
					}
				
			}
		});
		mnAluno.add(mntmAlterar);
		
		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=====consultarDadosPessoal=============================
					try {
					
					dao = new LeitorDAO();
					leitor = dao.consultarDadosPessoal(Integer.parseInt(txtRgm.getText()));
					txtNome.setText(leitor.getNomeLeitor());
					txtData.setText(leitor.getDataNacimentoLeitor());
					txtCpf.setText(Integer.toString( leitor.getCpfLeitor()));
					txtEmail.setText(leitor.getEmalLeitor());
					txtEnd.setText(leitor.getEnderecoLeitor());
					txtMunicipil.setText(leitor.getMunicipilLeitor());
					
					String tipo = leitor.getUfLeitor();
					
					if(tipo.equals("Selecione uma Opção")) {
						cbmUf.setSelectedIndex(0);
						
					}else if(tipo.equals("AC")) {
						cbmUf.setSelectedIndex(1);
						
					}else if(tipo.equals("AL")) {
						cbmUf.setSelectedIndex(2);
						
					}else if(tipo.equals("AM")) {
						cbmUf.setSelectedIndex(3);
						
					}else if(tipo.equals("BA")) {
						cbmUf.setSelectedIndex(4);
						
					}else if(tipo.equals("SE")) {
						cbmUf.setSelectedIndex(5);
						
					}else if(tipo.equals("DF")) {
						cbmUf.setSelectedIndex(6);
						
					}else if(tipo.equals("SP")) {
						cbmUf.setSelectedIndex(7);
						
					}else if(tipo.equals("SE")) {
						cbmUf.setSelectedIndex(8);
						
					}else {
						cbmUf.setSelectedIndex(9);
				
					}
					
					txtCelular.setText(leitor.getCelularLeitor());
					
			
		}catch(Exception e0) {
			JOptionPane.showMessageDialog(null,"Erro ao Listar "+e0.getMessage());
		}
			}
			
		
			
		});
		mnAluno.add(mntmConsultar);
		
		mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=============Excluir Dados Pessal
				try {
					
					//aqui ele vai abri a conexão
					dao = new LeitorDAO();
					
					dao.excluirDadoPessoal(Integer.parseInt(txtRgm.getText()));
					
					JOptionPane.showMessageDialog(null,"Excluido Com Sucesso.");
					}catch(Exception e0) {
						JOptionPane.showMessageDialog(null,"Erro ao Excluir "+e0.getMessage());
					}
				
			}
		});
		mnAluno.add(mntmExcluir);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//=======SAIR==============================
				int res;
				res = JOptionPane.showConfirmDialog( null,"Tem Cetesa que quer Fechar?","Confirma",JOptionPane.YES_NO_OPTION);
				if( res == 0) {
					System.exit(0);
				}else {
					
				}
				
			}
		});
		mnAluno.add(mntmSair);
		
		mnNotasEFaltas = new JMenu("Notas e Faltas");
		menuBar.add(mnNotasEFaltas);
		
		mntmSalvar_1 = new JMenuItem("Salvar");
		mntmSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	//=============MENU Salvar Nota e Falta=======================================
				

				try {
				//criei o objeto leitor para pegar os dado da tela
				leitor = new Leitor();
				leitor.setRgmLeitor(Integer.parseInt(txtRgmNotaFalta.getText()));
				leitor.setDiciplinaLeitor((String) cbmDiciplina.getSelectedItem());
				leitor.setSemestreLeitor((String) cbmSemestre.getSelectedItem());
				leitor.setNotaLeitor((String) cbmNota.getSelectedItem());
				leitor.setFaltaLeitor(Integer.parseInt(txtFalta.getText()));
				
				//aqui ele vai abri a conexão
				dao = new LeitorDAO();
				
				dao.salvarNotaFalta(leitor);
				JOptionPane.showMessageDialog(null,"Salvo Com Sucesso.");
				}catch(Exception e0) {
					JOptionPane.showMessageDialog(null,"Erro ao Gravar"+e0.getMessage());
				}
				
			}
		});
		
		mntmNovo_1 = new JMenuItem("Novo");
		mntmNovo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//=========nova nota e falta =====================
				
				txtRgmNotaFalta.setText(null);
				cbmDiciplina.setSelectedIndex(0);
				cbmSemestre.setSelectedIndex(0);
				cbmNota.setSelectedIndex(0);
				txtNomeAluno.setText(null);
				txtCursoAluno.setText(null);
				txtFalta.setText(null);
			}
		});
		mnNotasEFaltas.add(mntmNovo_1);
		mnNotasEFaltas.add(mntmSalvar_1);
		
		mntmAlterar_1 = new JMenuItem("Alterar");
		mntmAlterar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==========MENU Altera Notas e Falta========================
				
				try {
					//criei o objeto leitor para pegar os dado da tela
					leitor = new Leitor();
					leitor.setRgmLeitor(Integer.parseInt(txtRgmNotaFalta.getText()));
					leitor.setDiciplinaLeitor((String) cbmDiciplina.getSelectedItem());
					leitor.setSemestreLeitor((String) cbmSemestre.getSelectedItem());
					leitor.setNotaLeitor((String) cbmNota.getSelectedItem());
					leitor.setFaltaLeitor(Integer.parseInt(txtFalta.getText()));
					
					//aqui ele vai abri a conexão
					dao = new LeitorDAO();
					
					dao.alterarNotaFalta(leitor);
					JOptionPane.showMessageDialog(null,"Alterado Com Sucesso.");
					}catch(Exception e0) {
						JOptionPane.showMessageDialog(null,"Erro ao alterar "+e0.getMessage());
					}
			}
		});
		mnNotasEFaltas.add(mntmAlterar_1);
		
		mntmExcluir_1 = new JMenuItem("Excluir");
		mntmExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===============MENU Excluir Nota e Falta=============================================
				
				try {
					//aqui ele vai abri a conexão
					dao = new LeitorDAO();
					
					dao.excluirNotaFalta(Integer.parseInt(txtRgmNotaFalta.getText()));
					
					JOptionPane.showMessageDialog(null,"Excluido Com Sucesso.");
					}catch(Exception e0) {
						JOptionPane.showMessageDialog(null,"Erro ao Excluir "+e0.getMessage());
					}
			}
		});
		mnNotasEFaltas.add(mntmExcluir_1);
		
		mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//============MENU Consultar Nota Falta========================================================
				
				try {
				dao = new LeitorDAO();
				leitor = dao.consultarNotaFalta(Integer.parseInt(txtRgmNotaFalta.getText()));
				txtNomeAluno.setText(leitor.getNomeLeitor());
				txtCursoAluno.setText(leitor.getCurcoLeitor());
				String tipo1 = leitor.getDiciplinaLeitor();
				switch(tipo1) {
				case "Selecione uma Opção":
					cbmDiciplina.setSelectedIndex(0);
					break;
					
				case "Portugues":
					cbmDiciplina.setSelectedIndex(1);
					break;
					
				case "Matematica":
					cbmDiciplina.setSelectedIndex(2);
					break;
					
				case "Tequinica de Programação":
					cbmDiciplina.setSelectedIndex(3);
					break;
					
				case "Matematica Aplicada":
					cbmDiciplina.setSelectedIndex(4);
					break;
				
				}
				
				String tipo = leitor.getSemestreLeitor();
				
				switch(tipo) {
				case "2019 1":
					cbmSemestre.setSelectedIndex(0);
					break;
					
				case "2019 2":
					cbmSemestre.setSelectedIndex(1);
					break;
					
				case "2020 3":
					cbmSemestre.setSelectedIndex(2);
					break;
					
				case "2020 4":
					cbmSemestre.setSelectedIndex(3);
					break;
				}
				
				String tipo2 = leitor.getNotaLeitor();
				
				switch(tipo2) {
				case "Selecione um Opção":
					cbmNota.setSelectedIndex(0);
					break;
					
				case "0,5":
					cbmNota.setSelectedIndex(1);
					break;
					
				case "1,0":
					cbmNota.setSelectedIndex(2);
					break;
					
				case "1,5":
					cbmNota.setSelectedIndex(3);
					break;
					
				case "2,0":
					cbmNota.setSelectedIndex(4);
					break;
					
				case "3,0":
					cbmNota.setSelectedIndex(5);
					break;
					
				case "3,5":
					cbmNota.setSelectedIndex(6);
					break;
					
				case "4,0":
					cbmNota.setSelectedIndex(7);
					break;
					
				case "4,5":
					cbmNota.setSelectedIndex(8);
					break;
					
				case "5,0":
					cbmNota.setSelectedIndex(9);
					break;
					
				case "5,5":
					cbmNota.setSelectedIndex(10);
					break;
					
				case "6,0":
					cbmNota.setSelectedIndex(11);
					break;
					
				case "6,5":
					cbmNota.setSelectedIndex(12);
					break;
					
				case "7,0":
					cbmNota.setSelectedIndex(13);
					break;
					
				case "7,5":
					cbmNota.setSelectedIndex(14);
					break;
					
				case "8,0":
					cbmNota.setSelectedIndex(15);
					break;
					
				case "8,5":
					cbmNota.setSelectedIndex(16);
					break;
					
				case "9,0":
					cbmNota.setSelectedIndex(17);
					break;
					
				case "9,5":
					cbmNota.setSelectedIndex(18);
					break;
					
				case "10":
					cbmNota.setSelectedIndex(19);
					break;
				}
				txtFalta.setText(Integer.toString(leitor.getFaltaLeitor()));
				
}catch(Exception e0) {
	JOptionPane.showMessageDialog(null,"Erro ao Listar "+e0.getMessage());
}	
		
				
			}
		});
		mnNotasEFaltas.add(mntmConsultar_1);
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"CADASTRO ALUNO\n\n "
						+ "Copyright CADASTRO ALUNO contributors and others 2020.\n  "
						+ "All rights reserved.CADASTRO ALUNO logo are trademarks\n "
						+ "of the CADASTRO ALUNO, Inc. The CADASTRO ALUNO\n "
						+ "logo cannot be altered without CADASTRO ALUNO permission. CADASTRO ALUNO logos are provided\n "
						+ "for use under the CADASTRO ALUNO logo and trademark guidelines. \n"
						+ "David Santos de Santana and Java are trademarks or registered trademarks of David Santos de Santana\n"
						+ "Other names may be trademarks of their respective owners.\n");
			}
		});
		mnAjuda.add(mntmSobre);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 54, 516, 233);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);
		
		lblRgm = new JLabel("RGM");
		lblRgm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRgm.setBounds(10, 11, 35, 14);
		panel.add(lblRgm);
		
		txtRgm = new JTextField();
		txtRgm.setToolTipText("");
		txtRgm.setBounds(55, 9, 161, 20);
		panel.add(txtRgm);
		txtRgm.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(256, 11, 35, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(301, 9, 161, 20);
		panel.add(txtNome);
		
		lblDataDeNacimento = new JLabel("Data de Nacimento");
		lblDataDeNacimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataDeNacimento.setBounds(10, 53, 116, 14);
		panel.add(lblDataDeNacimento);
		
		txtData = new JTextField();
		txtData.setBounds(136, 51, 109, 20);
		panel.add(txtData);
		txtData.setColumns(10);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(256, 54, 35, 14);
		panel.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(301, 51, 161, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 97, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(55, 94, 407, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblEnd = new JLabel("End.");
		lblEnd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnd.setBounds(10, 132, 46, 14);
		panel.add(lblEnd);
		
		txtEnd = new JTextField();
		txtEnd.setBounds(55, 129, 407, 20);
		panel.add(txtEnd);
		txtEnd.setColumns(10);
		
		lblMunicipil = new JLabel("Municipil");
		lblMunicipil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMunicipil.setBounds(10, 167, 59, 14);
		panel.add(lblMunicipil);
		
		txtMunicipil = new JTextField();
		txtMunicipil.setBounds(75, 165, 109, 20);
		panel.add(txtMunicipil);
		txtMunicipil.setColumns(10);
		
		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUf.setBounds(189, 167, 27, 14);
		panel.add(lblUf);
		
		cbmUf = new JComboBox();
		cbmUf.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma Op\u00E7\u00E3o", "AC", "AL", "AM", "BA", "SE", "DF", "SP", "SE", "TO"}));
		cbmUf.setBounds(217, 165, 49, 20);
		panel.add(cbmUf);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCelular.setBounds(276, 167, 46, 14);
		panel.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(332, 165, 130, 20);
		panel.add(txtCelular);
		txtCelular.setColumns(10);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Dados", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblCursos = new JLabel("Curso");
		lblCursos.setBounds(10, 11, 46, 14);
		panel_1.add(lblCursos);
		
		lblCompo = new JLabel("Campo");
		lblCompo.setBounds(10, 42, 46, 14);
		panel_1.add(lblCompo);
		
		lblPerldo = new JLabel("Per\u00EDodo");
		lblPerldo.setBounds(10, 83, 46, 14);
		panel_1.add(lblPerldo);
		
		cbmCurso = new JComboBox();
		cbmCurso.setModel(new DefaultComboBoxModel(new String[] {"Selecione um Op\u00E7\u00E3o", "Administra\u00E7\u00E3o", "An\u00E1lise de Dados", "An\u00E1lise e Desenvolvimento de Sistemas", "Arquitetura e Urbanismo", "Automa\u00E7\u00E3o Industrial", "Biomedicina", "Ci\u00EAncia da Computa\u00E7\u00E3o", "Ci\u00EAncia de Dados", "Ci\u00EAncias Biol\u00F3gicas (Bacharelado)", "Ci\u00EAncias Biol\u00F3gicas (Licenciatura)", "Ci\u00EAncias Cont\u00E1beis", "Ci\u00EAncias Econ\u00F4micas", "Com\u00E9rcio Exterior", "Comunica\u00E7\u00E3o Social (Publicidade e Propaganda)", "Design", "Design de Interiores", "Design de Moda", "Design Gr\u00E1fico", "Direito", "Educa\u00E7\u00E3o F\u00EDsica (Gradua\u00E7\u00E3o Plena)", "Empreendedorismo e Startups", "Engenharia de Alimentos", "Engenharia Civil", "Engenharia de Computa\u00E7\u00E3o", "Engenharia de Controle e Automa\u00E7\u00E3o", "Engenharia El\u00E9trica", "Engenharia Eletr\u00F4nica", "Engenharia Mec\u00E2nica", "Engenharia de Produ\u00E7\u00E3o", "Engenharia Qu\u00EDmica", "Enfermagem", "Engenharia Aeron\u00E1utica", "Engenharia Mecanica", "Farm\u00E1cia", "Fisioterapia", "Forma\u00E7\u00E3o para Youtuber", "Gastronomia", "Gest\u00E3o Ambiental", "Gest\u00E3o Comercial", "Gest\u00E3o da Qualidade", "Gest\u00E3o da Tecnologia da Informa\u00E7\u00E3o", "Gest\u00E3o de Cooperativas", "Gest\u00E3o de Recursos Humanos", "Gest\u00E3o de Seguran\u00E7a Privada", "Gest\u00E3o de Servi\u00E7os Jur\u00EDdicos, Notariais e de Registro", "Gest\u00E3o do Agroneg\u00F3cio", "Gest\u00E3o Financeira", "Gest\u00E3o Portu\u00E1ria", "Jogos Digitais", "Jornalismo", "Letras Licenciatura em L\u00EDngua Portuguesa", "Letras Licenciatura em L\u00EDngua Portuguesa e L\u00EDngua Inglesa", "Letras Bacharelado em Tradu\u00E7\u00E3o em L\u00EDngua Portuguesa e L\u00EDngua Inglesa", "Log\u00EDstica", "Matem\u00E1tica", "Medicina Veterin\u00E1ria", "Neg\u00F3cios Imobili\u00E1rios", "Nutri\u00E7\u00E3o", "Odontologia", "Pedagogia", "Petr\u00F3leo e G\u00E1s", "Processos Gerenciais", "Produ\u00E7\u00E3o Audiovisual", "Propaganda", "Marketing", "Psicologia", "Radiologia", "Redes de Computadores", "Rela\u00E7\u00F5es Internacionais", "Secretariado Executivo", "Servi\u00E7o Social", "Sistemas de Informa\u00E7\u00E3o", "Turismo"}));
		cbmCurso.setBounds(49, 8, 392, 20);
		panel_1.add(cbmCurso);
		
		cbmCampo = new JComboBox();
		cbmCampo.setModel(new DefaultComboBoxModel(new String[] {"Selecione um Op\u00E7\u00E3o", "Guarulhos", "Campinas", "S\u00E3o Bernardo do Campo", "S\u00E3o Jos\u00E9 dos Campos", "Santo Andr\u00E9", "Ribeir\u00E3o Preto", "Osasco", "Sorocaba", "Mau\u00E1", "S\u00E3o Jos\u00E9 do Rio Preto", "Mogi das Cruzes", "Santos", "Diadema", "Jundia\u00ED", "Piracicaba", "Carapicu\u00EDba", "Bauru", "Itaquaquecetuba", "S\u00E3o Vicente", "Franca", "Praia Grande", "Guaruj\u00E1", "Taubat\u00E9", "Limeira", "Suzano", "Tabo\u00E3o da Serra", "Sumar\u00E9", "Barueri", "Embu das Artes", "Itu", "Bragan\u00E7a Paulista", "Pindamonhangaba", "Itapetininga", "S\u00E3o Caetano do Sul", "Franco da Rocha", "Mogi Gua\u00E7u", "Ja\u00FA", "Atibaia", "Tatuape"}));
		cbmCampo.setBounds(49, 42, 392, 20);
		panel_1.add(cbmCampo);
		
		rdbtMatutino = new JRadioButton("Matutino");
		rdbtMatutino.setBounds(85, 79, 75, 23);
		panel_1.add(rdbtMatutino);
		
		rdbtVespetino = new JRadioButton("Vespertino");
		rdbtVespetino.setBounds(197, 79, 109, 23);
		panel_1.add(rdbtVespetino);
		
		rdbtNoturno = new JRadioButton("Noturno");
		rdbtNoturno.setBounds(332, 79, 109, 23);
		panel_1.add(rdbtNoturno);
		
		ButtonGroup group = new ButtonGroup();
        group.add(rdbtNoturno);
        group.add(rdbtVespetino);
        group.add(rdbtMatutino);
		
		btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=========nova nota e falta =====================
				
				
					cbmCurso.setSelectedIndex(0);
					cbmCampo.setSelectedIndex(0);
					rdbtNoturno.setSelected(false);
					rdbtVespetino.setSelected(false);
					rdbtMatutino.setSelected(false);;
				
			
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\Actions-bookmark-new-icon.png"));
		btnNewButton.setBounds(10, 130, 89, 64);
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//========salva dados==========================
				JFrame f = null;
				
				String rgm = JOptionPane.showInputDialog(f,"Digite o se RGM");
				
				try {
					
				//criei o objeto leitor para pegar os dado da tela
				leitor = new Leitor();
				leitor.setRgmLeitor(Integer.parseInt(rgm));
				leitor.setCurcoLeitor((String) cbmCurso.getSelectedItem());
				leitor.setCampoLeitor((String) cbmCampo.getSelectedItem());
						if(rdbtNoturno.isSelected()== true){
							leitor.setPerildoLeitor("Noturno");
						} else if(rdbtVespetino.isSelected()== true) {
							leitor.setPerildoLeitor("Vespetino");
						} else if(rdbtMatutino.isSelected()== true) {
							leitor.setPerildoLeitor("Matutino");
						}
				
				//aqui ele vai abri a conexão
				dao = new LeitorDAO();
				
				dao.salvarDados(leitor);
				JOptionPane.showMessageDialog(null,"Salvo Com Sucesso.");
				}catch(Exception e0) {
					JOptionPane.showMessageDialog(null,"Erro ao Gravar"+e0.getMessage());
					
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\salvar-\u00EDcone-de-disco-flex\u00EDvel-o-bot\u00E3o-quadrado-azul-89658451.jpg"));
		btnNewButton_1.setBounds(109, 130, 89, 64);
		panel_1.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//============Altera Dados==============
				
				JFrame f = null;
				
				String rgm = JOptionPane.showInputDialog(f,"Digite o se RGM");
				
				try {
					//criei o objeto leitor para pegar os dado da tela
					leitor = new Leitor();
					leitor.setRgmLeitor(Integer.parseInt(rgm));
					leitor.setCurcoLeitor((String) cbmCurso.getSelectedItem());
					leitor.setCampoLeitor((String) cbmCampo.getSelectedItem());
							if(rdbtNoturno.isSelected()== true){
								leitor.setPerildoLeitor("Noturno");
							} else if(rdbtVespetino.isSelected()== true) {
								leitor.setPerildoLeitor("Vespetino");
							} else if(rdbtMatutino.isSelected()== true) {
								leitor.setPerildoLeitor("Matutino");
							}
					
					
					//aqui ele vai abri a conexão
					dao = new LeitorDAO();
					
					dao.alterarDados(leitor);
					JOptionPane.showMessageDialog(null,"Alterado Com Sucesso.");
					}catch(Exception e0) {
						JOptionPane.showMessageDialog(null,"Erro ao alterar"+e0.getMessage());
					}
			
			
			}
		});
		btnNewButton_2.setToolTipText("Alterar");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\download.png"));
		btnNewButton_2.setBounds(208, 130, 89, 64);
		panel_1.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//======consultar Dados================
				
				JFrame f = null;
				
				String rgm = JOptionPane.showInputDialog(f,"Digite o se RGM");
				
					try {
					
					dao = new LeitorDAO();
					leitor = dao.consultarDados(Integer.parseInt(rgm));
					String tipo1 = leitor.getCurcoLeitor();
					
					
					
					switch(tipo1) {
					case "Selecione uma Opção":
						cbmCurso.setSelectedIndex(0);
						break;
						
					case "Administração":
						cbmCurso.setSelectedIndex(1);
						break;
						
					case "Análise de Dados":
						cbmCurso.setSelectedIndex(2);
						break;
						
					case "Análise e Desenvolvimento de Sistemas":
						cbmCurso.setSelectedIndex(3);
						break;
						
					case "Arquitetura e Urbanismo":
						cbmCurso.setSelectedIndex(4);
						break;
						
					case "Automação Industrial":
						cbmCurso.setSelectedIndex(5);
						break;
						
					case "Biomedicina":
						cbmCurso.setSelectedIndex(6);
						break;
						
					case "Ciência da Computação":
						cbmCurso.setSelectedIndex(7);
						break;
						
					case "Ciência de Dados":
						cbmCurso.setSelectedIndex(8);
						break;
						
					case "Ciências Biológicas (Bacharelado)":
						cbmCurso.setSelectedIndex(9);
						break;
						
					case "Ciências Biológicas (Licenciatura)":
						cbmCurso.setSelectedIndex(10);
						break;
						
					case "Ciências Contábeis":
						cbmCurso.setSelectedIndex(11);
						break;
						
					case "Ciências Econômicas":
						cbmCurso.setSelectedIndex(12);
						break;
						
					case "Comércio Exterior":
						cbmCurso.setSelectedIndex(13);
						break;
						
					case "Comunicação Social (Publicidade e Propaganda)":
						cbmCurso.setSelectedIndex(14);
						break;
						
					case "Design":
						cbmCurso.setSelectedIndex(15);
						break;
						
					case "Design de Interiores":
						cbmCurso.setSelectedIndex(16);
						break;
						
					case "Design de Moda":
						cbmCurso.setSelectedIndex(17);
						break;
						
					case "Design Gráfico":
						cbmCurso.setSelectedIndex(18);
						break;
						
					case "Direito":
						cbmCurso.setSelectedIndex(19);
						break;
						
					case "Educação Física (Graduação Plena)":
						cbmCurso.setSelectedIndex(20);
						break;
						
					case "Empreendedorismo e Startups":
						cbmCurso.setSelectedIndex(21);
						break;
						
					case "Engenharia de Alimentos":
						cbmCurso.setSelectedIndex(22);
						break;
						
					case "Engenharia Civil":
						cbmCurso.setSelectedIndex(23);
						break;
						
					case "Engenharia de Computação":
						cbmCurso.setSelectedIndex(24);
						break;
						
					case "Engenharia de Controle e Automação":
						cbmCurso.setSelectedIndex(25);
						break;
						
					case "Engenharia Elétrica":
						cbmCurso.setSelectedIndex(26);
						break;
						
					case "Engenharia Eletrônica":
						cbmCurso.setSelectedIndex(27);
						break;
						
					case "Engenharia Mecânica":
						cbmCurso.setSelectedIndex(28);
						break;
						
					case "Engenharia de Produção":
						cbmCurso.setSelectedIndex(26);
						break;
						
					case "Engenharia Química":
						cbmCurso.setSelectedIndex(27);
						break;
						
					case "Enfermagem":
						cbmCurso.setSelectedIndex(28);
						break;
						
					case "Engenharia Aeronáutica":
						cbmCurso.setSelectedIndex(29);
						break;
						
					case "Engenharia Meca	nica":
						cbmUf.setSelectedIndex(30);
						break;
						
					case "Farmácia":
						cbmCurso.setSelectedIndex(31);
						break;
						
					case "Fisioterapia":
						cbmCurso.setSelectedIndex(32);
						break;
						
					case "Formação para Youtuber":
						cbmCurso.setSelectedIndex(33);
						break;
						
					case "Gastronomia":
						cbmCurso.setSelectedIndex(34);
						break;
						
					case "Gestão Ambiental":
						cbmCurso.setSelectedIndex(35);
						break;
						
					case "Gestão Comercial":
						cbmCurso.setSelectedIndex(36);
						break;
						
					case "Gestão da Qualidade":
						cbmCurso.setSelectedIndex(37);
						break;
						
					case "Gestão da Tecnologia da Informação":
						cbmCurso.setSelectedIndex(38);
						break;
						
					case "Gestão de Recursos Humanos":
						cbmCurso.setSelectedIndex(39);
						break;
						
					case "Gestão de Segurança Privada":
						cbmCurso.setSelectedIndex(40);
						break;
						
					case "Gestão de Serviços Jurídicos, Notariais e de Registro":
						cbmCurso.setSelectedIndex(41);
						break;
						
					case "Gestão do Agronegócio":
						cbmCurso.setSelectedIndex(42);
						break;
						
					case "Gestão Financeira":
						cbmCurso.setSelectedIndex(43);
						break;
						
					case "Gestão Portuária":
						cbmCurso.setSelectedIndex(44);
						break;
						
					case "Jogos Digitais":
						cbmCurso.setSelectedIndex(45);
						break;
						
					case "Jornalismo":
						cbmCurso.setSelectedIndex(46);
						break;
						
					case "Letras Licenciatura em Língua Portuguesa":
						cbmCurso.setSelectedIndex(47);
						break;
						
					case "Letras Licenciatura em Língua Portuguesa e Língua Inglesa":
						cbmCurso.setSelectedIndex(48);
						break;
						
					case "Letras Bacharelado em Tradução em Língua Portuguesa e Língua Inglesa":
						cbmCurso.setSelectedIndex(49);
						break;
						
					case "Logística":
						cbmCurso.setSelectedIndex(50);
						break;
						
						
					case "Marketing":
						cbmCurso.setSelectedIndex(51);
						break;
						
					case "Matemática":
						cbmCurso.setSelectedIndex(52);
						break;
						
					case "Medicina Veterinária":
						cbmCurso.setSelectedIndex(53);
						break;
						
					case "Negócios Imobiliários":
						cbmCurso.setSelectedIndex(54);
						break;
						
					case "Nutrição":
						cbmCurso.setSelectedIndex(55);
						break;
						
					case "Odontologia":
						cbmCurso.setSelectedIndex(56);
						break;
						
					case "Pedagogia":
						cbmCurso.setSelectedIndex(57);
						break;
						
					case "Petróleo e Gás":
						cbmCurso.setSelectedIndex(58);
						break;
						
					case "Processos Gerenciais":
						cbmCurso.setSelectedIndex(59);
						break;
						
					case "Produção Audiovisual":
						cbmCurso.setSelectedIndex(60);
						break;
						
					case "Propaganda":
						cbmCurso.setSelectedIndex(61);
						break;
						
					
					case "Psicologia":
						cbmCurso.setSelectedIndex(62);
						break;
						
					case "Radiologia":
						cbmCurso.setSelectedIndex(63);
						break;
						
					case "Redes de Computadores":
						cbmCurso.setSelectedIndex(64);
						break;
						
					case "Relações Internacionais":
						cbmCurso.setSelectedIndex(65);
						break;
						
					case "Secretariado Executivo":
						cbmCurso.setSelectedIndex(66);
						break;
						
					case "Serviço Social":
						cbmCurso.setSelectedIndex(67);
						break;
						
					case "Sistemas de Informação":
						cbmCurso.setSelectedIndex(68);
						break;
						
					case "Turismo":
						cbmCurso.setSelectedIndex(69);
						break;
						
					}
					
					String tipo = leitor.getCampoLeitor();
					
					switch(tipo) {
					case "Selecione uma Opção":
						cbmCampo.setSelectedIndex(0);
						break;
						
					case "Guarulhos":
						cbmCampo.setSelectedIndex(1);
						break;
						
					case "Campinas":
						cbmCampo.setSelectedIndex(2);
						break;
						
					case "São Bernardo do Campo":
						cbmCampo.setSelectedIndex(3);
						break;
						
					case "São José dos Campos":
						cbmCampo.setSelectedIndex(4);
						break;
						
					case "Santo André":
						cbmCampo.setSelectedIndex(5);
						break;
						
					case "Ribeirão Preto":
						cbmUf.setSelectedIndex(6);
						break;
						
					case "Osasco":
						cbmCampo.setSelectedIndex(7);
						break;
						
						
					case "Sorocaba":
						cbmCampo.setSelectedIndex(8);
						break;
						
					case "Mauá":
						cbmCampo.setSelectedIndex(9);
						break;
						
					case "São José do Rio Preto":
						cbmCampo.setSelectedIndex(10);
						break;
						
					case "Mogi das Cruzes":
						cbmCampo.setSelectedIndex(11);
						break;
						
					case "Santos":
						cbmCampo.setSelectedIndex(12);
						break;
						
					case "Diadema":
						cbmCampo.setSelectedIndex(13);
						break;
						
					case "Jundiaí":
						cbmCampo.setSelectedIndex(14);
						break;
						
					case "Piracicaba":
						cbmCampo.setSelectedIndex(15);
						break;
						
					case "Carapicuíba":
						cbmCampo.setSelectedIndex(16);
						break;
						
					case "Bauru":
						cbmCampo.setSelectedIndex(17);
						break;
						
					case "Itaquaquecetuba":
						cbmCampo.setSelectedIndex(18);
						break;
						
					case "São Vicente":
						cbmCampo.setSelectedIndex(19);
						break;
						
					case "Franca":
						cbmCampo.setSelectedIndex(20);
						break;
						
					case "Praia Grande":
						cbmCampo.setSelectedIndex(21);
						break;
						
					case "Guarujá":
						cbmCampo.setSelectedIndex(22);
						break;
						
					case "Taubaté":
						cbmCampo.setSelectedIndex(23);
						break;
						
					case "Limeira":
						cbmCampo.setSelectedIndex(24);
						break;
						
					case "Suzano":
						cbmCampo.setSelectedIndex(25);
						break;
						
					case "Taboão da Serra":
						cbmCampo.setSelectedIndex(26);
						break;
						
					case "Sumaré":
						cbmCampo.setSelectedIndex(27);
						break;
						
					case "Barueri":
						cbmCampo.setSelectedIndex(28);
						break;
						
					case "Embu das Artes":
						cbmCampo.setSelectedIndex(29);
						break;
						
					case "Itu":
						cbmCampo.setSelectedIndex(30);
						break;
						
					case "Bragança Paulista":
						cbmCampo.setSelectedIndex(31);
						break;
						
					case "Pindamonhangaba":
						cbmCampo.setSelectedIndex(32);
						break;
						
					case "Itapetininga":
						cbmCampo.setSelectedIndex(33);
						break;
						
					case "São Caetano do Sul":
						cbmCampo.setSelectedIndex(34);
						break;
						
					case "Franco da Rocha":
						cbmCampo.setSelectedIndex(35);
						break;
						
					case "Mogi Guaçu":
						cbmCampo.setSelectedIndex(36);
						break;
						
					case "Jaú":
						cbmCampo.setSelectedIndex(37);
						break;
						
					case "Atibaia":
						cbmCampo.setSelectedIndex(38);
						break;
						
					case "Tatuape":
						cbmCampo.setSelectedIndex(39);
						break;
					}
					
					
					leitor.getPerildoLeitor();
					
					if(leitor.getPerildoLeitor().equals("Noturno")){
						rdbtNoturno.setSelected(true);
					} else if(leitor.getPerildoLeitor().equals("Vespetino")) {
						rdbtVespetino.setSelected(true);
					} else if(leitor.getPerildoLeitor().equals("Matutino")) {
						rdbtMatutino.setSelected(true);;
					}
					
	}catch(Exception e0) {
		JOptionPane.showMessageDialog(null,"Erro ao Listar "+e0.getMessage());
	}
		}
		
			
		});
		btnNewButton_3.setToolTipText("Consultar");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\lupa_org_20170315094946.png"));
		btnNewButton_3.setBounds(307, 130, 89, 64);
		panel_1.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===================Excluir Dados===========================
				
				try {
					JFrame f = null;
					
					String rgm = JOptionPane.showInputDialog(f,"Digite o se RGM");
					
					//aqui ele vai abri a conexão
					dao = new LeitorDAO();
					
					dao.excluirDado(Integer.parseInt(rgm));
					
					JOptionPane.showMessageDialog(null,"Excluido Com Sucesso.");
					}catch(Exception e0) {
						JOptionPane.showMessageDialog(null,"Erro ao Excluir "+e0.getMessage());
					}
			}
		});
		btnNewButton_4.setToolTipText("Excluir");
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\download (1).png"));
		btnNewButton_4.setBounds(406, 130, 89, 64);
		panel_1.add(btnNewButton_4);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);
		
		btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==========Altera Notas e Falta========================
				
				try {
					//criei o objeto leitor para pegar os dado da tela
					leitor = new Leitor();
					leitor.setRgmLeitor(Integer.parseInt(txtRgmNotaFalta.getText()));
					leitor.setDiciplinaLeitor((String) cbmDiciplina.getSelectedItem());
					leitor.setSemestreLeitor((String) cbmSemestre.getSelectedItem());
					leitor.setNotaLeitor((String) cbmNota.getSelectedItem());
					leitor.setFaltaLeitor(Integer.parseInt(txtFalta.getText()));
					
					//aqui ele vai abri a conexão
					dao = new LeitorDAO();
					
					dao.alterarNotaFalta(leitor);
					JOptionPane.showMessageDialog(null,"Alterado Com Sucesso.");
					}catch(Exception e0) {
						JOptionPane.showMessageDialog(null,"Erro ao alterar "+e0.getMessage());
					}
				
			}
		});
		btnNewButton_5.setToolTipText("Alterar");
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\download.png"));
		btnNewButton_5.setBounds(10, 130, 89, 64);
		panel_2.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//============Consultar Nota Falta========================================================
				
				
					try {
					dao = new LeitorDAO();
					leitor = dao.consultarNotaFalta(Integer.parseInt(txtRgmNotaFalta.getText()));
					txtNomeAluno.setText(leitor.getNomeLeitor());
					txtCursoAluno.setText(leitor.getCurcoLeitor());
					String tipo1 = leitor.getDiciplinaLeitor();
					switch(tipo1) {
					case "Selecione uma Opção":
						cbmDiciplina.setSelectedIndex(0);
						break;
						
					case "Portugues":
						cbmDiciplina.setSelectedIndex(1);
						break;
						
					case "Matematica":
						cbmDiciplina.setSelectedIndex(2);
						break;
						
					case "Tequinica de Programação":
						cbmDiciplina.setSelectedIndex(3);
						break;
						
					case "Matematica Aplicada":
						cbmDiciplina.setSelectedIndex(4);
						break;
					
					}
					
					String tipo = leitor.getSemestreLeitor();
					
					switch(tipo) {
					case "2019 1":
						cbmSemestre.setSelectedIndex(0);
						break;
						
					case "2019 2":
						cbmSemestre.setSelectedIndex(1);
						break;
						
					case "2020 3":
						cbmSemestre.setSelectedIndex(2);
						break;
						
					case "2020 4":
						cbmSemestre.setSelectedIndex(3);
						break;
					}
					
					String tipo2 = leitor.getNotaLeitor();
					
					switch(tipo2) {
					case "Selecione um Opção":
						cbmNota.setSelectedIndex(0);
						break;
						
					case "0,5":
						cbmNota.setSelectedIndex(1);
						break;
						
					case "1,0":
						cbmNota.setSelectedIndex(2);
						break;
						
					case "1,5":
						cbmNota.setSelectedIndex(3);
						break;
						
					case "2,0":
						cbmNota.setSelectedIndex(4);
						break;
						
					case "3,0":
						cbmNota.setSelectedIndex(5);
						break;
						
					case "3,5":
						cbmNota.setSelectedIndex(6);
						break;
						
					case "4,0":
						cbmNota.setSelectedIndex(7);
						break;
						
					case "4,5":
						cbmNota.setSelectedIndex(8);
						break;
						
					case "5,0":
						cbmNota.setSelectedIndex(9);
						break;
						
					case "5,5":
						cbmNota.setSelectedIndex(10);
						break;
						
					case "6,0":
						cbmNota.setSelectedIndex(11);
						break;
						
					case "6,5":
						cbmNota.setSelectedIndex(12);
						break;
						
					case "7,0":
						cbmNota.setSelectedIndex(13);
						break;
						
					case "7,5":
						cbmNota.setSelectedIndex(14);
						break;
						
					case "8,0":
						cbmNota.setSelectedIndex(15);
						break;
						
					case "8,5":
						cbmNota.setSelectedIndex(16);
						break;
						
					case "9,0":
						cbmNota.setSelectedIndex(17);
						break;
						
					case "9,5":
						cbmNota.setSelectedIndex(18);
						break;
						
					case "10":
						cbmNota.setSelectedIndex(19);
						break;
					}
					txtFalta.setText(Integer.toString(leitor.getFaltaLeitor()));
					
	}catch(Exception e0) {
		JOptionPane.showMessageDialog(null,"Erro ao Listar "+e0.getMessage());
	}	
			}
						
		});
		btnNewButton_6.setToolTipText("Consutar");
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\lupa_org_20170315094946.png"));
		btnNewButton_6.setBounds(208, 130, 89, 64);
		panel_2.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=============Salvar Nota e Falta=======================================
				
				try {
				//criei o objeto leitor para pegar os dado da tela
				leitor = new Leitor();
				leitor.setRgmLeitor(Integer.parseInt(txtRgmNotaFalta.getText()));
				leitor.setDiciplinaLeitor((String) cbmDiciplina.getSelectedItem());
				leitor.setSemestreLeitor((String) cbmSemestre.getSelectedItem());
				leitor.setNotaLeitor((String) cbmNota.getSelectedItem());
				leitor.setFaltaLeitor(Integer.parseInt(txtFalta.getText()));
				
				//aqui ele vai abri a conexão
				dao = new LeitorDAO();
				
				dao.salvarNotaFalta(leitor);
				JOptionPane.showMessageDialog(null,"Salvo Com Sucesso.");
				}catch(Exception e0) {
					JOptionPane.showMessageDialog(null,"Erro ao Gravar"+e0.getMessage());
				}
				
			}
		});
		btnNewButton_7.setToolTipText("Salvar");
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\salvar-\u00EDcone-de-disco-flex\u00EDvel-o-bot\u00E3o-quadrado-azul-89658451.jpg"));
		btnNewButton_7.setBounds(109, 130, 89, 64);
		panel_2.add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===============Excluir Nota e Falta=============================================
				
				try {
					//aqui ele vai abri a conexão
					dao = new LeitorDAO();
					
					dao.excluirNotaFalta(Integer.parseInt(txtRgmNotaFalta.getText()));
					
					JOptionPane.showMessageDialog(null,"Excluido Com Sucesso.");
					}catch(Exception e0) {
						JOptionPane.showMessageDialog(null,"Erro ao Excluir "+e0.getMessage());
					}
				
			}
		});
		btnNewButton_8.setToolTipText("Excluir");
		btnNewButton_8.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\download (1).png"));
		btnNewButton_8.setBounds(307, 130, 89, 64);
		panel_2.add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("");
		btnNewButton_9.setToolTipText("Sair");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=========nova nota e falta =====================
				
				txtRgmNotaFalta.setText(null);
				cbmDiciplina.setSelectedIndex(0);
				cbmSemestre.setSelectedIndex(0);
				cbmNota.setSelectedIndex(0);
				txtNomeAluno.setText(null);
				txtCursoAluno.setText(null);
				txtFalta.setText(null);
			}
		});
		btnNewButton_9.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\Actions-bookmark-new-icon.png"));
		btnNewButton_9.setBounds(406, 130, 89, 64);
		panel_2.add(btnNewButton_9);
		
		lblRgm_1 = new JLabel("RGM");
		lblRgm_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRgm_1.setBounds(10, 13, 35, 14);
		panel_2.add(lblRgm_1);
		
		txtRgmNotaFalta = new JTextField();
		txtRgmNotaFalta.setToolTipText("Digite o seu RGM");
		txtRgmNotaFalta.setColumns(10);
		txtRgmNotaFalta.setBounds(55, 11, 127, 20);
		panel_2.add(txtRgmNotaFalta);
		
		txtNomeAluno = new JLabel("");
		txtNomeAluno.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.GRAY));
		txtNomeAluno.setBounds(203, 12, 292, 20);
		panel_2.add(txtNomeAluno);
		
		txtCursoAluno = new JLabel("");
		txtCursoAluno.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.GRAY));
		txtCursoAluno.setBounds(10, 42, 485, 20);
		panel_2.add(txtCursoAluno);
		
		lblDiciplina = new JLabel("Disciplina");
		lblDiciplina.setBounds(10, 73, 64, 14);
		panel_2.add(lblDiciplina);
		
		lblS = new JLabel("Semestre");
		lblS.setBounds(10, 105, 64, 14);
		panel_2.add(lblS);
		
		cbmDiciplina = new JComboBox();
		cbmDiciplina.setModel(new DefaultComboBoxModel(new String[] {"Selecione um Op\u00E7\u00E3o", "Portugues", "Matematica", "Tequinica de Programa\u00E7\u00E3o", "Matematica Aplicada"}));
		cbmDiciplina.setBounds(71, 70, 424, 20);
		panel_2.add(cbmDiciplina);
		
		cbmSemestre = new JComboBox();
		cbmSemestre.setModel(new DefaultComboBoxModel(new String[] {"2019 1", "2019 2", "2020 3", "2020 4"}));
		cbmSemestre.setBounds(71, 99, 111, 20);
		panel_2.add(cbmSemestre);
		
		lblNota = new JLabel("Nota");
		lblNota.setBounds(192, 105, 46, 14);
		panel_2.add(lblNota);
		
		cbmNota = new JComboBox();
		cbmNota.setModel(new DefaultComboBoxModel(new String[] {"Selecione um Op\u00E7\u00E3o", "0,5", "1,0", "1,5", "2,0", "2,5", "3,0", "3,5", "4,0", "4,5", "5,0", "6,0", "6,5", "7,0", "7,5", "8,0", "8,5", "9,0", "9,5", "10"}));
		cbmNota.setBounds(248, 102, 64, 20);
		panel_2.add(cbmNota);
		
		lblFalta = new JLabel("Falta");
		lblFalta.setBounds(332, 105, 46, 14);
		panel_2.add(lblFalta);
		
		txtFalta = new JTextField();
		txtFalta.setBounds(375, 102, 86, 20);
		panel_2.add(txtFalta);
		txtFalta.setColumns(10);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_3, null);
		panel_3.setLayout(null);
		
		lblRgm_2 = new JLabel("RGM");
		lblRgm_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRgm_2.setBounds(10, 13, 35, 14);
		panel_3.add(lblRgm_2);
		
		txtRgmBoletin = new JTextField();
		txtRgmBoletin.setColumns(10);
		txtRgmBoletin.setBounds(75, 11, 127, 20);
		panel_3.add(txtRgmBoletin);
		
		txtNomeBoletim = new JLabel("");
		txtNomeBoletim.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.GRAY));
		txtNomeBoletim.setBounds(75, 43, 420, 20);
		panel_3.add(txtNomeBoletim);
		
		lblDiciplina_1 = new JLabel("Disciplina");
		lblDiciplina_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiciplina_1.setBounds(10, 74, 69, 14);
		panel_3.add(lblDiciplina_1);
		
		lblS_1 = new JLabel("Semestre");
		lblS_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblS_1.setBounds(10, 106, 69, 14);
		panel_3.add(lblS_1);
		
		lblNota_1 = new JLabel("Nota");
		lblNota_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNota_1.setBounds(10, 131, 46, 14);
		panel_3.add(lblNota_1);
		
		lblFalta_1 = new JLabel("Falta");
		lblFalta_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFalta_1.setBounds(10, 168, 46, 14);
		panel_3.add(lblFalta_1);
		
		cbmDisciplinaBoleim = new JComboBox();
		cbmDisciplinaBoleim.setModel(new DefaultComboBoxModel(new String[] {"Selecione um Op\u00E7\u00E3o", "Portugues", "Matematica", "Tequinica de Programa\u00E7\u00E3o", "Matematica Aplicada"}));
		cbmDisciplinaBoleim.setBounds(75, 71, 420, 20);
		panel_3.add(cbmDisciplinaBoleim);
		
		textNotaBoletim = new JLabel("");
		textNotaBoletim.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.GRAY));
		textNotaBoletim.setBounds(75, 131, 127, 20);
		panel_3.add(textNotaBoletim);
		
		cbmSemestreBoletim = new JComboBox();
		cbmSemestreBoletim.setModel(new DefaultComboBoxModel(new String[] {"2019 1", "2019 2", "2020 3", "2020 4"}));
		cbmSemestreBoletim.setBounds(75, 103, 420, 20);
		panel_3.add(cbmSemestreBoletim);
		
		txtFaltaBoletim = new JLabel("");
		txtFaltaBoletim.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.LIGHT_GRAY, Color.GRAY));
		txtFaltaBoletim.setBounds(75, 162, 127, 20);
		panel_3.add(txtFaltaBoletim);
		
		lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome_1.setBounds(10, 49, 46, 14);
		panel_3.add(lblNome_1);
		
		btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\lupa_org_20170315094946.png"));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//===consultar Boletim=============================
				try {
					dao = new LeitorDAO();
					leitor = dao.consultarBoletim(Integer.parseInt(txtRgmBoletin.getText()));
					txtNomeBoletim.setText(leitor.getNomeLeitor());
					String tipo1 = leitor.getDiciplinaLeitor();
					switch(tipo1) {
					case "Selecione uma Opção":
						cbmDisciplinaBoleim.setSelectedIndex(0);
						break;
						
					case "Portugues":
						cbmDisciplinaBoleim.setSelectedIndex(1);
						break;
						
					case "Matematica":
						cbmDisciplinaBoleim.setSelectedIndex(2);
						break;
						
					case "Tequinica de Programação":
						cbmDisciplinaBoleim.setSelectedIndex(3);
						break;
						
					case "Matematica Aplicada":
						cbmDisciplinaBoleim.setSelectedIndex(4);
						break;
					
					}
					
					String tipo = leitor.getSemestreLeitor();
					
					switch(tipo) {
					case "2019 1":
						cbmSemestreBoletim.setSelectedIndex(0);
						break;
						
					case "2019 2":
						cbmSemestreBoletim.setSelectedIndex(1);
						break;
						
					case "2020 3":
						cbmSemestreBoletim.setSelectedIndex(2);
						break;
						
					case "2020 4":
						cbmSemestreBoletim.setSelectedIndex(3);
						break;
					}
					
					
					
					textNotaBoletim.setText(leitor.getNotaLeitor());
					txtFaltaBoletim.setText(Integer.toString(leitor.getFaltaLeitor()));
				}catch(Exception e0) {
					JOptionPane.showMessageDialog(null,"Erro ao Listar "+e0.getMessage());
				}	
			
			}
		});
		btnConsultar.setBounds(401, 131, 94, 63);
		panel_3.add(btnConsultar);
		
		btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon("C:\\Users\\david\\OneDrive\\\u00C1rea de Trabalho\\Nova pasta (2)\\Tecnica de programa\u00E7\u00E3o\\workspace\\Icinis\\Actions-bookmark-new-icon.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=========nova Boletim=====================
				
				txtNomeBoletim.setText(null);
				cbmDisciplinaBoleim.setSelectedIndex(0);
				cbmSemestreBoletim.setSelectedIndex(0);
				textNotaBoletim.setText(null);
				txtFaltaBoletim.setText(null);
			}
		});
		btnNovo.setBounds(296, 131, 94, 63);
		panel_3.add(btnNovo);
	}
}
