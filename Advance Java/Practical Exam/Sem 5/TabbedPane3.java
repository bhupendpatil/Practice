/*
An application using JTabbedPaane component
 */

import javax.swing.*;
import java.awt.*;

public class TabbedPane3 extends JFrame{
    
    JTabbedPane jtp;
    
    TabbedPane3(){
        setTitle("Tabbed Pane");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jtp = new JTabbedPane();
        
        jtp.addTab("1st", new JLabel("First Tab",JLabel.CENTER));
        jtp.addTab("2nd", new JLabel("Second Tab", JLabel.CENTER));
        jtp.addTab("3rd", new JLabel("Third Tab", JLabel.CENTER));
        
        add(jtp);
        
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args){
        new TabbedPane3();
    }
}
