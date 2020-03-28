package try01;

import java.util.Scanner;



public class Main_amuse{
  
	
	static int [] arr = null;
	
	static double getMean() {
		double sum = 0.0;
		for(int x:arr) {
			sum += x;
		}
		return sum/arr.length;
	}
	
	
	static int getClosest(int index) {
		double mean = getMean();
		
		double tmp = arr[0];
		for (int i : arr) {
			tmp = Math.abs(i-tmp)>tmp?tmp:i-tmp;
		}

		return 0;
	}
	
	
	public static void main(String [] args){
		//initialize:
 	 	Scanner sc = new Scanner(System.in);
  
  		int n = sc.nextInt(), k = sc.nextInt();
  		int times = 2*n+k;
  		
  		arr = new int[times];
 	 	while (times != 0) {
 	 		arr[2*n+k-times] = sc.nextInt();
 	 		times--;
 	 	}
 	 	
 	 	//
 	 	
 	 	times = 0;
 	 	int result = 0;
 	 	while (times != 2*n+k) {
 	 		result += getClosest(times);
 	 		
 	 		times++;
 	 	}
 	 	System.out.println(result);
 	 	
 	 	
 	 	
 	 	
 	 	
 	 	
 	 	sc.close();
  }
}