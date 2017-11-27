import javax.swing.*;
import java.awt.*;

class Add extends JPanel {
	
	JLabel l1,l2;
	JTextField t1, t2;
	JButton b1, b2;

	Add() {
		l1 = new JLabel("Enter First Number");
		l2 = new JLabel("Enter Second Number");
		
		t1 = new JTextField(10);
		t2 = new JTextField(10);

		b1 = new JButton("ADD");
		b2 = new JButton("Clear");

		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b1);
		add(b2);
	}
}

class Subt extends JPanel {
	
	JLabel l1,l2;
	JTextField t1, t2;
	JButton b1, b2;

	Subt() {
		l1 = new JLabel("Enter First Number");
		l2 = new JLabel("Enter Second Number");
		
		t1 = new JTextField(10);
		t2 = new JTextField(10);

		b1 = new JButton("SUBTRACT");
		b2 = new JButton("Clear");

		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b1);
		add(b2);
	}
}

class TabbedPane extends JFrame {

	JTabbedPane jtp;

	TabbedPane() {
		setSize(500,300);
		setTitle("Tabbed Pane");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jtp = new JTabbedPane(JTabbedPane.TOP);

		jtp.add("First", new Add());
		jtp.add("Second", new Subt());
		
		add(jtp);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TabbedPane();
	}
}