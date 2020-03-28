package threads;
//ThreadGroup:a group for threads.
class threadDemo extends Thread{
	
	public void run() {
		System.out.println("this is a demo");
	}
}

public class threadGroup extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup tg0 = new ThreadGroup("A");
		ThreadGroup tg1 = new ThreadGroup("B");
		
		threadDemo a = new threadDemo();
		new Thread(tg0,a).start();
		Thread t = new Thread(tg1,a);
		System.out.println(t.getThreadGroup());
		t.start();
		//a thread no more belong to any group if
		//terminated.
	}

}
