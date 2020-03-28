package test.ccf.May_2019;

import java.util.Scanner;


public class test2 {

	
	static String str;
	static int n;
	static Scanner scanner;
	static{
		scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
	}
	
	static boolean isFirstClass(char ch){
		return ch == '+' || ch == '-';
	}
	
	static int binaryExec(int optrSe, int opndSe, int ... lr){
		char[] ch = str.toCharArray();
		int index = 2* optrSe +1;
		int i = 2* opndSe;
		
		int re = 0;
		
		int left = 0,right = 0;
		if(lr.length == 1){
			left = lr[0];
			right = ch[i]-'0';
		}else {
			left = lr[0];
			right = lr[1];
		}
		
		switch (ch[index]) {
		case '+':
			re = right+left;
			break;
			
		case '-':
			re = left-right;
			break;
		case '*':
			re = right*left;
			break;
			
		case '/':
			re = left/right;
			break;
		default:
			break;
		}
		
		return re;
	}
	
	static int exec(int state){
		
		char[] ch = str.toCharArray();
		int re = 0;
		
		switch (state) {
		case 0:
			re = binaryExec(0, 1, ch[0]-'0');
			re = binaryExec(1, 2, re);
			re = binaryExec(2, 3, re);
			break;
		case 1:
			re = binaryExec(0, 1, ch[0]-'0');
			re = binaryExec(1, 2, re);
			re = binaryExec(2, 3, re);
			break;
		case 2:
			re = binaryExec(1, 2, ch[2]-'0');
			re = binaryExec(0, 1, ch[0]-'0', re);
			re = binaryExec(2, 3, re);
			break;
		case 3:
			re = binaryExec(2, 3, ch[4]-'0');
			re = binaryExec(1, 2, ch[2]-'0',re);
			re = binaryExec(0, 1, ch[0]-'0',re);
			
			break;
			
		case 4 :
			re = binaryExec(0, 1, ch[0]-'0');
			re = binaryExec(1, 2, re);
			re = binaryExec(2, 3, re);
			break;
			
			case 5:
				
				re = binaryExec(0, 1, ch[0]-'0');
				int re2;
				re2 = binaryExec(2, 3, ch[4]-'0');
				re = binaryExec(1, 2, re, re2);
				break;
			case 6:
				re = binaryExec(2, 3, ch[4]-'0');
				re = binaryExec(1, 2, ch[2]-'0',re);
				re = binaryExec(0, 1, ch[0]-'0',re);
				break;
			case 7:
				re = binaryExec(0, 1, ch[0]-'0');
				re = binaryExec(1, 2, re);
				re = binaryExec(2, 3, re);
				break;

		
		}
		
		return re;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		for (int i = 0; i < n; i++) {
			str = scanner.next();
			char[] ch = str.toCharArray();
			
			boolean one = isFirstClass(ch[1]),
			two = isFirstClass(ch[3]),
			three = isFirstClass(ch[5]);
			
			int result = 0;
			
			if(one && two && three){
				result = exec(0);
			}else if (!one && !two && ! three) {
				result = exec(7);
			}else if (!one && two && three) {
				result = exec(1);
			}else if (one && !two && three) {
				result = exec(2);
			}else if (one && two && !three) {
				result = exec(3);
			}else if (!one && !two && three) {
				result = exec(4);
			}else if (!one && two && !three) {
				result = exec(5);
			}else if (one && !two && !three) {
				result = exec(6);
			}
			
			System.out.println(result == 24? "Yes":"No");
		}
	}
}
