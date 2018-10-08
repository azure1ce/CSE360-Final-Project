
public class Network {

	private Path[] networkPaths; 
	private Input[] inArray;
	
	//constructor
	public Network(){
		
		networkPaths = new Path[10]; //will create more space if necessary by copying into a larger array later
		inArray = new Input[10];
		//fill both arrays with nulls
		for(int i = 0; i < networkPaths.length; i++){
			networkPaths[i] = null;
		}
		for(int i = 0; i < inArray.length; i++){
			inArray[i] = null;
		}
		
	}
	

	
	//public methods
	
	public void addInput(String aName, String[] aPredecessors, int aDuration){
		int i = 0;
		this.checkInFull(); //check to make sure array is not full
		//find empty spot in array
		while(inArray[i] != null){
			i++;
		}
		//create new input object and add to input array
		Input newIn = new Input(aName, aPredecessors, aDuration);
		inArray[i] = newIn;
		
		//this.printInArray(); //FOR TESTING
	}
	
	public String process(){
		
		//check for errors
		if(this.checkEmpty() == true){
			return "There are no activities in the network, please enter in activities before processing";
		}
		if(this.checkOne() == true){
			return "There is only one activity in the network, please enter in more activities before processing";
		}
		if(this.checkStart() == false){
			return "There either exists no starting activity, or more than one starting activity, please restart program";
		}
		else if(this.checkConnection() == false){
			return "Not all activities are connected, please add in missing activities, or restart program";
		}
		else if(this.checkCycle() == true){
			return "There is a cycle in the network activity diagram, please restart program";
		}
		
		
		this.sortInArray();
		for(int i = 0; i < inArray.length; i++){
			if(inArray[i] != null){ //make sure area being checked is not null
				if(inArray[i].inPredecessors[0] == null){//find starting array
					Path newPath = new Path(inArray[i].inName, inArray[i].inDuration); //create path with it and put it into array of paths
					networkPaths[0] = newPath;
				}
			}
		}
		//this.printArray(); //FOR TESTING
		
		for(int i = 0; i < inArray.length; i++){
			if(inArray[i] != null){ //check to make sure element at i is not null
				if(inArray[i].inPredecessors[0] != null){ //makes sure to ignore starting activity
					for(int j = 0; j < inArray[i].inPredecessors.length; j++){ //adds activity to each path with its predecessor
						//System.out.println(i); //FOR TESTING
						//System.out.println(inArray[i].inName); //FOR TESTING
						this.addActivity(inArray[i].inName, inArray[i].inDuration, inArray[i].inPredecessors[j]);
					}
				}
			}
		}
		
		this.sortPaths();
		String message = "Paths:\n";
		for(int i = 0; i < networkPaths.length; i++){
			if(networkPaths[i] != null){
				message += "Path " + (i+1) + ": \nDuration: " + networkPaths[i].getPathDuration() + "\n";
				message += "Activities: " + networkPaths[i].getActivities() + "\n\n";
			}
		}
		return message;
		
	}
	

	//resets program
	public void restart(){
		//set values in both arrays to null
		for(int i = 0; i < networkPaths.length; i++){
			networkPaths[i] = null;
		}
		for(int i = 0; i < inArray.length; i++){
			inArray[i] = null;
		}
	}
	
	
	//private methods

	
	
