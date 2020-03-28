package algorithm_dataStructure;

import java.util.LinkedList;

public class Linkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2, 3);
		list.remove();//remove by default the first
		list.remove(1);
		for(int i:list) {
			System.out.print(i);
		}
		
		System.out.print("\n"+list);
		
		
	}

}
