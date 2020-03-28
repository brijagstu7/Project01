package threads;
//This is a model showing a fake usage of synchronized
//remember: one object, one monitor.
class callme1 implements Runnable{
	//callme1 target = new callme1("");
	private String msg;
	Thread t;
	callme1(String msg){
		this.msg = msg;
		t = new Thread(this);
		t.start();
	}
	
	synchronized void call() {
		System.out.print(msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" is here.");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//HINT:synchronized methods cannot be
		//synchronized with current object.
		this.call();
		//look at sync.java.
	}
	
}
public class sync1 {
	
	public static void main(String[] args) {
		/* in this move, 3 objects a,b,c do not 
		 * share the same monitor, but 3 for each, 
		 * even if one monitor is locked, the others
		 * are not affected.
		 */
		callme1 a = new callme1("one");
		callme1 b = new callme1("two");
		callme1 c = new callme1("three");
		//when running in one sync method, all 
		//sync methods in current object is blocked.
		try {
			a.t.join();
			b.t.join();
			c.t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
