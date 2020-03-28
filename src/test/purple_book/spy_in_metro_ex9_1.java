package test.purple_book;

import java.util.Scanner;

public class spy_in_metro_ex9_1 {

    static int n,t,m1,m2;
    static int[] passage,beginTimeLeft,beginTimeRight;
    static int[][] dp;

    static {
        Scanner sc = new Scanner(System.in);

        int n0 = n = sc.nextInt();
        t = sc.nextInt();
        dp = new int[t][n];//time,station

        passage = new int[n];
        while (n0-- != 0){
            passage[n-n0-1] = sc.nextInt();
        }
        n0 = m1 = sc.nextByte();
        beginTimeLeft = new int[m1];
        while (n0-- != 0){
            beginTimeLeft[m1-n0-1] = sc.nextInt();
        }

        m2 = sc.nextByte();
        beginTimeRight = new int[m2];
        while (n0-- != 0){
            beginTimeLeft[m1-n0-1] = sc.nextInt();
        }




    }

    static boolean canTakeLeft(int time, int station){
        if (station <= 0)return false;
        //
        return false;
    }

    static boolean canTakeRight(int time, int station){
        if (station >= n)return false;
        //
        return false;
    }

    /**
     * we have 3 choices: take the left train(if able) or the right train(if able) or just wait for 1 period.
     * @param time
     * @param station 0~n-1.meaning the 1,2,3,...n th station
     * @return the minimal total time spent on waiting in the station
     */
    static int dp(int time, int station){

        if (time > t || time < 0)return -1;
        if (station == n)return 0;
        if (dp[time][station] >0)return dp[time][station];

        int waitingSum = dp(time+1,station);
        dp[time][station] = waitingSum;
        //only when
        if (canTakeLeft(time,station)){
            dp[time][station] = Math.min(dp(time+passage[station-1],station-1),waitingSum);
        }
        if (canTakeRight(time, station)){
            dp[time][station] = Math.min(dp(time+passage[station],station+1),dp[time][station]);
        }

        //why do I doubt this operation!!
        if (dp[time][station] == waitingSum){
            dp[time][station] += 1;
        }
        return dp[time][station];
    }

    public static void main(String[] args) {
        int d = dp(0,0);
        System.out.println(d<0?"impossible":d);
    }
}
