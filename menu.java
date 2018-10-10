import javax.swing.*;
import java.util.*;
import java.awt.*;

public class menu extends JApplet{

	
		private int APPLET_WIDTH = 800, APPLET_HEIGHT = 300;   //Applet Size

		   private JTabbedPane tPane ;
		   private menuPanel menuPanel1=new menuPanel();    // where the buttons will be
		   private helpPanel helpPanel=new helpPanel();     // help page
		   private about about1=new about();                // about page

		   public void init()
		    {

		     tPane = new JTabbedPane();
		     tPane.addTab("menu", menuPanel1);
		     tPane.addTab("help", helpPanel);
		     tPane.addTab("about", about1);
            
		     getContentPane().add(tPane);
		     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
		    }
	}
