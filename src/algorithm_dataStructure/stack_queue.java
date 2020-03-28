package algorithm_dataStructure;

import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stack_queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push(12);
		stack1.add(1);
		int i = stack1.pop();
		System.out.println(stack1.contains(1));
		
		
		Queue<String> queue = new LinkedList<String>();
		//Queue is an interface, instantiation limited
		
		//Queue q = new AbstractQueue();
	}

}
