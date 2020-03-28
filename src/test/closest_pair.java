package test;

import java.util.ArrayList;
import java.util.Scanner;



/*
we define a point with a int[2], which indicates {x-axis, y-axis}

we define a line with a double[3], which indicates {A,B,C};or double [2], with {k,b}
*/

//a funny experience:  System.out.println(number0 + ' ' + number1), guess what? A number printed as the result.


class closest_pair{

	static ArrayList<int[]> arr = new ArrayList<int[]>(), desArr = new ArrayList<int[]>();

	static double disLinePoint(int [] p,double [] l){
		if (l.length == 2) {
			l = kb2ABC(l);
		}
		
		int x = p[0],y=p[1];
		double A=l[0],B=l[1],C=l[2];
		return Math.abs(A*x+B*y+C)/Math.sqrt(A*A+B*B);
	}
	
	static double[] kb2ABC(double [] l) {
		if (l.length == 3) {
			System.err.println("kb2ABC error");
		}
		
		return new double[] { l[0],-1.0,l[1] };
	}

	static double[] connectPoint(int [] p1, int [] p2){
		int x1 = p1[0],x2=p2[0],y1=p1[1],y2=p2[1];
		double k = (double)(y1-y2)/(x1-x2);
		return new double[]{k,y2-k*x2};
	}

	static boolean isUpThan(int[] p, double [] l) {
		if(l.length == 2){
			int x = p[0],y= p[1];
			double k = l[0], b = l[1];

			if(y>k*x+b)return true;
			else return false;
		}else {
			System.err.println("y=kx+b is required");
			System.exit(1);
		}
		return false;
	}

	static boolean isDownThan(int[] p, double [] l) {
		if(l.length == 2){
			int x = p[0],y= p[1];
			double k = l[0], b = l[1];

			if(y<k*x+b)return true;
			else return false;
		}else {
			System.err.println("y=kx+b is required");
			System.exit(1);
		}
		return false;
	}

	static void upEnvol(int [] p1, int [] p2){
		double [] l = connectPoint(p1,p2);
		int [] farthestP = null;
		
		double curFar = 0;
		
		int cnt = 0;//for the count of points that are over the current line
		
		for(int [] p: arr){
			if(isUpThan(p,l)){
				double dis;
				if((dis=disLinePoint(p,l))>curFar){
					farthestP = p;
					curFar = dis;
				}
				
				++cnt;
			}
		}
		
		if (cnt == 0) {
			if (!desArr.contains(p1)) {
				desArr.add(p1);
			}
			if (!desArr.contains(p2)) {
				desArr.add(p2);
			}
			return;
		}
		
		upEnvol(p1,farthestP);
		upEnvol(farthestP,p2);
	}

	static void downEnvol(int [] p1, int [] p2){
		double [] l = connectPoint(p1,p2);
		int [] farthestP = null;
		
		double curFar = 0;
		
		int cnt = 0;
		
		for(int [] p: arr){
			if(isDownThan(p,l)){
				double dis;
				if((dis=disLinePoint(p,l))>curFar){
					farthestP = p;
					curFar = dis;
					
					
				}
				
				++cnt;
			}
		}
		
		
		if (cnt == 0) {
			if (!desArr.contains(p1)) {
				desArr.add(p1);
			}
			if (!desArr.contains(p2)) {
				desArr.add(p2);
			}
			return;
		}
		
		downEnvol(p1,farthestP);
		downEnvol(farthestP,p2);
	}	

	public static void main(String [] args){

		//the input--------------
		Scanner sc = new Scanner(System.in);

		int epoch = sc.nextInt();
		while(epoch-- != 0){
			arr.add( new int[]{sc.nextInt(),sc.nextInt()} );
		}

		//-----------------------
		upEnvol(arr.get(0),arr.get(arr.size()-1));
		downEnvol(arr.get(0),arr.get(arr.size()-1));
		
		System.out.println("the result pairs:");
		for (int[] pair : desArr) {
			System.out.println(pair[0]+" "+pair[1]);
		}
		
		sc.close();
	}

}