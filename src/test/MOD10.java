package test;

import java.util.Scanner;

public class MOD10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a+b==0)return;
			int cnt = 0;
			String str = null;
			
			for(Integer i = a;i<=b;i++) {
				str = i.toString();
				if(str.contains("4")||str.contains("38"))
					cnt++;
			}
			System.out.print(cnt);
		}
		sc.close();
	}
}
