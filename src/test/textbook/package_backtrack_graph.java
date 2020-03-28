package test.textbook;

import java.util.ArrayList;
import java.util.Scanner;
/*
    the example:
    6 20
5 3 2 10 4 2
11 8 15 18 12 6
 */
public class package_backtrack_graph {

    static int n,W,curW,curV;
    static int w[],v[];
    static ArrayList<Integer>pack = new ArrayList<>();
    static {
        Scanner sc = new Scanner(System.in);

        int n0 = n = sc.nextInt();W = sc.nextInt();

        w = new int[n];v = new int[n];
        while (n0-- != 0){
            w[n-n0-1] = sc.nextInt();
        }
        n0 = n;
        while (n0-- != 0){
            v[n-n0-1] = sc.nextInt();
        }
    }

    static void print(){
        for (int i = 0; i < pack.size()-1; i++) {
            System.out.print(pack.get(i)+" -> ");
        }
        System.out.print(pack.get(pack.size()-1));
        System.out.println(" value:"+curV);
    }

    /**
     *
     * @param index how far the search goes: current thing to check
     */
    static void search(int index){
        if (index == n-1){
            print();
            return;
        }

        for (int i = index+1; i < n; i++) {
            ArrayList ta = new ArrayList(pack);
            int tc = curV;
            int tw = curW;
            if (curW + w[i] <= W) {
                curW += w[i];
                pack.add(i);
                curV += v[i];
                search(i);
            }
            pack = ta;
            curV = tc;
            curW = tw;
        }
    }

    public static void main(String args[]){
        search(-1);
    }
}
