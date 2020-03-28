package try01;

public class Bit_operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a =  0b00000011;//3
		byte b =  0b000001__0___0;//4
		//                 2^1 2^0
		System.out.println(a);
		
		//since there're auto type-promotion for 
		//type byte, short,
		//some arithmetics can be exotic.
		
		int c = a*b*b*b*b;
		int d = b << 6;
		System.out.println(c+" "+d);
		//they won't overflow
		
		Integer i = 10;
		Integer.highestOneBit(i);
		int i0 = 10;
		Bit_operation b1 = new Bit_operation();
		b1.foo();
		Math.sin(12);
	}

	void foo() {
		
	}
}
