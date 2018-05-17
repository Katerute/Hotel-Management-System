import java.util.ArrayList;
import java.util.Scanner;

/**
*
* @author Jekaterina Kelbaite
*
* Last date of editing: 12/12/2017
*/

/**
 * 
 * This class produces a textual report for a hotel object describing the name of the hotel, 
 * the number of rooms and, for each room, lists the number and size of the beds. Moreover, 
 * it also displays if the hotel has vacancies or not.
 *
 */

public class HotelReport {
	
	//initialization of an "abstract" hotel object(without values). The values will be passed from other classes
	private Hotel hotel;
	
	/** Constructor */
	public HotelReport(Hotel h)
	{
		//pass the hotel object from another class to this class
		this.hotel = h;
	}
	
	/** The method generates the report for the given hotel */
	public void getReport()
	{
		System.out.println("======================================================================================");
		
		//show the name of the hotel
		System.out.println(String.format("The name of hotel:\t%s",this.hotel.getName()));
		
		System.out.println("--------------------------------------------------------------------------------------");
		
		//show the number of rooms in the hotel
		System.out.println(String.format("The number of rooms:\t%s",this.hotel.getRoomList().size()));
	
		//get the list of rooms for a particular hotel object
		ArrayList<Room> rooms = this.hotel.getRoomList();
		
		//initialization of an integer variable that represents the index of the room in the list of rooms
		int roomIndex=1;
		
		/*This for each loop is responsible for displaying the number of beds in each room*/
		for(Room r: rooms)
		{
			if(this.hotel.getRoomList().size()==1)
			{
				System.out.println(String.format(" The number of beds in this room ("+r.getAvailabilityDescription()+"):  %s",r.getNumberOfBeds()));
			}
			else System.out.println(String.format(" The number of beds in room "+roomIndex+ " ("+r.getAvailabilityDescription()+"):  %s",r.getNumberOfBeds()));//show the number of beds in each room
			roomIndex++;
			
			//get the list of beds for a particular room object
			ArrayList<Bed>beds = r.getBedList();
			
			//initialization of an integer variable that represents the index of the bed in the list of beds
			int bedIndex=1;
			
			/*This for each loop is responsible for displaying the size of each bed*/
			for(Bed b : beds)
			{
				//show the size of each bed
				if(r.getNumberOfBeds()==1)
				{
					System.out.println(String.format("		The size of this bed:\t%s",b.getBedDescription()));
				}
				else System.out.println(String.format("		The size of bed "+bedIndex+":\t%s",b.getBedDescription()));
				bedIndex++;
			}
		}
		//display if the hotel has vacancies or not
		if(this.hotel.isHasVacancies())
		{
			System.out.println("Has vacancies!");
		}
		else System.out.println("No rooms available!");
		System.out.println("======================================================================================");
		
	}
}

