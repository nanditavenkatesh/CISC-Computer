package Registers;
/*
 * The GPR register is a child class of the Register class and inherits its properties.
 * when it's called it creates the GPR register
 */
public class GPRegister extends Register {

	public GPRegister(int inputValue) {
		super(inputValue, 16, "GPR");
	}
	
}
