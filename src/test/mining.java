package test;

import java.util.ArrayList;
import java.util.HashMap;
import static java.lang.Math.max;

//To know about the test, go to WeChat.

//This is the best example for elementary DP.
public class mining {
	/** values*/
	static int G[] = {10, 40, 30, 50, 35, 40, 30};
	/** burdens*/
	static int P[] = {35, 30, 60, 50, 40, 10, 25};
	
	static int value;
	static Integer arr[];
	/**
	 * HashMap method, O(n^2)
	 */
	static int F(int n, int w, HashMap<Integer[],
			Integer>map) {
		if(n<=1&&w<P[0])return 0;
		if(n==1&&w>=P[0])return G[0];
		
		arr = new Integer[]{n,w};
		if (!map.containsKey(arr)) {
			if (n > 1 && w < P[n - 1])
				value = F(n - 1, w, map);
			else//with import static, fucking easy?
				value = max(F(n - 1, w, map),
						F(n - 1, w - P[n - 1], map) 
						+ G[n - 1]);
			map.put(arr, value);
			return value;
		}else {
			return map.get(arr);
		}
	}
	/**
	 * Using greedy algorithm.
	 * same O(n^2).
	 * It will be forever correct unless two 
	 * G[i]/P[i] are same.
	 */
	static int greedy(int upperBound) {
		ArrayList<Float> avr = new ArrayList<Float>();
		
		for(int i=0;i<G.length;i++) {
			avr.add((float) (G[i]/P[i]));
		}
		
		float maxValue=0;
		int ordinal=0;
		while(true) {
			for (int i = 0; i < avr.size(); i++) {
				if(avr.get(i) > maxValue) {
					maxValue = avr.get(i);
					ordinal = i;
				}
			}
			if(value+G[ordinal]<upperBound)value += G[ordinal];
			else break;
			avr.remove(ordinal);
		}
		return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer[],Integer> map = 
				new HashMap<Integer[],Integer>();
		System.out.println(F(G.length, 150, map));
		System.out.print(greedy(150));
	
	}
}
