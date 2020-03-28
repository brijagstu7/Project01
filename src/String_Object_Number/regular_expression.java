package String_Object_Number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regular_expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * In Java and JavaScript, the 
		 * grammar of regular expression is the same.
		 * 
		 * Mismatch can cause exception.
		 */
		
		
		Pattern p = Pattern.compile("[vs]..");//factory only
		Matcher m = p.matcher("vvvvvvx");
		
		System.out.println("m.matches():"+m.matches());
		//if all fits
		
		System.out.println("m.find():"+m.find());//if one fits
		
		System.out.println("m.start():"+m.start());//the index
		//of matcher string to fit the pattern
		
		System.out.println("m.group():"+m.group());
		
		Pattern p0 = Pattern.compile("[ ,.;]");
		String str[] = p0.split("this is a class, demonstrating the regular expression.");
		
		for(String s: str) {
			System.out.println(s);
		}
	}

}
