package test;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c,h;
		
		a:while(sc.hasNext()) {
		String str = sc.nextLine();
		String str1 = "CCHHHHOON";
		char[] ch1 = str1.toCharArray();
		char[] ch = str.toCharArray();
        
        
        for(int i=0;i<9;i++){
            if(ch[i]!=ch1[i]){
                
                System.out.print("No\n");
                continue a;
            }
        }
		c=h=0;
		for(int i=0;i<ch.length;i++) {
			if('C'==ch[i])c++;
			if('H'==ch[i])h++;
		}
		
		if(2*(c-2)+1==(h-4))System.out.println("Yes");
		else System.out.println("No");
	}
	}

}
