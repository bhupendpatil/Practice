import javax.swing.*;
import java.awt.*;

class DemoJColorChooser extends JColorChooser {

	DemoJColorChooser(){
		showDialog(null, "Title", Color.red);
	}

	public static void main(String[] args) {
		new DemoJColorChooser();
	}
}
