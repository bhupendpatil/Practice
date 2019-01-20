import javax.swing.*;


class TextAndPasswordFieldJ extends JFrame {
	
	JLabel l1, l2;
	JTextField t1;
	JPasswordField p1;
	JPanel panel;

	TextAndPasswordFieldJ() {
		setSize(300,200);
		setTitle("TextField");
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		l1 = new JLabel("Username");
		t1 = new JTextField();
		t1.setColumns(20);

		l2 = new JLabel("Password");
		p1 = new JPasswordField();
		p1.setColumns(20);

		panel = new JPanel();

		panel.add(l1);
		panel.add(t1);

		panel.add(l2);
		panel.add(p1);

		add(panel);

		setLocationRelativeTo(null); 
		setVisible(true);

	}

	public static void main(String[] args) {
		new TextAndPasswordFieldJ();
	}
}