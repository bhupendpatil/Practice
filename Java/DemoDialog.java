import javax.swing.*;
import java.awt.*;

class DemoDialog extends JFrame {

	JDialog d;

	DemoDialog(){
		setTitle("Dialog");
		setSize(200,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		d = new JDialog(this,"Frame");
		d.setLayout(new FlowLayout());
		d.setSize(100,100);
		d.add(new JLabel("Okay?"));
		d.setVisible(true);
		d.setLocationRelativeTo(null);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new DemoDialog();
	}
}