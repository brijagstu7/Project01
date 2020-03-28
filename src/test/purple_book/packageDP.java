package test.purple_book;

import java.util.Scanner;

/*
    the example:
    6 20
5 3 2 10 4 2
11 8 15 18 12 6
 */
public class packageDP {

    static int n,W;
    static int w[],v[], dp_inf[];
    static int dp_x[][];//dp_x[the i th thing to carry][volume left]

    static {
        Scanner sc = new Scanner(System.in);

        int n0 = n = sc.nextInt();W = sc.nextInt();

        w = new int[n];
        v = new int[n];
        dp_inf = new int[W+1];
        dp_x = new int[n][W+1];

        while (n0-- != 0){
            w[n-n0-1] = sc.nextInt();
        }
        n0 = n;
        while (n0-- != 0){
            v[n-n0-1] = sc.nextInt();
        }
    }

    /**
     *  This is a mode for a question with infinite things to carry.
     * @param leftWeight the weight left
     * @return the greatest total value at present state(the weight left)
     */
    static int dp(int leftWeight){
        if (leftWeight <= 0)return 0;
        if (dp_inf[leftWeight]>0)return dp_inf[leftWeight];

        for (int i = 0; i < n; i++) {
            if (leftWeight - w[i] >= 0){
                dp_inf[leftWeight] = Math.max(dp_inf[leftWeight],dp(leftWeight - w[i])+v[i]);
            }
        }

        return dp_inf[leftWeight];
    }

    /**
     * This is a mode for a question with one thing for each to carry.
     * @param index the index th thing to carry
     * @param leftWeight
     * @return the greatest total value at present state
     */
    static int dp(int index, int leftWeight){
        if (leftWeight <= 0 || index >=n)return 0;
        if (dp_x[index][leftWeight]>0)return dp_x[index][leftWeight];

        if (leftWeight - w[index] >= 0) {
            dp_x[index][leftWeight] =
                    Math.max(dp(index+1,leftWeight-w[index])+v[index], dp(index + 1, leftWeight));
        }

        return dp_x[index][leftWeight];
    }

    public static void main(String[] args) {
        System.out.println(dp(0,W));
    }
}
