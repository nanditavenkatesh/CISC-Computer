package Registers;

import java.util.logging.Logger;


 // The super class of register.
 // All register are extended from this class

public class Register {
    private int value, length;
    private String name;
    final Logger logging = Logger.getLogger("CPU.Register");

    public Register(int value, int length, String name) {
        this.length = length;
        this.name = name;
        setValue(value);
    }

    public String ToBinaryString() {
        String binaryStr = Integer.toBinaryString(value);// Change to BinaryString
        String stringlength = "" + length;
        String format = "%0numberd".replace("number", stringlength);
        return String.format(format, Long.valueOf(binaryStr));//
    }

    public int getValue() {
        return value;
    }
    
    public String getBitValue() {
        return ToBinaryString();
    }

    //Do the security check (if overflow) and set the value to the register.
    
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