import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class helpPanel extends JPanel{
     public helpPanel() {
    	 
    	 JTextArea helptext=new JTextArea();
    	 helptext.setEditable(false);
    	 
    	 // change help info if you want 
    	 String a="Help:\n\n";
    	 a += "-To create a network diagram to process, use the add activity button to input in the activities to the network.\n\n";
    	 a += "-When all activities have been added, click the process button to see all the paths in the network.\n\n";
    	 a += "-Use the display critical path button to view the critical path(s) in the network\n\n";
    	 a += "-To change the duration of an activity, use the change duration button\n\n";
    	 a += "-A report for the network can be created using the create report button\n\n";
    	 a += "-If the activities inputted are incorrect, click on the restart button to reset the network.\n\n";
    	 a += "-Click on the quit button to close the program once finished.";
    	 
    	 
    	 helptext.setText(a);
    	 
    	 add(helptext);
    	 
     }
	
	
	
	
	
}