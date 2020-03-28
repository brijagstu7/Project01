package test;

import java.util.ArrayList;

import java.util.Scanner;

class point0 {
	int x;int y;

	point0(int x, int y) {
		//super();
		this.x = x;
		this.y = y;
	}
	
}
class set extends ArrayList<set>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<point0> p = new ArrayList<point0>();

	set(int[][] map) {
		//super();
		//MAIN DEFFICULTY
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				if(map[i][j]==1) {
					p.add(new point0(i,j));
				}
			}
		}
		
	}
	static boolean closeQ(point0 p1,point0 p2) {
		return false;
		
	}
	boolean isClose() {
		return false;
		
	}
	
}
public class demacia {
	static int cnt;
	static int n;static int m;
	static int map[][];
	static ArrayList<point0> p = null;
	static {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();m = sc.nextInt();
		map = new int[n][m];
		sc = new Scanner(System.in);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
			sc = new Scanner(System.in);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		set s = new set(map);
		for(set i:s) {
			if(i.isClose())cnt++;
		}
		System.out.print(cnt);
	}

}
