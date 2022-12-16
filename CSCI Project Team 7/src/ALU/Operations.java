package ALU;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import Memory.Cache;
import Memory.Memory;
import Registers.ConditionCode;
import Registers.FPRegister;
import Registers.GPRegister;
import Registers.IndexRegister;
import Registers.InstructionRegister;
import Registers.MemoryAddressRegister;
import Registers.MemoryBufferRegister;
import Registers.MemoryFaultRegister;
import Registers.PCRegister;
import Simulator.ConsoleLog;
import Simulator.ConsolePrinter;
import Utils.ConvertBinarytoInt;
import Utils.ConvertHexToBinary;
import Utils.ConvertIntegerToBinary;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Operations {
	private MemoryAddressRegister mar = new MemoryAddressRegister(0);
	private MemoryBufferRegister mbr = new MemoryBufferRegister(0);
	private MemoryFaultRegister mfr =new MemoryFaultRegister(0);
	private InstructionRegister ir = new InstructionRegister(0);
	private PCRegister pc = new PCRegister(0);
	private Memory memory;
	private Cache cache;
	private GPRegister gpr0 = new GPRegister(0);
	private GPRegister gpr1 = new GPRegister(1);
	private GPRegister gpr2 = new GPRegister(2);
	private GPRegister gpr3 = new GPRegister(3);
	private ArrayList<GPRegister> gprList = new ArrayList<GPRegister>();
	private IndexRegister ixr0 = new IndexRegister(0);
	private IndexRegister ixr1 = new IndexRegister(1);
	private IndexRegister ixr2 = new IndexRegister(2);
	private IndexRegister ixr3 = new IndexRegister(3);
	private ArrayList<IndexRegister> ixrList = new ArrayList<IndexRegister>();
	private FPRegister fpr0 = new FPRegister(0);
	private FPRegister fpr1 = new FPRegister(1);
	private ArrayList<FPRegister> fprList = new ArrayList<FPRegister>();
	private ConditionCode cc0 = new ConditionCode(0);
	private ConditionCode cc1 = new ConditionCode(1);
	private ConditionCode cc2 = new ConditionCode(2);
	private ConditionCode cc3 = new ConditionCode(3);
	private ArrayList<ConditionCode> ccList = new ArrayList<ConditionCode>();
	StringBuilder fileContent = new StringBuilder();
	private ConvertIntegerToBinary cib = new ConvertIntegerToBinary();
	private ConvertBinarytoInt cbi = new ConvertBinarytoInt();
	private ConvertHexToBinary H2B = new ConvertHexToBinary();
	private Devices printer = new Devices();
	private Devices keyboard = new Devices();
	private Devices cardReader= new Devices();
	private ArrayList<Devices> deviceList = new ArrayList<Devices>();
	private ArrayList<Integer> charaterValues = new ArrayList<Integer>();
	private final static Logger logger = Logger.getLogger("OperationsLogger");
	private ConsoleLog console;
	private ConsolePrinter consolePrinter;
	
	
	public Operations(Memory memory, ConsoleLog console, ConsolePrinter consolePrinter) {
		this.memory = memory;
		this.console = console;
		this.consolePrinter = consolePrinter;
		gprList.add(gpr0); gprList.add(gpr1); gprList.add(gpr2); gprList.add(gpr3);
		ixrList.add(ixr0); ixrList.add(ixr1); ixrList.add(ixr2); ixrList.add(ixr3);
		fprList.add(fpr0);fprList.add(fpr1);
		ccList.add(cc0); ccList.add(cc1); ccList.add(cc2); ccList.add(cc3);
		deviceList.add(keyboard); deviceList.add(printer); deviceList.add(cardReader); 
	}
	public ArrayList<GPRegister> getGPRList(){
		return gprList;
	}
	
	public void setGPRList(ArrayList<GPRegister> gprList){
		this.gprList = gprList;
	}
	
	public ArrayList<IndexRegister> getIXRList(){
		return ixrList;
	}
	
	public ArrayList<FPRegister> getFPRList(){
		return fprList;
	}
	
	public ArrayList<ConditionCode> getCCList(){
		return ccList;
	}
	
	/**
	 * @return the mar
	 */
	public MemoryAddressRegister getMAR() {
		return mar;
	}

	/**
	 * @param mar the mar to set
	 */
	public void setMar(MemoryAddressRegister mar) {
		this.mar = mar;
	}

	/**
	 * @return the mbr
	 */
	public MemoryBufferRegister getMBR() {
		return mbr;
	}

	/**
	 * @param mbr the mbr to set
	 */
	public void setMbr(MemoryBufferRegister mbr) {
		this.mbr = mbr;
	}

	/**
	 * @return the mfr
	 */
	public MemoryFaultRegister getMFR() {
		return mfr;
	}

	/**
	 * @param mfr the mfr to set
	 */
	public void setMfr(MemoryFaultRegister mfr) {
		this.mfr = mfr;
	}

	/**
	 * @return the ir
	 */
	public InstructionRegister getIr() {
		return ir;
	}

	/**
	 * @param ir the ir to set
	 */
	public void setIr(InstructionRegister ir) {
		this.ir = ir;
	}

	/**
	 * @return the pc
	 */
	public PCRegister getPc() {
		return pc;
	}

	/**
	 * @param pc the pc to set
	 */
	public void setPc(PCRegister pc) {
		this.pc = pc;
	}

	/**
	 * @return the gpr0
	 */
	public GPRegister getGpr0() {
		return gpr0;
	}

	/**
	 * @param gpr0 the gpr0 to set
	 */
	public void setGpr0(String gpr0) {
		this.gpr0.setValue(gpr0);
	}

	/**
	 * @return the gpr1
	 */
	public GPRegister getGpr1() {
		return gpr1;
	}

	/**
	 * @param gpr1 the gpr1 to set
	 */
	public void setGpr1(String gpr1) {
		this.gpr1.setValue(gpr1);
	}

	/**
	 * @return the gpr2
	 */
	public GPRegister getGpr2() {
		return gpr2;
	}

	/**
	 * @param gpr2 the gpr2 to set
	 */
	public void setGpr2(String gpr2) {
		this.gpr2.setValue(gpr2);
	}

	/**
	 * @return the gpr3
	 */
	public GPRegister getGpr3() {
		return gpr3;
	}

	/**
	 * @param gpr3 the gpr3 to set
	 */
	public void setGpr3(String gpr3) {
		this.gpr3.setValue(gpr3);
	}

	/**
	 * @return the ixr1
	 */
	public IndexRegister getIxr1() {
		return ixr1;
	}

	/**
	 * @param ixr1 the ixr1 to set
	 */
	public void setIxr1(IndexRegister ixr1) {
		this.ixr1 = ixr1;
	}

	/**
	 * @return the ixr2
	 */
	public IndexRegister getIxr2() {
		return ixr2;
	}

	/**
	 * @param ixr2 the ixr2 to set
	 */
	public void setIxr2(IndexRegister ixr2) {
		this.ixr2 = ixr2;
	}

	/**
	 * @return the ixr3
	 */
	public IndexRegister getIxr3() {
		return ixr3;
	}

	/**
	 * @param ixr3 the ixr3 to set
	 */
	public void setIxr3(IndexRegister ixr3) {
		this.ixr3 = ixr3;
	}
	
	/**
	 * @return the gpr0
	 */
	public FPRegister getFpr0() {
		return fpr0;
	}

	/**
	 * @param gpr0 the gpr0 to set
	 */
	public void setFpr0(String fpr0) {
		this.fpr0.setValue(fpr0);
	}

	/**
	 * @return the gpr1
	 */
	public FPRegister getFpr1() {
		return fpr1;
	}

	/**
	 * @param gpr1 the gpr1 to set
	 */
	public void setFpr1(String fpr1) {
		this.fpr1.setValue(fpr1);
	}
	
	// getting the low 16 bits of an integer
	private int getLowOrderBits(int x) {
		return (x & 0xFFFF);
	}

	// getting the high 16 bits of an integer
	private int getHighOrderBits(int x) {
		return x >> 16;
	}
				
	public void loadFromMemory() {
		logger.info("Loading from Memory Begins");
		String addr = mar.getBitValue();
		int i = memory.getValue(addr);
		mbr.setValue(i);
		logger.info("Loading from Memory Ends");
	}
	
	public void store() {
		logger.info("Store Begins");
		String addr = mar.getBitValue();
		String value = mbr.getBitValue();
		int iaddr = cbi.ToInteger(addr);
		//If address is greater than the MAX Size then set MFR to 1
		if(iaddr >= memory.getMemoryMaxSize()) {
			mfr.setValue(8);
			logger.severe("Memory location out of bounds");
		}
		else {
			if(iaddr >= 0 && iaddr <= 5) {
				mfr.setValue(1);
				logger.severe("Cannot perform Store in reserved memory locations");
			}
			else {
				memory.setValue(addr, value);
			}
		}
		logger.info("Store Ends");
	}
	
	public void storePlus() {
		logger.info("Store Plus Begins");
		store();
		mar.setValue(mar.getValue()+1);
		logger.info("Store Plus incremented MAR by 1. Store Plus ends.");
	}
	
	public void singleStep() {
		logger.info("Single Step Begins");
		String PCvalue = pc.getBitValue();
		logger.info("PC value "+pc.getValue());
		int i = memory.getValue(PCvalue);
		ir.setValue(i);
		operation();
		logger.info("Single Step incremented PC by 1");
	}
	
	public int getEA() {
		logger.info("Calculating Effective Address");
		int effectiveAddress;
		String addr = cib.ToBinary12(cbi.ToInteger(ir.IRAddress()));
		//Calling function from the IR Class to fetch the Index Register bits 
		int ixrnumber = cbi.ToInteger(ir.IRIndexNumber());
		//Calling function from the IR Class to fetch the Indirect/Direct bit
		int indirect = cbi.ToInteger(ir.IRIndirect());
		if(indirect==1 && ixrnumber== 0) {
			effectiveAddress = memory.getValue(addr);
			//i = memory.getValue(cib.ToBinary12(effectiveAddress));
		}
		//If indirect is 0 and IXR registers have value fetch the effective address by adding the IXR value to the value present in MAR
		else if(indirect==0 && ixrnumber != 0) {
			int ixrvalue = ixrList.get(ixrnumber).getValue();
			effectiveAddress = ixrvalue + cbi.ToInteger(addr);
			//i = memory.getValue(cib.ToBinary12(effectiveAddress));
		}
		//
		//If indirect is 1 and IXR registers have value fetch the effective address by first adding the IXR value to the value present in MAR
	 	//and then the corresponding value present in memory
		else if(indirect==1 && ixrnumber != 0) {
			int ixrvalue = ixrList.get(ixrnumber).getValue();
			effectiveAddress = memory.getValue(cib.ToBinary12(ixrvalue + cbi.ToInteger(addr)));
			//i = memory.getValue(cib.ToBinary12(effectiveAddress));
		}
		//if both indirect and IXR are 0 the value present in MAR is the effective address
		else {
			effectiveAddress = cbi.ToInteger(addr);
		}
		logger.info("Returning Effective address");
		return effectiveAddress;
	}
	public String rightShift(String value, int count, int AL) {
		char sign;
		if (AL == 0) {
			sign = value.charAt(0);
		}
		else {
			sign = '0';
		}
        for (int i = 0; i < count; i++) {
        	value = sign + value.substring(0, gpr0.getLength() - 1);
        }

        return value;
	}
	
	public String leftShift(String value, int count) {
		for (int i = 0; i < count; i++) {
        	value = value.substring(1, gpr0.getLength()) + "0";
        }

        return value;
	}
	
	public void CMP() {
		int main = gprList.get(1).getValue();
        int smallest = gprList.get(2).getValue();
        int next = gprList.get(3).getValue();
        int oldDiff = main - smallest;
        int newDiff = main - next;
        if (oldDiff > newDiff) {
            gprList.get(2).setValue(next);
        }
        pc.setValue(pc.getValue()+1);
	}
	
	public float binaryToFloatingPoint(FPRegister fr) {
        double result = 0;
        String mantissa = fr.getMantissaValue_String();
        int sign = fr.getSignBit_Integer();
        int exponent = fr.getExponentValue_Integer();
        int bias = 63;
        double exponentValue = Math.pow(2.0, (double)(exponent - bias));
        double half = 0.5;
        double mantissaValue = 1;
        for (int i = 0; i < mantissa.length(); i++) {
            int bit = Integer.valueOf(mantissa.substring(i, i + 1));
            mantissaValue += half * bit;
            half = half / 2;
        }
        result = sign * exponentValue * mantissaValue;
        return (float) result;
    }
	public int floatingPointToBinaryInt(float value) {
        // Get Sign
        String sign;
        if (value >= 0) {
            sign = "0";
        } else {
            sign = "1";
        }
        // Get Exponent
        int exponent = findExponent(value) + 63;
        if (exponent > (63 + 64)) {
        	logger.info("Exponent more than the limit");
            return 0;
        }
        String exponentBinary = toBinaryString(exponent, 7);
        String Mantissa = calculateMantissa(value, exponent - 63);
        return setFPValue(sign, exponentBinary, Mantissa);
    }
	private String calculateMantissa(float value, int exponetInt) {
        value = Math.abs(value);
        Double exponetDouble = Math.pow(2, exponetInt);
        double a = value / exponetDouble - 1;
        double half = 0.5;
        String result = "";
        while (result.length() != 8) {
            if (a > half) {
                result += "1";
                a -= half;
            } else {
                result += "0";
            }
            half = half / 2;
        }
        return result;
    }

    private String toBinaryString(int val, int length) {
        String value = Integer.toBinaryString(val);// Change to BinaryString
        if (value.length() == 32 && value.substring(0, 1).equals("1")) {
            // Negative number
            return value;
        }
        String Stringlength = "" + length;
        String format = "%0numberd".replace("number", Stringlength);
        return String.format(format, Long.valueOf(value));//
    }


    private int findExponent(float value) {
        int num = 1;
        int i = 0;
        while (value > num) {
        	num = num * 2;
            i = i + 1;
        }
        return i - 1;
    }
    
    public int setFPValue(String sign, String exponent, String mantissa) {
        if (sign.length() != 1) {
        	logger.info("Floating Point sign Length Error.");
        }
        if (exponent.length() != 7) {
        	logger.info("Floating Point exponent Length Error.");

        }
        if (mantissa.length() != 8) {
        	logger.info("Floating Point mantissa Length Error.");
        }
        String value = sign + exponent + mantissa;
        return Integer.parseInt(value, 2);

    }
	
	public void LDR() {
		logger.info("LDR Start");
		//Calling function from the IR Class to fetch the GPR bits 
		int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		mar.setValue(getEA());
		mbr.setValue(memory.getValue(cib.ToBinary12(mar.getValue())));
		gprList.get(gprNumber).setValue(mbr.getValue());
		pc.setValue(pc.getValue()+1);
		logger.info("LDR End");
	}

	private void STR() {
		logger.info("STR Start");
		int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		if(!(gprList.get(gprNumber).getIsStingValue())){
			mar.setValue(getEA());
			mbr.setValue(gprList.get(gprNumber).getValue());
			store();
			pc.setValue(pc.getValue()+1);
		}
		else {
			int EA = getEA();
			int asciiValue;
			ArrayList<Integer> ascii = gprList.get(gprNumber).getCharacterValues();
			for(int i = 0; i < ascii.size(); i++) {
				mar.setValue(EA);
				asciiValue = ascii.get(i);
				mbr.setValue(asciiValue);
				store();
				EA = EA + 1;
			}
			gprList.get(gprNumber).setIsStingValue(false);
			pc.setValue(pc.getValue()+1);
		}
		logger.info("STR Ends");
	}
	
	private void LDA() {
		logger.info("LDA Start");
		int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		gprList.get(gprNumber).setValue(getEA());
		pc.setValue(pc.getValue()+1);
		logger.info("LDA Ends");
	}
	
	private void LDX() {
		logger.info("LDX Start");
		//Calling function from the IR Class to fetch the IXR bits 
		int ixrNumber = cbi.ToInteger(ir.IRIndexNumber());
		mar.setValue(getEA());
		logger.info("mar value"+mar.getValue());
		mbr.setValue(memory.getValue(cib.ToBinary12(mar.getValue())));
		logger.info("mbr value"+mbr.getValue());
		ixrList.get(ixrNumber).setValue(mbr.getValue());
		logger.info("ixr value"+ixrList.get(ixrNumber).getValue());
		pc.setValue(pc.getValue()+1);
		logger.info("LDX End");
	}
			
	private void STX() {
		logger.info("STX Start");
		int ixrNumber = cbi.ToInteger(ir.IRIndexNumber());
		mar.setValue(getEA());
		mbr.setValue(ixrList.get(ixrNumber).getValue());
		store();
		pc.setValue(pc.getValue()+1);
		logger.info("STX Ends");
	}
		
	private void JMA() {
		logger.info("JMA Start");
		pc.setValue(getEA());
		logger.info("JMA Ends");
		
	}
	private void JCC() {
		logger.info("JCC Start");
		int ccNumber = cbi.ToInteger(ir.IRGprnumber());
		int ccValue = ccList.get(ccNumber).getValue();
		if (ccValue == 1) {
			pc.setValue(getEA());
		}
		else {
			pc.setValue(pc.getValue() +  1);
		}
		logger.info("JCC Ends");
		
	}
	private void JNE() {
		logger.info("JNE Start");
		 int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		 int gprValue = gprList.get(gprNumber).getValue();
		 if (gprValue != 0) {
			 pc.setValue(getEA());
		 }
		 else {
			 pc.setValue(pc.getValue()+1);
		 }
		logger.info("JNE Ends");
	}
	private void JZ() {
		logger.info("JZ Start");
		 int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		 int gprValue = gprList.get(gprNumber).getValue();
		 if (gprValue == 0) {
			 pc.setValue(getEA());
		 }
		 else {
			 pc.setValue(pc.getValue()+1);
		 }
		logger.info("JZ Ends");
	}
	
	public void JSR() {
		logger.info("JSR Start");
		gprList.get(3).setValue(pc.getValue()+1);
		pc.setValue(getEA());
		logger.info("JSR End");
	}
	
	public void RFS() {
		logger.info("RFS Start");
		gprList.get(0).setValue(ir.IRAddress());
		pc.setValue(gprList.get(3).getValue());
		logger.info("RFS End");
	}
	
	public void SOB() {
		logger.info("SOB Start");
		int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		gprList.get(gprNumber).setValue(gprList.get(gprNumber).getValue()-1);
		if((gprList.get(gprNumber).getValue()) > 0) {
			pc.setValue(getEA());
		}
		else {
			pc.setValue(pc.getValue()+1);
		}
		logger.info("SOB End");
	}

	public void JGE() {
		logger.info("JGE Start");
		int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		if((gprList.get(gprNumber).getValue()) >= 0) {
			pc.setValue(getEA());
		}
		else {
			pc.setValue(pc.getValue()+1);
		}
		logger.info("JGE End");
	}

	public void AMR() {
		logger.info("AMR Start");
		mar.setValue(getEA());
		loadFromMemory();
		int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		double result = gprList.get(gprNumber).getValue() + mbr.getValue();
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			ccList.get(0).setValue(1);
		}
		else {
			gprList.get(gprNumber).setValue(gprList.get(gprNumber).getValue() + mbr.getValue());
		}
		pc.setValue(pc.getValue()+1);
		logger.info("AMR End");
	}
	
	public void SMR() {
		logger.info("SMR Start");
		mar.setValue(getEA());
		loadFromMemory();
		int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		double result = gprList.get(gprNumber).getValue() - mbr.getValue();
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			ccList.get(0).setValue(1);
		}else {
			gprList.get(gprNumber).setValue(gprList.get(gprNumber).getValue() - mbr.getValue());
		}
		pc.setValue(pc.getValue()+1);
		logger.info("SMR End");
	}

	public void AIR() {
		logger.info("AIR Start");
		int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		int immed = cbi.ToInteger(ir.IRAddress());
		if (immed != 0) {
				double result = gprList.get(gprNumber).getValue() + immed;
				if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
					ccList.get(0).setValue(1);
				}
				else {
					gprList.get(gprNumber).setValue(gprList.get(gprNumber).getValue() + immed);
			}
		}
		pc.setValue(pc.getValue()+1);
		logger.info("AIR End");
	}
	
	public void SIR() {
		logger.info("SIR Start");
		int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		int immed = cbi.ToInteger(ir.IRAddress());
		if (immed != 0) {
				double result = gprList.get(gprNumber).getValue() - immed;
				if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
					ccList.get(0).setValue(1);
				}
				else {
					gprList.get(gprNumber).setValue(gprList.get(gprNumber).getValue() - immed);
			}
		}
		pc.setValue(pc.getValue()+1);
		logger.info("SIR End");
	}
	
	private void MLT() {
		logger.info("Multiply Starts");
		int Rx = cbi.ToInteger(ir.IRGprnumber());
		int Ry = cbi.ToInteger(ir.IRIndexNumber());
		int rxValue = gprList.get(Rx).getValue();
		int ryValue = gprList.get(Ry).getValue();
		if ((Rx == 0 || Rx == 2) && (Ry == 0 || Ry == 2)){
			double result = rxValue * ryValue;
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				ccList.get(0).setValue(1);
				logger.info("Multiplication Error: Bit OverFlow");
			}
			else {
				gprList.get(Rx).setValue(getHighOrderBits((int)result));
				gprList.get(Rx+1).setValue(getLowOrderBits((int)result));
				logger.info("Higher Order bits of result "+cib.ToBinary(getHighOrderBits((int)result))+ " stored in GPR "+cib.ToBinary(Rx));
				logger.info("Lower Order bits of result "+cib.ToBinary(getLowOrderBits((int)result))+ " stored in GPR "+cib.ToBinary(Rx+1));
			}
		}
		else {
			logger.severe("Multiplication Error: Values to be places on registers 0 or 2");
		}
		pc.setValue(pc.getValue()+1);
		logger.info("Multiply Ends");
		
	}
	
	private void DVD() {
		logger.info("Divide Starts");
		int Rx = cbi.ToInteger(ir.IRGprnumber());
		int Ry = cbi.ToInteger(ir.IRIndexNumber());
		int rxValue = gprList.get(Rx).getValue();
		int ryValue = gprList.get(Ry).getValue();
		if ((Rx == 0 || Rx == 2) && (Ry == 0 || Ry == 2)){
			if(ryValue == 0) {
				ccList.get(2).setValue(1);
			}
			else {
				double result = rxValue / ryValue;
				if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
					ccList.get(0).setValue(1);
					logger.info("Division Error: Bit OverFlow");
				}
				else {
					int quotient = rxValue / ryValue;
					int remainder = rxValue % ryValue;
					gprList.get(Rx).setValue(quotient);
					gprList.get(Rx+1).setValue(remainder);
					logger.info("Quotient of the division "+cib.ToBinary(quotient)+ " stored in GPR "+cib.ToBinary(Rx));
					logger.info("Remainder of the division "+cib.ToBinary(remainder)+ " stored in GPR "+cib.ToBinary(Rx+1));
				}
			}
			
		}
		else {
			logger.severe("Division Error: Values to be places on registers 0 or 2");
		}
		pc.setValue(pc.getValue()+1);
		logger.info("Divide Ends");
		
	}
	
	private void TRR() {
		logger.info("TRR Starts");
		int Rx = cbi.ToInteger(ir.IRGprnumber());
		int Ry = cbi.ToInteger(ir.IRIndexNumber());
		int rxValue = gprList.get(Rx).getValue();
		int ryValue = gprList.get(Ry).getValue();
		if (rxValue == ryValue) {
			ccList.get(3).setValue(1);
			logger.info("Equal Or Not CC bit Set to 1");
		}
		else {
			ccList.get(3).setValue(0);
			logger.info("Equal Or Not CC bit Set to 0");
		}
		pc.setValue(pc.getValue()+1);
		logger.info("TRR Ends");
	}
	private void AND() {
		logger.info("And Starts");
		int Rx = cbi.ToInteger(ir.IRGprnumber());
		int Ry = cbi.ToInteger(ir.IRIndexNumber());
		int rxValue = gprList.get(Rx).getValue();
		int ryValue = gprList.get(Ry).getValue();
		int logicalAnd = rxValue & ryValue;
		gprList.get(Rx).setValue(logicalAnd);
		pc.setValue(pc.getValue()+1);
		logger.info("GPR "+ cib.ToBinary(Rx)+ "Set with value "+ cib.ToBinary(logicalAnd));
		logger.info("And Ends");
	}
	private void ORR() {
		logger.info("OR Starts");
		int Rx = cbi.ToInteger(ir.IRGprnumber());
		int Ry = cbi.ToInteger(ir.IRIndexNumber());
		int rxValue = gprList.get(Rx).getValue();
		int ryValue = gprList.get(Ry).getValue();
		int logicalOr = rxValue | ryValue;
		gprList.get(Rx).setValue(logicalOr);
		pc.setValue(pc.getValue()+1);
		logger.info("GPR "+ cib.ToBinary(Rx)+ "Set with value "+ cib.ToBinary(logicalOr));
		logger.info("OR Ends");	
	}
	private void NOT() {
		logger.info("NOT Starts");
		int Rx = cbi.ToInteger(ir.IRGprnumber());
		String rxValue = gprList.get(Rx).getBitValue();
		String logicalNot = "";
		for (int i = 0; i<rxValue.length(); i++) {
			if (rxValue.charAt(i) == '0')
				logicalNot += '1';
			else
				logicalNot += '0';
		}
		gprList.get(Rx).setValue(logicalNot);
		pc.setValue(pc.getValue()+1);
		logger.info("GPR "+ cib.ToBinary(Rx)+ "Set with value "+ logicalNot);
		logger.info("NOT Ends");	
		
	}
		
	private void RRC() {
		logger.info("RRC instruction start");
		int reg = cbi.ToInteger(ir.IRGprnumber());
		int count = cbi.ToInteger(ir.IRCount());
		int lr = cbi.ToInteger(ir.IRlr());
		String gprNum = gprList.get(reg).getBitValue();
		int registerLength = gprList.get(reg).getLength();
		if (lr == 0) {
			for(int i=0; i<count; i++) {
				gprNum = gprNum.charAt(registerLength- 1) + gprNum.substring(0, registerLength - 1);
			}
		}
		else {
			for(int i=0; i<count; i++) {
				gprNum = gprNum.substring(1) + gprNum.charAt(0);
			}
		}
		gprList.get(reg).setValue(Integer.parseInt(gprNum,2));
		pc.setValue(pc.getValue()+1);
		logger.info("RRC instruction end");
	}
	private void SRC() {
		logger.info("SRC instruction Start");
		int reg = cbi.ToInteger(ir.IRGprnumber());
		int count = cbi.ToInteger(ir.IRCount());
		int al = cbi.ToInteger(ir.IRal());
		int lr = cbi.ToInteger(ir.IRlr());
		String gprNum = gprList.get(reg).getBitValue();
		String result = "";
		if (lr == 0) {
			result = rightShift(gprNum,count,al);
		}
		else {
			result = leftShift(gprNum,count);
		}
		
		gprList.get(reg).setValue(Integer.parseInt(result, 2));
		pc.setValue(pc.getValue()+1);
		logger.info("SRC instruction end");
		
	}
	private void IN() {
		logger.info("IN instruction start.");
		int register = cbi.ToInteger(ir.IRGprnumber());
		int devid = cbi.ToInteger(ir.IRAddress());
		if(devid != 1) {
			if(devid == 0) {
				String input = "";
				input = JOptionPane.showInputDialog("Please give the input");
				if (input.matches("[0-9]+")) {
					gprList.get(register).setValue(Integer.valueOf(input));
				}
				else {
					gprList.get(register).setIsStingValue(true);
					charaterValues.clear();
					for(int i = 0; i<input.length();i++) {
						charaterValues.add(Integer.valueOf(input.charAt(i)));
					}
					gprList.get(register).setCharacterValues(charaterValues);
					gprList.get(register).setValue(Integer.valueOf(input.charAt(0)));
				}
			}
			else {
				int value = deviceList.get(devid).getValue();
				gprList.get(register).setValue(value);
				logger.info("IN instruction end.");
			}	
		}
		else {
			logger.info("IN instruction end with no action as cannot input with printer.");
		}
		pc.setValue(pc.getValue()+1);
		
	}
	private void OUT() {
		logger.info("OUT instruction start.");
		int register = cbi.ToInteger(ir.IRGprnumber());
		int devid = cbi.ToInteger(ir.IRAddress());
		int value = gprList.get(register).getValue();
		if(devid != 0) {
			if(devid == 1) {
				if(value <= 9) {
					consolePrinter.printText(String.valueOf(value));
				}
				else {
					consolePrinter.printText(String.valueOf((char)value));
				}
			}
			else if (devid == 2) {
				consolePrinter.printText(String.valueOf(value));
			}
			else {
				deviceList.get(devid).setValue(value);
				logger.info("OUT instruction end.");
			}
		}
		else {
			logger.info("OUT instruction end with no action.");
		}
		pc.setValue(pc.getValue()+1);
	}
	
	public void HLT() {
		logger.info("HLT Start");
		pc.setValue(pc.getValue()+1);
		logger.info("HLT End");
	}
	
	public void TRAP() {
		logger.info("TRAP instruction start.");
		int trapCode = cbi.ToInteger(ir.IRCount());
		if(trapCode > 15 || trapCode < 0 || (trapCode + memory.getValue(cib.ToBinary(0))==0)) {
	        	mfr.setValue(2); // Illegal Code	
	        }
		// Storing the value of  PC+1 in the memory location 2
		memory.setValue(cib.ToBinary(2),cib.ToBinary(pc.getValue()+1));
		pc.setValue(cib.ToBinary(trapCode + memory.getValue(cib.ToBinary(0))));
		logger.info("TRAP instruction end.");
		
	}
	
	public void CHK() {
        logger.info("CHK instruction start.");
        int register = cbi.ToInteger(ir.IRGprnumber());
        int devid = cbi.ToInteger(ir.IRAddress());
        if (devid >= 0 && devid < 32) {
            // Check Status of the Devices.
            gprList.get(register).setValue(1);
        } else {
            logger.info("Invalid- DEVID>32");
        }
        pc.setValue(pc.getValue()+1);
        logger.info("CHK instruction end.");
    }
	
	public void FADD() {
		logger.info("FADD instruction start.");
        int frNumber = cbi.ToInteger(ir.IRGprnumber());
        
        if(frNumber == 0 || frNumber == 1) {
        	float FRvalue = binaryToFloatingPoint(fprList.get(frNumber));
        	mar.setValue(getEA());
    		mbr.setValue(memory.getValue(cib.ToBinary12(mar.getValue())));
    		int content = mbr.getValue();
    		float total = (float)content + FRvalue;
    		fprList.get(frNumber).setValue(floatingPointToBinaryInt(total));   		
        }
        else {
        	logger.info("Floating point register number should be 0 or 1");
        }
        pc.setValue(pc.getValue()+1);
        logger.info("FADD instruction end.");
	}
	
	public void FSUB() {
		logger.info("FSUB instruction start.");
        int frNumber = cbi.ToInteger(ir.IRGprnumber());
        
        if(frNumber == 0 || frNumber == 1) {
        	float FRvalue = binaryToFloatingPoint(fprList.get(frNumber));
        	mar.setValue(getEA());
    		mbr.setValue(memory.getValue(cib.ToBinary12(mar.getValue())));
    		int content = mbr.getValue();
    		float total = FRvalue - (float)content;
    		logger.info(" " + FRvalue + " - " + (float)(content)+ "= " + total);
    		fprList.get(frNumber).setValue(floatingPointToBinaryInt(total));	
        }
        else {
        	logger.info("Floating point register number should be 0 or 1");
        }
        pc.setValue(pc.getValue()+1);
        logger.info("FSUB instruction end.");
	}
	
	public void CNVRT() {
		logger.info("CNVRT instruction start.");
        int gprNumber = cbi.ToInteger(ir.IRGprnumber());
        int gprValue = gprList.get(gprNumber).getValue();
        mar.setValue(getEA());
		mbr.setValue(memory.getValue(cib.ToBinary12(mar.getValue())));
		if(gprValue == 0) {
        	int content = mbr.getValue();
        	int prevValue = fprList.get(0).getValue();
        	fprList.get(0).setValue(content);
        	float FRvalue = binaryToFloatingPoint(fprList.get(0));
        	int integerValue = Math.round(FRvalue);
        	gprList.get(cbi.ToInteger(ir.IRGprnumber())).setValue(integerValue);
    		fprList.get(0).setValue(prevValue);   		
        }
        if(gprValue == 1) {
        	int content = mbr.getValue();
        	float value = (float)content;
        	fprList.get(0).setValue(floatingPointToBinaryInt(value));      	
        }        
        pc.setValue(pc.getValue()+1);
        logger.info("FADD instruction end.");
	}
	
	private void VADD() {
		logger.info("VADD Start");
		int fprNumber = cbi.ToInteger(ir.IRGprnumber());
		int VectorLength = fprList.get(fprNumber).getValue();
		mar.setValue(getEA());
		mbr.setValue(memory.getValue(cib.ToBinary12(mar.getValue())));
		int Vector1BaseAdd = mbr.getValue();
		mar.setValue(getEA()+1);
		mbr.setValue(memory.getValue(cib.ToBinary12(mar.getValue())));
		int Vector2BaseAdd = mbr.getValue();
		for (int i = 0; i < VectorLength; i++) {
          int Vector1CurrentValue = memory.getValue(cib.ToBinary(Vector1BaseAdd+i));
          int Vector2CurrentValue = memory.getValue(cib.ToBinary(Vector2BaseAdd+i));
          logger.info("VADD:Length= " +VectorLength+" Current= "+i+" Vector1Base= "+Vector1BaseAdd+" Vector1Value= "+Vector1CurrentValue+" Vector2Base= "+Vector2BaseAdd+" Vector2Value= "+Vector2CurrentValue);
          mar.setValue(Vector1BaseAdd+i);
          mbr.setValue(Vector1CurrentValue + Vector2CurrentValue);
          store();
		}
		pc.setValue(pc.getValue()+1);
		logger.info("VADD Ends");
	}
	
	private void VSUB() {
		logger.info("VSUB Start");
		int fprNumber = cbi.ToInteger(ir.IRGprnumber());
		int VectorLength = fprList.get(fprNumber).getValue();
		mar.setValue(getEA());
		mbr.setValue(memory.getValue(cib.ToBinary12(mar.getValue())));
		int Vector1BaseAdd = mbr.getValue();
		mar.setValue(getEA()+1);
		mbr.setValue(memory.getValue(cib.ToBinary12(mar.getValue())));
		int Vector2BaseAdd = mbr.getValue();
		for (int i = 0; i < VectorLength; i++) {
          int Vector1CurrentValue = memory.getValue(cib.ToBinary(Vector1BaseAdd+i));
          int Vector2CurrentValue = memory.getValue(cib.ToBinary(Vector2BaseAdd+i));
          logger.info("VSUB:Length= " +VectorLength+" Current= "+i+" Vector1Base= "+Vector1BaseAdd+" Vector1Value= "+Vector1CurrentValue+" Vector2Base= "+Vector2BaseAdd+" Vector2Value= "+Vector2CurrentValue);
          mar.setValue(Vector1BaseAdd+i);
          mbr.setValue(Vector1CurrentValue - Vector2CurrentValue);
          store();
		}
		pc.setValue(pc.getValue()+1);
		logger.info("VSUB Ends");
	}
	
	public void LDFR() {
		logger.info("LDFR Start");
		//Calling function from the IR Class to fetch the GPR bits 
		int fprNumber = cbi.ToInteger(ir.IRGprnumber());
		mar.setValue(getEA());
		mbr.setValue(memory.getValue(cib.ToBinary12(mar.getValue())));
		if (fprNumber == 0 | fprNumber == 1) {
			fprList.get(fprNumber).setValue(mbr.getValue());
		}
		else {
			logger.info("FPR should be 0 or 1");
		}
		pc.setValue(pc.getValue()+1);
		logger.info("LDFR End");
	}

	private void STFR() {
		logger.info("STFR Start");
		int fprNumber = cbi.ToInteger(ir.IRGprnumber());
		if( fprNumber == 0 | fprNumber == 1){
			mar.setValue(getEA());
			mbr.setValue(fprList.get(fprNumber).getValue());
			store();	
		}
		else {
			logger.info("FPR should be 0 or 1");
		}
		pc.setValue(pc.getValue()+1);
		logger.info("STFR Ends");
	}
	
	public void operation() {
		//Calling function from the IR Class to fetch the operation bits 
		int operation = cbi.ToInteger(ir.IROperation()); 
		switch(operation) {
		case 0: 
			HLT(); break;
		case 1:
			LDR(); break;
		case 2:
			STR(); break;
		case 3:
			LDA(); break;
		case 4:
			AMR(); break;
		case 5:
			SMR(); break;
		case 6:
			AIR(); break;
		case 7:
			SIR(); break;
		case 10:
			JZ(); break;
		case 11:
			JNE(); break;
		case 12:
			JCC(); break;
		case 13:
			JMA(); break;
		case 14:
			JSR(); break;
		case 15:
			RFS(); break;
		case 16:
			SOB(); break;
		case 17:
			JGE(); break;
		case 20:
			MLT(); break;
		case 21:
			DVD(); break;
		case 22:
			TRR(); break;
		case 23:
			AND(); break;
		case 24:
			ORR(); break;
		case 25:
			NOT(); break;
		case 26:
			CMP(); break;
		case 30:
			TRAP(); break;
		case 31:
			SRC(); break;
		case 32:
			RRC(); break;
		case 33: 
			FADD(); break;
		case 34:  
			FSUB(); break;
		case 35: 
			VADD(); break;
		case 36:
			VSUB(); break;
		case 37:
			CNVRT(); break;
		case 41:
			LDX(); break;
		case 42:
			STX(); break;
		case 50:
			LDFR(); break;
		case 51:
			STFR(); break;
		case 61:
			IN(); break;
		case 62:
			OUT(); break;
		case 63:
			CHK(); break;
		default: mfr.setValue(4); 
				logger.severe("Invalid Operation Code!");
				pc.setValue(pc.getValue()+1); break;
		}
		
	}
	
	public void clearAll() {
		mar.setValue(0);
		mbr.setValue(0);
		mfr.setValue(0);
		ir.setValue(0);
		pc.setValue(0);
		memory.clearMemory();;
//		cache.ClearCache();
		for (int i = 0; i < gprList.size(); i++)
			gprList.get(i).setValue(0);
		for (int i = 0; i < fprList.size(); i++)
			fprList.get(i).setValue(0);
		for (int i = 0; i < ixrList.size(); i++)
			ixrList.get(i).setValue(0);
		for (int i = 0; i < ccList.size(); i++)
			ccList.get(i).setValue(0);
	}
	
}
