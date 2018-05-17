import java.util.ArrayList;
import java.util.List;
/**
*
* @author Jekaterina Kelbaite
*
* Last date of editing: 12/12/2017
*/

/**
 * The class models a hotel object. Every hotel stores the name, the number of rooms in it (variable numberOfRooms), the list of 
 * room objects (list roomList) and vacancy status (boolean variable hasVacancies).
 *  
 * This class also contains the method which adds the given room to the list of rooms (addRoomToList), 
 * the method which updates the information whether a hotel has a vacancy (updateHasVacancies),
 * the method that changes the status of the room occupancy (bookRoom)
 * and the method that counts the total number of sleeping places in the hotel (getMaxOccupancy).
 * 
 * */

public class Hotel {

	//initialization of a private String variable which stores the name of the hotel
	private String name;
	//initialization of a private integer variable that stores the number of rooms in the hotel
	private int numberOfRooms;
	//initialization of a private boolean variable for hasVacancies property
	private boolean hasVacancies;
	//initialization of a private list of room objects that the hotel has
	private ArrayList<Room> roomList;
	
	/** Constructor */
	public Hotel(String name)
	{
		this.name = name;
		this.roomList = new ArrayList<>();
	}
	
	/** Get method for name - to access the variable outside this class */
	public String getName() {
		return name;
	}
	
	/** Set method for name - sets the value for this private variable */
	public void setName(String name) {
		this.name = name;
	}
		
	/** Get method for numberOfRooms - to access the variable outside this class */
	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	/** Set method for numberOfRooms - sets the value for this private variable */
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}	
	
	/** Get method for hasVacancies - to access the variable outside this class */
	public boolean isHasVacancies() {
		return hasVacancies;
	}	
	
	/** Set method for hasVacancies - sets the value for this private variable */
	public void setHasVacancies(boolean hasVacancies) {
		this.hasVacancies=hasVacancies;
	}
	
	/** The method updates the information whether a hotel has a vacancy*/
	public boolean updateHasVacancies(){
		
		/* To decide if the hotel has vacancies, we can assume that if ANY ONE room has a vacancy => the hotel has a vacancy*/
		
		//this for loop goes through the list of rooms and if ANY of them is not occupied the method returns true (hotel has a vacancy)
		for(Room room : this.roomList)
		{
			// If the room is NOT OCCUPIED
			if (!room.isOccupied()) 
			{
				// The hotel a vacancy - return true
				return true; 
			}
		}
		//otherwise - if the value was not returned while executing the for loop (where all the room were checked for occupancy) - return false
		return false;
	}

	/** Get method for roomList - to access the variable outside this class */
	public ArrayList<Room> getRoomList() {
		return roomList;
	}
	
	/** Set method for roomList - sets the value for this private variable */
	public void setRoomList(ArrayList<Room> roomList) {
		this.roomList = roomList;
	}
	
	/** The method adds the given room to the list of rooms*/
	public void addRoomToList(Room room){
		this.roomList.add(room);
	}
	
	/** The method changes the status of the room to occupied (sets a boolean variable occupied to true)*/
	public void bookRoom(int roomNumber){
		//set the variable occupied to true for a particular room
		this.roomList.get(roomNumber).setOccupied(true);
	}
	
	/** The method counts the number of sleeping places in the hotel - maximum occupancy*/
	public int getMaxOccupancy() {
		
	/* To count maximum occupancy of a hotel, we need to add up the number of sleeping places of every bed in every room of the hotel*/
		
		//initializing of an integer variable that stores the number of sleeping places
		int places=0;
		
		//this for loop goes through the list of rooms
		for(Room r: roomList)
		{
			//get the list of beds for a particular room
			ArrayList<Bed>beds = r.getBedList();
			
			//this for loop goes through the list of beds
			for(Bed b: beds)
			{
				//count the number of sleeping places
				places+=b.getBedCapacity();
			}
		}
		return places;
	}
	
	
}