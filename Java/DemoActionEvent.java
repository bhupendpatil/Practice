import javax.swing.*;
import java.awt.event.*;

class DemoActionEvent extends JFrame implements ActionListener {

	JButton b;

	DemoActionEvent(){
		setTitle("Action Event");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		b = new JButton("Ok?");
		b.addActionListener(this);

		add(b);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == b){
			b.setText("Bye Now!");
		}
	}

	public static void main(String[] args){
		new DemoActionEvent();
	}

}