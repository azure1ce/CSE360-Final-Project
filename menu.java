
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class menu extends JApplet{

	
		private int APPLET_WIDTH = 800, APPLET_HEIGHT = 300;

		   private JTabbedPane tPane ;
		   private menuPanel menuPanel1=new menuPanel();    // where the buttons will be
		   private helpPanel helpPanel=new helpPanel();     // help section with only a textarea
		   private about about1=new about();

		   //The method init initializes the Applet with a Pane with two tabs
		   public void init()
		    {
		     //list of books to be used in every panel
		  //   bookList = new ArrayList();

		     //customer selection panel uses the list of books
	//	     selectPanel = new SelectPanel(bookList);


		//     addPanel = new AddPanel(bookList, selectPanel);


		     //create a tabbed pane with two tabs
			//   Container content = getContentPane();

			    // An ExamplePanel objects contains all components
		//	    ExamplePanel panel = new ExamplePanel();

			//    content.add(panel);

			//    setSize(400,400);
		     tPane = new JTabbedPane();
		     tPane.addTab("menu", menuPanel1);
		     tPane.addTab("help", helpPanel);
		     tPane.addTab("about", about1);
              
		     getContentPane().add(tPane);
		     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
		    }
	}


