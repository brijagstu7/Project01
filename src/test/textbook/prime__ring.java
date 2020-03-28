package test.textbook;


import java.util.Scanner;

/**
 * add offset to avoid returning to the bad old track
 *
 * this is version without for-recurse traverse
 */
public class prime__ring {

    static int n,offset;
    //resource number array is always 1,2,3,...,n

    static int []answer;

    /**
     * pure prime checking
     * @param i index , not number
     * @param number the number at i to test
     * @return
     */
    static boolean isOK(int i,int number){
        if (i == 0)return true;

        if (i == n-1){
            if (isPrime(number+answer[i-1]) && isPrime(number+answer[0])){
                return true;
            }else return false;
        }
        if (isPrime(number+answer[i-1]))return true;

        return false;
    }

    /**
     *  try number from offset+1 to n
     * @return the number to put at position i, -1 when fails
     */
    static int isOK(int index){
        for (int i = offset+1; i <= n; i++) {
            if (!isdup(i)){
                if (isOK(index,i))return i;
            }
        }
        return -1;
    }

    static boolean isdup(int num){
        for (int i = 0; i < answer.length; i++) {
            if (num == answer[i])return true;
        }
        return false;
    }

    static boolean isPrime(int n){

        if (n%2 == 0)return false;

        for (int i = 3; i*i <= n; i+=2) {
            if (n%i == 0)return false;
        }
        return true;
    }

    static {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        answer = new int[n];
    }
    public static void main(String args[]){

        for (int i = 0; i < n; i++) {
            int t;
            if ((t=isOK(i))>0) {
                answer[i] = t;
                offset = 0;
            }
            else {

                offset = answer[i-1];
                answer[i-1] = 0;

                i -= 2;
            }
        }

        int t = 0;
        while (t != answer.length) {
            System.out.print(answer[t++]+" ");
        }
        System.out.println();
    }
}
