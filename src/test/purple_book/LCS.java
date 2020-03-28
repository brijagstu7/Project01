package test.purple_book;

import java.util.Scanner;


/*
    example:
    6 7
1 5 2 6 8 7
2 3 5 6 9 8 4
 */
public class LCS {


    static int n,m;
    static int[] list0,list1;
    static int[][] dp;

    static {
        Scanner sc = new Scanner(System.in);

        int n0 = n = sc.nextInt();
        int m0 = m = sc.nextByte();
        list0 = new int[n];
        list1 = new int[m];
        dp = new int[n][m];

        while (n0-- != 0){
            list0[n-n0-1] = sc.nextInt();
        }

        while (m0-- != 0){
            list1[m-m0-1] = sc.nextInt();
        }

        n0 = n;
        while (n0-- != 0){
            if (list0[n-n0-1] == list1[0]){
                int i = n-n0-1;
                while (i<n){
                    dp[i][0] = 1;
                    i++;
                }
                break;
            }
        }
        m0 = m;
        while (m0-- != 0){
            if (list1[m-m0-1] == list0[0]){
                int i = m-m0-1;
                while (i<m){
                    dp[0][i] = 1;
                    i++;
                }
                break;
            }
        }

    }
    public static void main(String[] args) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (list0[i] == list1[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
