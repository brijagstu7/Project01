package threads;

public class create_threads implements Runnable{
	//there's another way to create a new thread
	//which change "implements Runnable" to
	//"extends Thread". Nothing else adjusted.
	;
	void NewThread(){
		Thread t = new Thread(this, "Demo");
		System.out.println("child thread: "+ t);
		t.setPriority(3);//priority ranges
		//from 1 to 10
		t.start();//must to run a child thread.
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//enter what to do in this thread.
		try {
			for(int i=5;i>0;i--) {
				System.out.println("child thread: "+ i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("child interrupted.");
		}
	}

}
