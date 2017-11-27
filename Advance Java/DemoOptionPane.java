import javax.swing.*;

class DemoOptionPane extends JFrame {
	
	JOptionPane op;

	DemoOptionPane(){

		op = new JOptionPane();

		op.showInputDialog(new JFrame(),"This is message box","Error",JOptionPane.ERROR_MESSAGE);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]){
		new DemoOptionPane();
	}
}