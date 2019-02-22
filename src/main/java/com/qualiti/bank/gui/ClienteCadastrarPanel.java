package com.qualiti.bank.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.facade.Fachada;
import com.qualiti.bank.facade.IFachada;
import com.qualiti.bank.model.Cliente;
import com.qualiti.bank.model.Endereco;
import com.qualiti.bank.model.TipoPessoa;
import com.qualiti.bank.util.DateUtil;

@Component
public class ClienteCadastrarPanel extends JPanel {
	private JTextField nomeTxt;
	private JTextField loginTxt;
	private JPasswordField senhaTxt;
	private JTextField emailTxt;
	private JTextField telefoneTxt;
	private JTextField logradouroTxt;
	private JTextField numeroTxt;
	private JTextField complementoTxt;
	private JTextField bairroTxt;
	private JTextField cidadeTxt;
	private JFormattedTextField cpfTxt;
	private JComboBox<String> ufCb;
	private JButton btnAtualizar;
	private JButton btnCadastrar;
	private JButton btnProcurar;
	private JButton btnRemover;
	private JTextField dataNascimentoTxt;
	private JFormattedTextField cepTxt;
	private JSeparator lblEndereco;
	private JLabel lblNome;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JLabel lblEmail;
	private JLabel lblTelefone;
	private JLabel lblDataNascimento;
	private JLabel lblLogradouro;
	private JLabel lblNmero;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblComplemento;
	private JLabel lblCep;
	private JLabel lblUf;

	@Autowired
	private IFachada fachada;
	
