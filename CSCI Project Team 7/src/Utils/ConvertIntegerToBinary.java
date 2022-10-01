package Utils;

public class ConvertIntegerToBinary {
	public String ToBinary(int c){ 
		int decimal = c;
		String binaryString = Integer.toBinaryString(0x10000 |decimal).substring(1);  
		return binaryString;
	}
	public String ToBinary12(int c){ 
		int decimal = c;
		String binaryString = Integer.toBinaryString(0x10000 |decimal).substring(5);  
		return binaryString;
	}
}
