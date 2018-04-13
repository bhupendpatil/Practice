/*
An application using JDesktopPane Component.
 */

import javax.swing.*;

public class DesktopPane4 extends JFrame {
    
    JDesktopPane dop;
    JInternalFrame ji;
    
    DesktopPane4(){
        setTitle("Desktop Pane");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        dop = new JDesktopPane();
        
        for(int i=1;i<=5;i++){
            ji = new JInternalFrame("Internal Frame: "+i,true,true,true,true);
            ji.setBounds(i*50, i*50, 100, 100);
            ji.setVisible(true);
        
            dop.add(ji);
        }
        add(dop);
        
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args){
        new DesktopPane4();
    }
}
