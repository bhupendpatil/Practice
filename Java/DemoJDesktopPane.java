import javax.swing.*;
import java.awt.*;

class DemoJDesktopPane extends JFrame {

	JDesktopPane dp;
	JInternalFrame i;

	DemoJDesktopPane(){
		setTitle("Desktop Pane");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		dp = new JDesktopPane();
		i = new JInternalFrame("Internal Frame", true, true, true, true);
		i.setSize(100,100);
		i.setVisible(true);
		dp.add(i);

		add(dp);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new DemoJDesktopPane();
	}

}