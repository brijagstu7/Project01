package generic;



class nums<E extends Number>{
	E[] arr;
	nums(E arr[]){
		this.arr = arr;
	}
	
	double Sum() {
		double sum = 0.0;
		for(E i:this.arr) {
			sum += i.doubleValue();
		}
		return sum;
	}
	/** Here's an example showing the difference between E,?
	 *  
	 *  nums<Double> n0 = new nums<Double>();
	 * 	nums<Integer> n1 = new nums<Integer>();
	 * 	//after instantiation
	 * 	n0.sameSum(n1)
	 * 	//OK for ? , not E.
	 */
	boolean sameSum(nums<?> nums1) {
		if(Sum()==nums1.Sum())
		return true;
		return false;
	}
}

public class wildcard {
	//A wildcard is <?> in a signature.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i[] = {1,2,3,5};
		nums<Integer> n1 = new nums<Integer>(i);
		Double j[] = {1.3,1.4,6.2};
		nums<Double> n2 = new nums<Double>(j);
		
		System.out.print(n1.sameSum(n2));
	}

}
