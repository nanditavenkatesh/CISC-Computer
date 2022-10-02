package Registers;
/*
 * The Memory Buffer Register  register class is a child class of the Register class and inherits its properties.
 * when it's called it creates the MBR register which is a buffer that stores the data that is being transferred
 * to and from the immediate access storage
 */
public class MemoryBufferRegister extends Register {
	public MemoryBufferRegister(int inputValue) {
		super(inputValue, 16, "MBR");
	}

}
