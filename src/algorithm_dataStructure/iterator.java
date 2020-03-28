package algorithm_dataStructure;

import java.util.Iterator;
import java.util.Stack;

public class iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		Iterator<Integer> i = stack.iterator();

		//WARNING : iterators cannot go back

		while(i.hasNext()) {
			//next returns current object.
			System.out.print(i.next());
		}
	}

}
