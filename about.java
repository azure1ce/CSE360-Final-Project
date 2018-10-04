
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class about extends JPanel{

	public about() {
		
		
		JTextArea about1=new JTextArea();
   	 //   about1.setPreferredSize(new Dimension(400,800));
		about1.setEditable(false);
		
		String temp=" If you need help \n";
		about1.setText(temp);
		
		add(about1);
	}
	
	
}
