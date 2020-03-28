package test;


import java.util.Scanner;

public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//System.out.print(sc.next());
		while (sc.hasNext()) {
			String str = sc.next();
			while (true) {
				str = str.replaceAll("oo", "O");
				str = str.replaceAll("OO", "");
				if (str.replaceAll("oo", "O").equals(str) && str.replaceAll("OO", "").equals(str))
					break;
			}
			System.out.print(str);
			//sc.close();
			sc = new Scanner(System.in);
		}
		
	}
}
