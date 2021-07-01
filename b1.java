package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class b1 implements ActionListener {
	JFrame myFrame;
	JTextField textField;
	JButton[] numButt = new JButton[10];
	JButton[] functionButt = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;


	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	ImageIcon icon = new ImageIcon("w2_1.jpg");
	double num1 = 0, num2 = 0, result = 0;
	char operator;

	b1() {
		myFrame = new JFrame("b1");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(420, 525);
		myFrame.setLayout(null);
		myFrame.getContentPane().setBackground(Color.CYAN);

		textField = new JTextField();
		textField.setBounds(50, 35, 300, 50);
		textField.setFont(myFont);
		textField.setEditable(false);


		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("del");
		clrButton = new JButton("clr");
		negButton = new JButton("(-)");

		functionButt[0] = addButton;
		functionButt[1] = subButton;
		functionButt[2] = mulButton;
		functionButt[3] = divButton;
		functionButt[4] = decButton;
		functionButt[5] = equButton;
		functionButt[6] = delButton;
		functionButt[7] = clrButton;
		functionButt[8] = negButton;

		for (int i = 0; i < 9; i++) {
			functionButt[i].addActionListener(this);
			functionButt[i].setFont(myFont);
			functionButt[i].setFocusable(false);
		}

		for (int i = 0; i < 10; i++) {
			numButt[i] = new JButton(String.valueOf(i));
			numButt[i].addActionListener(this);
			numButt[i].setFont(myFont);
			numButt[i].setFocusable(false);
		}
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(240, 430, 100, 50);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.cyan);

		panel.add(numButt[1]);
		panel.add(numButt[2]);
		panel.add(numButt[3]);
		panel.add(addButton);
		panel.add(numButt[4]);
		panel.add(numButt[5]);
		panel.add(numButt[6]);
		panel.add(subButton);
		panel.add(numButt[7]);
		panel.add(numButt[8]);
		panel.add(numButt[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numButt[0]);
		panel.add(equButton);
		panel.add(divButton);

		myFrame.add(panel);

		myFrame.setIconImage(icon.getImage());
		myFrame.add(negButton);
		myFrame.add(delButton);
		myFrame.add(clrButton);
		myFrame.add(textField);
		myFrame.setVisible(true);

	}

	public static void main(String[] args) {

		new b1();
	}

	public void actionPerformed(ActionEvent e) {
		//show the number to textfield
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numButt[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		//show decimal to textField
		if (e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}
		
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());          	//truyen du lieu vao num1
			operator = '+';												//set operator
			textField.setText("");										//reset lai textfield de nhap num2
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());//lay du lieu num2

			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			default:
				break;
			}
			textField.setText(String.valueOf(result));// show result
			 num1 = result;//dua reslt vao num1 de tiep tuc tinh
		}
		if (e.getSource() == clrButton) {
			textField.setText("");
		}
		if (e.getSource() == delButton) {
			String string = textField.getText();
			textField.setText("");
			for (int i = 0; i < string.length() - 1; i++) {//dung for de xoa chuoi text tren tung i
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
		if (e.getSource() == negButton) {//chuyen so duong sang am
			double temp = Double.parseDouble(textField.getText());//truyen du lieu tu textfield vao temp
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}
	}
}
