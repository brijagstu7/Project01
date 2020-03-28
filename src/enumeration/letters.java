package enumeration;

public enum letters {
	a,b,c,d,e,f,g1/*1 is error*/,_1,n$,
	//like defining a var
	//motherfucking troubling
	//instantiation inside
	
	a1(10);
	//instantiations must be put together.
	
	int price;
	
	letters(){}
	letters(int n){
		price = n;
	}
}
