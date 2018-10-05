
public class Network {

	private Path[] networkPaths; 
	
	//constructor
	public Network(String aName, int aDuration){
		
		networkPaths = new Path[10]; //will create more space if necessary by copying into a larger array later
		//fill the array with null
		for(int i = 0; i < networkPaths.length; i++){
			networkPaths[i] = null;
		}
		
		//create new path and place into network
		Path newPath = new Path(aName, aDuration);
		networkPaths[0] = newPath;
		
	}
	
	//methods
	public void addActivity(String aName, int aDuration, String predecessor){
		
		//check to make sure predecessor exists
		boolean predecessorExists = false;
		boolean predecessorNextExists = false;
		for(int i = 0; i < networkPaths.length; i++){ //check every path in the network diagram
			if(networkPaths[i] != null){
				if(networkPaths[i].checkPredecessor(aName)){ //check to see if predecessor exists
					predecessorExists = true;
					
					if(networkPaths[i].checkPredecessorNext(aName)){ //then check to see if predecessor already has a next if it exists
						predecessorNextExists = true;
					}
				}
			}
		}
		
		//adding activity
		if(predecessorExists){
			//a split in the diagram
			if(predecessorNextExists){
				this.checkFull();
				int newIndex = 0;
				while(networkPaths[newIndex] != null){
					newIndex++;
				}
				for(int i = 0; i < networkPaths.length; i++){
					if(networkPaths[i] != null){
						if(networkPaths[i].checkPredecessor(aName)){
							Path newPath = networkPaths[i].copyPath(aName); //create a new path
							newPath.addToPath(aName, aDuration); //add activity to new path
							//check to make sure new path does not already exist in network
							boolean alreadyExists = false;
							for(int k = newIndex; k < networkPaths.length; k++){
								if(networkPaths[k] != null){
									if(networkPaths[k].comparePaths(newPath)){
										alreadyExists = true;
									}
								}
							}
							//add new path to network
							if(!alreadyExists){
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
						if(networkPaths[i].checkPredecessor(aName)){
							networkPaths[i].addToPath(aName, aDuration);
						}
					}
				}
			}
			
		}
		
		
	}
	
	//checks to see if array is full, if it is then create a larger array
	public void checkFull(){
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
	
}
