package test.purple_book;

import java.util.ArrayList;
import java.util.Scanner;


/*
    example:
    5 3
    1 2 2 3 4 5
 */
public class cutting_rings_7_4 {

    static int n;
    static ArrayList<int[]>initRings;
    static int count;

    static {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int seq;
        seq = sc.nextInt();

        initRings = new ArrayList<>();
        while (seq-- != 0){
            initRings.add(new int[]{sc.nextInt(),sc.nextInt()});
        }


    }

    static boolean checkRings(int[] r0, int[] r1){
        for (int i :
                r0) {
            for (int j :
                    r1) {
                if (i == j) {
                    return true;
                }
            }
        }
        return false;
    }



    static void generateRinged(){

        for (int i = 0; i < initRings.size(); ) {
            int[] i1 = null,i2 = null;
            ArrayList<int[]>bag = new ArrayList<>();
            bag.add(initRings.get(i));
            for (int j = i+1; j < initRings.size(); j++) {
                //i1 ----  i2 ~~~~~
                if (checkRings((i1 = initRings.get(i)),(i2 = initRings.get(j)))){
                    bag.add(i2);
                }
            }



            /*
            int[][] t = (int[][])bag.toArray();
            int[] t1 = new int[t.length*t[0].length];
            //fillform t1 with a flattened t


            for (int j = 0; j < t.length; j++) {
                for (int k = 0; k < t[0].length; k++) {
                    t1[j*t[0].length+k] = t[j][k];
                }
            }

            //setRings(t1);

            */


            //delete to free memory
            for (int[] ar :
                    bag) {
                initRings.remove(ar);
            }

            count++;
        }
    }



    public static void main(String[] args) {
        generateRinged();
        System.out.println(count-1);
    }
}
