package try01;

import java.util.Scanner;

public class number_tower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//new Scanner does not request input.
		int times, height;
		times = sc.nextInt();
		
		for(int k=0;k<times;k++) {
		height = sc.nextInt();
		if(height<1||height>100)return;
		/**
		 * initialize [][]
		 */
		int a[][] = new int[height][height];
		int dp[][] = new int[height][height];
		/*for(int i=0;i<height;i++) {
			for(int j=0;j<=i;j++) {
				a[i] = new int[j+1];
				dp[i] = new int[j+1];
			}
		}*/
		
		/**
		 * input a[][]
		 */
	
			//nextInt request input once
			
			for(int i=0;i<height;i++) {
				for(int j=0;j<=i;j++) {
					a[i][j] = sc.nextInt();
					//System.out.println(Arrays.toString(a));
				}
			}
		
		/**
		 * test:current array
		 */
		/*for(int i=0;i<height;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}*/
		
		/**
		 * main process
		 */
		dp[0][0] = a[0][0];
		for(int i=1;i<height;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0)dp[i][j] = a[i][j] + dp[i-1][j];
				else if(j==i)dp[i][j] = a[i][j] + dp[i-1][j-1];
				else
				dp[i][j] = a[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
			}
		}
		
		/**
		 * look for the biggest dp
		 */
		int max;
		max = dp[height-1][0];
		for(int i=1;i<height;i++) {
			max = dp[height-1][i] > max ? dp[height-1][i] : max;
		}
		
		System.out.println(max+"\n");
	}
	}
}
