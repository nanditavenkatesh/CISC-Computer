package ALU;

import java.util.ArrayList;
import java.util.Arrays;

import Memory.Memory;
import Registers.ConditionCode;
import Registers.GPRegister;
import Registers.IndexRegister;
import Registers.InstructionRegister;
import Registers.MemoryAddressRegister;
import Registers.MemoryBufferRegister;
import Registers.PCRegister;
import Simulator.ConsoleLog;
import Utils.ConvertBinarytoInt;
import Utils.ConvertHexToBinary;
import Utils.ConvertIntegerToBinary;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Operations {
	private MemoryAddressRegister mar = new MemoryAddressRegister(0);
	private MemoryBufferRegister mbr = new MemoryBufferRegister(0);
	private InstructionRegister ir = new InstructionRegister(0);
	private PCRegister pc = new PCRegister(0);
	private Memory memory;
	private GPRegister gpr0 = new GPRegister(0);
	private GPRegister gpr1 = new GPRegister(1);
	private GPRegister gpr2 = new GPRegister(2);
	private GPRegister gpr3 = new GPRegister(3);
	private ArrayList<GPRegister> gprList = new ArrayList<GPRegister>();
	private IndexRegister ixr1 = new IndexRegister(1);
	private IndexRegister ixr2 = new IndexRegister(2);
	private IndexRegister ixr3 = new IndexRegister(3);
	private ArrayList<IndexRegister> ixrList = new ArrayList<IndexRegister>();
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
	private final static Logger logger = Logger.getLogger("OperationsLogger");
	private ConsoleLog console;
	
	public Operations(Memory memory, ConsoleLog console) {
		this.memory = memory;
		this.console = console;
		gprList.add(gpr0); gprList.add(gpr1); gprList.add(gpr2); gprList.add(gpr3);
		ixrList.add(ixr1); ixrList.add(ixr2); ixrList.add(ixr3); 
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
		memory.setValue(addr, value);
		logger.info("Store Ends");
	}
	
	public void storePlus() {
		logger.info("Store Plus Begins");
		store();
		mar.setValue(mar.getValue()+1);
		logger.info("Store Plus incremented MAR by 1");
	}
	
	public void singleStep() {
		logger.info("Single Step Begins");
		String PCvalue = pc.getBitValue();
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
		mar.setValue(getEA());
		mbr.setValue(gprList.get(gprNumber).getValue());
		store();
		pc.setValue(pc.getValue()+1);
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
		mbr.setValue(memory.getValue(cib.ToBinary12(mar.getValue())));
		ixrList.get(ixrNumber).setValue(mbr.getValue());
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
		int ccNumber = cbi.ToInteger(ir.IRGprnumber());
		int ccValue = ccList.get(ccNumber).getValue();
		if (ccValue == 1) {
			pc.setValue(getEA());
		}
		else {
			pc.setValue(pc.getValue() +  1);
		}
		
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
		
		pc.setValue(gprList.get(3).getValue());
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
		
		pc.setValue(gprList.get(3).getValue());
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
		int ryValue = ixrList.get(Ry).getValue();
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
		int ryValue = ixrList.get(Ry).getValue();
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
		int ryValue = ixrList.get(Ry).getValue();
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
		int ryValue = ixrList.get(Ry).getValue();
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
		int ryValue = ixrList.get(Ry).getValue();
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
		int reg = cbi.ToInteger(ir.IRGprnumber());
		int count = cbi.ToInteger(ir.IRCount());
		int lr = cbi.ToInteger(ir.IRlr());
		String[] gpr = Integer.toString(gprList.get(reg).getValue()).split("",1);
		String temp;
		for (int i = 0; i < count; i++) {
			if (lr == 1) { // rotate left
				temp = gpr[0];
				for (int j = 0; j < 16; j++) {
					if (j != 15) {
						gpr[j] = gpr[j + 1];
					} else {
						gpr[j] = temp;
					}
				}
			} else { // rotate right
				temp = gpr[15];
				for (int j = 15; j >= 0; j--) {
					if (j != 0) {
						gpr[j] = gpr[j - 1];
					} else {
						gpr[j] = temp;
					}
				}
			}
		}
		String gprNum = Arrays.toString(gpr);
		gprList.get(reg).setValue(Integer.parseInt(gprNum));
		pc.setValue(pc.getValue()+1);
		
	}
	private void SRC() {
		int reg = cbi.ToInteger(ir.IRGprnumber());
		int count = cbi.ToInteger(ir.IRCount());
		int al = cbi.ToInteger(ir.IRal());
		int lr = cbi.ToInteger(ir.IRlr());
		String[] gpr = Integer.toString(gprList.get(reg).getValue()).split("",1);
		
		for (int i = 0; i < count; i++) {
			if (lr == 1) { // shift left
				for (int j = 0; j < 16; j++) {
					if (j != 15) {
						gpr[j] = gpr[j + 1];
					} else {
						gpr[j] = "0";
					}
				}
			}
			else { // shift right
				for (int j = 15; j >= 0; j--) {
					if (j != 0) {
						gpr[j] = gpr[j - 1];
					} else if (al == 1) { // logically shift
						gpr[j] = "0";
					} // if it's arithmetically shift, keep the sign bit.
				}
			}
		}
		String gprNum = Arrays.toString(gpr);
		gprList.get(reg).setValue(Integer.parseInt(gprNum));
		pc.setValue(pc.getValue()+1);
		logger.info("RRC instruction end");
		
	}
	private void IN() {
		logger.info("IN instruction start.");
		int register = cbi.ToInteger(ir.IRGprnumber());
		int devid = cbi.ToInteger(ir.IRAddress());
		if(devid != 1) {
			if(devid == 0) {
				String input = "";
				input = JOptionPane.showInputDialog("Please give the input");
				gprList.get(register).setValue(Integer.valueOf(input));
			}
			else {
				int value = deviceList.get(devid).getValue();
				gprList.get(register).setValue(value);
				logger.info("IN instruction end.");
			}	
		}
		else {
			logger.info("IN instruction end with no action.");
		}
		pc.setValue(pc.getValue()+1);
		
	}
	private void OUT() {
		logger.info("IN instruction start.");
		int register = cbi.ToInteger(ir.IRGprnumber());
		int devid = cbi.ToInteger(ir.IRAddress());
		int value = gprList.get(register).getValue();
		if(devid != 0) {
			if(devid == 1) {
				JOptionPane.showInternalMessageDialog(null, "Printer value is " + String.valueOf(value));
				console.setText("Printer value is" + String.valueOf(value));
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
	public void operation() {
		//Calling function from the IR Class to fetch the operation bits 
		int operation = cbi.ToInteger(ir.IROperation()); 
		switch(operation) {
		case 0: 
			HLT();break;
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
		case 31:
			SRC(); break;
		case 32:
			RRC(); break;
		case 41:
			LDX(); break;
		case 42:
			STX(); break;
		case 61:
			IN(); break;
		case 62:
			OUT(); break;
		default: logger.severe("Invalid Operation Code!"); break;
		}
		
	}
	
}
