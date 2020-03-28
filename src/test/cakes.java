package test;

import java.util.Scanner;
/*
 * This test is not complete. 
 * 2 unsolved problems are encountered:
 *   1.go to triangle.
 *   2.go to area.
 */
class point{
	int x;int y;

	point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
class line{
	point x;point y;

	line(point x, point y) {
		
		this.x = x;
		this.y = y;
	}
	double Equation(double x0) {
		return (double)(y.y-x.y)/(y.x-x.x)*(x0-x.x)+x.y;
	}
	boolean LowQ(point p) {
		return this.Equation(p.x)<p.y;
	}
	/**
	 * @param l all points
	 * @return how many points is higher than me
	 */
	int HighNum(point[] p) {
		int cnt = 0;
		for(int i=0;i<p.length;i++) {
			if(this.LowQ(p[i]))cnt++;
		}
		return cnt;
	}
}
class triangle{
	point x;point y; point z;
	/**
	 * this must be used within a loop, with index from
	 * 0 to l.length.
	 * @param l must be all lines.
	 * @param p must be all points.
	 * @param index which line is the fundamental line.
	 * @throws Exception I originally think that each line(except 
	 *         the top one)can find the other that has one less
	 *         point that is higher than itself. But the output is
	 * 		   indicating that something might be wrong.
	 * @return Unknown: More than one null z are returned.
	 */
	triangle(line[] l, int index, point[] p) throws Exception{
		x = l[index].x;y = l[index].y;
		int tmp = l[index].HighNum(p);
		for(int i=0;i<l.length-1;i++) {
			if(tmp==l[i].HighNum(p)-1) {
				z = l[i].y;
				break;
			}
		}
		if(z.equals(null))throw new Exception("z has no point");
	}
}
public class cakes {
	static double min(double[] target) {
		double min = 0;
		for(double i:target) {
			min = min<i?min:i;
		}
		return min;
	}
	/**
	 * @return An NaN returns for unknown reason.(Not divided by 0)
	 */
	static double area(int x1, int x2,int y1,int y2,double[] cross) {
		double a,b,c,p,s;
		a = Math.sqrt((double)(x1*x1+y1*y1));
		b = Math.sqrt((double)(x2*x2+y2*y2));
		c = Math.sqrt((x1-cross[0])*(x1-cross[0])+(y1-cross[1])*(y1-cross[1]));
		p = (a+b+c)/2;
		s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return s;
	}
	static void p(Object b) {
		System.out.print(b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x[] = new int[n];int y[] = new int[n];
		for(int i=0;i<n;i++) {
			sc = new Scanner(System.in);
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		sc.close();
		
		point p[] = new point[n];
		line l[] = new line[n-1];
		triangle tr[] = new triangle[n-2];
		double s[] = new double[n-2];
		double biggest = 0;
		//instantiate points.
		for (int i = 0; i < n; i++) {
			p[i] = new point(x[i],y[i]);
		}
		x=y=null;
		//switch public points.
		for(int i = 0;i<n;i++) {//i th point
			//instantiate lines
			for(int j=0;j<n-1;j++) {
				if(j==i) {
					l[j] = new line(p[i],p[p.length-1]);
					continue;
				}
				l[j] = new line(p[i],p[j]);
			}
			//instantiate triangles
			for(int j=0;j<n-2;j++) {
				try {
					tr[j] = new triangle(l,j,p);
				} catch (Exception e) {
					try {
						//this block is predicted to run once
						tr[j] = new triangle(l,n-2,p);
					} catch (Exception e1) {
					}
				}
			}
			//calculate areas.
			for(int j=0;j<n-2;j++) {
				s[j] = 
area(tr[j].x.x,tr[j].y.x,tr[j].x.y,tr[j].y.y,new double[] {tr[j].z.x,tr[j].z.y});
			}
			biggest = min(s)>biggest?biggest:min(s);
		}
		p(biggest);
	}

}
