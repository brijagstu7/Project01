package threads;
//wait and notify MUST be used with synchronized 
//at needed methods.
class Q{
	int n;
	boolean value = false;
	synchronized int get() {
		while(!value) {
			try {
				wait();//wait until put() has executed
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("got:"+n);
		value = false;
		notify();
		return n;
	}
	synchronized void put(int n) {
		while(value) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.n = n;
		value = true;
		notify();
		System.out.println("put:"+n);
	}
}
class Producer implements Runnable{
	Q q;
	
	Producer(Q q){
		this.q = q;
		new Thread(this).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(i<1000) {
			q.put(i++);
		}
	}
	
}
class Customer implements Runnable{
	Q q;
	Customer(Q q){
		this.q = q;
		new Thread(this).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(i<1000) {
			q.get();
			i++;
		}
	}
	
}
public class Wait_notice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q q = new Q();
		new Producer(q);
		new Customer(q);
	}

}
