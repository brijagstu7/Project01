package threads;

public class main_thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		create_threads t = new create_threads();
		t.NewThread();
		
		//run child thread
		try {
			for(int i=5;i>0;i--) {
				System.out.println("main thread: "+i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