	private void addActivity(String aName, int aDuration, String predecessor){
		
		//check to make sure predecessor exists
		
		boolean predecessorNextExists = false;
	
		
		for(int i = 0; i < networkPaths.length; i++){ //check every path in network diagram
			if(networkPaths[i] != null){ //make sure not null before checking
				if(networkPaths[i].checkPredecessor(predecessor) == true){ //find predecessor
					if(networkPaths[i].checkPredecessorNext(predecessor) == true){ //check to see if predecessor is already connected to another node
						predecessorNextExists = true;
					}
				}
			}
		}
		
		//adding activity
		//a split in the diagram
		if(predecessorNextExists==true){
			//System.out.println("SPLIT"); //FOR TESTING
			this.checkFull();
			int newIndex = 0;
			while(networkPaths[newIndex] != null){
				newIndex++;
			}
			for(int i = 0; i < networkPaths.length; i++){
				if(networkPaths[i] != null){
					if(networkPaths[i].checkPredecessor(predecessor)==true){
						Path newPath = networkPaths[i].copyPath(predecessor); //create a new path
						//System.out.println("Creating new path"); //FOR TESTING
						newPath.addToPath(aName, aDuration); //add activity to new path
						//check to make sure new path does not already exist in network
						boolean alreadyExists = false;
						for(int k = newIndex; k < networkPaths.length; k++){
							if(networkPaths[k] != null){
								if(networkPaths[k].comparePaths(newPath)==true){
									alreadyExists = true;
								}
							}
						}
						//add new path to network
						if(alreadyExists!=true){
							this.checkFull(); //check to make sure array has space
							//find empty spot in array
							int j = 0;
							while(networkPaths[j] != null){
								j++;
							}
							networkPaths[j] = newPath; //place newPath into it
						}
							
					}
				}
			}
		}
		else{ //if not a split, add activity to the end of every path with the predecessor
			for(int i = 0; i < networkPaths.length; i++){
				if(networkPaths[i] != null){
					//System.out.println("Check predecessor: " + predecessor + " for " + aName); //FOR TESTING
					if(networkPaths[i].checkPredecessor(predecessor)==true){
						//System.out.println("addActivity: " + aName); //FORTESTING
						networkPaths[i].addToPath(aName, aDuration);
					}
				}
			}
		}
			
		//System.out.print("Path: " ); //FOR TESTING
		//this.printArray(); //FOR TESTING
	}
	
	//sorts the paths in the array based on their durations, with shortest durations first
	private void sortPaths(){
		
		for(int i = 0; i < networkPaths.length; i++){
			//find shortest path duration path
			if(networkPaths[i] != null){
				int min = networkPaths[i].getPathDuration();
				int minIndex = i;
				for(int j = i; j < networkPaths.length; j++){
					if(networkPaths[j] != null){
						if (min > networkPaths[j].getPathDuration()){
							min = networkPaths[j].getPathDuration();
							minIndex = j;
						}
					}
				}
				//swap the paths
				Path temp = networkPaths[i];
				networkPaths[i] = networkPaths[minIndex];
				networkPaths[minIndex] = temp;
			}
		}
	}
	
	//checks to see if array is full, if it is then create a larger array
	private void checkFull(){
		int count = 0;
		//count amount of nulls in array
		for(int i = 0; i < networkPaths.length; i++){
			if(networkPaths[i] == null){
				count ++;
			}
		}
		
		//if no nulls, that means array is full, then create new array
		if(count == 0){
			Path[] newArray = new Path[networkPaths.length*2];
			//fill new array with null
			for(int i = 0; i < newArray.length; i++){
				newArray[i] = null;
			}
			//copy in the array of networks
			for(int i = 0; i < networkPaths.length; i++){
				newArray[i] = networkPaths[i];
			}
			networkPaths = newArray; //networkPaths now points to new array
		}
	}
	
	//check to see if input array is full
	private void checkInFull(){
		int count = 0;
		for(int i = 0; i < inArray.length; i++){ //check to see if array has space by find how many nulls there are
			if(inArray[i] == null){
				count++;
			}
		}
		
		if(count==0){ //create a bigger array if array is full
			//create array 2 times size of old array
			Input[] newArray = new Input[inArray.length*2];
			for(int i = 0; i < newArray.length; i++){
				newArray[i] = null;
			}
			//fill in array
			for(int i = 0; i < inArray.length; i++){
				newArray[i] = inArray[i];
			}
			inArray = newArray;
		}
	}
	
