import javax.swing.*;
import java.awt.*;

class Panel extends JFrame {

	JPanel panel;

	Panel(){
		setSize(100,100);
		setTitle("Panel");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel = new JPanel(new FlowLayout());

		panel.add(new JButton("OK"));
		panel.add(new JButton("Bye"));

		add(panel);

		setVisible(true);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new Panel();
	}

}