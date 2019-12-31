//Radix Sort
import java.util.*;
import java.io.*;
public class RadixSort {
	int count;
	public RadixSort(ArrayList<int[]> File)  throws FileNotFoundException{
		int fileNum = 8;	
		for(int x = 0; x < File.size(); x++) {// for each file
			count=0;
			int [] a = File.get(x); //Get the array stored in each file
			Radix_Sort(a);			
			PrintWriter out = new PrintWriter("SortedRadixNum" + fileNum + ".txt");  
			out.println();
			out.println("Radix Sort count for Num"+ fileNum + ".txt = " + count);			
			for(int sorted = 0; sorted < a.length; sorted++) { //loop to print out number to a file
				out.print(a[sorted] + " ");
			}
			out.close();
			System.out.println("Radix Sort count for Num"+ fileNum + ".txt = " + count);
			fileNum=fileNum*2;
		}
	}
	private void Radix_Sort(int[] a) {
		int length = a.length;
		int size = 10;		
		int max = getMax(a);
		for(int r = 1; max/r>0; r *=10 ){
			int [] storeArray = new int[length];
			int [] countArray = new int[size];			
			for(int x = 0; x<10; x++) {
				countArray[x]=0;
			}			
			int last;			
			for(int x=0; x<length; x++) {
				last = (a[x]/r)%10;
				countArray[last] += 1;
            }			
			for (int x=1; x<10; x++) {
				countArray[x] = countArray[x] + countArray[x - 1];
			}
			int index;
            for (int x = (length-1); x>=0; x--){
            	count++; 
            	last = (a[x]/r)%10;
            	index = countArray[last]-1;
            	storeArray[index] = a[x];
            	countArray[last] -= 1;
            }
            for(int x=0; x<length; x++){
                a[x] = storeArray[x];
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