	//check to see if theres a cycle in inputs, returns true if theres a cycle, false if none
	private boolean checkCycle(){
		int value = 0;
		for(int i = 0; i < inArray.length; i++){
			for(int j = 0; j < inArray.length; j++){
				if(inArray[i] != null && inArray[j] != null){ //make sure spots being checked are not null
					if(inArray[j].inPredecessors[0] != null){ //check to make sure element being compared to has predecessors
						for(int k = 0; k < inArray[j].inPredecessors.length; k++){ //checking against all predecessors
							if(inArray[i].inName.equals(inArray[j].inPredecessors[k])){
								value += this.checkCycleHelp(inArray[i], inArray[j]);
								//reset cycleChecked value to prepare array to be tested again
								for(int l = 0; l < inArray.length; l++){
									if(inArray[l] != null){ //check for null pointer exception
										inArray[l].cycleChecked = false;
									}
								}
							}
						}
					}
				}
			}
		}
		//return true if there are cycles, false if there are none
		if(value != 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	//function called in checkCycle to check if there is a cycle
	private int checkCycleHelp(Input inputA, Input inputB){
		int value = 0;
		inputB.cycleChecked = true;
		//check to make sure InputB is not a predecessor of inputB
		for(int i = 0; i < inputA.inPredecessors.length; i++){ 
			//System.out.println("Cycle checking: Checking " + inputA.inName + "'s predecessor "+ inputA.inPredecessors[i] + " against " + inputB.inName); //FOR TESTING
			if(inputA.inPredecessors[i] != null){
				if(inputA.inPredecessors[i].equals(inputB.inName) == true){
					return 1;
				}
			}
		}
		//count to see how many inputs have inputB as a predecessor
		int count = 0; 
		for(int i = 0; i < inArray.length; i++){
			if(inArray[i] != null){//check to make sure place being checked is not null
				if(inArray[i].inPredecessors[0] != null){ //makes sure nodes has predecessors before checking it
					for(int j = 0; j < inArray[i].inPredecessors.length; j++){
						if(inArray[i].inPredecessors[j] != null){ //make sure there is a predecessor to be checked
							if(inArray[i].inPredecessors[j].equals(inputB.inName) == true && inArray[i].cycleChecked == false){ //add 1 to count if the node being checked has inputB as a predecessor
								count++;
								//System.out.println("count++ : " + inArray[i].inName + " has " + inputB.inName + " as a predecessor");//FOR TESTING
							}
						}	
					}
				}
			}
		}
		//return 0 if no nodes has inputB as a predecessor
		//System.out.println("CYCLECHECKHELP COUNT: " + count); //FOR TESTING
		if(count == 0){
			return 0;
		}
		//recursively call function for nodes with inputB as predecessor
		for(int i = 0; i < inArray.length; i++){
			if(inArray[i] != null){ //make sure element at index is not null
				if(inArray[i].inPredecessors[0] != null){ //makes sure input has predecessors
					for(int j = 0; j < inArray[i].inPredecessors.length; j++){ //check for all predecessors of input
						if(inArray[i].inPredecessors[j].equals(inputB.inName) && inArray[i].cycleChecked == false){ //checks to see if input at index has inputB as a predecessor
							//System.out.println("Recursive call cycleCheckHelp(" + inputA.inName + ", " + inArray[i].inName + ")"); //FOR TESTING
							value += this.checkCycleHelp(inputA, inArray[i]); //recursive call
						}
					}
				}
			}
		}
		return value; //returns value ( value is how many cycles there are)
	}
	
	//check to make sure all activities are connected, return true if connected, false otherwise
	private boolean checkConnection(){
		boolean connected = false;
		for(int i = 0; i < inArray.length; i++){
			if(inArray[i] != null){ //makes sure spot being checked is not null
				if(inArray[i].inPredecessors[0] != null){ //makes sure activity being checked has predecessors
					for(int j = 0; j < inArray[i].inPredecessors.length; j++){ //checks for each predecessor
						for(int k = 0; k < inArray.length; k++){ //checks against each element in array
							if(inArray[k] != null && inArray[i].inPredecessors[j] != null){ //makes sure area being checked against is not null
								if((inArray[i].inPredecessors[j]).equals(inArray[k].inName)){ //checks to see if the predecessor is found in array
									connected = true;
								}
							}
						}
						//returns false if the predecessor was not able to be found
						if(!connected){
							return false;
						}
						connected = false; //changes connected back to false for testing other against other predecessors
					}
				}
			}
		}
		return true; //all connections were able to found
	}
	
	//check to make sure that is at least one starting activity and only one starting activity
	private boolean checkStart(){
		int count = 0;
		//count number of activities with no predecessors
		for(int i = 0; i < inArray.length; i++){
			if(inArray[i] != null){
				if(inArray[i].inPredecessors[0] == null){
					count++;
				}
			}
		}
		//return true if only one starting activity, false otherwise
		if(count == 1){
			return true;
		}
		else{
			return false;
		}
	}
	
	//check to see if input array is empty
	private boolean checkEmpty(){
		if(inArray[0] == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	//check to see if there is only one input in the input array
	private boolean checkOne(){
		if(inArray[1] == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	private void sortInArray(){
		this.checkInFull(); 
		Input[] newArray = new Input[inArray.length]; //create new array
		//fill it with null
		for(int i = 0; i < newArray.length; i++){
			newArray[i] = null;
		}
		//find input for starting node and put it in first spot of array
		for(int i = 0; i < inArray.length; i++){
			if(inArray[i] != null){ //check to see if null
				if(inArray[i].inPredecessors[0] == null){
					newArray[0] = inArray[i];
					//System.out.println("Found starting activity " + newArray[0].inName);
				}
			}
		}
		
		int lastIndex = 0;
		while(inArray[lastIndex] != null){
			lastIndex++;
		}
		lastIndex--;
		
		int nextIndex = 1;
		
		
		//fill in the rest
		while(newArray[lastIndex] == null){
			//System.out.println("Entered sort inArray while loop"); //FOR TESTING
			for(int i = 0; i < inArray.length; i++){
				int predecessorsFound = 0;
				if(inArray[i] != null){ //check for null pointer exception
					if(inArray[i].inPredecessors[0] != null){ //check for predecessors
						for(int j = 0; j < inArray[i].inPredecessors.length; j++){ //check to make sure all predecessors are already in array
							//System.out.println("Entered j for loop"); //FOR TESTING
							//System.out.println("Predecessor of " + inArray[i].inName + " is " + inArray[i].inPredecessors[j]); //FOR TESTING
							if(inArray[i].inPredecessors[j] != null){ //check for null pointer exception
								for(int k = 0; k < newArray.length; k++){ //check predecessors against new array
									//System.out.println("Entered k for loop"); //FOR TESTING
									if(newArray[k] != null){ //check for null pointer exception
										//System.out.println("newArray[k] != null"); //FOR TESTING
										if(inArray[i].inPredecessors[j].equals(newArray[k].inName) == true){
											predecessorsFound++;
											//System.out.print(inArray[i].inName + "'s predecessor " + inArray[i].inPredecessors[j] + " found"); //FOR TESTING
										}
									}
								}
							}
						}
						//System.out.println("Exited predecessor loop, predecessors found = " +predecessorsFound ); //FOR TESTING
						if(predecessorsFound == inArray[i].inPredecessors.length){
							//System.out.println("Putting " + inArray[i].inName + "into new array"); //FOR TESTING
							newArray[nextIndex] = inArray[i];
							inArray[i] = null;
							nextIndex++;
						}
					}
					
				}		
			}
		}
		inArray = newArray;
	}
	
	
	//Testing functions
	private void printArray(){
		for(int i = 0; i < networkPaths.length; i++){
			if(networkPaths[i]!= null){
				System.out.println(networkPaths[i].getActivities());
			}
		}
	}
	
	private void printInArray(){
		for(int i = 0; i < inArray.length; i++){
			if(inArray[i]!= null){
				System.out.print(inArray[i].inName + " ");
			}
		}
		System.out.print("\n");
	}
	
	
	//class to hold data for inputs
	private class Input{
		
		//private variables
		private String inName;
		private String[] inPredecessors; //array to hold predecessors of the activity
		private int inDuration;
		private boolean cycleChecked; //used for cycle check function
		
		//constructor
		private Input(String aName, String[] predecessors, int aDuration){
			inName = aName;
			inPredecessors = predecessors;
			inDuration = aDuration;
			cycleChecked = false;
		}
		
	}
	
}
