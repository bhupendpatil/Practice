import javax.swing.*;

class DemoJFileChooser extends JFileChooser {

	DemoJFileChooser(){
		showOpenDialog(null);
	}

	public static void main(String[] args) {
		new DemoJFileChooser();
	}
}
