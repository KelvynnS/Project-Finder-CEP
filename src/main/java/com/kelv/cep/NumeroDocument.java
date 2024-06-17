package com.kelv.cep;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumeroDocument extends PlainDocument {

   
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        // Verificar se todos os caracteres são números
        if (str.chars().allMatch(Character::isDigit)) {
            super.insertString(offset, str, attr);
        }
    }

    public static void main(String[] args) {
        // Criar a janela principal
        JFrame frame = new JFrame("Exemplo JTextField Aceita Apenas Números");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        // Criar o JTextField e definir o documento personalizado
        JTextField textField = new JTextField();
        textField.setDocument(new NumeroDocument());

        // Adicionar o JTextField à janela
        frame.getContentPane().add(textField);

        // Exibir a janela
        frame.setVisible(true);
        
		}
    }
