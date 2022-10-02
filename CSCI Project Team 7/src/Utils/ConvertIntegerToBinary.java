package Utils;
//A java program used to convert the Integer values into binary
public class ConvertIntegerToBinary {
	public String ToBinary(int c){ 
		//Stores the integer value received
		int decimal = c;
		//Stores and converts the integer value into 16 bit binary string
		String binaryString = Integer.toBinaryString(0x10000 |decimal).substring(1);  
		//Return the value
		return binaryString;
	}
	public String ToBinary12(int c){ 
		//Stores the integer value received
		int decimal = c;
		//Stores and converts the integer value into 12 bit binary string
		String binaryString = Integer.toBinaryString(0x10000 |decimal).substring(5);  
		//Return the value
		return binaryString;
	}
}
