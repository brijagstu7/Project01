package threads.concurrency;

import java.util.concurrent.CountDownLatch;
/**
 * CountDownLatch lets one thread pause.
 * @author yang-sijie
 *
 */
public class count_down_latch {
	static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch c = new CountDownLatch(5);
		new Thread(new a(c)).start();
		
		try {
			c.await();//wait until the count reaches 0
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("incrementation finished");
	}

}
class a implements Runnable{
	CountDownLatch c;
	
	a(CountDownLatch c) {
		this.c = c;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("incrementing cnt");
		while (c.getCount()!=0) {
			System.out.println(++count_down_latch.cnt);
			c.countDown();
		}
	}
	
}
