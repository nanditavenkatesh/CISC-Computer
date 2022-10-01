package Simulator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Memory.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import Registers.*;
import Utils.*;



public class StimulatorWindow {

	private JFrame CSCIProjectTeam7;
	private JLabel Operation;
	private JPanel AddressPanel;
	private JPanel GPRPanel;
	private JPanel IXRPanel;
	private JPanel IPanel;
	private JButton OperationBit15;
	private JButton OperationBit14;
	private JButton OperationBit13;
	private JButton OperationBit12;
	private JButton OperationBit11;
	private JButton OperationBit10;
	private JButton GPRBit09;
	private JLabel GPR;
	private JButton GPRBit08;
	private JLabel IXR;
	private JButton IXRBit07;
	private JButton IXRBit06;
	private JLabel I;
	private JButton IBit05;
	private JLabel Address;
	private JButton AddressBit04;
	private JButton AddressBit03;
	private JButton AddressBit02;
	private JButton AddressBit01;
	private JButton AddressBit00;
	private JPanel GPRIXRPanel;
	private JPanel AddressRegisterPanel;
	private JTextField GPR0;
	private JTextField GPR1;
	private JTextField GPR2;
	private JTextField GPR3;
	private JTextField IXR1;
	private JTextField IXR2;
	private JTextField IXR3;
	private JTextField PC;
	private JTextField MAR;
	private JTextField MBR;
	private JTextField IR;
	private JTextField MFR;
	private JPanel ButtonPanel;
	private JLabel GPR0Label;
	private JLabel GPR1Label;
	private JLabel GPR2Label;
	private JLabel GPR3Label;
	private JLabel IXR1Label;
	private JLabel IXR2Label;
	private JLabel IXR3Label;
	private JLabel ProgramCounter;
	private JLabel MemoryAddressRegister;
	private JLabel MemoryBufferRegister;
	private JLabel InstructionRegister;
	private JLabel MemoryFaultRegister;
	private JButton StoreButton;
	private JButton StorePlus;
	private JButton LoadButton;
	private JButton RunButton;
	private JButton SingleStep;
	private JButton InitButton;
	private JButton LoadButtonGPR0;
	private JButton LoadButtonGPR1;
	private JButton LoadButtonGPR2;
	private JButton LoadButtonGPR3;
	private JButton LoadButtonIXR1;
	private JButton LoadButtonIXR2;
	private JButton LoadButtonIXR3;
	private JButton LoadButtonPC;
	private JButton LoadButtonMAR;
	private JButton LoadButtonMBR;
	private JLabel RunLabel;
	private JLabel HaltLabel;
	private JButton[] bitArray = new JButton[16];
	private MemoryAddressRegister mar = new MemoryAddressRegister(0);
	private InstructionRegister ir = new InstructionRegister(0);
	private Memory memory = new Memory();
	StringBuilder fileContent = new StringBuilder();
	private ConvertIntegerToBinary cib = new ConvertIntegerToBinary();
	private ConvertBinarytoInt cbi = new ConvertBinarytoInt();
	private ConvertHexToBinary H2B = new ConvertHexToBinary();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StimulatorWindow window = new StimulatorWindow();
					window.CSCIProjectTeam7.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StimulatorWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CSCIProjectTeam7 = new JFrame();
		CSCIProjectTeam7.getContentPane().setFont(new Font("Lucida Calligraphy", Font.PLAIN, 12));
		CSCIProjectTeam7.setBackground(new Color(105, 105, 105));
		CSCIProjectTeam7.setFont(new Font("Dialog", Font.BOLD, 12));
		CSCIProjectTeam7.setTitle("CSCI 6461 Project Team 7 Stimulator");
		CSCIProjectTeam7.getContentPane().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		CSCIProjectTeam7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		CSCIProjectTeam7.getContentPane().setBackground(new Color(105, 105, 105));
		
