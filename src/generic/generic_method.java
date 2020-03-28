package generic;

public class generic_method {
	
	/**
	 * this is a generic method.
	 * the generic declaration <E extends...F>
	 * has the same usage as that of a class.
	 * so as constructors, interfaces.
	 * 
	 * Note that: it is put before return type.
	 */
	static <E extends Comparable<E>, F> 
	boolean isIn(E x, F[] y) {
		for(int i=0;i<y.length;i++) {
			if(x.equals(y[i]))return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer nums[] = {1,2,3,4,5};
		System.out.print(isIn('a',nums));
	}

}
