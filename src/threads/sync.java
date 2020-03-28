package threads;
class call_{
	static void call(String msg) {
		System.out.print(msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" is here.");
	}
}
class callme implements Runnable{
	//callme target = new callme("");
	private String msg;
	Thread t;
	//call_ call = new call_();
	Object ob;
	
	callme(Object ob,/*call_ call, */String msg){
		this.msg = msg;
		this.ob = ob;
		t = new Thread(this);
		t.start();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(ob) {
			//if there's a sync label before the 
			//target method, no need for this
			//sync block.
			call_.call(msg);
		}
	}
	
}
public class sync {
	
	public static void main(String[] args) {
		Object d = "";
		callme a = new callme(d,"one");
		callme b = new callme(d,"two");
		callme c = new callme(d,"three");
		
		try {
			a.t.join();
			//join means:the following codes execute
			//only when a.t dies.
			b.t.join();
			c.t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
