//Contains Logical Errors

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener {
	
	JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAC, bPlus_Minus, bPercent, bdivide, bMultiply, bPlus, bMinus, bDot, bEqual;
	JTextField input;
	JPanel panel;
	String inp="",ch="";
	double a=0.0, b=0.0;

	Calculator() {
		setSize(233,323);
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		input = new JTextField();
		input.setColumns(10);
		input.setEnabled(false);
		input.setHorizontalAlignment(JTextField.RIGHT);
		input.setFont(new Font("Bookman Old Style", Font.BOLD,25));

		
		b0 = new JButton("0");
		b0.addActionListener(this);
		b1 = new JButton("1");
		b1.addActionListener(this); 
		b2 = new JButton("2");
		b2.addActionListener(this);
		b3 = new JButton("3");
		b3.addActionListener(this);
		b4 = new JButton("4");
		b4.addActionListener(this);
		b5 = new JButton("5");
		b5.addActionListener(this);
		b6 = new JButton("6");
		b6.addActionListener(this);
		b7 = new JButton("7");
		b7.addActionListener(this);
		b8 = new JButton("8");
		b8.addActionListener(this);
		b9 = new JButton("9");
		b9.addActionListener(this);

		bAC = new JButton("AC");
		bAC.addActionListener(this);
		bPlus_Minus = new JButton("±");
		bPlus_Minus.addActionListener(this);
		bPercent = new JButton("%");
		bPercent.addActionListener(this);
		bdivide = new JButton("÷");
		bdivide.addActionListener(this);
		bMultiply = new JButton("x");
		bMultiply.addActionListener(this);
		bPlus = new JButton("+");
		bPlus.addActionListener(this);
		bMinus = new JButton("-");
		bMinus.addActionListener(this);
		bDot = new JButton(".");
		bDot.addActionListener(this);
		bEqual = new JButton("=");
		bEqual.addActionListener(this);

		panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 100;
        	gbc.weighty = 100;
      	
      		gbc.gridy =	0;
        	gbc.gridx = 0;
        	gbc.gridwidth = 4;
        	panel.add(input, gbc);

        	gbc.gridwidth = 1;
      		gbc.gridy = 1;

      		gbc.gridx = 0;
      		panel.add(bAC,gbc);
      		gbc.gridx = 1;
		panel.add(bPlus_Minus,gbc);
		gbc.gridx = 2;
		panel.add(bPercent,gbc);
		gbc.gridx = 3;
		panel.add(bdivide,gbc);

		gbc.gridy = 2;

		gbc.gridx = 0;
		panel.add(b7,gbc);
		gbc.gridx = 1;
		panel.add(b8,gbc);
		gbc.gridx = 2;
		panel.add(b9,gbc);
		gbc.gridx = 3;
		panel.add(bMultiply,gbc);

		gbc.gridy = 3;

		gbc.gridx = 0;
		panel.add(b4,gbc);
		gbc.gridx = 1;
		panel.add(b5,gbc);
		gbc.gridx = 2;
		panel.add(b6,gbc);
		gbc.gridx = 3;
		panel.add(bMinus,gbc);

		gbc.gridy = 4;

		gbc.gridx = 0;
		panel.add(b1,gbc);
		gbc.gridx = 1;
		panel.add(b2,gbc);
		gbc.gridx = 2;
		panel.add(b3,gbc);
		gbc.gridx = 3;
		panel.add(bPlus,gbc);

		gbc.gridy = 5;

		gbc.gridx = 0;
		gbc.gridwidth = 2;
		panel.add(b0,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		panel.add(bDot,gbc);
		gbc.gridx = 3;
		panel.add(bEqual,gbc);

		add(panel, BorderLayout.CENTER);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==b0) {
			inp=inp+"0";
			input.setText(inp);
			bAC.setText("C");
		}

		if (ae.getSource()==b1) {
			inp=inp+"1";
			input.setText(inp);
			bAC.setText("C");
		}

		if (ae.getSource()==b2) {
			inp=inp+"2";
			input.setText(inp);
			bAC.setText("C");
		}

		if (ae.getSource()==b3) {
			inp=inp+"3";
			input.setText(inp);
			bAC.setText("C");
		}

		if (ae.getSource()==b4) {
			inp=inp+"4";
			input.setText(inp);
			bAC.setText("C");
		}

		if (ae.getSource()==b5) {
			inp=inp+"5";
			input.setText(inp);
			bAC.setText("C");
		}

		if (ae.getSource()==b6) {
			inp=inp+"6";
			input.setText(inp);
			bAC.setText("C");
		}

		if (ae.getSource()==b7) {
			inp=inp+"7";
			input.setText(inp);
			bAC.setText("C");
		}

		if (ae.getSource()==b8) {
			inp=inp+"8";
			input.setText(inp);
			bAC.setText("C");
		}

		if (ae.getSource()==b9) {
			inp=inp+"9";
			input.setText(inp);
			bAC.setText("C");
		}

		if (ae.getSource()==bAC) {
			if (bAC.getText()=="C") {
				inp="";
				input.setText(inp);
				bAC.setText("AC");
			}
			if (bAC.getText()=="AC") {
				inp="";
				ch="";
				a=0.0;
				b=0.0;
				input.setText(inp);
				bAC.setText("AC");
			}
		}

		if (ae.getSource()==bPlus_Minus) {
			a = Double.parseDouble(inp);
			if (a > 0) {
				inp = ""+inp;
				input.setText(inp);
			}
			if (a < 0) {
				inp = "-"+inp;
				input.setText(inp);
			}
			if (a == 0) {
				inp = inp;
				input.setText(inp);
			}
		}

		if (ae.getSource()==bPercent) {
			a = Double.parseDouble(inp);
			inp = ""+a/100;
			input.setText(inp);
		}

		if (ae.getSource()==bdivide) {
			a = Double.parseDouble(inp);
			inp = "";
			input.setText(inp);
			ch = "/";
		}

		if (ae.getSource()==bMultiply) {
			a = Double.parseDouble(inp);
			inp = "";
			input.setText(inp);
			ch = "*";
		}

		if (ae.getSource()==bPlus) {
			a = Double.parseDouble(inp);
			inp = "";
			input.setText(inp);
			ch = "+";
		}

		if (ae.getSource()==bMinus) {
			a = Double.parseDouble(inp);
			inp = "";
			input.setText(inp);
			ch = "-";
		}

		if (ae.getSource()==bDot) {
			String arr[] = inp.split("");
			int c = 0;
			for(int i=0;i<arr.length;i++){
				if (arr[i].equals(".")) {
					c=c+1;
				}
			}
			if (c == 0) {
				inp=inp+".";
				input.setText(inp);
				bAC.setText("C");
			}
		}

		if (ae.getSource()==bEqual) {
			b = Double.parseDouble(inp);
			if (ch.equals("+")) {
				inp=""+(a+b);
				input.setText(inp);
			}
			if (ch.equals("-")) {
				inp=""+(a-b);
				input.setText(inp);
			}
			if (ch.equals("*")) {
				inp=""+(a*b);
				input.setText(inp);
			}
			if (ch.equals("/")) {
				inp=""+(a/b);
				input.setText(inp);
			}
		}

	}

	public static void main(String[] args) {
		new Calculator();
	}
}
