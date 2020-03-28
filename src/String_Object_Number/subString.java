package String_Object_Number;

public class subString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "610402200007072715";
		//what can i do to get my birthday?
		String birthM = id.substring(10, 12);
		//                        id[10] id[12]
		String birthD = id.substring(12, 14);
		//first char is included, not the last one
		System.out.println("Month:"+birthM+" Day:"+birthD);
		
		//to get my gender:
		String gender = id.substring(id.length()-1);
		gender = (Integer.parseInt(gender) % 2 != 0)?"Male":"Female";
		System.out.print(gender);
		
		//sc.next auto-trim the string. 
		//trim means delete spaces or tabs before
		//or after the real words.
	}

}
