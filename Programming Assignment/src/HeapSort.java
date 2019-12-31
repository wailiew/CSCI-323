//Heap Sort

import java.util.*;
import java.io.*;
public class HeapSort {
	int count;
	public HeapSort(ArrayList<int[]> File) throws FileNotFoundException {
		int [] totalLoop = new int[File.size()];
		int fileNum = 8;	
			
		for(int x = 0; x < File.size(); x++) {// for each file
			int [] a = File.get(x); //Get the array stored in each file
			count = 0; //to keep count
			Heap_Sort(a);
		
			PrintWriter out = new PrintWriter("SortedHeapNum" + fileNum + ".txt"); // create a file to store the 
			out.println();
			out.println("Heap Sort count for Num"+ fileNum + ".txt = " + count);
			
			for(int sorted = 0; sorted < a.length; sorted++) { //loop to print out number to a file
				out.print(a[sorted] + " ");
			}
			out.close();
			System.out.println("Heap Sort count for Num"+ fileNum + ".txt = " + count);
			fileNum=fileNum*2;
		}
	}

	private void Heap_Sort(int[] a) {
		int size = a.length;
		Build_Max_Heap(a);
		for(int length = size-1; length>=0; length--) {
			swap(a,0,length);
			size--;
			Heapify(a,0,size);
		}
	}

	private void Build_Max_Heap(int[] a) {
		int size = a.length;
		for(int length = size/2; length>=0; length--) {
			Heapify(a,length,size);
		}
	}

	private void Heapify(int[] a, int index, int size) {
		int left = (index * 2)+1;
		int right= (index * 2)+2;
		int largest;
		
		if((left < size) && a[left] > a[index]) {
			largest = left;
		}
		else {
			largest = index;
		}
		if((right < size) && a[right] > a[largest]) {
			largest = right;
		}
		if(largest != index) {
			count++;
			swap(a,index,largest);
			Heapify(a, largest, size);
		}
	}
	
	 public void swap(int[] a, int one, int two) {
		int temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
