package test.purple_book;

import java.util.Scanner;

public class palindrome_partition {
    static String str;
    static int n;
    static {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        n = str.length();
    }


    static boolean isPalin(int offset, int rear){
        if (offset > rear)return false;

        while (offset <= rear){
            if (str.charAt(offset) != str.charAt(rear)){
                return false;
            }
            offset++;
            rear--;
        }
        return true;
    }

    public static void main(String[] args) {
        int longest;
        for (int offset = 0; offset < n; offset++) {
            longest = 0;
            for (int rear = 0; rear < n; rear++) {
                if (offset >= rear)continue;

                if (isPalin(offset,rear)){
                    if (rear - offset > longest){
                        longest = rear - offset;
                    }
                }
            }
            System.out.println(str.substring(offset,offset + longest + 1));
            offset += (longest);
        }
    }
}
