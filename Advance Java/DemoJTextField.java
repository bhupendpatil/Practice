import javax.swing.*;
import java.awt.*;

class DemoJTextField extends JFrame {
	
	JTextField t1;

	DemoJTextField(){
		setTitle("Text Field");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		t1 = new JTextField(10);

		add(t1);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new DemoJTextField();
	}
}