# CSE360p
Network Class:
Variables:
Array of paths object

Functions:
Process - returns a string listing paths in order with the one with lowest duration on top
Inputs: array of paths
output: string

sortNetwork - goes through array and sorts paths based on their duration, with lowest	duration being first
Inputs: array of paths
Output: none

addActivity - adds activity to the network
	Inputs: string name, int duration
	-This will first make sure all inputs are valid
	-Call checkPredecessor to see if the predecessor exists, it not output error
	-If it exists, call checkPredecessorNext to see if the predecessor is already linked to another activity
	-If the predecessor is already linked to another activity, create a new path to add to the array by copying the old path up to the predecessor and add the activity to next
	-if predecessor does not have a next activity, add activity to path(calls addToPath function)
	-make sure to loop through the array to do this for every path, because paths can merge(this means we’ll add a activity to both of the paths)


Path Class:
Variables: 
Activity Object
Int pathDuration

Constructors:
	Path(int duration, string name)- creates a starting node, calls constructor from activity class

Functions:
addToPath- adds an activity onto the path (This will call addNode function from activity class, this will also add the duration of the new activity to pathDuration)
	Inputs: int for duration, string for name
	Output: none

checkPredecessor - goes through the path to check if the predecessor exists
	Inputs: name of predecessor(string)
	Outputs: boolean(true or false)

checkPredecessorNext - goes through path to see if the predecessor already has a node for next
Inputs: name of predecessor(string)
Outputs: boolean

copyPath - creates and copies a path up to a certain node
	Inputs: string name for where to copy up to, and path object to copy from
	Outputs: new path


Activity Class(This will be a linked list)
Variables:
String name
Int duration
Activity?(this will be a pointed to point to next node) next

Functions:
addNode- adds a node to next
	Inputs: int for duration, string for name
	Output: none
