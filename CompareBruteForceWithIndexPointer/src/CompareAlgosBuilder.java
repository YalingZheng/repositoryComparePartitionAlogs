
public class CompareAlgosBuilder {	
	public CompareAlgos comparealgos = new CompareAlgos();
	
	public CompareAlgos build(){
		return comparealgos;
	}
	
	public CompareAlgosBuilder withNumInstances(int anum) {		
		comparealgos.setNumInstances(anum);
		return this;
	}
	
	public CompareAlgosBuilder withList2Partition(Integer[] a) {
		comparealgos.setList2Parition(a);
		return this;
	}
	
	public CompareAlgosBuilder withNumElements(int anum) {
		comparealgos.setNumElements(anum);
		return this;
	}
	
	
}
