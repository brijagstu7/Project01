package generic;
/*
 * This series of class talks about properties of 
 * generic classes with bounds.
 */
class TwoD{
	int a,b;
	TwoD(int a, int b){
		this.a = a;
		this.b = b;
	}
}
class ThreeD extends TwoD{
	int c;
	ThreeD(int a, int b, int c){
		super(a,b);
		this.c = c;
	}
}
class FourD extends ThreeD{
	int d;
	FourD(int a, int b, int c, int d) {
		super(a, b, c);
		this.d = d;
		// TODO Auto-generated constructor stub
	}

}

class coords<E extends TwoD>{//extends means
	//TwoD or its subclass to be an instantiation.
	E[] coords;
	coords(E[] coords){
		this.coords = coords;
	}
}

//I find it quite useless compared to DMD.
public class bounded_wildcard {
	/**
	 * this method cannot invoke args in 
	 * TwoD 's subclasses.
	 */
	static void show2(coords<? extends ThreeD> c) {
		//Type E is invisible unless having declared
		//before like generic_method.java
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].a+
					" "+c.coords[i].b);
		}
	}
	/**
	 * this method seemingly can invoke TwoD 's args
	 * but if used for TwoD instances c.coord[i].c and
	 * c.coord[i].d can not be found and RE occurred.
	 */
	static void show4(coords<? extends FourD> c) {
		//If using extends, ? is must.
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].a+
					" "+c.coords[i].b+" "+c.coords[i].c
					+" "+c.coords[i].d);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourD one[] = 
			{new FourD(1,2,3,4),new FourD(5,6,7,8)};
		ThreeD two[] = {new ThreeD(1,2,3)};
		coords c = new coords(one);
		coords c1 = new coords(two);
		show2(c);
		show4(c1);
	}

}
