
public class TestStrategies {

	public static void main(String[] args) {
		// Test and compare the strategies
		CompareAlgos ca0 = new CompareAlgosBuilder().withNumElements(0).build();
		String[] strategies = {"BruteForceStrategy", "IndexStrategy"};
		
		ca0.CompareWithStrategies(strategies);
		Integer[] A2 = {1, 2, 3, 4, 5};
		Integer[] A3 = {5, 4, 3, 2, 1};
		Integer[] A4 = {5, 4, 3, 2, 3};
		Integer[][] Alists = {A2, A3, A4};
		
		for (int index = 0; index < Alists.length; index++) {
			Integer[] curA = Alists[index];
			CompareAlgos ca1 = new CompareAlgosBuilder().withList2Partition(curA).build();
			ca1.CompareWithStrategies(strategies);
		}
		
		CompareAlgos ca2 = new CompareAlgosBuilder().withNumElements(10).withNumInstances(5).build();
		ca2.CompareWithStrategies(strategies);
		
		CompareAlgos ca3 = new CompareAlgosBuilder().withNumElements(10000000).withNumInstances(5).build();
		ca3.CompareWithStrategies(strategies);
	}

}
