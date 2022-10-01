package Simulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileReader {
	
	int noOfLines; 
	JFileChooser chooser = new JFileChooser();
	StringBuilder fileText = new StringBuilder();
	
	public void chooseFile() throws FileNotFoundException {
	 
     FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
     chooser.setFileFilter(filter);
     if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
    	 
    	 File file = chooser.getSelectedFile();
    	 Scanner input = new Scanner(file);
    	 
    	 while(input.hasNext()) {
    		 fileText.append(input.nextLine());
    		 fileText.append("\n");
    		 noOfLines++;
    	 	}
    	 System.out.println(fileText);
    	 System.out.println(noOfLines);
    	 input.close();
     	}
     else {
    	 fileText.append("No File was Selected");
     }
   }
	public String[] getCommands(){
		String[] fileLines =  fileText.toString().split("\n");
		return fileLines;
	}	
}
