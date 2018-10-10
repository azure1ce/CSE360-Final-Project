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
	 
	 String name;
	 String[] predecessors;
	 
	 Network diagram = new Network(); //creating the network
	 JTextArea showpath;
	 Boolean processed = false;
	 
	 JTextField t1=new JTextField();   //name
	 JTextField t111=new JTextField();  //predecessors
	  JTextField t11=new JTextField();  //duration
	 JLabel errorHandle=new JLabel();    // error message 
	 JLabel restartMessage = new JLabel();
	 JLabel enterMessage = new JLabel();
	 
	 
	 
	 
	 public menuPanel() {
	
		 // MAIN MENU 
		 JLabel label;
		 menu.setLayout(new GridLayout(8,1));
		 label=new JLabel("Network Analysis ");
		 label.setForeground(Color.RED);
		 JLabel abel2=new JLabel("Please Select an Option to perform");
		 menu.add(label);
		 menu.add(abel2);
    
		 JButton addActivity=new JButton("Add Activity");    
		 menu.add(addActivity);
		 JButton button=new JButton("Process"); 
		 menu.add(button);
		 JButton restart=new JButton("Restart");
		 menu.add(restart);
		 JButton quit=new JButton("Quit");
		 menu.add(quit);
		 
		 restartMessage = new JLabel("");
		 menu.add(restartMessage);

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
		 JLabel n=new JLabel("Activity Name"); 
    	JLabel d=new JLabel("Duration");
    	JLabel predecessor=new JLabel("Predecessors");
    
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
    	add.add(enterMessage);
    	add.add(errorHandle);
    	
    	JLabel instr = new JLabel("If there are no predecessors, enter in \"none\"(all lowercase) for the predecessor field.");
    	JLabel instr2 = new JLabel("If there are multiple predecessors seperate them with a \",\"(No spaces between activities and comma).");
    	JLabel instr3 = new JLabel("For example, predecessors one and two would be inputted as \"one,two\"(Exact spacing)");
    	add.add(instr);
    	add.add(instr2);
    	add.add(instr3);
    	
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
    	showpath=new JTextArea();
    	showpath.setEditable(false);
        //showpath.setPreferredSize(new Dimension(300, 300));
        JScrollPane scrollPane = new JScrollPane(showpath);
        scrollPane.setPreferredSize(new Dimension(300, 300));
    	//lower.add(path);
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
        	  enterMessage.setText("");
          }
          if(whichButton=="Add Activity")
          {
        	  errorHandle.setText("");
        	  restartMessage.setText("");
        	  enterMessage.setText("");
          	 enterAdd();	
          	 updateUI();

          	 
          }
          if(whichButton=="Process") {
        	  //System.out.println("name currently is " + name);
        	  if(processed == false){
        		  showpath.setText(diagram.process());
        		  processed = true;
        	  }
        	  else{
        		  showpath.setText("Network has already been processed, please restart for a new network");
        	  }
        	  errorHandle.setText("");
        	  restartMessage.setText("");
        	  enterMessage.setText("");
        	   enterProcess();
        	   updateUI();
        	   // print array 
        	   
        	   
          }
          
          if(whichButton=="enter") {
        	  errorHandle.setText("");
        	  restartMessage.setText("");
        	  enterMessage.setText("");
        	  
        	  try {
        	  name=t1.getText();
        	  int duration=Integer.parseInt(t11.getText());
        	  predecessors = (t111.getText()).split(",");
        	  if(predecessors[0].equals("none")){
        		  predecessors[0] = null;
        	  }
        	//  System.out.println("Name = " + name);
        	//  System.out.println("Predecessor[0] = "+ predecessors[0]);
        	  
        	  if(duration <= 0){
        		  errorHandle.setText("Duration must be an integer greater than zero.");
        		  errorHandle.setForeground(Color.red);
        	  }
        	  else{
        		  diagram.addInput(name, predecessors, duration); 
        		  enterMessage.setText("Activity " + name + " has been added to the network");
        		  enterMessage.setForeground(Color.BLUE);
        	  }
        	//  System.out.println("input added for " + name);
        	  //System.out.println(diagram.process());
        	  
        	 // System.out.println(duration);
        	  
        	  
        	  
        	  }catch(Exception e) {
        		  errorHandle.setText("Inputs are not valid. Please Enter Integer For Duration.");
        		  errorHandle.setForeground(Color.RED);
        	  }
        	  
        	  
          }
          if(whichButton=="Restart") {
        	  // implement  restart here
        	  
        	  diagram.restart();
        	  processed = false;
        	  //System.out.println(processed);
        	  restartMessage.setText("The network has been reset.");
        	  
          }
          if(whichButton=="Quit") {
        	  
        	  
        	  System.exit(1);
          }
          
          
        	  
        	  
          
          
          
          // implement button functions  
          
          
          
             //TO BE COMPLETED             
         } //end of actionPerformed method
    } //end of ButtonListener class
}	
	
