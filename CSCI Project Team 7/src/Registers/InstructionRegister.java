package Registers;
/*
 * Instruction Register inherits the properties of the Register class
 * The value that is set in the instruction register is separated into individual components 
 * that are used to decode the operation to be performed
 * first 5 bits are reserved for address
 * the following bit is used for direct/indirect addressing
 * the following two bits are used to reference index 
 * the next two bits are used for referencing the General purpose registers
 * The last 6 bits are used for the required op-codes
 */
public class InstructionRegister extends Register{
	public InstructionRegister(int inputValue) {
		super(inputValue, 16, "IR");
	}
	public String IRAddress() {
		String value = getBitValue();
		return value.substring(11);
	}
	public String IRIndirect() {
		String value = getBitValue();
		return value.substring(10, 11);
	}
	public String IROperation() {
		String value = getBitValue();
		return value.substring(0 , 6);
	}
	public String IRGprnumber() {
		String value = getBitValue();
		return value.substring(6, 8);
	}
	public String IRIndexNumber() {
		String value = getBitValue();
		return value.substring(8, 10);
	}
}
