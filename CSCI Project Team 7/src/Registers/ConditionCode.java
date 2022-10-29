package Registers;

/*
 * The CC register is a child class of the Register class and inherits its properties.
 * when it's called it creates the CC register of 1 bit size
 */

public class ConditionCode extends Register {
	public ConditionCode(int inputValue) {
		super(inputValue, 1, "CC");
	}

}
