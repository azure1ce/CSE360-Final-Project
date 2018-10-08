
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Thing that need to be add



//  Restart  :  delete array
//  call add activity class
// call process class


public class menuPanel extends JPanel {
	
	 JPanel menu=new JPanel();
  
	 JPanel add=new JPanel();
	 
	 JPanel process=new JPanel();
	 
	 JTextField t1=new JTextField();   //name
	 JTextField t111=new JTextField();  //predecessor
	  JTextField t11=new JTextField();  //duration
	 JLabel errorHandle=new JLabel();    // error message 
public menuPanel() {
 // MAIN MENU 
     JLabel label;
	menu.setLayout(new GridLayout(8,1));
	 label=new JLabel("Network Analysis ");
	 label.setForeground(Color.RED);
	 JLabel abel2=new JLabel("Please Select an Option to perform");
	menu.add(label);
	menu.add(abel2);
    
    JButton addActivity=new JButton("add Activity");    
    menu.add(addActivity);
    JButton button=new JButton("process"); 
    menu.add(button);
    JButton restart=new JButton("restart");
    menu.add(restart);
    JButton quit=new JButton("quit");
    menu.add(quit);

    addActivity.addActionListener(new ButtonListener());
    button.addActionListener(new ButtonListener());
    restart.addActionListener(new ButtonListener());
    quit.addActionListener(new ButtonListener());


    add(menu);
    //  add  activity
    ///
    //
    //
    JPanel b=new JPanel();
    add.setLayout((new BoxLayout(add, BoxLayout.Y_AXIS)));
    JLabel message=new  JLabel("Network Diagram Analysis \n Please enter the information  ");
    JLabel n=new JLabel("acitvity name"); 
    JLabel d=new JLabel("duration");
    JLabel predecessor=new JLabel("predecessors");
    
    b.setLayout(new GridLayout(3,3));
    b.add(n);
     //getName
    b.add(t1);

   b.add(d);   
   //getDuration
   b.add(t11);
   b.add(predecessor);   
   b.add(t111);
   add.add(message);
   add.add(b);
   JButton button1=new JButton("enter");
   button1.addActionListener(new ButtonListener());
   add.add(button1);
   JButton button2=new JButton("back");
   button2.addActionListener(new ButtonListener());
   add.add(button2);
   add.add(errorHandle);
    add(add); 
    
    add.setVisible(false);
    //process 
         JPanel a=new JPanel();
	
       JPanel lower=new JPanel();
    	JLabel label_1=new JLabel("Network Diagram Analysis");
    	JLabel label1=new JLabel("The activities in the network diagram have been processed.");
    	a.setLayout(new BoxLayout(a, BoxLayout.Y_AXIS));
    	lower.setLayout(new FlowLayout());
    	a.add(label_1);
    	a.add(label1);
    	JLabel path=new JLabel("Path:");
    	JTextArea showpath=new JTextArea();
    	showpath.setEditable(false);
        showpath.setPreferredSize(new Dimension(300, 300));
        JScrollPane scrollPane = new JScrollPane(showpath);
    	lower.add(path);
    	lower.add(scrollPane);
    	a.add(lower);
    	JButton back=new JButton("back");
       
    	a.add(back);
    	back.addActionListener(new ButtonListener());
        this.process.add(a);
      
    	add(this.process);
    	
         this.process.setVisible(false);

   
    
   
}
    
    private void back() {
    	menu.setVisible(true);
    	add.setVisible(false);
    	process.setVisible(false);
    	
    	
    }
   private void enterAdd() {
	   menu.setVisible(false);
	   add.setVisible(true);
	   process.setVisible(false);
   }
   public void enterProcess() {
	   menu.setVisible(false);
	   add.setVisible(false);
	   process.setVisible(true);
	   
   }
    
    private class ButtonListener implements ActionListener
    {
         public void actionPerformed(ActionEvent event)
         {
          String whichButton=event.getActionCommand();

          if(whichButton=="back") {
        	  back(); errorHandle.setText("");
          }
          if(whichButton=="add Activity")
          {
        	  errorHandle.setText("");
          	 enterAdd();	
          	 updateUI();

          	 
          }
          if(whichButton=="process") {
        	  errorHandle.setText("");
        	   enterProcess();
        	   updateUI();
        	   // print array 
        	   
        	   
          }
          
          if(whichButton=="enter") {
        	  errorHandle.setText("");
        	  
        	  try {
        	  String name=t1.getText();
        	  int duration=Integer.parseInt(t11.getText());
        	  String predecessor=t111.getText();
        	  System.out.println(duration);
        	  
        	  
        	  
        	  }catch(Exception e) {
        		  errorHandle.setText("Inputs are not valid. Please Enter Integer For Duration.");
        		  errorHandle.setForeground(Color.YELLOW);
        	  }
        	  
        	  
          }
          if(whichButton=="restart") {
        	  // implement  restart here
        	  
        	  
        	  
        	  
          }
          if(whichButton=="quit") {
        	  
        	  
        	  System.exit(1);
          }
          
          
        	  
        	  
          
          
          
          // implement button functions  
          
          
          
             //TO BE COMPLETED             
         } //end of actionPerformed method
    } //end of ButtonListener class
 
    
}	
	


