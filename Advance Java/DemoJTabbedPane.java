import javax.swing.*;
import java.awt.*;

class DemoJTabbedPane extends JFrame {

	JTabbedPane jtp;

	DemoJTabbedPane(){
		setTitle("Tabbed Pane");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jtp = new JTabbedPane();

		jtp.addTab("Label 1", new JLabel("Label 1",JLabel.CENTER));
		jtp.addTab("Label 2", new JLabel("Label 2",JLabel.CENTER));

		add(jtp);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new DemoJTabbedPane();
	}
}