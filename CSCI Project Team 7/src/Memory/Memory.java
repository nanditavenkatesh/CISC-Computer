package Memory;

import java.util.HashMap;
import java.util.logging.Logger;

/*
*Memory Class used to implement the memory size of 2048 words. The memory is also expandable to 4096 words.
*The Set and Get methods are used to set the memory with the provided value and to retrieve the stored value from the memory respectively
*Clear memory method is used to reset the hash map
*/
public class Memory {
	//Use Hash map to serve as the memory
	HashMap<Integer, Integer> memory;
	//Memory Limit for default value
	private int maxSize = 2048;
	
	private final static Logger logger = Logger.getLogger("MemoryLogger");
	
	//Constructor to initialize the object and create the Hash map to be used as memory
	public Memory() {
		memory = new HashMap<>();
	}
	
	//Expand the memory to 4096 when called, sets the maxSize variable to 4096 
	public void expandMemory() {
		maxSize = 4096;
	}
	
	//Shrink Memory to 2048, this is a hard shrink and does not save values before shrinking
	public void shrinkMemory() {
		maxSize = 2048;
	}
	
	//Set Memory value if the memory address and value are less than maxSize and 16 bits respectively
	//If invalid throw error
	public void setValue(String address, String value) {
		int addressInInt = Integer.valueOf(address, 2);
		//verify the address is valid
		if (addressInInt < maxSize && value.length() <= 16) {
			if (addressInInt > 6) {
				memory.put(addressInInt, Integer.valueOf(value, 2));
				//log the address and the value stored
				logger.info("Value " + value + " placed at memory location " + address);
			}
			else {
				logger.severe("Reserved Memory Location cannot be used");
			}
			
		}
		//if address is invalid the error message is printed
		else
		{
			logger.severe("Invalid Memory Address");
		}
		
	}
	//Get the Memory value if the memory address is valid else return 0
	public int getValue(String address) {
		
		int addressInInt = Integer.valueOf(address, 2);
		//verify the address is valid
		if (addressInInt >= maxSize || memory.get(addressInInt)== null) {
			return 0;
		}
		else
		{
			return memory.get(addressInInt);
		}
		
	}
	//Reset the hash map to default value and clear all the stored values
	public void clearMemory() {
		memory.clear();
	}

}
