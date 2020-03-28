package try01;

import java.util.Arrays;

import java.util.Scanner;
//different needs, different bulk.
class JosephProblem {
	static int mod(int gap, int k, int pn) {
		int a = (gap*k-k+1);
		if(a <= pn) {
			return a;
		}else {
			//???
			k %= (pn%gap) == 0? gap: (pn%gap);
			return a;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("population:");
		Scanner sc = new Scanner(System.in);
		int pn = sc.nextInt();
		System.out.print("gap area:");
		sc = new Scanner(System.in);
		int gap = sc.nextInt();
		int i,j,k;
		int p[] = new int[pn];
		//declare people array
		for(i=1;i<=pn;i++) {
			p[i-1] = i;
		}
		
		for(k=1;p.length>1;k++) {
			for(i=1,j=0;i<=pn;i++) {
				if(i==mod(gap,k,pn))continue;
				if((j) <= (p.length-1)) {
					p[j] = i;
					j++;
				}else {
					p[(j)%p.length] = i;
					j++;
				}
			}
			p = Arrays.copyOf(p, p.length-1);
		}
		System.out.println(p[0]);
	}

}
