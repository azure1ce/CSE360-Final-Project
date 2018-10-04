
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class menuPanel extends JPanel {
	
	JPanel a=new JPanel();
    
	
public menuPanel() {
	setBackground(Color.GRAY);
//	Color buttonColor = new Color(10,10,255);
   JLabel label;
    updateUI();
	a.setLayout(new BoxLayout(a, BoxLayout.Y_AXIS));
	 label=new JLabel("Network Analysis ");
	 JLabel abel2=new JLabel("Please Select an Option to perform");
	a.add(label);
	a.add(abel2);
	JButton addFirst=new JButton("Add Activity(starting node)");
  //  addFirst.setBackground(Color.cyan);
    a.add(addFirst);
    JButton addActivity=new JButton("add Activity");   
    a.add(addActivity);
    JButton process=new JButton("process"); 
    a.add(process);
    JButton restart=new JButton("restart");
    a.add(restart);
    JButton quit=new JButton("quit");
    a.add(quit);
    addFirst.addActionListener(new ButtonListener());
    addActivity.addActionListener(new ButtonListener());
    process.addActionListener(new ButtonListener());
    restart.addActionListener(new ButtonListener());
    quit.addActionListener(new ButtonListener());
    a.setBackground(Color.gray);
    add(a);
   
    
   
}
    
    private class ButtonListener implements ActionListener
    {
         public void actionPerformed(ActionEvent event)
         {
          String whichButton=event.getActionCommand();
          
          
          if(whichButton=="Add Activity(starting node)") {
        	  // add head and add to array you guys should modify this function
        	remove(a);
        	updateUI();
        	addFirst addf=new addFirst();
        	add(addf);
        	updateUI();
        	 
        	 
        	 
          }
          if(whichButton=="add Activity")
          {
        	  remove(a);
          	 addactivity addf=new addactivity();
         
          	 add(addf); 	
          	 updateUI();
          }
          if(whichButton=="process") {
        	    remove(a);
            	process addf=new process();
            	updateUI();
            	add(addf);
          }
          if(whichButton=="restart") {
        	  // implement 
        	  
        	  
        	  
          }
          if(whichButton=="quit") {
        	  
        	  
        	  System.exit(1);
          }
          
          
        	  
        	  
          
          
          
          // implement button functions  
          
          
          
             //TO BE COMPLETED             
         } //end of actionPerformed method
    } //end of ButtonListener class
 
    
}	
	


