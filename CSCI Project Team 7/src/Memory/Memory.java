package Memory;

import java.util.HashMap;
import java.util.logging.Logger;

//Memory Class
public class Memory {
	//Use Array List to save data
	HashMap<Integer, Integer> memory;
	//Memory Limit
	private int maxSize = 2048;
	
	private final static Logger logger = Logger.getLogger("MemoryLogger");
	
	public Memory() {
		memory = new HashMap<>();;
	}
	
	//Expand the memory to 4096
	public void expandMemory() {
		maxSize = 4096;
	}
	
	//Shrink Memory to 2048
	public void shrinkMemory() {
		maxSize = 2048;
	}
	//Set Memory value if the memory address and value are less than maxSize and 16 bits respectively
	//If invalid throw error
	
	public void setValue(String address, String value) {
		int addressInInt = Integer.valueOf(address, 2);
		//verify the address is valid
		if (addressInInt < maxSize && value.length() <= 16) {
			memory.put(addressInInt, Integer.valueOf(value, 2));
			logger.info("Value " + value + " placed at memory location " + address);
		}
		else
		{
			logger.severe("Invalid Memory Address");
		}
		
	}
	public int getValue(String address) {
		int addressInInt = Integer.valueOf(address, 2);
		//verify the address is valid
		if (addressInInt >= maxSize || memory.get(addressInInt)== null) {
			return 0;
			//logger.info("Value " + value + "placed at memory location" + address);
		}
		else
		{
			return memory.get(addressInInt);
			//logger.severe("Invalid Memory Address");
		}
		
	}
	public void clearMemory() {
		memory.clear();
	}

}
