package test.textbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/*
    p189,3
    example:
    6 20
    5 3 2 10 4 2
    11 8 15 18 12 6

    target : which burden's thing has been taken




    to learn from this test is not advisable
 */

public class package_A_star {

    static int w_v[][];
    static int n,n0;
    static int v,volume;
    static int flag_index;
    static ArrayList<Integer>weight_list = new ArrayList<>();

    static Scanner sc;

    static int[] target;
    static int how_many_targets;

    static {
        sc = new Scanner(System.in);
        int n0 = n = sc.nextInt();
        v = volume = sc.nextByte();

        w_v = new int[n][2];


        while (n0-- != 0){
            w_v[n-n0-1][0] = sc.nextInt();

        }
        n0 = n;
        while (n0-- != 0){
            w_v[n-n0-1][1] = sc.nextInt();

        }

        n0 = how_many_targets = sc.nextInt();
        if(n0 != 0) {
            target = new int[how_many_targets];
            int r = target.length;
            while (n0-- != 0) {
                target[r - n0 - 1] = sc.nextInt();
            }
        }

        Comparator c = new comparator();
        Arrays.sort(w_v,c);
    }

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

    /**
     *
     * @return the initial value account
     */
    static int setForTarget(){
        int re = 0;
        if (how_many_targets == 0) {
            flag_index = 1<<7;
            return 0;
        }
        for (int b :
                target) {
            for (int i = w_v.length-1; i >=0; i--) {
                if (w_v[i][0]==b){
                    //clearance
                    volume-=b;
                    re += w_v[i][1];
                    flag_index = i;//the one to omit


                }
            }
        }
        return re;
    }

    public static void main(String args[]){

        while(true) {
            int value = setForTarget();



        /*
            w_v[i][0]: burden
            w_v[i][1]: value
         */
            for (int i = w_v.length - 1; i >= 0; i--) {
                if (volume == 0) {
                    break;
                }
                if (volume < w_v[i][0]) {
                    continue;
                }
                if (i == flag_index){
                    continue;
                }
                weight_list.add(w_v[i][0]);
                volume -= w_v[i][0];
                value += w_v[i][1];
            }


            System.out.println(value+" "+weight_list.toString());
            weight_list.clear();

            n0 = how_many_targets = sc.nextInt();
            if (n0 != 0) {
                target = new int[how_many_targets];
                int r = target.length;
                while (n0-- != 0) {
                    target[r - n0 - 1] = sc.nextInt();
                }
            }
            volume = v;

            int initval =  0;
            for (int i = 0; i < target.length; i++) {
                for (int j = 0; j < n; j++) {
                    if (target[i] == w_v[j][0]){
                        initval += w_v[j][1];
                    }
                }
            }
            System.out.println(initval);
        }

    }
}
