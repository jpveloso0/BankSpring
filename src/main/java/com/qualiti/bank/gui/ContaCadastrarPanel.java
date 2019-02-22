package com.qualiti.bank.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.facade.Fachada;
import com.qualiti.bank.facade.IFachada;
import com.qualiti.bank.model.Cliente;
import com.qualiti.bank.model.Conta;
import com.qualiti.bank.model.ContaBonus;
import com.qualiti.bank.model.Poupanca;
import com.qualiti.bank.model.TipoConta;

@Component
public class ContaCadastrarPanel extends JPanel {
	private JTextField nmeroTxt;
	private JTextField cpfTxt;
	private JLabel lblNmero;
	private JLabel lblCpf;
	private JLabel lblTipo;
	private JButton btnRemover;
	private JButton btnProcurar;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JRadioButton rdbtnCorrente;
	private JRadioButton rdbtnPoupana;
	private JRadioButton rdbtnBnus;
	private JTextField saldoTxt;
	private JLabel lblSaldo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	@Autowired
	private IFachada fachada;
	
	/**
	 * Create the panel.
	 */
	public ContaCadastrarPanel() {
		setLayout(null);
		
		nmeroTxt = new JTextField();
		nmeroTxt.setBounds(97, 33, 124, 20);
		add(nmeroTxt);
		nmeroTxt.setColumns(10);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setEnabled(false);
		lblCpf.setBounds(30, 96, 46, 14);
		add(lblCpf);
		
		lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(30, 36, 46, 14);
		add(lblNmero);
		
		cpfTxt = new JTextField();
		cpfTxt.setEnabled(false);
		cpfTxt.setBounds(97, 93, 124, 20);
		add(cpfTxt);
		cpfTxt.setColumns(10);
		
		lblTipo = new JLabel("Tipo: ");
		lblTipo.setEnabled(false);
		lblTipo.setBounds(30, 155, 46, 14);
		add(lblTipo);
		
		rdbtnCorrente = new JRadioButton("Corrente");
		buttonGroup.add(rdbtnCorrente);
		rdbtnCorrente.setEnabled(false);
		rdbtnCorrente.setSelected(true);
		rdbtnCorrente.setBounds(59, 195, 109, 23);
		add(rdbtnCorrente);
		
		rdbtnPoupana = new JRadioButton("Poupan\u00E7a");
		buttonGroup.add(rdbtnPoupana);
		rdbtnPoupana.setEnabled(false);
		rdbtnPoupana.setBounds(204, 195, 109, 23);
		add(rdbtnPoupana);
		
		rdbtnBnus = new JRadioButton("B\u00F4nus");
		buttonGroup.add(rdbtnBnus);
		rdbtnBnus.setEnabled(false);
		rdbtnBnus.setBounds(315, 195, 109, 23);
		add(rdbtnBnus);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String numero = nmeroTxt.getText();
				String cpf = cpfTxt.getText();
				String saldoTexto = saldoTxt.getText();
				
				TipoConta tipo = null;
				Conta conta = null;
				
				if(rdbtnCorrente.isSelected()){
					tipo = TipoConta.CORRENTE;
					conta = new Conta();
				}
				
				if(rdbtnPoupana.isSelected()){
					tipo = TipoConta.POUPANCA;
					conta = new Poupanca();
				}
				
				if(rdbtnBnus.isSelected()){
					tipo = TipoConta.BONUS;
					conta = new ContaBonus();
				}
				
				try {
					Cliente cliente = fachada.procurar(cpf);
					
					if(cliente != null){
						
						conta.setCliente(cliente);
						conta.setNumero(numero);
						
						double saldo = Double.parseDouble(saldoTexto);
						
						conta.setSaldo(saldo);
						conta.setTipo(tipo);
						
						fachada.inserirConta(conta);
						
						JOptionPane.showMessageDialog(null, "Conta inserida com sucesso", "Cadastrar Conta", 
								JOptionPane.INFORMATION_MESSAGE);
						
						cpfTxt.setText("");
						nmeroTxt.setText("");
						rdbtnCorrente.setSelected(true);
						saldoTxt.setText("");
						
						lblCpf.setEnabled(false);
						lblSaldo.setEnabled(false);
						lblTipo.setEnabled(false);
						
						cpfTxt.setEnabled(false);
						saldoTxt.setEnabled(false);
						
						rdbtnBnus.setEnabled(false);
						rdbtnCorrente.setEnabled(false);
						rdbtnPoupana.setEnabled(false);
						
						btnAtualizar.setEnabled(false);
						btnRemover.setEnabled(false);
						btnCadastrar.setEnabled(false);
						
						
					}else{
						JOptionPane.showMessageDialog(null, "CPF n�o cadastrado", "Cadastrar Conta", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (BancoException e) {	
					JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastrar Conta", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(97, 242, 89, 23);
		add(btnCadastrar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				String numero = nmeroTxt.getText();
				String cpf = cpfTxt.getText();
				String saldoTexto = saldoTxt.getText();
				
				TipoConta tipo = null;
				Conta conta = null;
				
				if(rdbtnCorrente.isSelected()){
					tipo = TipoConta.CORRENTE;
					conta = new Conta();
				}
				
				if(rdbtnPoupana.isSelected()){
					tipo = TipoConta.POUPANCA;
					conta = new Poupanca();
				}
				
				if(rdbtnBnus.isSelected()){
					tipo = TipoConta.BONUS;
					conta = new ContaBonus();
				}
				
				try {
					Cliente cliente = fachada.procurar(cpf);
					
					if(cliente != null){
						
						conta.setCliente(cliente);
						conta.setNumero(numero);
						
						double saldo = Double.parseDouble(saldoTexto);
						
						conta.setSaldo(saldo);
						conta.setTipo(tipo);
						
						fachada.atualizarConta(conta);
						
						JOptionPane.showMessageDialog(null, "Conta atualizada com sucesso", "Atualizar Conta", 
								JOptionPane.INFORMATION_MESSAGE);
						
						cpfTxt.setText("");
						nmeroTxt.setText("");
						rdbtnCorrente.setSelected(true);
						saldoTxt.setText("");
						
						lblCpf.setEnabled(false);
						lblSaldo.setEnabled(false);
						lblTipo.setEnabled(false);
						
						cpfTxt.setEnabled(false);
						saldoTxt.setEnabled(false);
						
						rdbtnBnus.setEnabled(false);
						rdbtnCorrente.setEnabled(false);
						rdbtnPoupana.setEnabled(false);
						
						btnAtualizar.setEnabled(false);
						btnRemover.setEnabled(false);
						btnCadastrar.setEnabled(false);
						
						
					}else{
						JOptionPane.showMessageDialog(null, "CPF n�o atualizado", "Atualizar Conta", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (BancoException e) {	
					JOptionPane.showMessageDialog(null, e.getMessage(), "Atualizar Conta", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnAtualizar.setEnabled(false);
		btnAtualizar.setBounds(239, 242, 89, 23);
		add(btnAtualizar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					fachada.removerConta(nmeroTxt.getText());
					
					int escolha = JOptionPane.showConfirmDialog(null, "Deseja realmente remover a conta? ", "Remover Conta", 
							JOptionPane.YES_NO_OPTION);
					
					if(escolha == JOptionPane.YES_OPTION){
						
						cpfTxt.setText("");
						nmeroTxt.setText("");
						rdbtnCorrente.setSelected(true);
						saldoTxt.setText("");
						
						lblCpf.setEnabled(false);
						lblSaldo.setEnabled(false);
						lblTipo.setEnabled(false);
						
						cpfTxt.setEnabled(false);
						saldoTxt.setEnabled(false);
						
						rdbtnBnus.setEnabled(false);
						rdbtnCorrente.setEnabled(false);
						rdbtnPoupana.setEnabled(false);
						
						btnAtualizar.setEnabled(false);
						btnRemover.setEnabled(false);
						btnCadastrar.setEnabled(false);
						
					}
					
				} catch (BancoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Remover Conta", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnRemover.setEnabled(false);
		btnRemover.setBounds(239, 32, 89, 23);
		add(btnRemover);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String numero = nmeroTxt.getText();
				
				try {
					Conta contaBusca = fachada.procurarConta(numero);
					
					if(contaBusca != null){
						cpfTxt.setText(contaBusca.getCliente().getCpf());
						
						String saldoTexto = Double.toString(contaBusca.getSaldo());
						
						saldoTxt.setText(saldoTexto);
						
						TipoConta tipo = contaBusca.getTipo();
						
						if(tipo.equals(TipoConta.CORRENTE)){
							rdbtnCorrente.setSelected(true);
						}
						
						if(tipo.equals(TipoConta.POUPANCA)){
							rdbtnPoupana.setSelected(true);
						}
						
						if(tipo.equals(TipoConta.BONUS)){
							rdbtnBnus.setSelected(true);
						}
						
						lblCpf.setEnabled(true);
						lblSaldo.setEnabled(true);
						lblTipo.setEnabled(true);
						
						cpfTxt.setEnabled(true);
						saldoTxt.setEnabled(true);
						
						rdbtnBnus.setEnabled(true);
						rdbtnCorrente.setEnabled(true);
						rdbtnPoupana.setEnabled(true);
						
						btnAtualizar.setEnabled(true);
						btnRemover.setEnabled(true);
						btnCadastrar.setEnabled(false);
						
						
					}else{
						
						int escolha = JOptionPane.showConfirmDialog(null, "Conta n�o existe. Deseja cadastrar?", "Cadastrar Conta",
								JOptionPane.YES_NO_OPTION);
						
						if(escolha == JOptionPane.YES_OPTION){
							
							lblCpf.setEnabled(true);
							lblSaldo.setEnabled(true);
							lblTipo.setEnabled(true);
							
							cpfTxt.setEnabled(true);
							saldoTxt.setEnabled(true);
							
							rdbtnBnus.setEnabled(true);
							rdbtnCorrente.setEnabled(true);
							rdbtnPoupana.setEnabled(true);
							
							btnAtualizar.setEnabled(false);
							btnRemover.setEnabled(false);
							btnCadastrar.setEnabled(true);
							
						}
						
					}
					
				} catch (BancoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Procurar Conta", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		btnProcurar.setBounds(351, 32, 89, 23);
		add(btnProcurar);
		
		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setEnabled(false);
		lblSaldo.setBounds(239, 96, 46, 14);
		add(lblSaldo);
		
		saldoTxt = new JTextField();
		saldoTxt.setEnabled(false);
		saldoTxt.setBounds(284, 93, 124, 20);
		add(saldoTxt);
		saldoTxt.setColumns(10);

	}
	
	
	
	
}
