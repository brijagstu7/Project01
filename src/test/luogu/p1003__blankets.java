package test.luogu;

import java.util.ArrayList;
import java.util.Scanner;

public class p1003__blankets {

    static class blanket{
        int x;
        int y;

        int width;
        int height;

        public blanket(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public blanket() {
        }
    }

    static int n;
    static ArrayList<blanket> blankets = new ArrayList<>();

    static boolean onBlanketQ(blanket b, int x0, int y0){

        if (x0>=b.x && x0 <= b.x+b.width && y0 >= b.y && y0 <= b.y+b.height){
            return true;
        }

        return false;
    }



    public static void main(String[] args){
        //initialize
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        while (n-- != 0){
            blankets.add(new blanket(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));


        }

        int x0 = sc.nextInt(),y0 = sc.nextInt();

        for (int i = 1; i <= blankets.size(); i++) {

            int index = blankets.size() - i;//reverse search

            if (onBlanketQ(blankets.get(index),x0,y0)){
                System.out.println(index+1);
                return;
            }

        }
        System.out.println("-1");
    }
}
