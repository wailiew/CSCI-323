//Bucket Sort
import java.util.*;
import java.io.*;
public class BucketSort {
	int count;
	public BucketSort(ArrayList<int[]> File)  throws FileNotFoundException{
		int fileNum = 8;	
		for(int x = 0; x < File.size(); x++) {// for each file
			count=0;
			int [] a = File.get(x); //Get the array stored in each file
			Bucket_Sort(a);			
			PrintWriter out = new PrintWriter("SortedBucketNum" + fileNum + ".txt"); 
			out.println();
			out.println("Bucket Sort count for Num"+ fileNum + ".txt = " + count);			
			for(int sorted = 0; sorted < a.length; sorted++) { //loop to print out number to a file
				out.print(a[sorted] + " ");
			}
			out.close();
			System.out.println("Bucket Sort count for Num"+ fileNum + ".txt = " + count);
			fileNum=fileNum*2;
		}
	}
	private void Bucket_Sort(int[] a) {
		int max =getMax(a);
		int size = 10;		
		int divider = (int) Math.ceil(max + 1 / size);
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] buckets =  new ArrayList[size];
		for(int i = 0; i < buckets.length; i++)
			buckets[i] = new ArrayList<Integer>();		
		for(int x = 0; x< a.length; x++) {
			int j = a[x]/divider;
			buckets[j].add(a[x]);	
		}		
		for(int x=0; x<buckets.length;x++) {
			insertionSort(buckets[x]);
		}
		int p = 0;
		for(int x=0;x<size;x++) {
			for(int y = 0; y<buckets[x].size();y++) {
				a[p]=buckets[x].get(y);
				p++;
			}
		}	
	}
	private void insertionSort(List<Integer> a) {
		for(int j = 1; j < a.size(); j++) { // for each number in the file
			int key = a.get(j);
			int i = j - 1;
			
			while (i >= 0 && a.get(i) > key) {
				count++;	
				a.set(i+1, a.get(i));
				i = i-1;
				a.set(i+1, key);
			}		
		}			
	}	
	public int getMax(int a[]){ //return maximum value
        int max = a[0];
        for (int x = 1; x < a.length; x++)
            if (a[x] > max)
                max = a[x];
        return max;
    }
}
