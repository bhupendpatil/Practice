/*
An application to create a login page using swing’s text components.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login1 extends JFrame implements ActionListener {
    
    JLabel uL, pL;
    JTextField ut;
    JPasswordField pt;
    JButton submit, clear;
    
    Login1(){
        setTitle("Login");
        setSize(300,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        uL = new JLabel("username");
        pL = new JLabel("password");
        
        ut = new JTextField(10);
        pt = new JPasswordField(10);
        
        submit = new JButton("submit");
        submit.addActionListener(this);
        clear = new JButton("clear");
        clear.addActionListener(this);
        
        setLayout(new GridLayout(3,3));
        
        add(uL);
        add(ut);
        
        add(pL);
        add(pt);
        
        add(submit);
        add(clear);   
        
        setVisible(true);
        setLocationRelativeTo(null);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submit){
            String a = ut.getText();
            String b = pt.getText();
            
            if(a.equals("admin") && b.equals("admin")){
                JOptionPane.showMessageDialog(new JFrame(),"Welcome");
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(),"Invalid username and password","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(ae.getSource()==clear){
            ut.setText("");
            pt.setText("");
        }
    
    }
    
    public static void main(String[] args){
        new Login1();
    }
}
