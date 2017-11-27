import javax.swing.*;
import java.awt.*;

class LoginForm extends JFrame {
	
	JLabel l1,l2;
	JTextField t1;
	JPasswordField p1;
	JButton b1, b2;
	JPanel panel;

	LoginForm() {
		setSize(300,200);
		setTitle("Login Form");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel = new JPanel(new GridLayout(3,3));

		l1 = new JLabel("username");
		l2 = new JLabel("password");

		t1 = new JTextField(20);
		p1 = new JPasswordField(20);

		b1 = new JButton("OK");
		b2 = new JButton("Cancel");

		panel.add(l1);
		panel.add(t1);
		panel.add(l2);
		panel.add(p1);
		panel.add(b1);
		panel.add(b2);

		add(panel);

		setVisible(true);
	}

	public static void main(String[] args) {
		new LoginForm();
	}
}