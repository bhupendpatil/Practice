import java.awt.*;
import java.awt.event.*;

class CloseableSimpleWarning extends Frame implements WindowListener {
  Label l1;

  public CloseableSimpleWarning(){
    setTitle("Warning");
    setSize(200,300);
    addWindowListener(this);

    l1 = new Label("Hello");
    this.add(l1);
  }

  public void windowClosing(WindowEvent e){
    l1.setText("Closing");
    System.exit(0);
  }

  public void windowClosed(WindowEvent e){
    System.out.println("Close");
  }

  public void windowIconified(WindowEvent e){
    l1.setText("Iconified");
  }

  public void windowDeiconified(WindowEvent e) {
    l1.setText("dE-Iconified");
  }

  public void windowOpened(WindowEvent e){
    l1.setText("Open");
    System.out.println("Open");
  }

  public void windowActivated(WindowEvent e){
    l1.setText("Open");
  }

  public void windowDeactivated(WindowEvent e){
    System.out.println("Close");
  }

  public static void main(String [] args){
    CloseableSimpleWarning f = new CloseableSimpleWarning();
    f.show();
  }
}
