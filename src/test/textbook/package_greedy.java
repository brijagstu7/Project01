package test.textbook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
    input rules:
    [n]
    [volume]
    [w_v[][0]],..
    [w_v[][1]],..
 */

public class package_greedy {

    /**
     * First time to use comparator.
     * It determines the way of comparing.
     */
    static class comparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if ((double)o1[1]/o1[0] < (double)o2[1]/o2[0]){
                return -1;
            }else if((double)o1[1]/o1[0] == (double)o2[1]/o2[0]){
                return 0;
            }
            return 1;
        }
    }

    static int w_v[][];
    static int n;//number of things; dimension of w and v
    static int volume;

    static {
        Scanner sc = new Scanner(System.in);

        int n0 = n = sc.nextInt();
        volume = sc.nextByte();

        w_v = new int[n][2];


        while (n0-- != 0){
            w_v[n-n0-1][0] = sc.nextInt();

        }
        n0 = n;
        while (n0-- != 0){
            w_v[n-n0-1][1] = sc.nextInt();

        }


        //next are the averages.

        Arrays.sort(w_v,new comparator());

    }



    public static void main(String args[]){
        double value = 0;

        /*
            w_v[i][0]: burden
            w_v[i][1]: value
         */
        for (int i = w_v.length-1; i >=0; i--) {
            if (volume <w_v[i][0] && volume !=0){
                value += (double)w_v[i][1]/w_v[i][0]*volume;
                break;
            }
            volume -= w_v[i][0];
            value += w_v[i][1];
        }

        System.out.println("final value:"+value);
    }
}
