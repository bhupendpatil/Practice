import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DemoSignin extends JFrame implements ActionListener {

	JLabel l1, l2, l3;
	JTextField t1;
	JPasswordField p1;
	JButton b1,b2;
	JPanel panel1, panel2, panel3;

	DemoSignin() {
		setSize(500,150);
		setTitle("Demo Signup");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		l1 = new JLabel("Username");
		t1 = new JTextField(20);

		l2 = new JLabel("Password");
		p1 = new JPasswordField(20);

		b1= new JButton("OK");
		b1.addActionListener(this);

		b2= new JButton("Clear");
		b2.addActionListener(this);

		l3 = new JLabel("");

		panel1 = new JPanel(new GridLayout(3,2));

		panel1.add(l1);
		panel1.add(t1);
		panel1.add(new JLabel(""));
		panel1.add(new JLabel(""));
		panel1.add(l2);
		panel1.add(p1);
		
		panel2 = new JPanel();
		panel2.add(b1);
		panel2.add(b2);

		panel3 = new JPanel();
		panel3.add(l3);

		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource()==b1){
			char[] password = p1.getPassword();

			String passwordstr = new String(password);

			if((t1.getText()).equals("admin") && passwordstr.equals("abc123")){
				l3.setText("Success!!!");
			}
			else {
				l3.setText("Try Again");
			}
		}

		if (ae.getSource()==b2) {
			t1.setText("");
			p1.setText("");
			l3.setText("");
		}
	}

	public static void main(String[] args) {
		new DemoSignin();
	}
}
