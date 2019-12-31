//Insertion Sort

import java.util.*;
import java.io.*;
public class InsertionSort {
	int count;
	public InsertionSort(ArrayList<int[]> File) throws FileNotFoundException {
		int fileNum = 8;	
		for(int x = 0; x < File.size(); x++) {// for each file
			int [] a = File.get(x); //Get the array stored in each file
			count = 0; //to keep count
			
			for(int j = 1; j < a.length; j++) { // for each number in the file
				int key = a[j];
				int i = j - 1;
				
				while (i >= 0 && a[i] > key) {
					count++;	
					a[i + 1] = a[i];
					i = i-1;
					a[i + 1] = key;
				}		
			}			
		 
			PrintWriter out = new PrintWriter("SortedInsertionNum" + fileNum + ".txt"); 
			out.println("Insertion Sort count for Num"+ fileNum + ".txt = " + count);
			for(int sorted = 0; sorted < a.length; sorted++) { //loop to print out number to a file
				out.print(a[sorted] + " ");
			}
			out.close();
			
			System.out.println("Insertion Sort count for Num"+ fileNum + ".txt = " + count);
			fileNum=fileNum*2;			
		}
	}		
}

	