
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class helpPanel extends JPanel{
     public helpPanel() {
    	 
    	 JTextArea helptext=new JTextArea();
    	 helptext.setEditable(false);
    	 
    	 // change help info if you want 
    	 String a=" Instruction on How to use Network Diagram";
    	 
    	 
    	 helptext.setText(a);
    	 
    	 add(helptext);
    	 
     }
	
	
	
	
	
}
