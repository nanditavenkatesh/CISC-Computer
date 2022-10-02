package Utils;
//A Java program used to convert binary into integer values when it is called
public class ConvertBinarytoInt {
	public int ToInteger(String c){ 
		//Variable to store the input binary value
		String binaryString = c;  
		//Stores the converted integer value 
		int decimal = Integer.parseInt(binaryString,2);  
		//returning the converted value
		return decimal;
	}
}