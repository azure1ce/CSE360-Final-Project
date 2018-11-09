import java.awt.*;
import java.io.*;
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
	 
	 JPanel critPath=new JPanel();
	 
	 JPanel changeDur=new JPanel();
	 
	 JPanel repor =new JPanel();
	 String name;
	 String[] predecessors;
	 
	 Network diagram = new Network(); //creating the network
	 JTextArea showpath;
	 JTextArea showcritpath;
	 Boolean processed = false;
	 
	 JTextField t1=new JTextField();   //name for add activity
	 JTextField t111=new JTextField();  //predecessors for add activity
	 JTextField t11=new JTextField();  //duration  for add activity
	 JTextField reportname=new JTextField();
	 JTextField durname=new JTextField(); 
	 JTextField newdur=new JTextField();
	 
	  JLabel errorHandle=new JLabel();    // error message 
	 JLabel restartMessage = new JLabel();
	 JLabel enterMessage = new JLabel();
	 
	 
	 
	 
	 public menuPanel() {
	
		 // MAIN MENU 
		 JLabel label;
		 menu.setLayout(new GridLayout(15,1));
		 label=new JLabel("Network Analysis ");
		 label.setForeground(Color.RED);
		 JLabel abel2=new JLabel("Please Select an Option to perform");
		 menu.add(label);
		 menu.add(abel2);
    
		 JButton addActivity=new JButton("Add Activity");    
		 menu.add(addActivity);
		 JButton button=new JButton("Process"); 
		 menu.add(button);
		 JButton critPath=new JButton("Display Critical Path");
		 menu.add(critPath);
		 JButton changeDur=new JButton("Change Duration");
		 menu.add(changeDur);
		 JButton createRep=new JButton("Create Report");
		 menu.add(createRep);
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
         critPath.addActionListener(new ButtonListener());
         changeDur.addActionListener(new ButtonListener());
         createRep.addActionListener(new ButtonListener());
         
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
        
       //critPath panel
        
        JPanel criticalPanel=new JPanel();
        JPanel l=new JPanel();
    	JLabel newCriticalPath=new JLabel("Network Diagram Analysis");
    	JLabel newInstForCriticalPath=new JLabel("Critical Path .");
    	criticalPanel.setLayout(new BoxLayout(criticalPanel, BoxLayout.Y_AXIS));
    	l.setLayout(new FlowLayout());
    	criticalPanel.add(newCriticalPath);
    	criticalPanel.add(newInstForCriticalPath);
    	JLabel critLabelPath=new JLabel("critLabelPath:");
    	showcritpath=new JTextArea();
    	showcritpath.setEditable(false);
        //showpath.setPreferredSize(new Dimension(300, 300));
        JScrollPane critscrollPane = new JScrollPane(showcritpath);
        critscrollPane.setPreferredSize(new Dimension(300, 300));
    	//low.add(critLabelPath);
    	l.add(critscrollPane);
    	criticalPanel.add(l);
    	JButton back1=new JButton("back");
    	back1.addActionListener(new ButtonListener());
    	criticalPanel.add(back1);
        this.critPath.add(criticalPanel);
      
    	add(this.critPath);
    	
        this.critPath.setVisible(false);
        
        // changeDur Panel
        JPanel newb=new JPanel();
		 this.changeDur.setLayout((new BoxLayout(this.changeDur, BoxLayout.Y_AXIS)));
		 JLabel changeDurmessage=new  JLabel("Network Diagram Analysis Please enter the information(Changing Duration)");
		 JLabel changeDurn=new JLabel("Activity Name"); 
   	JLabel changeDurd=new JLabel("Duration(new)");
   
   	newb.setLayout(new GridLayout(3,3));
   	newb.add(changeDurn);
   	//getName
   	newb.add(durname);

   	newb.add(changeDurd);   
   	//getDuration
   	newb.add(newdur);
   //	newb.add(t111);
   	this.changeDur.add(changeDurmessage);
   	this.changeDur.add(newb);
   	JButton changeDurationbutton1=new JButton("enter for change");
   	changeDurationbutton1.addActionListener(new ButtonListener());
   	this.changeDur.add(changeDurationbutton1);
   	JButton changeDurationbutton2=new JButton("back");
   	changeDurationbutton2.addActionListener(new ButtonListener());
   	this.changeDur.add(changeDurationbutton2);
   	this.changeDur.add(enterMessage); // wont affect addPanel's error message
   	this.changeDur.add(errorHandle);
   	
   	JLabel newInstr = new JLabel("Please enter the name of the activity and new duration of that activity ");
   	JLabel newInstr2 = new JLabel("This is the activity required for modification");
   	JLabel newInstr3 = new JLabel("after ENTER is pressed, duration is subject to change");
   	this.changeDur.add(newInstr);
   	this.changeDur.add(newInstr2);
   	this.changeDur.add(newInstr3);
   	this.changeDur.add(enterMessage);
   	add(this.changeDur); 
   
   	this.changeDur.setVisible(false);
        
  // createRep 
    JPanel nestedreportPanel=new JPanel();
	 this.repor.setLayout((new BoxLayout(this.repor, BoxLayout.Y_AXIS)));
	 JLabel createRepmessage=new  JLabel("Please enter the title of report(creating report)");
	 JLabel createRepn=new JLabel("Name of report"); 
	nestedreportPanel.setLayout(new GridLayout(1,1));
	nestedreportPanel.add(createRepn);
	//getName
	nestedreportPanel.add(reportname);
    repor.add(enterMessage);
	this.repor.add(createRepmessage);
	this.repor.add(nestedreportPanel);
	JButton createRepbutton1=new JButton("create");
	createRepbutton1.addActionListener(new ButtonListener());
	this.repor.add(createRepbutton1);
	JButton back11=new JButton("back");
	back11.addActionListener(new ButtonListener());
	this.repor.add(back11);
	
	JLabel repnewInstr = new JLabel("Please enter the name of the activity(NO FILE EXTENSION) and new duration of that activity ");
//	JLabel repnewInstr3 = new JLabel("after ENTER is pressed, report will be created");
	this.repor.add(repnewInstr);
	//this.repor.add(repnewInstr3);
	
	add(this.repor); 

	this.repor.setVisible(false);
   
   	
	 }
    
	 private void back() {
		 menu.setVisible(true);
		 add.setVisible(false);
		 process.setVisible(false);
		 critPath.setVisible(false);
		 changeDur.setVisible(false);
		 repor.setVisible(false);
    	
    }
	 
	 private void enterAdd() {
		 menu.setVisible(false);
		 add.setVisible(true);
		 process.setVisible(false);
		 critPath.setVisible(false);
		 changeDur.setVisible(false);
		 repor.setVisible(false);
	 }
	 
	 public void enterProcess() {
		 menu.setVisible(false);
		 add.setVisible(false);
		 process.setVisible(true);   
		 critPath.setVisible(false);
		 changeDur.setVisible(false);
		 repor.setVisible(false);
	 }
     public void enterCritPath() {  
    	 menu.setVisible(false);
		 add.setVisible(false);
		 process.setVisible(false); 
		 critPath.setVisible(true);
		 changeDur.setVisible(false);
		 repor.setVisible(false);
    	 
     }
     public void enterchangEDur() {
    	 menu.setVisible(false);
		 add.setVisible(false);
		 process.setVisible(false); 
		 changeDur.setVisible(true);
		 critPath.setVisible(false);
		 repor.setVisible(false);
     }
     public void enterCreateRep() {
    	 menu.setVisible(false);
		 add.setVisible(false);
		 process.setVisible(false); 
		 repor.setVisible(true);
		 critPath.setVisible(false);
		 changeDur.setVisible(false);
     }

    
    private class ButtonListener implements ActionListener
    {

         public void actionPerformed(ActionEvent event)
         {
          String whichButton=event.getActionCommand();

          if(whichButton=="back") {
        	  back();
        	  errorHandle.setText("");
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
          
          if(whichButton=="Display Critical Path") {
        	  enterCritPath();
		  showcritpath.setText("eric edit:");
          }
          if(whichButton=="Change Duration") {
        	  enterchangEDur();
        	  
          }
          if(whichButton=="Create Report") {
        	  enterCreateRep();
          }
          
          if(whichButton=="enter for change") {
        	  
        	  //change duration 
        	  System.out.println("enter for change is pressed");  //test buttons
        	  errorHandle.setText("");
        	  restartMessage.setText("");
        	  enterMessage.setText("");
        	  
        	  
        	  
        	try {
        	  String activity=durname.getText();
        	  int duration=Integer.parseInt(newdur.getText());
        	 
        	  
        	  
        	  if(duration <= 0){
        		  errorHandle.setText("Duration must be an integer greater than zero.");
        		  errorHandle.setForeground(Color.red);
        	  }else {
        		  
        		  enterMessage.setText("changed");
        	  }
        	 }catch(Exception e) {
      		  errorHandle.setText("Inputs are not valid. Please Enter Integer For Duration.");
      		  errorHandle.setForeground(Color.RED);
      	  }
          }  
          
          if(whichButton=="create") {
        	  //create a text file then write array to it 
        	 // remember to import java library needed
        	  System.out.println("create is pressed");  //test
        	  enterMessage.setText("report generated as TXT");
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
	
