package test.textbook;

import java.util.Scanner;
/*
    form of input:
    [number of vertices]
    [c[0][0]] [c[0][1]] [c[0][2]], ...
    [c[1][0]] [c[1][1]] [c[1][2]], ...
    ...
 */
public class Minimize_a_distance {

    static int dp[] = null;//target value: the distance
    static int c[][] = null;//distance from i to j; -1 indicates no path
    static int n;//number of vertices


    static {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n];
        c = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = sc.nextInt();
            }
        }
        //we request the n-1'th vertex cannot go forward, and hence:
        for (int i = 0; i < n; i++) {
            if (c[i][n-1]>0){
                dp[i] = c[i][n-1];
            }
        }
    }

    public static void main(String args[]){

        for (int j = n-1; j >= 0; j--) {
            if (dp[j]!=0){
                continue;//have direct access to the end point
            }

            int curMaxDis = 0;
            for (int i = 0; i < n; i++) {
                if (c[j][i]<0)continue;

                if (c[j][i]+dp[j+1]>curMaxDis){
                    curMaxDis = c[j][i]+dp[j+1];

                }
                dp[j] = curMaxDis;
            }
        }

        System.out.println(dp[0]);

    }

}
