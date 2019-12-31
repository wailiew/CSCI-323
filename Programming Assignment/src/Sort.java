//Sort(main)

import java.util.*;
import java.io.*;
public class Sort {
		
	public static void main(String[] args) throws IOException {
		
		InsertionSort insert = new InsertionSort(new ImportFiles().getUnsortedFiles());
		QuickSort Quick = new QuickSort(new ImportFiles().getUnsortedFiles());
		MergeSort Merge = new MergeSort(new ImportFiles().getUnsortedFiles());
		HeapSort Heap = new HeapSort(new ImportFiles().getUnsortedFiles());
	
	}	
}
