/*
An application that will have a text area and a button. 
On click of button Color Dialog Box will be shown. 
The color selected by the user will be applied to the foreground
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChooser5 extends JFrame implements ActionListener {
    
    JTextArea ta;
    JButton b,c;
    Color color1, color2;
    JPanel panel;
    
    ColorChooser5(){
        setTitle("Color Chooser");
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        ta = new JTextArea(25,50);
        b = new JButton("Foreground Color");
        b.addActionListener(this);
        c = new JButton("Background Color");
        c.addActionListener(this);
        
        panel = new JPanel(new FlowLayout());
        
        
        add(ta);
        panel.add(b);
        panel.add(c);
        add(panel);
        
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b){
            color1 = JColorChooser.showDialog(this,"Select a Color for TextArea foreground", color1);
            if(color1!=null){
                ta.setForeground(color1);
            }
        }
        
        if(ae.getSource()==c){
            color2 = JColorChooser.showDialog(this,"Select a Color for TextArea background", color2);
            if(color2!=null){
                ta.setBackground(color2);
            }
        }
        
    }
    
    public static void main(String[] args){
        new ColorChooser5();
    }
}
