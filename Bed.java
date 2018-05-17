/**
*
* @author Jekaterina Kelbaite
*
* Last date of editing: 12/12/2017
*/


/**
 * The class models a bed object. Every bed has a capacity(variable bedCapacity). 
 * In order to name the size of the bed, the method getBedDescription is used.
 * 
 * */

public class Bed {

	//initialization of a private integer variable for the capacity of a bed
	private int bedCapacity;

	/** Constructor */
	public Bed( int bedCapacity){
		this.bedCapacity = bedCapacity;
	}

	/** Get method for bedCapacity - to access the variable outside this class */
	public int getBedCapacity() {
		return bedCapacity;
	}

	/** Set method for bedCapacity - sets the value for this private variable */
	public void setBedCapacity(int bedCapacity) {
		this.bedCapacity = bedCapacity;
	}
	
	/** The method gives a description of the size of the bed (Single, Double) according to the capacity. */
	public String getBedDescription()
	{
		String result="";
		//if the capacity is 1, the bed is Single
		if (this.bedCapacity == 1)
		{
			result = "Single";
		} 
		//if the capacity is 2, the bed is Double
		else if (this.bedCapacity == 2)
		{
			result = "Double";
		}
		return result;
	}
	
	
}

