//Merge Sort

import java.util.*;
import java.io.*;
public class MergeSort {
	
	int count; //to keep count
	public MergeSort(ArrayList<int[]> File) throws FileNotFoundException {
		int fileNum = 8;	
			
		for(int x = 0; x < File.size(); x++) {// for each file
			count=0;
			int [] a = File.get(x); //Get the array stored in each file
			int first = 0;
			int last = a.length-1;
			Merge_Sort(a,first,last);
				
			PrintWriter out = new PrintWriter("SortedMergeNum" + fileNum + ".txt"); 
			out.println();
			out.println("Merge Sort count for Num"+ fileNum + ".txt = " + count);
			for(int sorted = 0; sorted < a.length; sorted++) { //loop to print out number to a file
				out.print(a[sorted] + " ");
			}
			out.close();
			System.out.println("Merge Sort count for Num"+ fileNum + ".txt = " + count);
			fileNum=fileNum*2;		
		}
	}

	private void Merge_Sort(int[] a, int first, int last) {
		if(first<last) { //more than 1 element
			int mid = (first + last)/2;
			Merge_Sort(a,first,mid);
			Merge_Sort(a,mid+1,last);
			Merge(a,first,mid,last);
		}		
	}

	private void Merge(int[] a, int first, int mid, int last) {
		int left = first;
		int right = mid + 1;
		int [] b = new int [last - first + 1];
		int i=0;
		
		while((left <= mid) && (right<= last)) {
			count++;
			if (a[left] < a[right]) {
				b[i++] = a [left ++];
			}
			else {
				b[i++] = a[right++];
			}
		}
		
		if(left <= mid) { // still have data on left
			for(int j = left; j <= mid; j++) {
				count++;
				b[i++] = a[j];				
			}
		}
		
		else { //still have data on right
			for(int j=right; j<= last; j++) {
				count++;
				b[i++] = a[j];
			}
		}
	
		i = 0;
		for(int j = first; j<= last; j++) { // copy b to a
			a[j] = b[i++];
		}
	}
}
