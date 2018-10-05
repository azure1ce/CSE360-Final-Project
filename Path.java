
public class Path {
	
	Activity aPath; //starting activity, head of linked list
	int pathDuration; //duration of the whole path
	
	//constructor
	public Path(String aName, int aDuration){
		aPath = new Activity(aName, aDuration);
		pathDuration = aDuration;
	}
	
	//methods
	//get method for pathDuration
	public getPathDuration(){
		return pathDuration;
	}
	
	//method to add an activity to the end of the path
	public void addToPath(String aName, int aDuration){
		//create a temp variable to point to head of linked list, then traverse to end of linked list
		Activity temp = aPath;
		while(temp.next != null){
			temp = temp.next;
		}
		
		//add create new node and add it
		Activity newActivity = new Activity(aName, aDuration);
		temp.next = newActivity;
		pathDuration += aDuration; //add on the duration to the total duration of path
	}
	
	//go through path and find if a node exists
	public boolean checkPredecessor(String aName){
		
		Activity temp = aPath;
		//go through path
		while(temp.next != null){
			//return true if path exists
			if(temp.name == aName){
				return true;
			}
			temp = temp.next; //move on to next node if current node is not predecessor
		}
		
		return false; //return false if predecessor was not found in path
	}
	
	//check to see if a predecessor is already linked to another activity
	public boolean checkPredecessorNext(String aName){
		
		//go to predecessor in the path
		Activity temp = aPath;
		while(temp.name != aName){
			temp = temp.next;
		}
		
		//return true if the predecessor's next is null, else return false
		if(temp.next == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	//copy a path up to a certain activity
	public Path copyPath(String aName){
		
		//create new path, and temp pointer to current path
		Path newPath = new Path(aPath.name, aPath.duration);
		Activity temp = aPath.next;
		
		//go through path and copy the nodes
		while(temp.name != aName){
			newPath.addToPath(temp.name, temp.duration);
			temp = temp.next;
		}
		//need to copy node again to copy the activity that is inputed because while loops stops on the input activity
		newPath.addToPath(temp.name, temp.duration);
		
		return newPath; //return the newly created path
		
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
