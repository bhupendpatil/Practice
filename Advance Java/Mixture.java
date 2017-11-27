//Write a program containing Button, TextField, menu, date time.

import javax.swing.*;
import java.awt.*;

class Mixture extends JFrame {
	
	JButton b1;
	JTextField t1;
	JMenuBar mb;
	JMenu a,b,c;
	JMenuItem a1,a2,b3,c1,c2,c3;
	JPanel panel,datepanel,timepanel;
	JLabel date, time;
	JComboBox day,month,year,hours,mins;


	Mixture() {
		setTitle("Mix");
		setSize(600,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//menu
		mb = new JMenuBar();
		a = new JMenu("A");
		b = new JMenu("B");
		c = new JMenu("C");
		a1 = new JMenuItem("1");
		a2 = new JMenuItem("2");
		b3 = new JMenuItem("3");
		c1 = new JMenuItem("1");
		c2 = new JMenuItem("2");
		c3 = new JMenuItem("3");

		a.add(a1);
		a.add(a2);
		b.add(b3);
		c.add(c1);
		c.add(c2);
		c.add(c3);

		mb.add(a);
		mb.add(b);
		mb.add(c);

		//textfield
		t1 = new JTextField(20);
		t1.setText("Demo TextField");

		//button
		b1 = new JButton("OK");

		//Date and time
		panel = new JPanel(new FlowLayout());
		datepanel = new JPanel(new FlowLayout());
		timepanel = new JPanel(new FlowLayout()); 
		date = new JLabel("Date");
		time = new JLabel("Time");

		day = new JComboBox();
		for(int i=1;i<=31;i++)
			day.addItem(i);
		
		month = new JComboBox();
		for(int i=1;i<=12;i++)
			month.addItem(i);
		
		year = new JComboBox();
		for(int i=1950;i<=2018;i++)
			year.addItem(i);
		
		hours = new JComboBox();
		for(int i=0;i<=23;i++)
			hours.addItem(i);
		
		mins = new JComboBox();
		for(int i=0;i<=59;i++)
			mins.addItem(i);

		datepanel.add(date);
		datepanel.add(day);
		datepanel.add(month);
		datepanel.add(year);

		timepanel.add(time);
		timepanel.add(hours);
		timepanel.add(mins);

		panel.add(datepanel);
		panel.add(timepanel);


		//adding
		add(mb,BorderLayout.NORTH);
		add(t1,BorderLayout.EAST);
		add(panel,BorderLayout.WEST);
		add(b1,BorderLayout.SOUTH);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String args[]) {
		new Mixture();
	}
}