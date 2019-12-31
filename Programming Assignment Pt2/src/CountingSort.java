//Counting Sort
import java.util.*;
import java.io.*;
public class CountingSort {
	int count;
	public CountingSort(ArrayList<int[]> File)  throws FileNotFoundException{
		int fileNum = 8;	
		for(int x = 0; x < File.size(); x++) {// for each file
			count=0;
			int[] a = File.get(x); //Get the array stored in each file
			int max = getMax(a);
			int[] b = new int [max];			
			Counting_Sort(a, b, max);			
			PrintWriter out = new PrintWriter("SortedCountingNum" + fileNum + ".txt");
			out.println();
			out.println("Counting Sort count for Num"+ fileNum + ".txt = " + count);			
			for(int sorted = 0; sorted < b.length; sorted++) { //loop to print out number to a file
				out.print(b[sorted] + " ");
			}
			out.close();
			System.out.println("Counting Sort count for Num"+ fileNum + ".txt = " + count);
			fileNum=fileNum*2;
		}
	}	
	private void Counting_Sort(int[] a, int[] b, int max) {
		 int c[] = new int[max+1];	       
		 	for(int i=0;i<max;i++){ 
	            c[i] = 0;
	        }		 
	        for(int j= 1; j<max; j++){
	            ++c[a[j]] ;
	        }
	        for(int i = 1; i<=max; i++){
	            c[i] = c[i] + c[i-1];
	        }
	        for (int i = 0; i<max; ++i){
	            count++; 
	            b[c[a[i]]] = a[i];
	            c[a[i]] = c[a[i]] -1;
	        }	
	}
	public int getMax(int a[]){
        int max = a[0];
        for (int x = 1; x < a.length; x++)
            if (a[x] > max)
                max = a[x];
        return max;
    }	
}
