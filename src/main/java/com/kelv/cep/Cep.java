package com.kelv.cep;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class Cep extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cepTxt;
	private JTextField endTxt;
	private JTextField bairroTxt;
	private JTextField cidadeTxt;
	private JLabel ufLblNewLabel;
	private JComboBox<String> cboBox;
	/**
	 * Inicio do programa.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cep frame = new Cep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unused")
	private static Object makeObj(final String item) {
		return new Object() {
			public String toString() {
				return item;
			}
		};
	}

	/**
	 * Cronstrutor.
	 */
	public Cep() {
		setResizable(false);
		setTitle("Buscar CEP");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kelvynn.souza\\eclipse-workspace\\BuscarCEP\\src\\main\\java\\com\\kelv\\img\\Search.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * Caixas e campos de entrada e saida.
		 */

		JLabel lblNewLabel = new JLabel("CEP");
		lblNewLabel.setBounds(10, 26, 46, 14);
		contentPane.add(lblNewLabel);

		cepTxt = new JTextField();
		cepTxt.setDocument(new NumeroDocument());
		cepTxt.setBounds(38, 23, 108, 20);
		contentPane.add(cepTxt);
		cepTxt.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Endereço");
		lblNewLabel_1.setBounds(10, 73, 80, 14);
		contentPane.add(lblNewLabel_1);

		endTxt = new JTextField();
		endTxt.setBounds(66, 70, 358, 20);
		contentPane.add(endTxt);
		endTxt.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Bairro");
		lblNewLabel_2.setBounds(21, 123, 46, 14);
		contentPane.add(lblNewLabel_2);

		bairroTxt = new JTextField();
		bairroTxt.setBounds(66, 120, 358, 20);
		contentPane.add(bairroTxt);
		bairroTxt.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Cidade");
		lblNewLabel_3.setBounds(21, 178, 46, 14);
		contentPane.add(lblNewLabel_3);

		cidadeTxt = new JTextField();
		cidadeTxt.setBounds(66, 175, 239, 20);
		contentPane.add(cidadeTxt);
		cidadeTxt.setColumns(10);

		ufLblNewLabel = new JLabel("UF");
		ufLblNewLabel.setBounds(315, 178, 46, 14);
		contentPane.add(ufLblNewLabel);

		cboBox = new JComboBox<>();
		cboBox.setModel(new DefaultComboBoxModel<>(new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
				"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

		cboBox.setBounds(355, 174, 60, 22);
		cboBox.setSelectedIndex(0);
		contentPane.add(cboBox);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(21, 227, 89, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cepTxt.setText("");
				endTxt.setText("");
				bairroTxt.setText("");
				cidadeTxt.setText("");
				cboBox.setSelectedIndex(0);
			}
		});
		contentPane.add(btnLimpar);

		JButton btnCep = new JButton("Buscar");
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cepSize = (cepTxt.getText().split("")).length;
				if (cepSize < 8) {
					JOptionPane.showMessageDialog(null, "É necessário CEP ter 8 números!");
					cepTxt.requestFocus();
				} else {
					buscarCep(cboBox);
				}
			}
		});
		btnCep.setBounds(172, 22, 89, 23);
		contentPane.add(btnCep);

		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnSobre.setIcon(new ImageIcon("C:\\Users\\kelvynn.souza\\eclipse-workspace\\BuscarCEP\\src\\main\\java\\com\\kelv\\img\\Info.png"));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(SystemColor.control);
		btnSobre.setBounds(376, 11, 48, 48);
		contentPane.add(btnSobre);

	}

	private void buscarCep(JComboBox cboBox) {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = cepTxt.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep="+ cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					cidadeTxt.setText(element.getText());
						}
				if (element.getQualifiedName().equals("bairro")) {
					bairroTxt.setText(element.getText());
						}
				if (element.getQualifiedName().equals("uf")) {
				  ComboBoxModel<String> model = cboBox.getModel();
				  int index=0;
        for (int i = 0; i < model.getSize(); i++) {
            if (model.getElementAt(i).equals(element.getText())) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("O índice de " + element.getText() + " é: " + index);
            cboBox.setSelectedIndex(index); // Seleciona o item no JComboBox
        } else {
            System.out.println(element.getText() + " não encontrado no ComboBoxModel.");
        }
    }
					
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado"));
	
			}
			endTxt.setText(tipoLogradouro + " " + logradouro);
		} 
			catch(Exception e) {
			System.out.println(e);
		}
	}
}


