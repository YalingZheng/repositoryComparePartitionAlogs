public class PartitionStrategy {
	String name;
	
	public Integer[] arraylist;
	
	public PartitionStrategy(Integer[] A) {
		// deep copy
		if (A == null) return;
		int arraylen = A.length;
		arraylist = new Integer[arraylen];
		for (int i=0; i<arraylen;i++)
			this.arraylist[i] = A[i];
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int run() {
		return -1;
	}
	
}
