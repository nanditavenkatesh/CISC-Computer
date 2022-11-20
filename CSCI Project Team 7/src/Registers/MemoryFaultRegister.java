package Registers;
/*
 * The Memory Fault Register class is a child class of the Register class and inherits its properties.
 * when it's called it creates the MFR which holds the machine faults
 */
public class MemoryFaultRegister extends Register{
	public MemoryFaultRegister(int inputValue) {
		super(inputValue, 4, "MFR");
	}
}
