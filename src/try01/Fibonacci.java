package try01;

import java.util.Scanner;

class Fibonacci {
	
	static long nums(long n) {
		long a,b,tmp=0;
		a = b = 1;
		if(n==1||n==2)return 1;
		for(int i=0;i<n-2;i++) {
			tmp = a + b;
			a = b;
			b = tmp;
		}
		return tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		System.out.println(nums(n));
	}

}
