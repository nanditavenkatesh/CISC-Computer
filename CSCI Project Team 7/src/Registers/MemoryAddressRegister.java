package Registers;
/*
 * The Memory Address Register is a child class of the Register class and inherits its properties.
 * when it's called it creates the MAR register which points to the address location in the memory
 * It is allocated with 12 bits
 */
public class MemoryAddressRegister extends Register{
	public MemoryAddressRegister(int inputValue) {
		super(inputValue, 12, "MAR");
	}

}
