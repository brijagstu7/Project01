package String_Object_Number;


public class StringBuilderTest {
	String a = "abc";
	StringBuilder sb = new StringBuilder(a);
	StringBuffer sf = new StringBuffer(a);
	//Buffer and Builder have the same usage,
	//BUT: Buffer is synchronized, Builder not.
	//sb class returns itself.

	
	//@Test
	public void show() {
		sb.append("abcdefghijklmnopqrstuvwxyz");
		sb.reverse();

		String b = sb.toString();
		
		System.out.println(b);
		System.out.println(sb.capacity()+" "+sb.length());
	}
	public void show1() {
		sb.insert(0, "123");//insert before the offset
		a = sb.toString();
		System.out.print(a);

	}
}
