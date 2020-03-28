package test.purple_book;

import java.util.Scanner;


/*
    example:
    6 5
3 4 1 2 8 6
6 1 8 2 7 4
5 9 3 9 9 5
8 4 1 3 2 6
3 7 2 8 6 4
 */
public class unidirectional_tsp_ex9_4 {


    static int n,m;
    static int[][] arr,dp;


    static {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();//column
        m = sc.nextByte();//row

        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][n-1] = arr[i][n-1];
        }
    }


    public static void main(String[] args) {
        for (int i = n-2; i >=0 ; i--) {//column
            for (int j = 1; j < m-1; j++) {//row
                dp[j][i] = arr[j][i] + (dp[j][i+1]>dp[j-1][i+1] ? ( dp[j-1][i+1]>dp[j+1][i+1] ? dp[j+1][i+1] : dp[j-1][i+1] ) :
                        ( dp[j][i+1]>dp[j+1][i+1] ? dp[j+1][i+1] : dp[j][i+1] ));
            }
            dp[0][i] = arr[0][i] + (dp[0][i+1]>dp[m-1][i+1]? ( dp[m-1][i+1]>dp[1][i+1] ? dp[1][i+1]: dp[m-1][i+1]):
                    ( dp[0][i+1]>dp[1][i+1] ? dp[1][i+1] : dp[0][i+1] ));
            dp[m-1][i] = arr[m-1][i] + (dp[m-1][i+1]>dp[m-1-1][i+1]? (dp[m-1-1][i+1]>dp[0][i+1] ? dp[0][i+1] : dp[m-1-1][i+1]):
                    ( dp[m-1][i+1]>dp[0][i+1] ? dp[0][i+1] : dp[m-1][i+1] ));
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
