package test;

import java.util.*;

public class a_simple_bfs {

    /*
        example:
        (A)
        a chess board:
        n ->dimension of board
        ...
        ... -> 1 or 0 indicating a walkable path or not


        5
        1 0 0 0 0
        1 1 1 1 0
        0 0 0 1 0
        1 1 0 1 1
        1 0 1 1 1

        (B)
        a directed graph:
        n -> dimension of the adjacent matrix, i.e. how many nodes
        ...
        ... -> 1 or 0 indicating a walkable path or not

        5
        0 1 0 0 0
        0 0 1 1 0
        1 1 0 0 0
        0 0 0 0 1
        0 0 0 0 0

        intuitively:
         _____________
        |          ___----> 2
        v         /
        0 -> 1 <--
             |
              \____
                   --> 3 ---> 4
     */

    static int n,cnt;
    static int[][] board,admat;//adjacent matrix
    
    static Queue<int[]> q4board;
    static Queue<Integer>q4graph;//the number of 
    
    static int[] start,end;
    static String past = "";
    static int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

    /**
     *
     * Returns the Euclidean distance.
     *
     * @param o1 point 1
     * @param o2 point 2
     * @return
     */
    static double distance(int[] o1,int[] o2){
        return Math.sqrt((o1[0]-o2[0])*(o1[0]-o2[0])+(o1[1]-o2[1])*(o1[1]-o2[1]));
    }

    static class comparator implements Comparator<int[]> {

        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@code sgn(compare(x, y)) ==
         * -sgn(compare(y, x))} for all {@code x} and {@code y}.  (This
         * implies that {@code compare(x, y)} must throw an exception if and only
         * if {@code compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x, y)==0}
         * implies that {@code sgn(compare(x, z))==sgn(compare(y, z))} for all
         * {@code z}.<p>
         * <p>
         * It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."<p>
         * <p>
         * In the foregoing description, the notation
         * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
         * <i>signum</i> function, which is defined to return one of {@code -1},
         * {@code 0}, or {@code 1} according to whether the value of
         * <i>expression</i> is negative, zero, or positive, respectively.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         */
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1.length != 2 || o2.length != 2){
                throw new ArithmeticException("a wrong coordinate");
            }

            if (distance(o1,end) > distance(o2,end))return 1;
            else if (distance(o1,end) < distance(o2,end))return -1;
            return 0;
        }

    }

    /**
     * static block should be modified for the board or graph.
     *
     */
    static {
        Scanner sc = new Scanner(System.in);

        comparator c = new comparator();

        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        start = new int[]{0,0};
        end = new int[]{n-1,n-1};


        q4board = new PriorityQueue<>(c);
    }

    static boolean isDup4board(int[] i){
        String s = "";
        s += i[0];
        s += i[1];
        s +=" ";

        if (past.contains(s))return true;
        return false;
    }

    static boolean isDup4graph(int i){
        if (past.contains(Integer.toString(i)))return true;
        return false;
    }

    /**
     * Writes an array.
     * @param i
     */
    static void markDup4board(int[] i){
        past += i[0];
        past += i[1];
        past += " ";
    }
    
    static void markDup4graph(int i){
        past += i;
    }

    static void bfs4board(){
        q4board.add(start);

        while (!q4board.isEmpty()){
            int[] cur = q4board.poll();

            System.out.printf("%d,%d -> ",cur[0],cur[1]);

            if (Arrays.equals(cur,end)){
                return;
            }

            cnt++;
            markDup4board(cur);

            int[] next = cur.clone();

            for (int[] direction :
                    directions) {
                next[0] += direction[0];
                next[1] += direction[1];

                if (next[0] < 0 || next[0] >=n || next[1] <0 || next[1] >= n){
                    next = cur.clone();
                    continue;
                }
                if (isDup4board(next)){
                    next = cur.clone();
                    continue;
                }
                if (board[next[0]][next[1]] == 0){
                    next = cur.clone();
                    continue;
                }

                q4board.add(next);
                next = cur.clone();
            }
        }
    }

    /**
     * I didn't debug.
     */
    static void bfs4graph(){
        q4graph.add(0);//from the first node
        
        while (!q4graph.isEmpty()){
            int cur = q4graph.poll();

            System.out.printf("%d -> ",cur);

            if (cur == n){
                return;
            }

            cnt++;
            markDup4graph(cur);

            for (int i :
                    admat[cur]) {
                if (i == 0){
                    continue;
                }
                if (isDup4graph(i)){
                    continue;
                }
                q4graph.add(i);
            }
        }
        
        
    }



    public static void main(String[] args) {
        System.out.println("path below:");

        bfs4board();

        System.out.println("count: "+cnt);

    }
}
