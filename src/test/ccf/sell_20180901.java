package test.ccf;

import java.util.Scanner;

public class sell_20180901 {




    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int n0=0;
        int arr[] = new int[n];
        while (n0 != n){
            arr[n0] = sc.nextInt();
            n0++;
        }


        System.out.print((arr[1]+arr[0])/2+" ");
        n0=0;
        while (++n0 != n-1){
            System.out.print((arr[n0-1]+arr[n0]+arr[n0+1])/3+" ");
        }
        System.out.println((arr[n-1]+arr[n-2])/2);
    }
}
