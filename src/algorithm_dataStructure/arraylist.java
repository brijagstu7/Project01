package algorithm_dataStructure;

import java.util.ArrayList;

//an arraylist is an array with dynamic capacity
public class arraylist {
/*
 * ArrayList implements List and it allows index
 * and duplicated elements.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Character> a = new ArrayList<Character>();
		/*ensureCapacity means manually declare
		capacity 'cause it takes time to change
		capacity.
		*/
		a.ensureCapacity(10);
		
		a.add('1');
		a.add('g');
		
		a.trimToSize();//free unused capacity
		
		for(Object i:a) {
			System.out.println(i);
		}
		
		Character[] ch = new Character[2];
		ch = a.toArray(ch);
	}

}
