package test.purple_book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class egypt_fractions_7_7 {

    static long[] obj;
    static long[] sum;
    static long maxd;
    static int cnt;//count depth


    static ArrayList<long[]>seq;

    static {
        Scanner sc = new Scanner(System.in);

        obj = new long[2];
        obj[0] = sc.nextInt();
        obj[1] = sc.nextInt();

        sum = new long[2];
        sum[0] = 0;
        sum[1] = 1;

        seq = new ArrayList<>();
    }


    static long gcd(long b, long a){
        while (a != 0 && b != 0){
            if (a>b){
                a = a%b;
            }else {
                b = b%a;
            }
        }
        if (a == 0){
            return b;
        }else {
            return a;
        }
    }
    static long[] divide(long[] fra){

        long gcd = gcd(fra[0],fra[1]);

        fra[0] /= gcd;
        fra[1] /= gcd;

        return fra;
    }

    static long[] add(long[] a0, long[] a1){
        long[] a  =  new long[]{a0[0]*a1[1]+a0[1]*a1[0],a0[1]*a1[1]};

        return divide(a);
    }

    static long[] sub(long[] a0, long[] a1){
        long[] a  =  new long[]{a0[0]*a1[1]-a0[1]*a1[0],a0[1]*a1[1]};

        if (a[0] <0 || a[1] <0){
            throw new ArithmeticException("negative!!!!!");
        }

        return divide(a);
    }

    /**
     * heuristic function.
     *
     * Problematic.
     *
     * @param i
     * @return least depth
     */
    static strictfp double expected_length(long i){
        long[] re = add(sum,new long[]{1, i});

        //just for test.
        if (seq.size() == 2){
            if (seq.get(0)[1] == 33 && seq.get(1)[1] == 80 && i == 105){
                System.err.println("here");
            }
        }

        long[] d  = sub(obj,re);
        double s = (double)d[0]*i/d[1];

        return s;
    }


    static void func(long[] presentVal){


        long[] s,s0;//save values for sum
        cnt++;
        seq.add(presentVal);
        s = sum.clone();
        sum = add(sum,presentVal);//mark state

        for (long i = presentVal[1]+1; ; i++) {

            seq.add(new long[]{1, i});
            s0 = sum.clone();
            sum = add(sum,new long[]{1, i});//mark state




            if (Arrays.equals(sum, obj)){
                System.out.println(seq);
                System.exit(0);
            }//end program condition

            if (sum[0]*obj[1]>sum[1]*obj[0]){//sum is bigger than obj
                sum = s;
                seq.remove(seq.size()-1);//demark state
                continue;
            }//invalid state


            sum = s0;
            seq.remove(seq.size()-1);//demark state


            if (expected_length(i)<maxd-cnt) {
                if (cnt >= maxd){
                    continue;
                }

                func(new long[]{1, i});
            }else {
                break;
            }
        }//traverse next states

        sum = s;
        seq.remove(seq.size()-1);//demark state
        cnt--;

    }

    public static void main(String[] args) {
        for (maxd = 1; ; maxd++) {//maxd: max depth
            for (long i = 2; ; i++) {
                if (obj[0]*i<obj[1])continue;

                if (expected_length(i)<maxd) {
                    func(new long[]{1, i});
                }else {
                    break;
                }
            }

        }


    }
}
