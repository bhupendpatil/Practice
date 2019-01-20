import javax.swing.*;
import java.awt.*;

class InternalFrame extends JFrame{

	JInternalFrame jif;

	InternalFrame(){
		setTitle("Internal Frame");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jif = new JInternalFrame("Internal Frame",true,true,true,true);
		jif.setSize(100,200);
		jif.setVisible(true);

		add(jif);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args){
		new InternalFrame();
	}

}