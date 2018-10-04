import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class addStartingActivity extends JPanel {
	JPanel c=new JPanel();
  public addStartingActivity() {
      
	  updateUI();
	  setBackground(Color.GRAY);
	  setForeground(Color.GRAY);
	  JPanel b=new JPanel();

	  
	  c.setLayout((new BoxLayout(c, BoxLayout.Y_AXIS)));
	     JLabel message=new  JLabel("Network Diagram Analysis");
	     JLabel message1=new  JLabel("Please enter the information for starting node");
	     JLabel n=new JLabel("acitvity name");
	     JLabel d=new JLabel("duration");
	     b.setLayout(new GridLayout(2,2));
	     b.add(n);
	     JTextField t1=new JTextField();
	     b.add(t1);
	 
	     b.add(d);   JTextField t11=new JTextField();
        b.add(t11);
        c.add(message);
  
        c.add(b);
        JButton button=new JButton("enter");
        button.addActionListener(new ButtonListener());
        c.add(button);
        JButton button1=new JButton("back");
        button1.addActionListener(new ButtonListener());
        c.add(button1);
	     add(c);
	     updateUI();
	
  }
	
  private class ButtonListener implements ActionListener
  {
       public void actionPerformed(ActionEvent event)
       {
        String which=event.getActionCommand();
        if(which=="enter") {
        	
        }
        if(which=="back") {
        	remove(c);
        	updateUI();
        	menuPanel a=new menuPanel();
        	add(a);
        }
        // function of adding first node when enter is pressed
        
        
       }}
	
}
