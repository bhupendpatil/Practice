import javax.swing.*;
import java.awt.*;

class DemoJTree extends JFrame {

	JTree tree;

	DemoJTree(){
		setTitle("Tree");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Object[] a = {"Okaay", "Nothing", "Bye"};
		
		tree = new JTree(a);

		add(tree);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new DemoJTree();
	}
}