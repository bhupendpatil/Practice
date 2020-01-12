package closeablesimplewarning;

import java.awt.*;
import java.awt.event.*;

class CloseableSimpleWarning extends Frame implements WindowListener {

  public CloseableSimpleWarning(){
    setTitle("Warning");
    setSize(200,300);
    addWindowListener(this);
  }

  public void windowClosing(WindowEvent e){
    System.out.println("Closing");
    System.exit(0);
  }

  public void windowClosed(WindowEvent e){
    System.out.println("Close/Minimized");
  }

  public void windowIconified(WindowEvent e){
    System.out.println("Iconified");
  }

  public void windowDeiconified(WindowEvent e) {
    System.out.println("dE-Iconified");
  }

  public void windowOpened(WindowEvent e){
    System.out.println("Open");
  }

  public void windowActivated(WindowEvent e){
    System.out.println("Activated");
  }

  public void windowDeactivated(WindowEvent e){
    System.out.println("Close");
  }

  public static void main(String [] args){
    CloseableSimpleWarning f = new CloseableSimpleWarning();
    f.show();
  }
}