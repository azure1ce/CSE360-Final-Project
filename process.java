
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class process extends JPanel{
	JPanel a=new JPanel();
	
	JPanel lower=new JPanel();
	public process() {
	JLabel label=new JLabel("Network Diagram Analysis");
	JLabel label1=new JLabel("The activities in the network diagram have been processed.");
	a.setLayout(new BoxLayout(a, BoxLayout.Y_AXIS));
	lower.setLayout(new FlowLayout());
	a.add(label);
	a.add(label1);
	JLabel path=new JLabel("Path:");
	JTextArea showpath=new JTextArea();
	 showpath.setPreferredSize(new Dimension(300, 300));
	//showpath.setSize(new Dimension(40,40));
	//showpath.setEditable(false);
	lower.add(path);
	lower.add(showpath);
	a.add(lower);
	JButton back=new JButton("back");
	a.add(back);
	back.addActionListener(new ButtonListener());
	add(a);
	}
	 private class ButtonListener implements ActionListener
	    {
	         public void actionPerformed(ActionEvent event)
	         {
	        	 remove(a);
	        	 menuPanel back=new menuPanel();
	        	 add(back);
	        	 
	        	 
	         }
	         }
}
