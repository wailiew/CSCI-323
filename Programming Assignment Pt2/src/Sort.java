//Sort(main)
import java.io.FileNotFoundException;
public class Sort {
	public static void main(String[] args) throws FileNotFoundException {
		BucketSort bucket = new BucketSort(new ImportFiles().getUnsortedFiles());
		CountingSort count = new CountingSort(new ImportFiles().getUnsortedFiles());
		RadixSort Radix = new RadixSort(new ImportFiles().getUnsortedFiles());
	}
}
