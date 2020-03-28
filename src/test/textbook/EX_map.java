package test.textbook;

import java.util.ArrayList;
import java.util.Scanner;


/*

    hard to believe, this dfs reaches O(V+E) time complexity
    example:

 */
public class EX_map {

    static int n;
    static int[][] map;
    static int step;
    static ArrayList<int[][]>list;
    static int[][] direction;

    static {

        Scanner sc = new Scanner(System.in);

        n = sc.nextByte();

        map = new int[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        direction = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    }


    static void func(int x,int y){
        if (x==n && y==n){
            System.out.println(step);
            System.exit(0);
        }

        list.add(new int[x][y]);

        for (int[] dir :
                direction) {
            int x0 = x+dir[0];
            int y0 = y+dir[1];
            if (x0<0 || y0<0 || x0>n || y0>n){
                continue;
            }
            if (map[x0][y0] == 0){
                continue;
            }
            func(x0,y0);

        }
        list.remove(list.size()-1);

    }

    public static void main(String[] args) {

        func(0,0);
        System.out.println("no solution");

    }
}