		JPanel OperationPanel = new JPanel();
		OperationPanel.setBackground(new Color(192, 192, 192));
		OperationPanel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
		AddressPanel = new JPanel();
		AddressPanel.setBackground(new Color(192, 192, 192));
		AddressPanel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
		GPRPanel = new JPanel();
		GPRPanel.setBackground(new Color(192, 192, 192));
		GPRPanel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
		IXRPanel = new JPanel();
		IXRPanel.setBackground(new Color(192, 192, 192));
		IXRPanel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
		IPanel = new JPanel();
		IPanel.setBackground(new Color(192, 192, 192));
		IPanel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
	
		
		Address = new JLabel();
		Address.setFont(new Font("Calibri", Font.BOLD, 18));
		Address.setToolTipText("");
		Address.setText("Address");
		Address.setHorizontalAlignment(SwingConstants.CENTER);
		Address.setForeground(Color.BLACK);
		Address.setBackground(new Color(221, 160, 221));
		
		AddressBit04 = new JButton("4");
		AddressBit04.setBackground(Color.WHITE);
		AddressBit04.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[4]=AddressBit04;
		AddressBit04.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(AddressBit04);
			}
		});
		
		AddressBit03 = new JButton("3");
		AddressBit03.setBackground(Color.WHITE);
		AddressBit03.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[3]=AddressBit03;
		AddressBit03.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(AddressBit03);
			}
		});
		
		
		AddressBit02 = new JButton("2");
		AddressBit02.setBackground(Color.WHITE);
		AddressBit02.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[2]=AddressBit02;
		AddressBit02.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(AddressBit02);
			}
		});
		
		AddressBit01 = new JButton("1");
		AddressBit01.setBackground(Color.WHITE);
		AddressBit01.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[1]=AddressBit01;
		AddressBit01.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(AddressBit01);
			}
		});
		
		AddressBit00 = new JButton("0");
		AddressBit00.setBackground(Color.WHITE);
		AddressBit00.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[0]=AddressBit00;
		AddressBit00.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(AddressBit00);
				
			}
		});
		GroupLayout gl_AddressPanel = new GroupLayout(AddressPanel);
		gl_AddressPanel.setHorizontalGroup(
			gl_AddressPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressPanel.createSequentialGroup()
					.addGap(131)
					.addComponent(Address, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(145))
				.addGroup(gl_AddressPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(AddressBit04, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(AddressBit03, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(AddressBit02, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(AddressBit01, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(AddressBit00, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(4, Short.MAX_VALUE))
		);
		gl_AddressPanel.setVerticalGroup(
			gl_AddressPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressPanel.createSequentialGroup()
					.addComponent(Address, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_AddressPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(AddressBit04)
						.addComponent(AddressBit03)
						.addComponent(AddressBit02)
						.addComponent(AddressBit01)
						.addComponent(AddressBit00))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		AddressPanel.setLayout(gl_AddressPanel);
		
		I = new JLabel();
		I.setFont(new Font("Calibri", Font.BOLD, 18));
		I.setToolTipText("");
		I.setText("I");
		I.setHorizontalAlignment(SwingConstants.CENTER);
		I.setForeground(Color.BLACK);
		I.setBackground(new Color(221, 160, 221));
		
		IBit05 = new JButton("5");
		IBit05.setBackground(Color.WHITE);
		IBit05.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[5]=IBit05;
		IBit05.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(IBit05);
			}
		});
		GroupLayout gl_IPanel = new GroupLayout(IPanel);
		gl_IPanel.setHorizontalGroup(
			gl_IPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IPanel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_IPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(I, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(IBit05, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
					.addGap(26))
		);
		gl_IPanel.setVerticalGroup(
			gl_IPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IPanel.createSequentialGroup()
					.addComponent(I, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(IBit05)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		IPanel.setLayout(gl_IPanel);
		
		IXR = new JLabel();
		IXR.setFont(new Font("Calibri", Font.BOLD, 18));
		IXR.setToolTipText("");
		IXR.setText("IXR");
		IXR.setHorizontalAlignment(SwingConstants.CENTER);
		IXR.setForeground(Color.BLACK);
		IXR.setBackground(new Color(221, 160, 221));
		
		IXRBit07 = new JButton("7");
		IXRBit07.setBackground(Color.WHITE);
		IXRBit07.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[7]=IXRBit07;
		IXRBit07.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					setBackgroundColourOnClick(IXRBit07);
			}
		});
		
		IXRBit06 = new JButton("6");
		IXRBit06.setBackground(Color.WHITE);
		IXRBit06.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[6]=IXRBit06;
		IXRBit06.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					setBackgroundColourOnClick(IXRBit06);
			}
		});
		GroupLayout gl_IXRPanel = new GroupLayout(IXRPanel);
		gl_IXRPanel.setHorizontalGroup(
			gl_IXRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IXRPanel.createSequentialGroup()
					.addGap(22)
					.addComponent(IXR, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(23))
				.addGroup(gl_IXRPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(IXRBit07, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(IXRBit06, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_IXRPanel.setVerticalGroup(
			gl_IXRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IXRPanel.createSequentialGroup()
					.addComponent(IXR, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_IXRPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(IXRBit07)
						.addComponent(IXRBit06))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		IXRPanel.setLayout(gl_IXRPanel);
		
		GPRBit09 = new JButton("9");
		GPRBit09.setBackground(Color.WHITE);
		GPRBit09.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[9]=GPRBit09;
		GPRBit09.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(GPRBit09);
			}
		});;
		
		GPR = new JLabel();
		GPR.setFont(new Font("Calibri", Font.BOLD, 18));
		GPR.setToolTipText("");
		GPR.setText("GPR");
		GPR.setHorizontalAlignment(SwingConstants.CENTER);
		GPR.setForeground(Color.BLACK);
		GPR.setBackground(new Color(192, 192, 192));
		
		GPRBit08 = new JButton("8");
		GPRBit08.setBackground(Color.WHITE);
		GPRBit08.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[8]=GPRBit08;
		GPRBit08.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(GPRBit08);
			}
		});;
		GroupLayout gl_GPRPanel = new GroupLayout(GPRPanel);
		gl_GPRPanel.setHorizontalGroup(
			gl_GPRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GPRPanel.createSequentialGroup()
					.addGap(32)
					.addComponent(GPR, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
					.addGap(39))
				.addGroup(gl_GPRPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(GPRBit09, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(GPRBit08, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_GPRPanel.setVerticalGroup(
			gl_GPRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GPRPanel.createSequentialGroup()
					.addComponent(GPR, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_GPRPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(GPRBit09)
						.addComponent(GPRBit08))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		GPRPanel.setLayout(gl_GPRPanel);
		
		Operation = new JLabel();
		Operation.setFont(new Font("Calibri", Font.BOLD, 18));
		Operation.setForeground(new Color(0, 0, 0));
		Operation.setBackground(new Color(221, 160, 221));
		Operation.setHorizontalAlignment(SwingConstants.CENTER);
		Operation.setToolTipText("");
		Operation.setText("Operation");
		
		OperationBit15 = new JButton("15");
		OperationBit15.setBackground(Color.WHITE);
		OperationBit15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[15]=OperationBit15;
		OperationBit15.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(OperationBit15);
			}
		});
		
		OperationBit14 = new JButton("14");
		OperationBit14.setBackground(Color.WHITE);
		OperationBit14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[14]=OperationBit14;
		OperationBit14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(OperationBit14);
			}
		});
		
		OperationBit13 = new JButton("13");
		OperationBit13.setBackground(Color.WHITE);
		OperationBit13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[13]=OperationBit13;
		OperationBit13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(OperationBit13);
			}
		});
		
		OperationBit12 = new JButton("12");
		OperationBit12.setBackground(Color.WHITE);
		OperationBit12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[12]=OperationBit12;
		OperationBit12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(OperationBit12);
			}
		});
		
		OperationBit11 = new JButton("11");
		OperationBit11.setBackground(Color.WHITE);
		OperationBit11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[11]=OperationBit11;
		OperationBit11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(OperationBit11);
			}
		});
		
		OperationBit10 = new JButton("10");
		OperationBit10.setBackground(Color.WHITE);
		OperationBit10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[10]=OperationBit10;
		OperationBit10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackgroundColourOnClick(OperationBit10);
			}
		});
		GroupLayout gl_OperationPanel = new GroupLayout(OperationPanel);
		gl_OperationPanel.setHorizontalGroup(
			gl_OperationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OperationPanel.createSequentialGroup()
					.addGroup(gl_OperationPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_OperationPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(OperationBit15, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OperationBit14, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OperationBit13, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OperationBit12, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OperationBit11, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OperationBit10, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_OperationPanel.createSequentialGroup()
							.addGap(162)
							.addComponent(Operation, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
							.addGap(170)))
					.addContainerGap())
		);
		gl_OperationPanel.setVerticalGroup(
			gl_OperationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OperationPanel.createSequentialGroup()
					.addComponent(Operation, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_OperationPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(OperationBit15)
						.addComponent(OperationBit14)
						.addComponent(OperationBit13)
						.addComponent(OperationBit12)
						.addComponent(OperationBit11)
						.addComponent(OperationBit10))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		OperationPanel.setLayout(gl_OperationPanel);
		
		GPRIXRPanel = new JPanel();
		GPRIXRPanel.setBorder(null);
		GPRIXRPanel.setBackground(new Color(105, 105, 105));
		
		AddressRegisterPanel = new JPanel();
		AddressRegisterPanel.setBackground(new Color(105, 105, 105));
		
		ButtonPanel = new JPanel();
		ButtonPanel.setToolTipText("MFR");
		ButtonPanel.setBackground(new Color(105, 105, 105));
		GroupLayout groupLayout = new GroupLayout(CSCIProjectTeam7.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(OperationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(GPRPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(GPRIXRPanel, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ButtonPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(IXRPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(IPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(AddressPanel, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
						.addComponent(AddressRegisterPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(AddressRegisterPanel, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(ButtonPanel, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(GPRIXRPanel, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(GPRPanel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(IXRPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(AddressPanel, 0, 0, Short.MAX_VALUE)
						.addComponent(OperationPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(IPanel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		StoreButton = new JButton("STORE");
		StoreButton.setFont(new Font("Calibri", Font.BOLD, 26));
		StoreButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String addr = MAR.getText();
				String value = MBR.getText();
				memory.setValue(addr, value);
				resetBitValue();
			}
			});
		
		StorePlus = new JButton("S+");
		StorePlus.setFont(new Font("Calibri", Font.BOLD, 26));
		StorePlus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String addr = MAR.getText();
				String value = MBR.getText();
				int nextaddr = cbi.ToInteger(addr) + 1;
				memory.setValue(addr, value);
				MAR.setText(cib.ToBinary12(nextaddr));
				resetBitValue();
			}
			});
		
		LoadButton = new JButton("LOAD");
		LoadButton.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String addr = MAR.getText();
				int i = memory.getValue(addr);
				MBR.setText(cib.ToBinary(i));
				resetBitValue();
			}
			});
		
		RunButton = new JButton("RUN");
		RunButton.setFont(new Font("Calibri", Font.BOLD, 26));
		RunButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String PCvalue = PC.getText();
				int i = memory.getValue(PCvalue);
				IR.setText(cib.ToBinary(i));
				ir.setValue(i);
				while(cbi.ToInteger(ir.IROperation())>0) {
					HaltLabel.setForeground(Color.BLACK);
					operation(ir);
					PCvalue = addPCValue(PCvalue);
					i = memory.getValue(PCvalue);
					IR.setText(cib.ToBinary(i));
					ir.setValue(i);					
				}
				HaltLabel.setForeground(Color.GREEN);
				resetBitValue();
			}
			});
		
		SingleStep = new JButton("SS");
		SingleStep.setFont(new Font("Calibri", Font.BOLD, 26));
		SingleStep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String PCvalue = PC.getText();
				HaltLabel.setForeground(Color.BLACK);
				int i = memory.getValue(PCvalue);
				IR.setText(cib.ToBinary(i));
				ir.setValue(i);
				if(ir.getValue() == 0) {
					HaltLabel.setForeground(Color.GREEN);
				}
				operation(ir);
				PC.setText(addPCValue(PCvalue));
				resetBitValue();
			}
			});
		
		
		InitButton = new JButton("INIT");
		InitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileReader newPopUpScreen = new FileReader();
				fileContent = newPopUpScreen.fileText;
				try {
					newPopUpScreen.chooseFile();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				if (!fileContent.toString().isEmpty()) {
					memory.clearMemory();
					resetBitValue();
					resetTextbox();
					String[] fileLines = newPopUpScreen.getCommands();
					for( int i = 0; i<fileLines.length;i++) {
						String[] command = fileLines[i].toUpperCase().split("\\s");
						memory.setValue(H2B.hexToBinary(command[0]).substring(4), H2B.hexToBinary(command[1]));
					}
							
				}
			}
		});
		InitButton.setFont(new Font("Calibri", Font.BOLD, 26));
		
		RunLabel = new JLabel("RUN");
		RunLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		RunLabel.setForeground(Color.BLACK);
		
		HaltLabel = new JLabel("HALT");
		HaltLabel.setForeground(Color.BLACK);
		HaltLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		GroupLayout gl_ButtonPanel = new GroupLayout(ButtonPanel);
		gl_ButtonPanel.setHorizontalGroup(
			gl_ButtonPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ButtonPanel.createSequentialGroup()
					.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addGap(28)
							.addComponent(StoreButton, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(StorePlus, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(LoadButton, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(RunButton, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(SingleStep, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_ButtonPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(RunLabel)
							.addGap(26)))
					.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addComponent(InitButton, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
							.addGap(25))
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(HaltLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_ButtonPanel.setVerticalGroup(
			gl_ButtonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ButtonPanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(StoreButton, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addComponent(StorePlus, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(LoadButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(RunButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(SingleStep, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(InitButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(RunLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(HaltLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
		ButtonPanel.setLayout(gl_ButtonPanel);
		
		PC = new JTextField();
		PC.setFont(new Font("Tahoma", Font.PLAIN, 26));
		PC.setText("000000000000");
		PC.setEditable(false);
		PC.setColumns(10);
		PC.setBackground(SystemColor.menu);
		
		MAR = new JTextField();
		MAR.setFont(new Font("Tahoma", Font.PLAIN, 26));
		MAR.setText("000000000000");
		MAR.setEditable(false);
		MAR.setColumns(10);
		MAR.setBackground(SystemColor.menu);
		
		MBR = new JTextField();
		MBR.setFont(new Font("Tahoma", Font.PLAIN, 26));
		MBR.setText("0000000000000000");
		MBR.setEditable(false);
		MBR.setColumns(10);
		MBR.setBackground(SystemColor.menu);
		
		IR = new JTextField();
		IR.setFont(new Font("Tahoma", Font.PLAIN, 26));
		IR.setText("0000000000000000");
		IR.setEditable(false);
		IR.setColumns(10);
		IR.setBackground(SystemColor.menu);
		
		MFR = new JTextField();
		MFR.setFont(new Font("Tahoma", Font.PLAIN, 26));
		MFR.setText("0000");
		MFR.setEditable(false);
		MFR.setColumns(10);
		MFR.setBackground(SystemColor.menu);
		
		ProgramCounter = new JLabel("PC");
		ProgramCounter.setVerticalAlignment(SwingConstants.BOTTOM);
		ProgramCounter.setHorizontalAlignment(SwingConstants.CENTER);
		ProgramCounter.setFont(new Font("Calibri", Font.BOLD, 24));
		
		MemoryAddressRegister = new JLabel("MAR");
		MemoryAddressRegister.setVerticalAlignment(SwingConstants.BOTTOM);
		MemoryAddressRegister.setHorizontalAlignment(SwingConstants.CENTER);
		MemoryAddressRegister.setFont(new Font("Calibri", Font.BOLD, 24));
		
		MemoryBufferRegister = new JLabel("MBR");
		MemoryBufferRegister.setVerticalAlignment(SwingConstants.BOTTOM);
		MemoryBufferRegister.setHorizontalAlignment(SwingConstants.CENTER);
		MemoryBufferRegister.setFont(new Font("Calibri", Font.BOLD, 24));
		
		InstructionRegister = new JLabel("IR");
		InstructionRegister.setVerticalAlignment(SwingConstants.BOTTOM);
		InstructionRegister.setHorizontalAlignment(SwingConstants.CENTER);
		InstructionRegister.setFont(new Font("Calibri", Font.BOLD, 24));
		
		MemoryFaultRegister = new JLabel("MFR");
		MemoryFaultRegister.setToolTipText("");
		MemoryFaultRegister.setVerticalAlignment(SwingConstants.BOTTOM);
		MemoryFaultRegister.setHorizontalAlignment(SwingConstants.CENTER);
		MemoryFaultRegister.setFont(new Font("Calibri", Font.BOLD, 24));
		
		LoadButtonPC = new JButton("LD");
		LoadButtonPC.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonPC.setBackground(Color.LIGHT_GRAY);
		LoadButtonPC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PC.setText(GetBitValue12());
				resetBitValue();
			}
		});
		
		LoadButtonMAR = new JButton("LD");
		LoadButtonMAR.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonMAR.setBackground(Color.LIGHT_GRAY);
		LoadButtonMAR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MAR.setText(GetBitValue12());
				resetBitValue();
			}
		});
		
		LoadButtonMBR = new JButton("LD");
		LoadButtonMBR.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonMBR.setBackground(Color.LIGHT_GRAY);
		LoadButtonMBR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MBR.setText(GetBitValue16());
				resetBitValue();
			}
		});
		GroupLayout gl_AddressRegisterPanel = new GroupLayout(AddressRegisterPanel);
		gl_AddressRegisterPanel.setHorizontalGroup(
			gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(MemoryAddressRegister, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(MemoryBufferRegister, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(InstructionRegister, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(MemoryFaultRegister, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(ProgramCounter, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(MFR, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addComponent(MAR, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonMAR, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addComponent(PC, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonPC, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addComponent(MBR, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonMBR, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(IR, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		gl_AddressRegisterPanel.setVerticalGroup(
			gl_AddressRegisterPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
					.addContainerGap(78, Short.MAX_VALUE)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_AddressRegisterPanel.createSequentialGroup()
							.addComponent(LoadButtonPC, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(LoadButtonMAR, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(MemoryAddressRegister, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
								.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(PC, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addComponent(ProgramCounter, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(MAR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(MBR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(MemoryBufferRegister, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(LoadButtonMBR, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(IR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(InstructionRegister, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(MemoryFaultRegister, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(MFR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		AddressRegisterPanel.setLayout(gl_AddressRegisterPanel);
		
		GPR0 = new JTextField();
		GPR0.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GPR0.setText("0000000000000000");
		GPR0.setEditable(false);
		GPR0.setBackground(new Color(240, 240, 240));
		GPR0.setColumns(10);
		
		GPR1 = new JTextField();
		GPR1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GPR1.setText("0000000000000000");
		GPR1.setEditable(false);
		GPR1.setColumns(10);
		GPR1.setBackground(SystemColor.menu);
		
		GPR2 = new JTextField();
		GPR2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GPR2.setText("0000000000000000");
		GPR2.setEditable(false);
		GPR2.setColumns(10);
		GPR2.setBackground(SystemColor.menu);
		
		GPR3 = new JTextField();
		GPR3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GPR3.setText("0000000000000000");
		GPR3.setEditable(false);
		GPR3.setColumns(10);
		GPR3.setBackground(SystemColor.menu);
		
		IXR1 = new JTextField();
		IXR1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		IXR1.setText("0000000000000000");
		IXR1.setEditable(false);
		IXR1.setColumns(10);
		IXR1.setBackground(SystemColor.menu);
		
		IXR2 = new JTextField();
		IXR2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		IXR2.setText("0000000000000000");
		IXR2.setEditable(false);
		IXR2.setColumns(10);
		IXR2.setBackground(SystemColor.menu);
		
		IXR3 = new JTextField();
		IXR3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		IXR3.setText("0000000000000000");
		IXR3.setEditable(false);
		IXR3.setColumns(10);
		IXR3.setBackground(SystemColor.menu);
		
		GPR0Label = new JLabel("GPR0");
		GPR0Label.setHorizontalAlignment(SwingConstants.CENTER);
		GPR0Label.setVerticalAlignment(SwingConstants.BOTTOM);
		GPR0Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		GPR1Label = new JLabel("GPR1");
		GPR1Label.setVerticalAlignment(SwingConstants.BOTTOM);
		GPR1Label.setHorizontalAlignment(SwingConstants.CENTER);
		GPR1Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		GPR2Label = new JLabel("GPR2");
		GPR2Label.setVerticalAlignment(SwingConstants.BOTTOM);
		GPR2Label.setHorizontalAlignment(SwingConstants.CENTER);
		GPR2Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		GPR3Label = new JLabel("GPR3");
		GPR3Label.setVerticalAlignment(SwingConstants.BOTTOM);
		GPR3Label.setHorizontalAlignment(SwingConstants.CENTER);
		GPR3Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		IXR1Label = new JLabel("IXR1");
		IXR1Label.setVerticalAlignment(SwingConstants.BOTTOM);
		IXR1Label.setHorizontalAlignment(SwingConstants.CENTER);
		IXR1Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		IXR2Label = new JLabel("IXR2");
		IXR2Label.setVerticalAlignment(SwingConstants.BOTTOM);
		IXR2Label.setHorizontalAlignment(SwingConstants.CENTER);
		IXR2Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		IXR3Label = new JLabel("IXR3");
		IXR3Label.setVerticalAlignment(SwingConstants.BOTTOM);
		IXR3Label.setHorizontalAlignment(SwingConstants.CENTER);
		IXR3Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		LoadButtonGPR0 = new JButton("LD");
		LoadButtonGPR0.setBackground(new Color(192, 192, 192));
		LoadButtonGPR0.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonGPR0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GPR0.setText(GetBitValue16());
				resetBitValue();
			}
		});
		
		LoadButtonGPR1 = new JButton("LD");
		LoadButtonGPR1.setBackground(new Color(192, 192, 192));
		LoadButtonGPR1.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonGPR1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GPR1.setText(GetBitValue16());
				resetBitValue();
			}
		});
		
		LoadButtonGPR2 = new JButton("LD");
		LoadButtonGPR2.setBackground(new Color(192, 192, 192));
		LoadButtonGPR2.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonGPR2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GPR2.setText(GetBitValue16());
				resetBitValue();
			}
		});
		
		LoadButtonGPR3 = new JButton("LD");
		LoadButtonGPR3.setBackground(new Color(192, 192, 192));
		LoadButtonGPR3.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonGPR3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GPR3.setText(GetBitValue16());
				resetBitValue();
			}
		});
		
		LoadButtonIXR1 = new JButton("LD");
		LoadButtonIXR1.setBackground(new Color(192, 192, 192));
		LoadButtonIXR1.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonIXR1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				IXR1.setText(GetBitValue16());
				resetBitValue();
			}
		});
		
		LoadButtonIXR2 = new JButton("LD");
		LoadButtonIXR2.setBackground(new Color(192, 192, 192));
		LoadButtonIXR2.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonIXR2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				IXR2.setText(GetBitValue16());
				resetBitValue();
			}
		});
		
		LoadButtonIXR3 = new JButton("LD");
		LoadButtonIXR3.setBackground(new Color(192, 192, 192));
		LoadButtonIXR3.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonIXR3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				IXR3.setText(GetBitValue16());
				resetBitValue();
			}
		});
		GroupLayout gl_GPRIXRPanel = new GroupLayout(GPRIXRPanel);
		gl_GPRIXRPanel.setHorizontalGroup(
			gl_GPRIXRPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_GPRIXRPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(GPR0Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(GPR1Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(GPR2Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(GPR3Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(IXR1Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(IXR2Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(IXR3Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addComponent(GPR0, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonGPR0, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addComponent(IXR3, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonIXR3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addComponent(IXR2, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonIXR2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addComponent(IXR1, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonIXR1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addComponent(GPR3, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonGPR3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addComponent(GPR2, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonGPR2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addComponent(GPR1, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonGPR1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_GPRIXRPanel.setVerticalGroup(
			gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GPRIXRPanel.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(GPR0, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(GPR0Label, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
						.addComponent(LoadButtonGPR0))
					.addGap(18)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(GPR1Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(LoadButtonGPR1, 0, 0, Short.MAX_VALUE)
							.addComponent(GPR1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(GPR2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(GPR2Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(LoadButtonGPR2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addComponent(GPR3Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(IXR1Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(GPR3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(LoadButtonGPR3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGap(60)
							.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(LoadButtonIXR1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(IXR1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(IXR2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(IXR2Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(LoadButtonIXR2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(LoadButtonIXR3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(IXR3Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(IXR3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		GPRIXRPanel.setLayout(gl_GPRIXRPanel);
		CSCIProjectTeam7.getContentPane().setLayout(groupLayout);
		CSCIProjectTeam7.setBounds(100, 100, 1316, 684);
		CSCIProjectTeam7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void resetTextbox() {
		PC.setText("000000000000");
		MAR.setText("000000000000");
		MBR.setText("0000000000000000");
		IR.setText("0000000000000000");
		GPR0.setText("0000000000000000");
		GPR1.setText("0000000000000000");
		GPR2.setText("0000000000000000");
		GPR3.setText("0000000000000000");
		IXR1.setText("0000000000000000");
		IXR2.setText("0000000000000000");
		IXR3.setText("0000000000000000");
	}

	public void setBackgroundColourOnClick(JButton button){
		if(button.getBackground().equals(Color.WHITE)){
			button.setBackground(Color.PINK);
		}
		else {
			button.setBackground(Color.WHITE);
		}	
	}	
	public String GetBitValue16() {
		String s = "";
		for (int i=bitArray.length-1;i>=0;i--) {
			if(bitArray[i].getBackground().equals(Color.PINK)) {
				s += 1; 
			}
			else
			{
				s += 0;
			}
		}
		return s;
	}
	public String GetBitValue12() {
		String s = "";
		for (int i=11;i>=0;i--) {
			if(bitArray[i].getBackground().equals(Color.PINK)) {
				s += 1; 
			}
			else
			{
				s += 0;
			}
		}
		return s;
	}
	public void resetBitValue() {
		for (int i=bitArray.length-1;i>=0;i--) {
			bitArray[i].setBackground(Color.WHITE);
			}
	}
	public void setGprValue(int n, int value) {
		if(n == 0) {
			GPR0.setText(cib.ToBinary(value));
		}
		else if(n == 1) {
			GPR1.setText(cib.ToBinary(value));
		}
		else if(n == 2) {
			GPR2.setText(cib.ToBinary(value));
		}
		else if(n == 3) {
			GPR3.setText(cib.ToBinary(value));
		}
	}
	public int getIXRvalue(int n) {
		int value = 0;
		if(n == 1) {
			value = cbi.ToInteger(IXR1.getText());
		}
		else if(n == 2) {
			value = cbi.ToInteger(IXR2.getText());
		}
		else if(n == 3) {
			value = cbi.ToInteger(IXR3.getText());
		}
		return value;
	}
	public String addPCValue(String PCvalue) {
		int nextValue = cbi.ToInteger(PCvalue) + 1;
		return cib.ToBinary12(nextValue);
	}
	public void operation(InstructionRegister ir) {
		int i = 0;
		String addr = cib.ToBinary12(cbi.ToInteger(ir.IRAddress()));
		int operation = cbi.ToInteger(ir.IROperation()); 
		int gprNumber = cbi.ToInteger(ir.IRGprnumber());
		int ixrnumber = cbi.ToInteger(ir.IRIndexNumber());
		int indirect = cbi.ToInteger(ir.IRIndirect());
		if(operation == 1) {
			MAR.setText(addr);
			mar.setValue(addr);
			if(indirect==1 && ixrnumber== 0) {
				int effectiveAddress = memory.getValue(addr);
				i = memory.getValue(cib.ToBinary12(effectiveAddress));
			}
			else if(indirect==0 && ixrnumber != 0) {
				int ixrvalue = getIXRvalue(ixrnumber);
				int effectiveAddress = ixrvalue + cbi.ToInteger(addr);
				i = memory.getValue(cib.ToBinary12(effectiveAddress));
			}
			else if(indirect==1 && ixrnumber != 0) {
				int ixrvalue = getIXRvalue(ixrnumber);
				int effectiveAddress = memory.getValue(cib.ToBinary12(ixrvalue + cbi.ToInteger(addr)));
				i = memory.getValue(cib.ToBinary12(effectiveAddress));
			}
			else {
				i = memory.getValue(addr);	
			}
			setGprValue(gprNumber, i);
			
		}
		if(operation == 0) {
			
		}
		
	}
}
	
