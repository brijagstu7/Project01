package test.purple_book;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
    input:
    n
    [next nodes of 0th node]
    [next nodes of 1th node]
    [next nodes of 2th node]
    ...
    [next nodes of (n-1)th node]

    example:
    10
    ! 2 3
    ! 1 3 4
    ! 1 2 4 5
    ! 2 3
    ! 3 6
    ! 5 7
    ! 6 8
    ! 7 9 10
    ! 8
    ! 8
 */
public class firetruck_7_1 {

    static int n;
    static ArrayList<ArrayList<Integer>> nextNodes;
    static boolean[] isWalked;
    static Stack<Integer>stack = new Stack<>();

    static {
        Scanner sc = new Scanner(System.in);
        int n0 = n = sc.nextInt();

        nextNodes = new ArrayList<>();
        isWalked = new boolean[n];

        sc.next();
        while (n0-- != 0){
            nextNodes.add(new ArrayList<>(){
                {
                    String s;

                    while (!(s = sc.next()).equals("!")){
                        add(Integer.parseInt(s)-1);
                    }
                }
            });
        }
    }

    static void func(int index){
        if (index == 9){
            int i = 0;
            while (i<stack.size())
                System.out.print(stack.elementAt(i++)+1);
            System.out.println("0");//if we use 0 to indicate 10
            return;
        }
        isWalked[index] = true;
        stack.push(index);
        for (int i :
                nextNodes.get(index)) {
            if (isWalked[i])continue;
            func(i);
        }
        isWalked[index] = false;
        stack.pop();
    }
    public static void main(String[] args) {
        func(0);
    }
}
