package threads.concurrency;

import java.util.concurrent.Semaphore;

/**
 * In my opinion, semaphores can in a way Replace the use 
 * of wait() and notice() method for thread communication.
 * 
 * It is a higher efficient way to use Semaphore to replace
 * sleep.
 * @author yang-sijie
 *
 */
public class semaphore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//if true, the sequence is fixed.
		Semaphore s = new Semaphore(1,true);
		
		new Thread(new Inc("a",s)).start();
		new Thread(new Dec("b",s)).start();
	}

}
class Rep0{
	static int cnt=1;
}

class Inc implements Runnable{
	String msg;
	Semaphore s;
	Inc(String msg, Semaphore s) {
		this.msg = msg;
		this.s = s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("a is waiting");
		try {
			s.acquire();
			System.out.println("a got a permit");
			
			for(int i=0;i!=5;i++) {
				System.out.println("incrementing a:"+(++Rep0.cnt));
			}
			
			System.out.println("a is releasing");
			s.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

class Dec implements Runnable{
	String msg;
	Semaphore s;
	Dec(String msg, Semaphore s) {
		this.msg = msg;
		this.s = s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("b is waiting");
		try {
			s.acquire();
			System.out.println("b got a permit");
			
			for(int i=0;i!=5;i++) {
				System.out.println("decrementing b:"+(--Rep0.cnt));
			}
			
			System.out.println("b is releasing");
			s.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}