	/**
	 * Create the panel.
	 */
	public ClienteCadastrarPanel() {
		setLayout(null);
		
		lblNome = new JLabel("Nome:");
		lblNome.setEnabled(false);
		lblNome.setBounds(32, 88, 70, 15);
		add(lblNome);
		
		nomeTxt = new JTextField();
		nomeTxt.setEnabled(false);
		nomeTxt.setBounds(100, 86, 294, 19);
		add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(32, 43, 49, 15);
		add(lblCpf);
		
		cpfTxt = new JFormattedTextField();
		cpfTxt.setBounds(100, 41, 183, 19);
		add(cpfTxt);
		
		lblLogin = new JLabel("Login:");
		lblLogin.setEnabled(false);
		lblLogin.setBounds(32, 135, 70, 15);
		add(lblLogin);
		
		loginTxt = new JTextField();
		loginTxt.setEnabled(false);
		loginTxt.setBounds(100, 133, 183, 19);
		add(loginTxt);
		loginTxt.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setEnabled(false);
		lblSenha.setBounds(324, 135, 70, 15);
		add(lblSenha);
		
		senhaTxt = new JPasswordField();
		senhaTxt.setEnabled(false);
		senhaTxt.setBounds(394, 133, 183, 19);
		add(senhaTxt);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setEnabled(false);
		lblEmail.setBounds(32, 182, 70, 15);
		add(lblEmail);
		
		emailTxt = new JTextField();
		emailTxt.setEnabled(false);
		emailTxt.setBounds(100, 180, 294, 19);
		add(emailTxt);
		emailTxt.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setEnabled(false);
		lblTelefone.setBounds(32, 226, 70, 15);
		add(lblTelefone);
		
		telefoneTxt = new JTextField();
		telefoneTxt.setEnabled(false);
		telefoneTxt.setBounds(110, 224, 129, 19);
		add(telefoneTxt);
		telefoneTxt.setColumns(10);
		
		lblEndereco = new JSeparator();
		lblEndereco.setBounds(32, 268, 545, 15);
		add(lblEndereco);
		
		JLabel lblNewLabel_1 = new JLabel("Endereço");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(32, 268, 70, 15);
		add(lblNewLabel_1);
		
		lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setEnabled(false);
		lblLogradouro.setBounds(32, 309, 101, 15);
		add(lblLogradouro);
		
		logradouroTxt = new JTextField();
		logradouroTxt.setEnabled(false);
		logradouroTxt.setBounds(144, 307, 433, 19);
		add(logradouroTxt);
		logradouroTxt.setColumns(10);
		
		lblNmero = new JLabel("Número:");
		lblNmero.setEnabled(false);
		lblNmero.setBounds(32, 344, 70, 15);
		add(lblNmero);
		
		numeroTxt = new JTextField();
		numeroTxt.setEnabled(false);
		numeroTxt.setBounds(144, 342, 114, 19);
		add(numeroTxt);
		numeroTxt.setColumns(10);
		
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setEnabled(false);
		lblComplemento.setBounds(287, 344, 107, 15);
		add(lblComplemento);
		
		complementoTxt = new JTextField();
		complementoTxt.setEnabled(false);
		complementoTxt.setBounds(394, 342, 183, 19);
		add(complementoTxt);
		complementoTxt.setColumns(10);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setEnabled(false);
		lblBairro.setBounds(32, 382, 70, 15);
		add(lblBairro);
		
		bairroTxt = new JTextField();
		bairroTxt.setEnabled(false);
		bairroTxt.setBounds(144, 380, 250, 19);
		add(bairroTxt);
		bairroTxt.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setEnabled(false);
		lblCidade.setBounds(32, 419, 70, 15);
		add(lblCidade);
		
		cidadeTxt = new JTextField();
		cidadeTxt.setEnabled(false);
		cidadeTxt.setBounds(144, 417, 250, 19);
		add(cidadeTxt);
		cidadeTxt.setColumns(10);
		
		lblCep = new JLabel("CEP:");
		lblCep.setEnabled(false);
		lblCep.setBounds(416, 382, 70, 15);
		add(lblCep);
		
		cepTxt = new JFormattedTextField();
		cepTxt.setEnabled(false);
		cepTxt.setBounds(464, 380, 113, 19);
		add(cepTxt);
		
		lblUf = new JLabel("UF:");
		lblUf.setEnabled(false);
		lblUf.setBounds(416, 419, 70, 15);
		add(lblUf);
		
		ufCb = new JComboBox<>();
		ufCb.setEnabled(false);
		
		ufCb.addItem("");
		ufCb.addItem("AL");
		ufCb.addItem("PE");
		ufCb.addItem("RJ");
		ufCb.addItem("SP");
		ufCb.addItem("BA");
		
		ufCb.setBounds(464, 414, 113, 24);
		add(ufCb);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = cpfTxt.getText();
				String nome = nomeTxt.getText();
				String login = loginTxt.getText();
				String senha = new String(senhaTxt.getPassword());
				String telefone = telefoneTxt.getText();
				String email = emailTxt.getText();
				String dataNascimento = dataNascimentoTxt.getText();
				
				try {
				
					LocalDate dataNascimentoDate = 
							DateUtil.converterTextoData(dataNascimento);
					
					String logradouro = logradouroTxt.getText();
					String numero = numeroTxt.getText();
					String complemento = complementoTxt.getText();
					String bairro = bairroTxt.getText();
					String cidade = cidadeTxt.getText();
					String cep = cepTxt.getText();
					String uf = (String)ufCb.getSelectedItem();
					
					Endereco end = new Endereco();
					end.setLogradouro(logradouro);
					end.setNumero(numero);
					end.setComplemento(complemento);
					end.setBairro(bairro);
					end.setCidade(cidade);
					end.setCep(cep);
					end.setUf(uf);
					
				
					Cliente cliente = new Cliente();
					cliente.setCpf(cpf);
					cliente.setNome(nome);
					cliente.setDataNascimento(dataNascimentoDate);
					cliente.setLogin(login);
					cliente.setSenha(senha);
					cliente.setEmail(email);
					cliente.setTelefone(telefone);
					cliente.setTipo(TipoPessoa.CLIENTE);
					cliente.setEndereco(end);
					
					
					
					fachada.inserirCliente(cliente);
					
					JOptionPane.showMessageDialog(
							null, "Cliente cadastrado com sucesso", 
							"Cadastrar Cliente", 
							JOptionPane.INFORMATION_MESSAGE);
					
					limparCampos();
					
					habilitarDesabilitarCampos(false);
				
				
				}catch(BancoException ex) {
					
					JOptionPane.showMessageDialog(
							null, ex.getMessage(), 
							"Cadastrar Cliente", JOptionPane.ERROR_MESSAGE);
					
				}catch(DateTimeParseException ex) {
					
					JOptionPane.showMessageDialog(
							null, "Data Inválida", 
							"Cadastrar Cliente", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		btnCadastrar.setBounds(262, 487, 117, 25);
		add(btnCadastrar);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = cpfTxt.getText();
				
				try {
					Cliente clienteBusca = fachada.procurar(cpf);
					
					if(clienteBusca != null) {
						
						nomeTxt.setText(clienteBusca.getNome());
						emailTxt.setText(clienteBusca.getEmail());
						loginTxt.setText(clienteBusca.getLogin());
						senhaTxt.setText(clienteBusca.getSenha());
						telefoneTxt.setText(clienteBusca.getTelefone());
						
						LocalDate data = clienteBusca.getDataNascimento();
						
						String dataTexto = DateUtil.converterDataTexto(data);
						
						dataNascimentoTxt.setText(dataTexto);
						
						Endereco end = clienteBusca.getEndereco();
						
						if(end != null){
							logradouroTxt.setText(end.getLogradouro());
							numeroTxt.setText(end.getNumero());
							complementoTxt.setText(end.getComplemento());
							cepTxt.setText(end.getCep());
							cidadeTxt.setText(end.getCidade());
							bairroTxt.setText(end.getBairro());
							ufCb.setSelectedItem(end.getUf());
							
						}
						
						habilitarDesabilitarCampos(true);
						btnAtualizar.setEnabled(true);
						btnRemover.setEnabled(true);
						btnCadastrar.setEnabled(false);
						
					}else {
						
						int escolha = JOptionPane.showConfirmDialog(
								null, "CPF n�o cadastrado. Deseja cadastrar? ", "Cadastrar cliente", JOptionPane.YES_NO_OPTION);
						
						if(escolha == JOptionPane.YES_OPTION){
							
							habilitarDesabilitarCampos(true);
							
						}
						
					}
					
					
				} catch (BancoException e1) {
					
					JOptionPane.showMessageDialog(
							null, e1.getMessage(), 
							"Cadastrar Cliente", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		btnProcurar.setBounds(319, 38, 117, 25);
		add(btnProcurar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					fachada.removerCliente(cpfTxt.getText());
					int escolha = JOptionPane.showConfirmDialog(
							null, "Deseja realmente remover? ", "Remover Cliente", JOptionPane.YES_NO_OPTION);
					
					if(escolha == JOptionPane.YES_OPTION){
						
						limparCampos();
						habilitarDesabilitarCampos(false);
						
					}
				} catch (BancoException e) {
					
					JOptionPane.showMessageDialog(
							null, e.getMessage(), 
							"Remover Cliente", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		btnRemover.setEnabled(false);
		btnRemover.setBounds(460, 38, 117, 25);
		add(btnRemover);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = cpfTxt.getText();
				String nome = nomeTxt.getText();
				String email = emailTxt.getText();
				
				String login = loginTxt.getText();
				String senha = new String(senhaTxt.getPassword());
				String telefone = telefoneTxt.getText();
				String dataNascimento = dataNascimentoTxt.getText();
				
				try {
					
					LocalDate dataNascimentoDate = 
							DateUtil.converterTextoData(dataNascimento);
					
					String logradouro = logradouroTxt.getText();
					String numero = numeroTxt.getText();
					String complemento = complementoTxt.getText();
					String bairro = bairroTxt.getText();
					String cidade = cidadeTxt.getText();
					String cep = cepTxt.getText();
					String uf = (String)ufCb.getSelectedItem();
					
					Endereco end = new Endereco();
					end.setLogradouro(logradouro);
					end.setNumero(numero);
					end.setComplemento(complemento);
					end.setBairro(bairro);
					end.setCidade(cidade);
					end.setCep(cep);
					end.setUf(uf);
					
				
					Cliente cliente = fachada.procurar(cpf);
					
					if(cliente != null){
						cliente.setCpf(cpf);
						cliente.setNome(nome);
						cliente.setDataNascimento(dataNascimentoDate);
						cliente.setLogin(login);
						cliente.setSenha(senha);
						cliente.setEmail(email);
						cliente.setTelefone(telefone);
						
						cliente.setEndereco(end);
						
						
						fachada.atualizarCliente(cliente);
						
						JOptionPane.showMessageDialog(
								null, "Cliente atualizado com sucesso", 
								"Cadastrar Cliente", 
								JOptionPane.INFORMATION_MESSAGE);
						
						limparCampos();
						
						btnAtualizar.setEnabled(false);
						btnRemover.setEnabled(false);
						
						habilitarDesabilitarCampos(false);
					}else{
						JOptionPane.showMessageDialog(
								null, "Cliente n�o existe", 
								"Atualizar Cliente", 
								JOptionPane.INFORMATION_MESSAGE);
					}
				
				}catch(BancoException ex) {
					
					JOptionPane.showMessageDialog(
							null, ex.getMessage(), 
							"Atualizar Cliente", JOptionPane.ERROR_MESSAGE);
					
				}catch(DateTimeParseException ex) {
					
					JOptionPane.showMessageDialog(
							null, "Data Inv�lida", 
							"Atualizar Cliente", JOptionPane.ERROR_MESSAGE);
					
				}
				
				
				
			}
		});
		btnAtualizar.setEnabled(false);
		btnAtualizar.setBounds(438, 487, 117, 25);
		add(btnAtualizar);
		
		lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setEnabled(false);
		lblDataNascimento.setBounds(324, 226, 133, 15);
		add(lblDataNascimento);
		
		dataNascimentoTxt = new JTextField();
		dataNascimentoTxt.setEnabled(false);
		dataNascimentoTxt.setBounds(463, 224, 114, 19);
		add(dataNascimentoTxt);
		dataNascimentoTxt.setColumns(10);

	}
	
	private void habilitarDesabilitarCampos(boolean habilitar){
		
		nomeTxt.setEnabled(habilitar);
		emailTxt.setEnabled(habilitar);
		loginTxt.setEnabled(habilitar);
		senhaTxt.setEnabled(habilitar);
		telefoneTxt.setEnabled(habilitar);
		dataNascimentoTxt.setEnabled(habilitar);
		
		logradouroTxt.setEnabled(habilitar);
		numeroTxt.setEnabled(habilitar);
		complementoTxt.setEnabled(habilitar);
		cepTxt.setEnabled(habilitar);
		cidadeTxt.setEnabled(habilitar);
		bairroTxt.setEnabled(habilitar);
		ufCb.setEnabled(habilitar);
		
		lblNome.setEnabled(habilitar);
		lblLogin.setEnabled(habilitar);
		lblSenha.setEnabled(habilitar);
		lblEmail.setEnabled(habilitar);
		lblTelefone.setEnabled(habilitar);
		lblDataNascimento.setEnabled(habilitar);
		lblLogradouro.setEnabled(habilitar);
		lblNmero.setEnabled(habilitar);;
		lblBairro.setEnabled(habilitar);;
		lblCidade.setEnabled(habilitar);;
		lblComplemento.setEnabled(habilitar);;
		lblCep.setEnabled(habilitar);;
		lblUf.setEnabled(habilitar);;
		
		btnCadastrar.setEnabled(habilitar);
		
	}
	
	
	private void limparCampos(){
		cpfTxt.setText("");
		nomeTxt.setText("");
		emailTxt.setText("");
		loginTxt.setText("");
		senhaTxt.setText("");
		telefoneTxt.setText("");
		dataNascimentoTxt.setText("");
		
		logradouroTxt.setText("");
		numeroTxt.setText("");
		complementoTxt.setText("");
		cepTxt.setText("");
		cidadeTxt.setText("");
		bairroTxt.setText("");
		ufCb.setSelectedItem("");
	}
}
