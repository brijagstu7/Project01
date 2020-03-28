package test.ccf.May_2019;
import java.util.ArrayList;
import java.util.Scanner;


/*
	Anywhere with the notation  ╮(╯▽╰)╭  is the place where I omitted in the exam and now have updated.
 */

public class test3 {

	
	static int n,s,l,m, row;
	
	static int read[];
	
	static ArrayList<ArrayList<String> > list = new ArrayList<ArrayList<String> >();
	
	static{
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
		s = scanner.nextInt();
		l = scanner.nextInt();
		
		int index = 0;
		
		for (int i = 0; i < l; i++){
			list.add(new ArrayList<String>());
		}
		
		for (int i = 0; i < l; i++) {
			index = scanner.nextInt();
			String string = scanner.next();
			
			
			for (int j = 0; j+7 < string.length(); j+=8) {
				list.get(index).add(string.substring(j,j+8));
			}
		}
		
		m = scanner.nextInt();
		read = new int[m];
		for (int i = 0; i < m; i++) {
			read[i] = scanner.nextInt();
		}

		row = list.get(0).size();
	}
	
	static boolean isP(int x, int y){
		return y%n +x == n;
	}

	static int[] getPos(int m){
		int[] pos = {0,0};//row, column


		for (int i = 0; i < m; i++) {
			//turn right or down

			//turn down
			if(pos[1] == n-1){
				if(isP(pos[0]+1, 0)){
					pos[0]++;
					pos[1] = 1;
				}else {
					pos[0]++;
					pos[1] = 0;
				}
			}else {
				if(isP(pos[0], pos[1]+1)){
					pos[0]++;

				}else {
					//turn right
					pos[1] ++;
				}

			}



		}

		return pos;
	}



	static String FindBlock(int m){
		//if(n>s)return null;
		
		String ptr;
		
		int[] pos = getPos(m);

		int blocksPerRow = s*(n-1);

		int currentLeastRow = m / blocksPerRow;

		int strIndex = (m - currentLeastRow*s)%s;
		
		if(pos[1]>=l || m >= n * row)return null;//  ╮(╯▽╰)╭
		ptr = list.get(pos[1]).get(strIndex);
		
		return ptr;
	}

	static String nor(String s0, String s1){
		char[] se0 = s0.toCharArray();
		char[] se1 = s1.toCharArray();
		char[] re = new char[se0.length];


		for (int i = 0; i < se0.length; i++) {
			se0[i] -= '0';
			se1[i] -= '0';

			re[i] = (char)(se0[i]^se1[i] + '0'); //╮(╯▽╰)╭
		}

		return new String(re);
	}
	
	static String ComputeBlock(int m){
		//if(n>s)return null;

		int[] pos = getPos(m);

		if (m >= n * row || l <= n-2){
			return null;
		}

		pos[0] = pos[0] / s * s;

		//n-2 < l < n, i.e. l=n-1

		String re;

		re = list.get(0).get(pos[0]);
		for (int i = 1; i < s; i++) {
			re += list.get(0).get(pos[0] + i);
		}

		for (int i = 1; i < l; i++) {

			String tmp = list.get(i).get(pos[0]);
			for (int j = 1; j < s; j++) {
				tmp += list.get(i).get(pos[0] + j);
			}

			re = nor(re,tmp);
		}

		re = re.substring((m%s)*8,(m%s+1)*8);

		return re;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < read.length; i++) {
			String re = FindBlock(read[i]);
			if(re != null){
				System.out.println(re);
				continue;
			}
			re = ComputeBlock(read[i]);
			if(re != null){
				System.out.println(re);
				
			}else {
				System.out.println('-');
			}
		}
	}
/*
 3 2 2
 0 000102030405060710111213141516172021222324252627
 1 000102030405060710111213141516172021222324252627
 4
 0
 1
 2
 3
 */
}
