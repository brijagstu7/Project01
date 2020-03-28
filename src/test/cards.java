package test;

import java.util.Scanner;

public class cards {

	static int a[];static int n;
	
	static void scan() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		sc = new Scanner(System.in);
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		//System.out.print(a[0]);
	}
	static boolean rank() {
		for(int i=0;i<n-1;i++){
			if(a[i]>a[i+1])return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan();
		System.out.print((n>=30)&&rank()?"yes":"no");
	}

}
