import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DemoMouseEvent extends JFrame implements MouseListener, MouseMotionListener {

	JLabel lTop,lLow;

	DemoMouseEvent(){
		setTitle("Mouse Event");
		setSize(300,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		lTop = new JLabel("BABE move cursor here!!!");
		lTop.addMouseMotionListener(this);

		lLow = new JLabel("This will change!!!*move here too* xD");
		lLow.addMouseListener(this);

		add(lTop,BorderLayout.NORTH);
		add(lLow,BorderLayout.SOUTH);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){
		lLow.setText("Changed?");
	}
	public void mouseExited(MouseEvent me){
		lLow.setText("This will change!!!*move here too* xD");
		lTop.setText("Babe move cursor here!!!");
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseDragged(MouseEvent me){}
	public void mouseMoved(MouseEvent me){
		lTop.setText("You Babe? Ooh Really?! xD");
	}

	public static void main(String[] args){
		new DemoMouseEvent();
	}
}