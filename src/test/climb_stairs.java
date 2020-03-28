package test;

import java.util.HashMap;

//To know about the test, go to WeChat.

public class climb_stairs {
	//HashMap is a mapping.
	/**
	 * using HashMap.
	 * @param n
	 * @param map
	 * @return
	 */
	static long F(long n, HashMap<Long, Long> map) {
		if(n==1)return 1;
		if(n==2)return 2;
		
		if(map.containsKey(n)) {
			return map.get(n);
		}else {
			long value = F(n-1, map)+F(n-2, map);
			map.put(n, value);
			return value;
		}
	}
	/**
	 * not using HashMap.
	 * The problem is simply based on the equation
	 * F(n) = F(n-1) + F(n-2)
	 * @param n
	 * @return
	 */
	static long G(long n) {
		long a = 1;
		long b = 2;
		long temp = 0;
		
		if(n==1)return 1;
		if(n==2)return 2;
		for(int i=0;i<n-2;i++) {
			temp = a + b;
			a = b;
			b = temp;
		}
		return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		System.out.print(G(3));
	}

}
