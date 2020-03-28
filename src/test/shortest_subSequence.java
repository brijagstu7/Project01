package test;

import java.util.Scanner;

public class shortest_subSequence {

    static int lcs(char[] X, char[] Y, int m, int n)
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return lcs(X, Y, m-1, n-1) + 1;
        else
            return Math.max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        char[] ch1 = sc.next().toCharArray();
        char[] ch2 = sc.next().toCharArray();

        int a = lcs(ch1, ch2, ch1.length, ch2.length);

        System.out.print(a);
    }

}
