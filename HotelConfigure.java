import java.util.ArrayList;
import java.util.Scanner;
/**
*
* @author Jekaterina Kelbaite
*
* Last date of editing: 12/12/2017
*/

/** The main driver class of the program. This creates the hotel, room, and bed objects that are modeled elsewhere
* (in Hotel, Room, Bed classes), allows to input data and prints it back to the user.
* 
* This class contain the main method which provides a user interface that allows to choose a number of hotels,
*  for each hotel the number of rooms, and for each room choose the number and size of beds.
*  Moreover, the method errorCorrection is used to correct invalid data, the method intReadIn to read in the integer
*  value using Scanner, the method show to print the given line of text and the method enterRequest to print a different 
*  request for the input according to the given number.
* 
*/

public class HotelConfigure
{
	//new Scanner class object to read in the information from the keyboard. It is public because used not only in the main method.
	public static Scanner myVar = new Scanner(System.in);
	
	/** the MAIN method  */
	public static void main(String[] args) {
		
		//initialization of a private list of hotel objects
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	
		//print the explanation for the user (what to input)
		show("Enter the number of hotels: ");
		
		//read in the number of hotels the user wants to create
		int hotelNumber=intReadIn();
		
		/* The number of hotels has to be valid. 
		 * So, if the user enters the value which is less than 1, he/she is asked to 
		 * reenter the data - call errorCorrection method */
		hotelNumber = errorCorrection(hotelNumber, "hotels");
		
		/* This for loop is responsible for creating the hotel objects */
		for (int i = 0; i < hotelNumber; i++)
		{
			//print the explanation for the user (what to input)
			enterRequest(hotelNumber,"Please enter the hotel name: ","Please enter the name of hotel ",i);
			
			//read in the name of the hotel
			String hotelName = myVar.nextLine();
			
			//create the hotel object
			Hotel hotel = new Hotel(hotelName);
			//add the hotel object to the list of hotels
			hotels.add(hotel);
			
			//print the explanation for the user (what to input)
			show("Please enter a number of rooms you want to create in hotel " + hotelName + ": ");
			
			//read in the number of rooms the user wants to create in the hotel
			int numOfRooms = intReadIn();
			
			/* The number of rooms in the hotel has to be valid. 
			 * So, if the user enters the value which is less than 1, he/she is asked
			 * to reenter the data - call errorCorrection method*/
			numOfRooms = errorCorrection(numOfRooms, "rooms");
			
			//initialization of an integer variable that represents the index of the room in the list of rooms
			int roomIndex=0;
			
			/* This loop is responsible for creating room objects AND adding them to the hotel's room list */	
			for (int j = 0; j < numOfRooms; j++)
			{
				//print the explanation for the user (what to input)
				enterRequest(numOfRooms,"Please enter the number of beds in this room: ","Please enter the number of beds in room ",j);

				//read in the number of beds the user wants to create in the room
				int numOfBeds = intReadIn();
				
				/* The number of beds in the room has to be valid. 
				 * So, if the user enters the value which is less than 1, he/she is asked to 
				 * reenter the data - call errorCorrection method*/				
				numOfBeds=errorCorrection(numOfBeds, "beds");
				
				//create the room  object
				Room room = new Room(numOfBeds); 
				
				//add the new room object directly to the Hotel's list of rooms, different for every hotel
				hotel.addRoomToList(room); 
				
				/*This loop is responsible for creating bed objects AND adding them to the room's bed list*/
				for(int k=0; k<numOfBeds; k++)
				{
					//print the explanation for the user (what to input)
					enterRequest(numOfBeds, "Please enter the  capacity of this bed (1 or 2): ","Enter the capacity of bed ",k);
		
					//read in the capacity of the bed
					int bedCapacity = intReadIn();
					
					/* The capacity of beds in the room has to be valid. 
					 * So, if the user enters the value which is not 1(single bed) and not 2(double bed), he/she is asked to reenter the data */
					while(!(bedCapacity == 1 || bedCapacity == 2))
					{
						//print the explanation for the user (what to input)
						show("The size can be only single or double. Please enter the size of bed "+(i+1)+" (1 or 2) again: ");
						//read in the capacity of the bed
						bedCapacity=intReadIn();
					}
					
					//create the bed object
					Bed bed=new Bed(bedCapacity);
					//add the new bed object directly to the Room's list of beds, different for every room
					room.addBedToList(bed);
				}
				
				/*  Book a room   */
				
				//print the explanation for the user (what to input)
				show("To book this room press 1. Otherwise press 0 (to continue entering the information about the next room)");
				//read in the data
				int book=intReadIn();
				
				/* The data the user was asked to enter has to be valid.
				 * So if the entered value is not 1(book the room) and not 0(continue entering the information), he/she is asked to reenter the data.
				 **/
				while(!(book==1 || book==0))
				{
					//explain that the entered data was wrong
					show("The character is not suitable!");
					//print the explanation for the user (what to input)
					show("To book this room press 1. Otherwise press 0 (to continue entering the information about the next room)");
					//read in the data
					book=intReadIn();;
				}
				
				//if the user entered 1 => book the room in the hotel
				if(book==1)
				{
					//book the room 
					hotel.bookRoom(roomIndex);
				}
				//increment the index for the next loop 
				roomIndex++;
				
				//update the information about the vacancy of the hotel after creating and booking rooms
				hotel.setHasVacancies(hotel.updateHasVacancies());
			}
			
		}
	
		//close the scanner
		myVar.close();
		
		// For every hotel object, create a report
		for (Hotel h : hotels)
		{
			//create an object of HotelReport class
			HotelReport report = new HotelReport(h);
			//get the report for the given hotel
			report.getReport();
		}
	}	
	
	/** The method print a different request for the input according to the given number */
	private static void enterRequest(int num, String string1, String string2, int index) {
		if(num==1)
		{
			show(string1);
		}
		else show(string2+(index+1)+": ");
	}

	/** The method prints the given line of text */
	private static void show(String string) {
		System.out.println(string);
	}

	/** The method reads in the integer value using Scanner*/
	private static int intReadIn() {
		return Integer.valueOf(myVar.nextLine());
	}

	/** The method asks to reenter the incorrect data until it is correct*/
	private static int errorCorrection(int num, String what){
		if(num<1)
		{
			while(num<1)
			{
				//ask the user to reenter the number of beds in the room
				System.out.println("The number of "+what+" should be positive! Please enter the number of "+what+" again: ");
				//read in the number of beds the user wants to create in the room
				num=intReadIn();
			}
		}
		return num;
	}
}
