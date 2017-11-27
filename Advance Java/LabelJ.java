import javax.swing.*;

class LabelJ extends JFrame {
	
	JLabel l1,l2;
	JPanel panel;

	LabelJ() {
		setSize(300,200);
		setTitle("Label");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		l1 = new JLabel();
		l1.setText("Label 1");

		l2 = new JLabel();
		l2.setIcon(new ImageIcon("img/icon.png"));

		panel = new JPanel();
		panel.add(l1);
		panel.add(l2);

		add(panel);

		setLocationRelativeTo(null); 
		setVisible(true);
	}

	public static void main(String[] args) {
		new LabelJ();
	}
}