package Registers;

public class FPRegister extends Register{
		public FPRegister(int inputValue) {
			super(inputValue, 16, "FPR");			
	}
	public String getMantissaValue_String() {
		String value = getBitValue();
        return value.substring(8, 16);
    }
	public int getMantissaValue_Integer() {
		String value = getBitValue();
        return Integer.parseInt(value.substring(8, 16), 2);
    }
	public int getExponentValue_Integer() {
		String value = getBitValue();
        return Integer.parseInt(value.substring(1, 8), 2);
    }

    public String getExponentValue_String() {
    	String value = getBitValue();
        return value.substring(1, 8);
    }
    public int getSignBit_Integer() {
    	String value = getBitValue();
        int sign = Character.getNumericValue(value.charAt(0));
        if (sign == 1) {
            return -1;
        } else {
            return 1;
        }
    }
    public String getSignBit_String() {
    	String value = getBitValue();
        return String.valueOf(value.charAt(0));
    }
}
