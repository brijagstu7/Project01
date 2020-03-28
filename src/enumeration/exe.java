package enumeration;

public class exe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		letters l = letters.a;
		//enum is like a static class when assigning.
		//but it cannot be instantiated.
		//all instantiations are vars in it itself.

		System.out.println(l);
		
		//this class contains 2 methods.
		//one is values.
		for(letters i:letters.values()) {
			System.out.print(i+" ");
		}
		//the other is valueOf.shit useless.
		System.out.println("\n"+letters.valueOf("a"));
		//followings are methods for enum objects
		System.out.printf("%d,%d",letters.a1.ordinal(),
				letters.a.compareTo(letters.b));
		//compareTo means the ordinal of a minus that 
		//of b.
		//also equals is available. use same as strings.
	}

}
