package Registers;
/*
 * The Program Counter class is a child class of the Register class and inherits its properties.
 * when it's called it creates the PC which holds the address of the next instruction to be 
 * executed from memory
 */
public class PCRegister extends Register{
	public PCRegister(int inputValue) {
		super(inputValue, 12, "PC");
	}
}
