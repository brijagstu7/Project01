package threads;
/*
 * I want to show how volatile works.
 * See a tutorial about it in WeChat.
 * 
 * Without notes beginning with //*
 * the output is randomly 0 or 3.
 */

/**
 * Assign s.
 * @author brija
 *
 */
class A implements Runnable{
	
	
	Thread t1;
	/**
	 * thread starter.
	 */
	void T1(){
		t1 = new Thread(this,"A");
		t1.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Volatile.s = 3;
	}
	
}
/**
 * Print s.
 * @author brija
 *
 */
class B implements Runnable {
	
	
	Thread t2;
	/**
	 * thread starter.
	 */
	void T2(){
		t2 = new Thread(this,"B");
		t2.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print(Volatile.s);
	}
	
}

public class Volatile {

	public static int s = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		
		a.T1();
		
		b.T2();
	}

}
