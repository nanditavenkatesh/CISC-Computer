package Registers;

import java.util.ArrayList;
import java.util.logging.Logger;


 /* The super class of register.
  * All registers are extended from this class
  */

public class Register {
    private int value, length;
    private String name;
    private int registerNumber;
    private boolean isStringInput;
    private ArrayList<Integer> charaterValues = new ArrayList();
    final Logger logging = Logger.getLogger("CPU.Register");
    
    //Accepts the value, length and the Name of the register and creates the same with the respective size and name
    public Register(int value, int length, String name) {
        this.length = length;
        this.name = name;
        this.registerNumber = value;
        this.isStringInput = false;
        setValue(0);
    }
    //Change to BinaryString
    public String ToBinaryString() {
        String binaryStr = Integer.toBinaryString(value);
        String stringlength = "" + length;
        String format = "%0numberd".replace("number", stringlength);
        return String.format(format, Long.valueOf(binaryStr));
    }

    public int getValue() {
        return value;
    }
    
    public boolean getIsStingValue() {
    	return isStringInput;
    }
    
    public String getBitValue() {
        return ToBinaryString();
    }
    
    public ArrayList<Integer> getCharacterValues(){
        return charaterValues;
    }
    
    public int getLength() {
    	return length;
    }

    //Do the security check (if overflow) and set the value to the register.
    
    public void setIsStingValue(boolean value) {
    	isStringInput = value;
    }
    
    public void setCharacterValues(ArrayList<Integer> charaterValues){
        this.charaterValues = charaterValues;
    }
    
    public void setValue(int Value) {
        if (Math.pow(2, length) > Value && Value >= 0) {
            this.value = Value;
            logging.info(name + "=>" + ToBinaryString() + "(" + value + ")");
            System.out.println(name + "=>" + ToBinaryString() + "(" + value + ")");
        } else {
            logging.info("INVALID " + name + "=>" + ToBinaryString() + "(" + Value + ")");
            System.out.println("INVALID " + name + "=>" + ToBinaryString() + "(" + Value + ")");
        }
    }

    // Do the security check (if overflow) and set the value to the register. 
    public void setValue(String Value) {
        int IntValue = Integer.valueOf(Value, 2);
        setValue(IntValue);
    }

}