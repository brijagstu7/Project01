package test;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m,x,y;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		x = (m-2*n)/2;
		y = (4*n-m)/2;
		
		System.out.println(x);
		System.out.println(y);
	}

}
