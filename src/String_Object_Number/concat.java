package String_Object_Number;

public class concat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1234567";
		str += "89";
		System.out.println(str);
		//for the reason that all strings are final
		//all String methods don't modify this. 
		str = str.concat("0");
		System.out.println(str);
		
		str = str.replace('8', 'e');
		System.out.println(str);
		
		System.out.println(str.contains("12"));
		
		
	}

}
