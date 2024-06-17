package com.kelv.cep;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Sobre() {
		setModal(true);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kelvynn.souza\\eclipse-workspace\\BuscarCEP\\src\\main\\java\\com\\kelv\\img\\Home.png"));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar CEP - Version 1.0");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setBounds(10, 11, 172, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("By - Kelvynn S. Pereira");
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setBounds(10, 54, 172, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Web Services:");
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_2.setBounds(10, 95, 158, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblWebService = new JLabel("www.republicavirtual.com.br");
		lblWebService.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				link("https://www.republicavirtual.com.br/");
			}
		});
		lblWebService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWebService.setForeground(SystemColor.textHighlight);
		lblWebService.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblWebService.setBounds(100, 95, 226, 14);
		getContentPane().add(lblWebService);
		
		JButton btnGit = new JButton("");
		btnGit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link ("https://github.com/KelvynnS/Project-CEP-Finder");
			}
		});
		btnGit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGit.setToolTipText("Projeto");
		btnGit.setContentAreaFilled(false);
		btnGit.setBorderPainted(false);
		btnGit.setIcon(new ImageIcon("C:\\Users\\kelvynn.souza\\eclipse-workspace\\BuscarCEP\\src\\main\\java\\com\\kelv\\img\\github.png"));
		btnGit.setBounds(32, 166, 48, 48);
		getContentPane().add(btnGit);
		
		JButton btnLinkedin = new JButton("");
		btnLinkedin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link ("https://www.linkedin.com/in/kelvynn-s-pereira041/");
			}
		});
		btnLinkedin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLinkedin.setToolTipText("Linkedin");
		btnLinkedin.setContentAreaFilled(false);
		btnLinkedin.setBorderPainted(false);
		btnLinkedin.setIcon(new ImageIcon("C:\\Users\\kelvynn.souza\\eclipse-workspace\\BuscarCEP\\src\\main\\java\\com\\kelv\\img\\linkedin.png"));
		btnLinkedin.setBounds(128, 166, 48, 48);
		getContentPane().add(btnLinkedin);
		
	} //fim do construtor
	
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
