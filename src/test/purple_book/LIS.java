package test.purple_book;

import java.util.Scanner;

/*
    example
    6
1 6 2 3 7 5
 */
public class LIS {

    static int n;
    static int[] list,dp;

    static {
        Scanner sc = new Scanner(System.in);

        int n0 = n = sc.nextInt();

        list = new int[n];
        dp = new int[n];

        while (n0--!= 0){
            list[n-n0-1] = sc.nextInt();
        }

    }


    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {

            int max = 0;
            for (int j = 0; j < i; j++) {
                if (dp[j]>max){
                    if (list[i] >= list[j]) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max +1;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(dp[i]+" ");
        }
    }
}
