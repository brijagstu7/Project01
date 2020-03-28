package test.textbook;


/*
    first dp test.
 */
/*
example:
    5
8
12 15
3 9 6
8 10 5 12
16 4 18 10 9
 */

import java.util.Scanner;

public class Number_tower {

    static int dp[][];
    static int arr[][];
    static final int n;

    static{

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        dp = new int[n][n];

        int n0 = 0;
        while (n0 != n){
            int i = 0;
            while (i != n0+1){
                arr[n0][i] = sc.nextInt();
                i++;
            }


            n0++;
        }

        //assign edge values to dp[][].
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = arr[n-1][i];
        }

    }


    static int dp(int i, int j){
        if (dp[i][j] > 0){
            return dp[i][j];
        }else {
            return dp[i][j] = Math.max(dp(i+1,j),dp(i+1,j+1))+arr[i][j];
        }
    }

    public static void main(String args[]){



        for (int i = n-2; i >=0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1])+arr[i][j];
            }
        }
        //calculation specified
        System.out.println(dp[0][0]);

        /*
            the following were added in 12/11.
         */
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = arr[n-1][i];
        }

        //calculation simplified but with memory of calculation
        dp(0,0);

        System.out.println(dp[0][0]);

    }
}
