import javax.swing.*;
import java.awt.event.*;

class DemoWindowEvent extends JFrame implements WindowListener {

	DemoWindowEvent(){
		setTitle("Windows Event");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		addWindowListener(this);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void windowActivated(WindowEvent we){
		System.out.println("Active");
	}
	public void windowDeactivated(WindowEvent we){}
	public void windowOpened(WindowEvent we){}
	public void windowClosed(WindowEvent we){}
	public void windowClosing(WindowEvent we){}
	public void windowIconified(WindowEvent we){}
	public void windowDeiconified(WindowEvent we){}

	public static void main(String[] args){
		new DemoWindowEvent();
	}
}