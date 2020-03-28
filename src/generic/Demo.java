package generic;

class Gen<E>/*note the <E> */{
	//if Gen<E extends Number>, E can only be classes
	//in Number and can use API in it.
	E ob;
	//It is like Object. 
	//But no need for adding casts,
	//which can easily cause RE when ignored.
	Gen(E e){
		ob = e;
	}
	E getOb() {
		return ob;
	}
	void getType() {
		System.out.print(ob.getClass().getName());
		//getClass returns a class it belongs to
	}
}
/**
 * when a class extends a generic class, the generic 
 * args must be added.
 * or use Object-type constructors as default.
 */
class Gen2<E> extends Gen<E>{
	/** must.
	 */
	Gen2(E ob){
		super(ob);
	}
	//E e = new E();//cannot instantiate.
}
public class Demo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//u can instantiate in 3 forms.
		Gen gen2 = new Gen(12);
		Gen<String> gen1 = new Gen<>("12");
		Gen<Integer> gen = new Gen<Integer>(12);
		gen.getType();
	}

}
