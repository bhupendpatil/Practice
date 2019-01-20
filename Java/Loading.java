import javax.swing.*;
import java.awt.*;

class Loading extends JWindow {
	Thread t;
	JProgressBar progB;

	Loading() {
		setSize(300, 40);
		
		progB = new JProgressBar();

		progB.setStringPainted(true);

		add(progB);
		setLocationRelativeTo(null);
		setVisible(true);

		int i = 0;
		while(i<=100){
			try {
				progB.setValue(i);
				i = i + 1;
				t.sleep(100);
			} catch(Exception e) {}
			if(i==100)
				setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Loading();
	}
}
