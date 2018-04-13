/*
An application using JScrollPane component
 */

import javax.swing.*;
import java.awt.*;

public class ScrollPane2 extends JFrame {
    
    ScrollPane2(){
        setTitle("Scroll Pane");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(20,20));
        
        for(int i=0;i<=1000;i++){
            panel.add(new JLabel(""+i));
        }
        
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
        
        JScrollPane sp = new JScrollPane(panel, v, h);
        
        add(sp,BorderLayout.CENTER);
        
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args){
        new ScrollPane2();
    }
}
