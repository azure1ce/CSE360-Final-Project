
public class Path {
	
	private Activity aPath; //starting activity, head of linked list
	private int pathDuration; //duration of the whole path
	
	//constructor
	public Path(String aName, int aDuration){
		aPath = new Activity(aName, aDuration);
		pathDuration = aDuration;
	}
	
	//methods
	//get methods
	public Activity getPath(){
		return aPath;
	}
	
	public int getPathDuration(){
		return pathDuration;
	}
	
	//returns all activities in the path
	public String getActivities(){
		String acts = "";
		Activity temp = aPath;
		
		while(temp.next != null){
			acts += temp.name + ", ";
			//System.out.println("temp.name = " + temp.name); //FOR TESTING
			//System.out.println("creating string: " + temp.name); //FOR TESTING
			temp = temp.next;
		}
		
		if(temp.next == null){
			acts += temp.name;
			//System.out.println("Temp.next = null"); //FOR TESTING
		}
		
		return acts;
	}
	
	//method to add an activity to the end of the path
	public void addToPath(String aName, int aDuration){
		//create a temp variable to point to head of linked list, then traverse to end of linked list
		//System.out.println("addToPath: " + aName);//FOR TESTING
		Activity temp = aPath;
		while(temp.next != null){
			temp = temp.next;
		}
		
		//add create new node and add it
		Activity newActivity = new Activity(aName, aDuration);
		//System.out.println("addToPath: " + aName);//FOR TESTING
		temp.next = newActivity;
		pathDuration += aDuration; //add on the duration to the total duration of path
	}
	
	//go through path and find if a node exists
	public boolean checkPredecessor(String aName){
		
		Activity temp = aPath;
		
		//go through path
		while(temp.next != null){
			//return true if path exists
			if(temp.name.equals(aName)==true){
				return true;
			}
			temp = temp.next; //move on to next node if current node is not predecessor
		}
		
		if(temp.name.equals(aName)== true){
			return true;
		}
		
		return false; //return false if predecessor was not found in path
	}
	
	//check to see if a predecessor is already linked to another activity
	public boolean checkPredecessorNext(String aName){
		
		//go to predecessor in the path
		Activity temp = aPath;
		//System.out.println("Check next: ." + aName +"."); //FOR TESTING
		//System.out.println(temp.name);
		while(temp.name.equals(aName) == false){
			//System.out.println("CHecking: " + temp.name); //FOR Testing
			temp = temp.next;
			//System.out.println("Next");
		}
		//return false if the predecessor's next is null, else return true
		if(temp.next == null){
			return false;
		}
		else{
			return true;
		}
	}
	
	//copy a path up to a certain activity
	public Path copyPath(String aName){
		
		//create new path, and temp pointer to current path
		Path newPath = new Path(aPath.name, aPath.duration);
		Activity temp = aPath;
		if(temp.name.equals(aName) == false){
			temp = aPath.next;
		
			//System.out.println("Copying path to " + aName); //FOR TESTING
			//go through path and copy the nodes
			while(temp.name.equals(aName) == false){
				//System.out.println("Copying progress- on : " + temp.name); //FOR TESTING
				newPath.addToPath(temp.name, temp.duration);
				temp = temp.next;
			}
			//need to copy node again to copy the activity that is inputed because while loops stops on the input activity
			newPath.addToPath(temp.name, temp.duration);
		}
		
		return newPath; //return the newly created path
		
	}
	
	//compare two paths to see whether or not they are the same, return true if they are the same, false if different
	public boolean comparePaths(Path a){
		Activity temp = this.aPath;
		Activity temp2 = a.aPath;
		//this is needed because while loop will ignore starting activity if there are no other activities
		if(temp.name.equals(temp2.name) ==false|| temp.duration != temp2.duration){
			return false;
		}
		//go through both paths comparing values
		while(temp.next != null && temp2.next != null){
			if(temp.name.equals(temp2.name) ==false|| temp.duration != temp2.duration){
				return false;
			}
			temp = temp.next;
			temp2 = temp2.next;
		}
		return true;
	}
	
	//activity class, node for linked list
	private class Activity {
		
		//variables that will hold the information of the activity
		private String name;
		private int duration;
		private Activity next;
		
		//Constructor
		private Activity(String aName, int aDuration){
			name = aName;
			duration = aDuration;
			next = null;
		}
		
	}

	
}
