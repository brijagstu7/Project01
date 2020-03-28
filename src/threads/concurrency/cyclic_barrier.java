package threads.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * CyclicBarrier lets all threads run together before each
 * of them reaches a certain block.
 * @author yang-sijie
 *
 */
public class cyclic_barrier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier c = new CyclicBarrier(5);
		synchronized (c) {
			new Thread(new exe(79098766,"one",c)).start();
			new Thread(new exe(21847,"two",c)).start();
			new Thread(new exe(89078,"three",c)).start();
			new Thread(new exe(1,"four",c)).start();
			new Thread(new exe(982,"five",c)).start();
		}
	}

}


class exe implements Runnable{
	int top;
	String name;
	CyclicBarrier cb;
	exe(int u,String n,CyclicBarrier c){
		top = u;
		name = n;
		cb = c;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(i!=top)i++;
		
		System.out.println(name+" is finished");
		
		try {
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(name+" ");
	}
	
}