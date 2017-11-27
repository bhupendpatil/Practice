import javax.swing.*;
import java.awt.*;

public class RadioCheck11 extends JFrame {
    
    JLabel l1, l2;
    JRadioButton r1,r2;
    JCheckBox c1, c2;
    JPanel panel1, panel2;
    
    RadioCheck11(){
        setTitle("Demo");
        setSize(200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        l1 = new JLabel("CheckBox");
        l2 = new JLabel("Radio Button");
        
        c1 = new JCheckBox("1");
        c2 = new JCheckBox("2");
        
        r1 = new JRadioButton("1");
        r2 = new JRadioButton("2");
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        
        panel1 = new JPanel(new FlowLayout());
        panel2 = new JPanel(new FlowLayout());
        
        panel1.add(l1);
        panel1.add(c1);
        panel1.add(c2);
        
        panel2.add(l2);
        panel2.add(r1);
        panel2.add(r2);
        
        add(panel1);
        add(panel2);
        
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args){
        new RadioCheck11();
    }
}
