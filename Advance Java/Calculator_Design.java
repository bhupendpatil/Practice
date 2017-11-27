import java.awt.*;
import javax.swing.*;

class Calculator_Design extends JFrame {

	JTextField input;
	JButton zero,one,two,three,four,five,six,seven,eight,nine,plus,minus,mul,div,equ,dec,clear,percent,root,square;

	Calculator_Design(){
		setSize(200,300);
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		input = new JTextField(10);
		input.setEnabled(false);
		input.setHorizontalAlignment(JTextField.RIGHT);
		input.setFont(new Font("Bookman Old Style", Font.BOLD,25));
		
		zero = new JButton("0");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		dec = new JButton(".");

		plus = new JButton("+");
		minus = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		equ = new JButton("=");
		clear = new JButton("C");
		percent = new JButton("%");
		root = new JButton("√");
		square = new JButton("²");

		JPanel p = new JPanel(new GridLayout(5,4));

		p.add(clear);
		p.add(root);
		p.add(square);
		p.add(percent);

		p.add(one);
		p.add(two);
		p.add(three);
		p.add(div);

		p.add(four);
		p.add(five);
		p.add(six);
		p.add(mul);

		p.add(seven);
		p.add(eight);
		p.add(nine);
		p.add(minus);

		p.add(zero);
		p.add(dec);
		p.add(plus);
		p.add(equ);

		add(input, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Calculator_Design();
	}
}