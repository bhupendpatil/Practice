import javax.swing.*;
import java.awt.event.*;

class DemoButton extends JFrame implements ActionListener {
	
	JButton b1;

	DemoButton(){
		setTitle("Button");
		setSize(300,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		b1 = new JButton("Click!");
		b1.addActionListener(this);

		add(b1);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae){
		b1.setText("Clicked!");
	}

	public static void main(String args[]){
		new DemoButton();
	}
}