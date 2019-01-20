import javax.swing.*;
import java.awt.*;

class SplitPane extends JFrame {
	
	JSplitPane jp2;

	SplitPane() {
		setSize(500,400);
		setTitle("Split Pane");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JLabel("Left", JLabel.CENTER), new JLabel("Right", JLabel.CENTER));

		add(jp2);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SplitPane();
	}
}