package threads.concurrency;

import java.util.concurrent.Semaphore;

public class practice {
	static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore c = new Semaphore(5);
		Thread t = new Thread(new a0(c));
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("incrementation finished");
	}

}
class a0 implements Runnable{
	Semaphore c;
	
	a0(Semaphore c) {
		this.c = c;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("incrementing cnt");
		while (c.tryAcquire()) {
			
			System.out.println(++count_down_latch.cnt);
			
		}
	}
	
}
