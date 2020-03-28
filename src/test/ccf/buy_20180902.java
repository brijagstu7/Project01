package test.ccf;

import java.util.Scanner;

public class buy_20180902 {


    static int n;
    static int[][] timeFields0,timeFields1;
    static {

        Scanner sc = new Scanner(System.in);

        int n0 = n = sc.nextInt();

        timeFields0 = new int[n][2];
        timeFields1 = new int[n][2];

        while (n0-- != 0){
            timeFields0[n-n0-1][0] = sc.nextInt();
            timeFields0[n-n0-1][1] = sc.nextInt();
        }
        n0 = n;
        while (n0-- != 0){
            timeFields1[n-n0-1][0] = sc.nextInt();
            timeFields1[n-n0-1][1] = sc.nextInt();
        }



    }

    /**
     *
     * @param tf0 time field 0
     * @param tf1 time field 1
     * @return the overlapped time. 0 means no overlapped time.
     */
    static int ovlpNum(int[] tf0, int[] tf1){
        if (tf0[0]>=tf1[1] || tf0[1]<=tf1[0])return 0;
        if (tf0[1]>=tf1[1]) {
            if (tf0[0]>=tf1[0]) {
                return tf1[1] - tf0[0];
            }else {
                return tf1[1]-tf1[0];
            }
        }else if (tf1[0]>=tf0[0]) {
            return tf0[1] - tf1[0];
        }else {
            return tf0[1] - tf0[0];
        }



    }

    public static void main(String[] args){
        int totalTime = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalTime += ovlpNum(timeFields0[i],timeFields1[j]);
            }
        }
        System.out.println(totalTime);
    }
}
