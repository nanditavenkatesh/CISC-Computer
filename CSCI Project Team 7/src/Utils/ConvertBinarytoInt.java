package Utils;

public class ConvertBinarytoInt {
	public int ToInteger(String c){  
		String binaryString = c;  
		int decimal = Integer.parseInt(binaryString,2);  
		return decimal;
	}
}