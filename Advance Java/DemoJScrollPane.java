import javax.swing.*;
import java.awt.*;

class DemoJScrollPane extends JFrame {

	JScrollPane sp;

	DemoJScrollPane(){
		setTitle("Scroll Pane");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		sp = new JScrollPane(new JLabel("OKayyy",JLabel.CENTER));

		add(sp);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new DemoJScrollPane();	
	}
}