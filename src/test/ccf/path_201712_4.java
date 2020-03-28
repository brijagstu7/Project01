package test.ccf;

import java.util.ArrayList;
import java.util.Scanner;


/*
    example:
    6 7
1 1 2 3
1 2 3 2
0 1 3 30
0 3 4 20
0 4 5 30
1 3 5 6
1 5 6 1
 */
public class path_201712_4 {

    static int n,m;
    static boolean adj[][];
    static int[][] burden;
    static int[] dp;
    static ArrayList<Integer>arr;

    static {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m0 = m = sc.nextByte();

        adj = new boolean[n+1][n+1];
        burden = new int[n+1][n+1];
        dp = new int[n+1];
        arr = new ArrayList<>();

        while (m0-- != 0){
            boolean isNarrow = false;
            if (sc.nextInt() == 1){
                isNarrow = true;
            }

            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = true;
            //adj[b][a] = true;             note: a<b


            int distance = sc.nextInt();
            burden[a][b] = isNarrow?-distance*distance : distance;

        }
    }

    static int  add4square(int end){
        int i = arr.size()-2;
        int cur;
        int total = 0;
        while (i>=0){
            if ((cur = arr.get(i))<0){
                total+= (int)Math.sqrt(-cur);
            }else {
                break;
            }
            i++;
        }



        return 2*(total + end);

    }

    /**
     *
     * @param loc the number of location
     * @return the minimum cost from loc to the end.
     */
    static int dp(int loc){
        if (dp[loc]>0)return dp[loc];
        if (loc == n)return 0;

        int min = 1<<30;
        int j = -1;
        for (int i = 1; i <= n; i++) {
            if (adj[loc][i]){
                //arr.add(burden[loc][i]);
                dp[i] = dp(i);
                //if (arr.size()>0)arr.remove(arr.size()-1);
                if (dp[i] < min){
                    min = dp[i];
                    j = i;
                }
            }
        }

        arr.add(burden[loc][j]);
        //the position is not correct!

        if (burden[loc][j] < 0){
            //return min - burden[loc][j];//avoid distraction
            return min - burden[loc][j] + add4square(burden[loc][j]);
        }

        return min + burden[loc][j];
    }


    public static void main(String[] args) {
        System.out.println(dp(1));
    }
}
