import javax.swing.*;
import java.awt.*;

class DemoSplitPane extends JFrame {

	JSplitPane sp;

	DemoSplitPane(){
		setTitle("Split Pane");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JLabel("Left", JLabel.CENTER), new JLabel("Right", JLabel.CENTER));

		add(sp);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args){
		new DemoSplitPane();
	}
}