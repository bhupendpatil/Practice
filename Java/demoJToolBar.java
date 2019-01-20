import javax.swing.*;

class demoJToolBar extends JFrame {
	
	JToolBar toolbar;

	demoJToolBar(){
		setSize(300,300);
		setTitle("JToolBar");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		toolbar = new JToolBar("okay", JToolBar.VERTICAL);

		toolbar.add(new JButton("Noooo"));
		toolbar.add(new JButton("Yesss"));

		add(toolbar);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args){
		new demoJToolBar();
	}
}