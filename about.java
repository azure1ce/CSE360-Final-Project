import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class about extends JPanel{

	public about() {
		
		
		JTextArea about1=new JTextArea();
   	 //   about1.setPreferredSize(new Dimension(400,800));
		about1.setEditable(false);
		
		String temp="About\n\n";
		temp += "This program will take in the activities of a network diagram as input.\n";
		temp += "It will then use the inputs to find the paths in the network diagram.\n";
		temp += "Once the paths have been found, it will display the results to the user.\n";
		temp += "The paths will listed based on the duration, with the first paths being the ones with the shortest duration.\n";
		temp += "\nRepresented by Team P:\nEric Tan\nJingming Tan\nZachary Simmons\nZhiheng Zhang\\n\n";
		temp += "\nV 2.0.1\n\n";
		about1.setText(temp);
		
		add(about1);
	}
	
	
}