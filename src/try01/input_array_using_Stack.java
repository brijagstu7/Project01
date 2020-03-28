package try01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class input_array_using_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack1 = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			if(!sc.hasNextInt())break;
			stack1.push(sc.nextInt());
		}
		for(int i:stack1) {
			System.out.print(i);
		}
		System.out.print("\n"+stack1);
	}

}
