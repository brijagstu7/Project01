package test.purple_book;

import java.util.*;


/**
 * the BFS includes several things:
 * 1.   map, or something as a field
 * 2.   queue, or something else works as queues
 * 3.   the current state and next state(working for the iteration of queue)
 * 4.   definition of duplication and the examination
 * 5.   back track after a duplication has been spotted
 * 6.   definition of the distance and its iteration
 */

/*
    THIS IS UNFINISHED.
    NOT CORRECT.


    example:
    3
2 6 4 1 3 7 0 5 8
8 1 5 7 3 6 4 0 2

3
1 2 3 4 5 6 0 8 9
1 2 3 4 0 6 8 5 9
 */

/*
    NOTICE:    for 2d arrays, clone() or Arrays.copyOf can Not make an exact copy, but a same reference
 */


public class move_squares {

    static ArrayList<int[][]> stat;
    static ArrayList<Integer> dist;//state, distance
    static int n;

    final static int x = 0, y = 1;

    static int [][] map,dest,to;
    static int[] now,next;

    static Queue<int[]> q = new LinkedList<>();

    static {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        now = new int[3];next = new int[3];



        map = new int[n][n];
        dest = new int[n][n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(0==(map[i][j] = sc.nextInt())){
                    index = n*i+j;
                }
            }
        }
        now[x] = index/3;
        now[y] = index%3;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dest[i][j] = sc.nextInt();
            }
        }

        to = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        q.add(now);
        stat = new ArrayList<>();
        dist = new ArrayList<>();

        stat.add(map);


    }

    /**
     *  a version without hash function
     * @return whether duplicated
     */
    static boolean isDup(int [][] t){
        for (int [][] t0:
             stat) {
            for (int i = 0; i < n; i++) {
                if (!Arrays.equals(t[i],t0[i])){
                    return false;
                }
            }
            return true;

        }
        return true;
    }


    static int[][] get_new_state(int[][] t){

        int[][] t0 = new int[n][n];


        //extreme caution!
        for (int i = 0; i < n; i++) {
            t0[i] = t[i].clone();
        }


        int tmp = t0[next[x]][next[y]];
        t0[next[x]][next[y]] = t0[now[x]][now[y]];
        t0[now[x]][now[y]] = tmp;
        //exchange values, making a new state

        //stat.add(t);
        return t0;
    }

    static boolean checkRecent(){

        boolean flag = true;

        for (int i = 1; i < 4; i++) {

            if (stat.size()-i < 0)break;

            flag = true;

            for (int j = 0; j < n; j++) {
                if (!Arrays.equals(stat.get(stat.size()-i)[j],dest[j])){
                    flag = false;
                    break;
                }
            }

            if (flag)return true;
        }


        return flag;
    }

    public static void main(String args[]){

        int step = 1;

        dist.add(0);
        while (!q.isEmpty()){
            now = q.poll();

            if (checkRecent()){
                System.out.println(dist.get(dist.size()-1));
                System.exit(0);
            }


            int [][] lastStat = stat.get(step-1);
            for (int i = 0; i < 4; i++) {//now must be the coordinate for '0'
                next[x] = now[x]+to[i][x];
                next[y] = now[y]+to[i][y];

                if (next[x] < 0 || next[y] < 0 || next[x] >= n || next[y] >= n){
                    continue;
                }
                int [][] newStat;
                newStat = get_new_state(lastStat);
                if (isDup(newStat)){
                    continue;
                }


                //...something to indicate a distance increment
                dist.add(step);

                //...something to cause interface to duplicity :
                stat.add(newStat);

                q.add(next.clone());


            }
            step++;
        }

    }
}
