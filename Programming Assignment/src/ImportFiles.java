//Import Files

import java.util.*;
import java.io.*;

public class ImportFiles {
	ArrayList<int[]> unsortedFiles = new ArrayList<int[]>();
	
	public ImportFiles() throws FileNotFoundException { //put the number in the ArrayList
		for(int fileNum = 8; fileNum<=16384; fileNum=fileNum*2) {//
			String file = "Num" + fileNum + ".txt";
			File inputFile = new File(file);
			Scanner in = new Scanner (inputFile);
			int [] unsortedArray = new int[fileNum]; //each file to put in array[] 
			
			int count = 0;
			while (in.hasNextInt()) {
				unsortedArray[count]=in.nextInt();
				count++;
			}
			unsortedFiles.add(unsortedArray);
		}
	}

	public ArrayList<int[]> getUnsortedFiles() {
		return unsortedFiles;
	}
}
