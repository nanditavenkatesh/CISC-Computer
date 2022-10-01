package Registers;

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
