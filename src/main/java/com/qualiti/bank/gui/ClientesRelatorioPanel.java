package com.qualiti.bank.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.facade.IFachada;

@Component
@Scope("prototype")
public class ClientesRelatorioPanel extends JPanel {
	
	@Autowired
	private IFachada fachada;
	private JButton btnGerarRelatorio;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public ClientesRelatorioPanel() {
		setLayout(null);
		
		btnGerarRelatorio = new JButton("Gerar Relatório");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String relatorio;
				try {
					relatorio = fachada.nomesClienteOrdemAlfabetica();
					textArea.setText(relatorio);
				} catch (BancoException e) {
					
					e.printStackTrace();
				}
				
				
			}
		});
		btnGerarRelatorio.setBounds(96, 11, 111, 23);
		add(btnGerarRelatorio);
		
		textArea = new JTextArea();
		textArea.setBounds(60, 45, 324, 225);
		add(textArea);

	}
}
