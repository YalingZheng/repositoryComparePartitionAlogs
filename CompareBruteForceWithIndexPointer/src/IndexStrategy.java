import java.text.NumberFormat;
import java.util.Locale;

public class IndexStrategy extends PartitionStrategy {
	
	public IndexStrategy(Integer[] A) {
		super(A);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return "IndexStrategy";
	}
	
	public int run() {
		if (this.arraylist == null) {
			System.out.println("The given integer list is empty!!!");
			return -1;
		}
		// using two temporary list
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
		System.out.println();
		long begintime = System.currentTimeMillis();
			
		Integer pivotvalue = arraylist[arraylength - 1];
		
		int lindex = 0; 
		int rindex = arraylength - 2;
		
		while (lindex <= rindex) {
			while ((lindex <= rindex) && (this.arraylist[lindex] <= pivotvalue)) {
				lindex++;
			}
			if (lindex > rindex) break;
			while ((lindex <= rindex) && (this.arraylist[rindex] > pivotvalue)) {
				rindex--;
			}
			if (lindex > rindex) break;
			// swap arraylist[lindex] and arraylist[rindex]
			int temp = arraylist[lindex];
			arraylist[lindex] = arraylist[rindex];
			arraylist[rindex] = temp;
			lindex++;
			rindex--;
		}
		// insert the pivot before lindex
		// increase the index of all elements from lindex to arraylength - 2 by one
		for (int i=arraylength-1; i>= lindex+1; i--)
			arraylist[i] = arraylist[i-1];
		arraylist[lindex] = pivotvalue;
				
		long endtime = System.currentTimeMillis();
		long duration = endtime - begintime;
		
		System.out.println(this.getName() + " spends " + duration + " ms");
		
		if (arraylength <= 20) {
			System.out.println("after " + getName() + " partition, the array is ");
			for (int i=0; i<arraylength;i++)
				System.out.print(arraylist[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		return 0;
	}
}
