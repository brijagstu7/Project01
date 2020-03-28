package String_Object_Number;


public class Char_Unicode {
	public void test() {
		Character ch = 'a';
		//fucking weird: the result is not related to
		//the object itself.
		System.out.println(Character.isAlphabetic(ch));
	}
}
