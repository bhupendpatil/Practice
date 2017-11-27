import javax.swing.*;
import java.awt.event.*;

class DemoKeyEvent extends JFrame implements KeyListener {

	JTextField l;

	DemoKeyEvent(){
		setTitle("Key Event");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		l = new JTextField(30);
		l.addKeyListener(this);

		add(l);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void keyPressed(KeyEvent ke){
		l.setText("Key Pressed");
	}
	public void keyReleased(KeyEvent ke){
		l.setText("Key Released");
	}
	public void keyTyped(KeyEvent ke){
		l.setText("Key Typed");
	}

	public static void main(String[] args){
		new DemoKeyEvent();
	}

}