import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class BruteForceStrategy extends PartitionStrategy {

	public BruteForceStrategy(Integer[] A) {
		super(A);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return "BruteForceStrategy";
	}
	
	public int run() {
		if (this.arraylist == null) {
			System.out.println("The given integer list is empty!!!");
			return -1;
		}
		int arraylength = arraylist.length;
		if (arraylength <= 20) {
			System.out.println("before " + this.getName() + " partition, the array is ");
			for (int i=0; i<arraylength;i++) {
				System.out.print(arraylist[i] + " ");
			}
		}
		else 
		{
		NumberFormat nf = NumberFormat.getInstance(Locale.US); 
		System.out.println("Array List contains " + nf.format(arraylength) + " elements");
		}
		// using two temporary list
		long begintime = System.currentTimeMillis();
		ArrayList<Integer> NoBiggerElements = new ArrayList<Integer>();
		ArrayList<Integer> BiggerElements = new ArrayList<Integer>();
		
		Integer pivotvalue = arraylist[arraylist.length - 1];
		
		for (int i=0; i<arraylength-1; i++) {
			if (arraylist[i] <= pivotvalue)
				NoBiggerElements.add(arraylist[i]);
			else 
				BiggerElements.add(arraylist[i]);
		}
		
		int numNoBiggerElements = NoBiggerElements.size();
		for (int i=0; i<numNoBiggerElements;i++) {
			arraylist[i] = NoBiggerElements.get(i);
		}
		
		arraylist[numNoBiggerElements] = pivotvalue;
		
		for (int i=numNoBiggerElements;i<arraylength - 1;i++)
			arraylist[i+1] = BiggerElements.get(i - numNoBiggerElements);
		
		long endtime = System.currentTimeMillis();
		long duration = endtime - begintime;
		
		System.out.println();
		System.out.println(this.getName() + " spends " + duration + " ms");
		if (arraylist.length <= 20) {
			System.out.println("after " + this.getName() + " partition, the array is ");
			for (int i=0; i<arraylist.length;i++) {
				System.out.print(arraylist[i] + " ");
			}
		}
		System.out.println();
		System.out.println();
		return numNoBiggerElements;
	}
}
