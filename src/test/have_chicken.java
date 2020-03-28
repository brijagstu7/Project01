package test;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class have_chicken {
	static int G[] = null;
	static int P[] = null;
	
	static int value;
	static Integer arr[];
	
	static int greedy(int upperBound) {
		ArrayList<Float> avr = new ArrayList<Float>();
		
		for(int i=0;i<G.length;i++) {
			avr.add((float) (G[i]/P[i]));
		}
		
		float maxValue=0;
		int ordinal=0;
		int burden = 0;
		while(true) {
			for (int i = 0; i < avr.size(); i++) {
				if(avr.get(i) > maxValue) {
					maxValue = avr.get(i);
					ordinal = i;
				}
			}
			burden += P[ordinal];
			value += G[ordinal];
			if(burden<=upperBound);
			else break;
			avr.remove(ordinal);
		}
		return value;
	}
	static int F(int n, int w, HashMap<Integer[],
			Integer>map) {
		//if(w==0)return value;//
		if(n<=1&&w<P[0])return 0;
		if(n==1&&w>=P[0])return G[0];
		
		arr = new Integer[]{n,w};
		if (!map.containsKey(arr)) {
			if (n >= 1 && w < P[n - 1]) {
				if(w>0)
				value = max(F(n - 1, w, map),
						value+G[n-1]);
				else value = F(n - 1, w, map);
			}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0,m = 0,h = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		h = sc.nextInt();
		if(n==0) {
			sc.close();
			return;
		}
		//System.out.println(n+","+m+","+h);
		
		G = new int[n];//values
		P = new int[n];//burdens
		for(int i=0;i<n;i++) {
			sc = new Scanner(System.in);
			P[i] = sc.nextInt();
			G[i] = sc.nextInt();
		}
		sc.close();
		
		HashMap<Integer[],Integer> map = 
				new HashMap<Integer[],Integer>();
		System.out.println(greedy(m+h));
		
	}

}
