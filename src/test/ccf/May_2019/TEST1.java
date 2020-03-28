package test.ccf.May_2019;

import java.util.Scanner;


public class TEST1 {
	
	static int n ;
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i<n	; i++) {
			a[i]= scanner.nextInt(); 
		}
		
		int min,max;
		double mid;
		if(a[0]>a[n-1]){
			min = a[n-1];
			max = a[0];
		}else {
			min = a[0];
			max = a[n-1];
		}
		
		if(n % 2 == 0){
			mid = (double)(a[n/2]+a[n/2-1])/2;
		}else {
			mid  = (double)a[(n-1)/2];
		}
		
		
		System.out.println(max+" "+mid+" "+min);
	}

}
