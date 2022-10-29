package Simulator;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.EventQueue;
import java.io.PrintStream;
import Utils.CustomOutputStream;


public class ConsoleLog extends JFrame{

	private static PrintStream standardOut;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsoleLog frame = new ConsoleLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ConsoleLog() {
		JFrame consoleFrame = new JFrame("Console Log");
		consoleFrame.setBounds(200,200,647,498);
		consoleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane ConsoleLogScrollPane = new JScrollPane();
		ConsoleLogScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ConsoleLogScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JTextArea ConsoleLogTextArea = new JTextArea();
		ConsoleLogTextArea.setEditable(false);
		ConsoleLogScrollPane.setViewportView(ConsoleLogTextArea);
		
		PrintStream printStream = new PrintStream(new CustomOutputStream(ConsoleLogTextArea));
		standardOut = System.out;
		System.setOut(printStream);
        System.setErr(printStream);
        
		GroupLayout groupLayout = new GroupLayout(consoleFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(ConsoleLogScrollPane, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(ConsoleLogScrollPane, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE))
		);
		consoleFrame.getContentPane().setLayout(groupLayout);
		
		consoleFrame.setVisible(true);
	}

}
