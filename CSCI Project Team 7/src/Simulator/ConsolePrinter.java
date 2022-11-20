package Simulator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.EventQueue;
import java.io.PrintStream;
import Utils.CustomOutputStream;

public class ConsolePrinter extends JFrame {
	private JPanel consolePrinterFrame;
	private JScrollPane ConsolePrinterScrollPane;
	private JTextArea ConsolePrinterTextArea;
	private static PrintStream standardOut;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsolePrinter frame = new ConsolePrinter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConsolePrinter() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200,200,647,498);
		setTitle("Console Printer");
		consolePrinterFrame = new JPanel();
		consolePrinterFrame.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(consolePrinterFrame);
		//consoleFrame.setBounds(200,200,647,498);
		//consoleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ConsolePrinterScrollPane = new JScrollPane();
		ConsolePrinterScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ConsolePrinterScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		ConsolePrinterTextArea = new JTextArea();
		ConsolePrinterTextArea.setEditable(false);
		ConsolePrinterScrollPane.setViewportView(ConsolePrinterTextArea);
	    
		GroupLayout groupLayout = new GroupLayout(consolePrinterFrame);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(ConsolePrinterScrollPane, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(ConsolePrinterScrollPane, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE))
		);
		//consoleFrame.getContentPane().setLayout(groupLayout);
		consolePrinterFrame.setLayout(groupLayout);
	}
	public void printText(String value) {
//		JTextArea ConsolePrinterTextArea = new JTextArea();
		ConsolePrinterTextArea.append(value);
	}
}