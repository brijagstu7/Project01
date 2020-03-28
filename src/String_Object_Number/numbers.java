package String_Object_Number;

public class numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number a = 12;
		Number b = 12.3;
		//equivalent to new Number(12)
		System.out.println(a.getClass().getName()
				+"\n"+b.getClass().getName());
		//int c = a; this won't compile.
		//a is an object.
		int c = a.intValue();
		System.out.print(c);
		
		Integer i = 10;//auto-boxing
		int j = i;//auto-unboxing
		
		int d = (int) ((Integer)a + (Double)b);
		//d is 24.3. Java do the autoboxing job.
		//a.intValue is auto-added.
	}

}
