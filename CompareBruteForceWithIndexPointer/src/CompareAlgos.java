import java.util.Random;

public class CompareAlgos {
	
	private int upper_bound_integer = 1000000;
	
	public int num_instances = 1;
	
	public int num_elements = 5;
	
	public PartitionStrategy[] partition_strategies; 
	
	public Integer[] list2partition;
	
	public CompareAlgos() {

	}
	
	public void setNumElements(int anum) {
		this.num_elements = anum;
	}
	
	public void setList2Parition(Integer[] A) {
		list2partition = A;
	}
	
	public Integer[] getList2Parition() {
		return list2partition;
	}
	
	public void setNumInstances(int anum) {
		this.num_instances = anum;
	}
	
	public int getNumInstances() {
		return this.num_instances;
	}
	
	public void run(PartitionStrategy ps) {
		// run using this partitionstrategy
		ps.run();		
	}
	
	public Integer[] RandomListGenerator(int lenlist) {
		if (lenlist <= 0) return null;
		Random r = new Random();
		Integer[] A = new Integer[lenlist];
		for (int i=0; i<lenlist;i++) {
			A[i] = r.nextInt(upper_bound_integer);
		}
		return A;
	}
	
	public void compare(CompareAlgos thisca) {
		// compare based on thisca
		if (thisca.getList2Parition() == null) {
			// randomly generate one
		}
	}
	
	public void CompareWithStrategies(String[] strategies) {
		Integer[] currentList2Partition = this.getList2Parition();
		if ( currentList2Partition== null) {
			if (num_elements > 0) {
				// randomly generate one 
				currentList2Partition = RandomListGenerator(num_elements);
			}
			else return;
		}
		int counter = this.getNumInstances();
		while (counter > 0)	{
			for (String one_strategy: strategies) {
				if (one_strategy.equals("BruteForceStrategy")) {
					PartitionStrategy ps = new BruteForceStrategy(currentList2Partition);	
					this.run(ps);
				}
				else if (one_strategy.equals("IndexStrategy")) {
					PartitionStrategy ps = new IndexStrategy(currentList2Partition);	
					this.run(ps);
				}
				// TODO: when new strategies added, new logic adds here
			}
		counter--;
		}
		
	}
	

}
