package try01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class input_array_using_queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			if(!sc.hasNextInt())break;
			queue.add(sc.nextInt());
		}
		//for-each will automatically
		//select the right sequence.
		for (int i:queue) {
			System.out.print(i);
		}
		System.out.print("\n"+queue);
	}

}
