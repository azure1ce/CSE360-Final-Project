
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

   JLabel label;
    updateUI();
	a.setLayout(new GridLayout(7, 1));
	 label=new JLabel("Network Analysis ");
	 JLabel label2=new JLabel("Please Select an Option to perform");
	a.add(label);
	a.add(label2);
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
	


