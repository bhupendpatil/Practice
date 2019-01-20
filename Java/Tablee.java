import javax.swing.*;
import java.awt.*;

class Tablee extends JFrame {
	
	JTable tablee;
	JScrollPane sp;

	Tablee(){
		setSize(400,200);
		setTitle("Table");
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		Object a[] = {"Roll NO", "Name", "Marks"};
		Object b[][] = {{1, "ABC", 40},
						{2, "DEF", 35},
						{3, "GHI", 74},
						{4, "JKL", 80},
						{5, "MNO", 82}};

		tablee = new JTable(b,a);
		sp = new JScrollPane(tablee);

		add(sp);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Tablee();
	}
}