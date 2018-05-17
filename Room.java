import java.util.ArrayList;
/**
*
* @author Jekaterina Kelbaite
*
* Last date of editing: 12/12/2017
*/

/**
 * The class models a room object. Every room stores the number of beds in it (variable numberOfBeds), the list of 
 * bed objects (list bedList) and occupancy status (boolean variable occupied).
 *  
 * This class also contains the method to add given bed to the list of beds (addBedToList) and the method which 
 * creates a word description of the availability of the room according to the room's occupancy status (getAvailabilityDescription).
 * */

public class Room {

	//initialization of a private integer variable that stores the number of beds in the room
	private int numberOfBeds;
	//initialization of a private list of bed objects that the room has
	private ArrayList<Bed> bedList;
	//initialization of a private boolean variable that identifies whether the room is occupied
	private boolean occupied;

	/** Constructor */
	public Room(int numberOfBeds){
		setNumberOfBeds(numberOfBeds);
		this.bedList = new ArrayList<Bed>();
	}

	/** Get method for numberOfBeds - to access the variable outside this class */
	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	/** Set method for numberOfBeds - sets the value for this private variable */
	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}
	
	/** Get method for bedList - to access the variable outside this class */
	public ArrayList<Bed> getBedList() {
		return bedList;
	}
	
	/** Set method for bedList - sets the value for this private variable */
	public void setBedList(ArrayList<Bed> bedList) {
			this.bedList = bedList;
	}
		
	/** Get method for the variable occupied - to access the variable outside this class */
	public boolean isOccupied() {
		return occupied;
	}

	/** Set method for the variable occupied - sets the value for this private variable */
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	/** The method gives a word description of the availability of the room according to the occupancy status */
	public String getAvailabilityDescription(){
		//if isOccupied is true => the room is booked
		if(this.isOccupied())
		{
			return "booked";
		}
		//else the room is available
		else return "available";
	}
	
	/** The method adds the given bed to the list of beds */
	public void addBedToList(Bed bed)
	{
		//add the bed to the bedList
		this.bedList.add(bed);
	}
		
	
}
