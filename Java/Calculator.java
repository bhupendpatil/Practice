import java.awt.*;
import javax.swing.*;

class Calculator extends JFrame{
	JLabel display;
	JButton bMC, bMR, bMS, bMPlus, bMMinus, bBack, bCE, bC, bPlusMinus, bRoot, b7, b8, b9, bSlash, bPercent, b4, b5, b6, bStar, bOneByX, b1, b2, b3, bMinus, b0, bDot, bPlus, bEqual;
	
	Calculator(){
		setTitle("Calculator");
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new FlowLayout());
		display = new JLabel("Enter your problem..");

		bMC = new JButton("MC");
		bMR = new JButton("MR");
		bMS = new JButton("MS"); 
		bMPlus = new JButton("M+");
		bMMinus = new JButton("M-");
		bBack = new JButton("<-");
		bCE = new JButton("CE");
		bC = new JButton("C");
		bPlusMinus = new JButton("+/-");
		bRoot = new JButton("Root");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bSlash = new JButton("/"); 
		bPercent = new JButton("%");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		bStar = new JButton("*");
		bOneByX = new JButton("1/x");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		bMinus = new JButton("-");
		b0 = new JButton("0");
		bDot = new JButton(".");
		bPlus = new JButton("+");
		bEqual = new JButton("=");

		JPanel jp = new JPanel(new GridLayout(6,5));
		//jp.add(display);

		jp.add(bMC);
		jp.add(bMR);
		jp.add(bMS);
		jp.add(bMPlus);
		jp.add(bMMinus);
		jp.add(bBack);
		jp.add(bCE);
		jp.add(bC);
		jp.add(bPlusMinus);
		jp.add(bRoot);
		jp.add(b7);
		jp.add(b8);
		jp.add(b9);
		jp.add(bSlash);
		jp.add(bPercent);
		jp.add(b4);
		jp.add(b5);
		jp.add(b6);
		jp.add(bStar);
		jp.add(bOneByX);
		jp.add(b1);
		jp.add(b2);
		jp.add(b3);
		jp.add(bMinus);
		jp.add(b0);
		jp.add(bDot);
		jp.add(bPlus);
		jp.add(bEqual);

		add(jp);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Calculator();
	}
}