/*
An application using JTable component.
 */

import javax.swing.*;

public class Table6 extends JFrame {
    
    JTable t;
    JScrollPane sp;
    
    Table6(){
        setTitle("Table");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        String[] head = {"Roll no","Name"};
        String[][] data = {{"1","ABC"},
                            {"2","DEF"},
                            {"3","HIJ"}};
        
        t = new JTable(data,head);
        sp = new JScrollPane(t);
        
        add(sp);
        
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args){
        new Table6();
    }
}   
