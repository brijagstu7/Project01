package test.purple_book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
    example:
    3
6 3 1
6 0 0
4

IN this test , we demonstrate how to get a T[] from ArrayList<T>:
you have to specify a T[] first.
 */
public class pour_water {
    
    static int n;//dimension of state array
    static int volumns[] = null;
    static int curState[] = null;
    static int targetState[] = null;
    static ArrayList<int[]> statess = null;
    static int cnt;//counter
    static int targetNum;
    
    static {
        Scanner sc = new Scanner(System.in);
        
        int n0 = n = sc.nextInt();
        
        volumns = new int[n];
        curState = new int[n];
        targetState = new int[n];
        statess = new ArrayList<>();


        while (n0-- != 0){
            volumns[n0] = sc.nextInt();
        }
        n0 = n;
        while (n0-- != 0){
            curState[n0] = sc.nextInt();
        }
        /*
        while (n0-- != 0){
            targetState[n0] = sc.nextInt();
        }
        */
        targetNum = sc.nextInt();

    }
    
    static int[][] getStates(int[] state){

        ArrayList<int[]>tstates = new ArrayList<>();

        int[] temp;
        //pour j to i
        for (int i = 0; i < n; i++) {//
            for (int j = 0; j < n; j++) {//->0
                if (i==j || state[j]==0)continue;


                temp = state.clone();

                if (state[j]>=volumns[i]-state[i]) {
                    temp[i] = volumns[i];
                    temp[j] -= volumns[i]-state[i];
                }else {
                    temp[i] += state[j];
                    temp[j] = 0;
                }

                tstates.add(temp);
            }
        }
        int[][] t = new int[tstates.size()][n];
        return tstates.toArray(t);

    }

    static boolean isDup(int[] state){
        for (int[] t :
                statess) {
            if (Arrays.equals(t, state)) {
                return true;
            }
        }
        return false;
    }

    static boolean isOK(int[] state){
        for (int i :
                state) {
            if (i == targetNum) {
                return true;
            }
        }
        return false;
    }
    
    static void func(int[] state){
        
        if (isDup(state))return;
        
        if (/*Arrays.equals(state,targetState)*/isOK(state)){
            //give the amount of water poured
            System.out.println("counter:"+cnt);
            //give the times of moves
            
            //give the state path
            for (int[] i :
                    statess) {
                for (int j :
                        i) {
                    System.out.print(j+" ");
                }
                System.out.println();
            }
            //end
            System.exit(0);
        }

        cnt++;
        statess.add(state);
        
        int[][] states = getStates(state);
        for (int[] s :
                states) {
            func(s);
        }
        
        
    }
    
    public static void main(String args[]){
        
        func(curState);

        System.out.println("no, cannot solve");
    }
    
    
}
