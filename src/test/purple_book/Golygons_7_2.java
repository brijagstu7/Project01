package test.purple_book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Golygons_7_2 {

    static final int N=0,E=1,W=2,S=3;
    static final String DIREC= "NEWS";

    static ArrayList<Integer>poses = new ArrayList<>(100);
    static int n,k;
    static int[][] blocks;

    static Stack<Character>stack = new Stack<>();

    static {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int k0 = k = sc.nextInt();
        blocks = new int[k][2];

        while (k0-- != 0){
            blocks[k0][0] = sc.nextInt();
            blocks[k0][1] = sc.nextInt();
        }
    }

    static boolean isBlocked(int[] coord){
        for (int[]c:
             blocks) {
            if (Arrays.equals(c,coord))return true;
        }
        return false;
    }

    /**
     *
     * @param coord
     * @param step at which step. at step 20, there are things to do still.
     * @param direction
     */
    static void func(int[] coord, int step, int direction){
        if (coord[0] == 0 && coord[1] == 0 && step!=1){
            int i = 0;
            while (i<stack.size())
                System.out.print(stack.elementAt(i++)+" ");
            System.out.println(poses);
            return;
        }
        if (step>n)return;
        if (step==n-1){//heuristic
            if (direction == E || direction == W){
                if (step!=Math.abs(coord[1]) || step+1!=Math.abs(coord[0]))return;
            }else {
                if (step!=Math.abs(coord[0]) || step+1!=Math.abs(coord[1]))return;
            }
        }

        if (isBlocked(coord))return;

        stack.push(DIREC.charAt(direction));
        poses.add(coord[0]);
        poses.add(coord[1]);

        if (direction == E || direction == W) {
            int[] newCoord0 = new int[]{coord[0],coord[1]+step};
            int[] newCoord1 = new int[]{coord[0],coord[1]-step};

            func(newCoord0,step+1,N);
            func(newCoord1,step+1,S);
        }else {
            int[] newCoord0 = new int[]{coord[0]+step,coord[1]};
            int[] newCoord1 = new int[]{coord[0]-step,coord[1]};

            func(newCoord0,step+1,E);
            func(newCoord1,step+1,W);
        }

        stack.pop();
        poses.remove(poses.size()-1);
        poses.remove(poses.size()-1);
    }

    public static void main(String[] args) {

        func(new int[]{0,0},1,N);
        func(new int[]{0,0},1,E);
        func(new int[]{0,0},1,W);
        func(new int[]{0,0},1,S);
    }
}
