package test.textbook;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*
    drawback:  time consuming unbearably when dimension > 17
 */
public class n_queens {

    static int chessboard[][];
    static int dim;//dimension of chessboard
    static int cnt;

    static {
        File f = new File("/Users/yang_sijie/eclipse-workspace/Project01/src/test/textbook/example");
        Scanner sc = null;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        dim = sc.nextInt();
        chessboard = new int[dim][dim];
        cnt = 0;
    }

    static void printout(){
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (chessboard[i][j] == 1){
                    System.out.print("{"+i+","+j+"},");
                }
            }
        }
    }

    /**
     *
     * @param x
     * @param y
     * @return true if failed
     */
    static boolean fail0(int x, int y){
        for (int i = 0; i < dim; i++) {
            if (chessboard[x][i] == 1)return true;

        }
        return false;
    }

    static boolean fail1(int x, int y){
        for (int i = 0; i < dim; i++) {
            if (chessboard[i][y] == 1)return true;

        }
        return false;
    }

    /**
     *
     * @param x
     * @param y
     * @return true if out of range
     */
    static boolean outofrange(int x, int y){
        if (x<0||x>=dim||y<0||y>=dim)return true;
        return false;
    }
    static boolean fail2(int x, int y){
        for (int i = -dim; i< dim; i++) {
            if (outofrange(x+i,y+i)){
                continue;
            }
            if (chessboard[x+i][y+i] == 1)return true;


        }
        for (int i = -dim; i< dim; i++) {


            if (outofrange(x-i,y+i)){
                continue;
            }
            if (chessboard[x-i][y+i] == 1)return true;
        }
        return false;
    }
    /**
     *
     * @param x
     * @param y
     * @return  true if failed to put
     */
    static boolean fail(int x, int y){
        if (fail0(x,y) || fail1(x,y) || fail2(x,y))return true;
        return false;
    }

    /**
     *
     * This is the version that I wrote.
     * @param x row
     * @param y column
     * @return false if cannot put any queen since (x,y)
     */
    static boolean putQueen(int x, int y){
        if (cnt == dim) {
            printout();
            System.exit(0);
        }

        if (x>=dim || y>=dim){
            return false;
        }

        if (fail(x,y)){

            if (x == dim-1 && y == dim-1){
                return false;
            }

            if (y == dim-1){
                if(putQueen(x+1,0)){
                    return true;
                }
            }else {
                if(putQueen(x, y+1)){
                    return true;
                }
            }
        }else {

            chessboard[x][y] = 1;
            cnt++;

            if (x == dim-1 && y == dim-1){
                if (cnt == dim)
                return true;
                else return false;
            }
                if(!putQueen(x+1,0)){
                    chessboard[x][y] = 0;
                    cnt--;
                    return putQueen(x+1,0);
                }

        }
        return false;
    }


    public static void main(String args[]){
/*
        for (int i = 0; i < dim; i++) {
            if (putQueen(0, i))break;
        }

*/
        putQueen(0);

        printout();
    }

    /**
     * This is from purple book
     * @param row
     */
    static void putQueen(int row){
        if (row == dim){
            printout();
            System.out.println();
            System.exit(0); // add this if you just want one
        }else for (int column = 0; column < dim; column++) {


            if (!fail(row,column)){
                chessboard[row][column] = 1;
                putQueen(row+1);
            }

            //if we are still here, the column arrangement is failed
            chessboard[row][column] = 0;
        }
    }



}
