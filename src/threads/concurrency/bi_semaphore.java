package threads.concurrency;

import java.util.concurrent.Semaphore;
/**
 * It seems that static storage of conditions for concurrency
 * is useless for synchronization.
 * 
 * The usage of semaphore in this file is impressive.
 * @author yang-sijie
 *
 */
public class bi_semaphore {
	
	public static void main(String args[]) {
		
		new Thread(new producer()).start();
		new Thread(new customer()).start();
		
	}
	
}

class rep{
	static int cnt0 = 0;
	static Semaphore s0 = new Semaphore(0);
	static Semaphore s1 = new Semaphore(1);
}
class customer implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (rep.cnt0!=50) {
				rep.s0.acquire();
				System.out.println("get:" + (rep.cnt0));
				rep.s1.release();
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
class producer implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (rep.cnt0!=50) {
				rep.s1.acquire();
				System.out.println("put:" + (++rep.cnt0));
				rep.s0.release();
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}