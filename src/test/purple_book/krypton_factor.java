package test.purple_book;

import java.util.Scanner;

public class krypton_factor {

    static int n,L,cnt=0;
    static String chs = "0";
    static {
        Scanner sc = new Scanner(System.in);

        n  = sc.nextInt();int l0=L = sc.nextInt();
        l0-=1;
        while (l0-- != 0){//l0-1 times
            chs += (char)(chs.charAt(chs.length()-1)+1);
        }

    }


    static void backtrack(String str){
        if (++cnt == n){
            System.out.println(str);
            System.exit(0);
        }

        for (char ch :
                chs.toCharArray()) {
            if (iskry(str+ch)){
                backtrack(str+ch);
            }
        }
    }

    static boolean iskry(String str){
        int l = str.length();

        String s0,s1;
        for (int i = 1; ; i++) {
            if (l-2*i < 0)break;
            s0 = str.substring(l-2*i,l-i);
            s1 = str.substring(l-i,l);
            if (s0.equals(s1))return false;
        }
        return true;
    }

    public static void main(String args[]){
        backtrack("0");

    }
}
