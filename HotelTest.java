import java.util.ArrayList;

/**
*
* @author Jekaterina Kelbaite
*
* Last date of editing: 12/12/2017
*/

/**
 * 
 * This class creates a couple of hotels, several rooms in each hotel and few beds in each room 
 * in the main method. The class demonstrates that the hotel object is be able
 * to calculate its maximum occupancy
 * 
 * */

public class HotelTest {
	

	/** the MAIN method*/
	public static void main(String[] args)
	{
		//create the list of hotels
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		
		//create two hotel objects
		Hotel h1 = new Hotel("Hotel Plaza");
		Hotel h2 = new Hotel("Grand Hotel");
		
		//add two hotel objects to the hotel list
		hotels.add(h1);
		hotels.add(h2);
		
		//create rooms for Hotel Plaza
		Room r1_1 = new Room(3);
		Room r1_2 = new Room(1);
		Room r1_3 = new Room(2);
		
		//add these rooms to Hotel Plaza room list
		h1.addRoomToList(r1_1);
		h1.addRoomToList(r1_2);
		h1.addRoomToList(r1_3);
		
		//create rooms for Grand Hotel
		Room r2_1 = new Room(1);
		Room r2_2 = new Room(1);
		
		//add these rooms to Grand Hotel room list
		h2.addRoomToList(r2_1);
		h2.addRoomToList(r2_2);
		
		
		//create beds for rooms in Hotel Plaza
		Bed b1_1_1 = new Bed(2);
		Bed b1_1_2 = new Bed(1);
		Bed b1_1_3 = new Bed(1);
		Bed b1_2 = new Bed(2);
		Bed b1_3_1 = new Bed(1);
		Bed b1_3_2 = new Bed(1);
		
		//add these beds to the bed list of a particular room (in Hotel Plaza)
		r1_1.addBedToList(b1_1_1);
		r1_1.addBedToList(b1_1_2);
		r1_1.addBedToList(b1_1_3);
		r1_2.addBedToList(b1_2);
		r1_3.addBedToList(b1_3_1);
		r1_3.addBedToList(b1_3_2);
		
		
		//create beds for rooms in Grand Hotel
		Bed b2_1 = new Bed(2);
		Bed b2_2 = new Bed(1);
				
		//add these beds to the bed list of a particular room (in Grand Hotel)
		r2_1.addBedToList(b2_1);
		r2_2.addBedToList(b2_2);
				
		//for each hotel count and print out its maximum occupancy
		for (Hotel h : hotels)
		{
			System.out.println("Maximum occupancy of hotel "+h.getName()+": "+h.getMaxOccupancy());
		}
		
	}
}
