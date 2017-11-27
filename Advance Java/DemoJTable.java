import javax.swing.*;
import java.awt.*;

class DemoJTable extends JFrame{
	
	JTable t;
	JScrollPane sp;

	DemoJTable(){
		setTitle("Table");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		String[] head = {"Name","Roll no"};
		Object[][] data = {
			{"ABC","1"},
			{"DEF", "2"},
			{"HIJ", "3"}
		};

		t = new JTable(data,head);

		sp = new JScrollPane(t);

		add(sp);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new DemoJTable();
	}
}