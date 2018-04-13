/*
An application using JTree Component
 */

import javax.swing.*;
import javax.swing.tree.*;
        
public class Tree7 extends JFrame{
    
    JTree tree;
    DefaultMutableTreeNode numbers, one, onepone, oneptwo, two, twopone, three;
    
    Tree7(){
        setTitle("Tree");
        setSize(200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        numbers = new DefaultMutableTreeNode("Numbers");
        one = new DefaultMutableTreeNode("1");
        onepone = new DefaultMutableTreeNode("1.1");
        oneptwo = new DefaultMutableTreeNode("1.2");
        two = new DefaultMutableTreeNode("2");
        twopone = new DefaultMutableTreeNode("2.1");
        three = new DefaultMutableTreeNode("3");
        
        numbers.add(one);
        numbers.add(two);
        numbers.add(three);
        
        one.add(onepone);
        one.add(oneptwo);
        
        two.add(twopone);
        
        tree = new JTree(numbers);
        
        add(tree);
        
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args){
        new Tree7();
    }
}
