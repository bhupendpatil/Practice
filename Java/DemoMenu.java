import javax.swing.*;

class DemoMenu extends JFrame {
	
	JMenuBar mb;
	JMenu a, b, c;
	JMenuItem a1,a2,b1,c1,c2,c3;

	DemoMenu() {
		setTitle("Menu");
		setSize(500,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		mb = new JMenuBar();

		a = new JMenu("A");
		b = new JMenu("B");
		c = new JMenu("C");


		a1 = new JMenuItem("1");
		a2 = new JMenuItem("2");

		b1 = new JMenuItem("1");

		c1 = new JMenuItem("1");
		c2 = new JMenuItem("2");
		c3 = new JMenuItem("3");


		a.add(a1);
		a.add(a2);

		b.add(b1);

		c.add(c1);
		c.add(c2);
		c.add(c3);

		mb.add(a);
		mb.add(b);
		mb.add(c);

		add(mb);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String agrs[]) {
		new DemoMenu();
	}
}