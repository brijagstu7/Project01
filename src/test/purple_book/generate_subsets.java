package test.purple_book;

import java.util.Scanner;

/**
 * not ended.
 * THIS IS A WRONG ANSWER.
 */
public class generate_subsets {

    static int n;
    static int [] arr;

    static boolean isDupd(int num, int []ar){
        int t = 0;
        while (t!=ar.length){
            if (num == ar[t++])return true;

        }
        return false;
    }

    static void func(int index, int ar[]){
        if (index == ar.length){
            int t = 0;
            while (t != ar.length){
                System.out.print(ar[t]);
                t++;
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isDupd(arr[i],ar)) {
                ar[index] = arr[i];
                func(index + 1, ar);
            }
        }
    }
    static {
        Scanner sc = new Scanner(System.in);

        int n0 = n = sc.nextInt();
        arr = new int[n];
        while (n0-- != 0){
            arr[n-n0-1] = sc.nextInt();
        }
    }

    public static void main(String args[]){

        for (int i = 1; i <= n; i++) {
            int ar[] = new int[i];
            func(0,ar);
        }

    }
}
