import javax.swing.*;
import java.awt.*;

class ComboBox extends JFrame {

	JComboBox number;

	ComboBox(){
		setSize(300,100);
		setTitle("Combo Box");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		add(new JLabel("Select your Fav number"));

		number = new JComboBox();
		for(int i=1;i<=10;i++)
			number.addItem(i);

		add(number);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new ComboBox();
	}

}