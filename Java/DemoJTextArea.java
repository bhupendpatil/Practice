import javax.swing.*;
import java.awt.*;

class DemoJTextArea extends JFrame {

	JTextArea ta1;

	DemoJTextArea(){
		setTitle("Text Area");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		ta1 = new JTextArea(20,20);
		add(ta1);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String args[]){
		new DemoJTextArea();
	}

}