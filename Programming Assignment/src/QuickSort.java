//Quick Sort

import java.util.*;
import java.io.*;
public class QuickSort {
	
	int count; //to keep count
	public QuickSort(ArrayList<int[]> File) throws FileNotFoundException {
			
		int fileNum = 8;	
		for(int x = 0; x < File.size(); x++) {// for each file
			count=0;
			int [] a = File.get(x); //Get the array stored in each file
			int first = 0;
			int last = a.length-1;
				
			Quick_Sort(a,first,last);
				
			PrintWriter out = new PrintWriter("SortedQuickNum" + fileNum + ".txt");  
			out.println();
			out.println("Quick Sort count for Num"+ fileNum + ".txt = " + count);
			
			for(int sorted = 0; sorted < a.length; sorted++) { //loop to print out number to a file
				out.print(a[sorted] + " ");
			}
			out.close();
			System.out.println("Quick Sort count for Num"+ fileNum + ".txt = " + count);
			fileNum=fileNum*2;				
		}
	}
	
	private void Quick_Sort(int []a, int first, int last){
		if (first < last){
			int pivot = Partition(a, first, last);
			Quick_Sort(a, first, pivot-1);
			Quick_Sort(a, pivot + 1, last);
		}
	}
			
	private int Partition(int [] a, int first, int last){
		int x = a[last];
		int left = first-1;
		
		for(int right = first;right < last; right++){
			count++;
			if(a[right] < x){
				left++; 
				swap(a,left,right);
			}
		}		
		swap(a,left+1,last);
		return left+1;
		}
	
    public void swap(int[] a, int one, int two) {
	int temp = a[one];
	a[one] = a[two];
	a[two] = temp;
    }
}
