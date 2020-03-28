package String_Object_Number;

import java.util.StringTokenizer;

public class stringTokenizer {
//this method : divide a string into several groups
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "I want to f**k";
		StringTokenizer st = new StringTokenizer(str);
		//default: space,tab,LF are tokens
		while(st.hasMoreElements())
			System.out.println(st.nextToken());
		
		str = "date: 2018/1/23";
		st = new StringTokenizer(str);
		//also available if using the constructor 
		//StringTokenizer(String str, String delimiter)
		while(st.hasMoreElements())
			System.out.println(st.nextToken(":").trim());
		
	}

}
