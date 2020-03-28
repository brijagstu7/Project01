package threads;

public class sleep {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("before sleep");
		Thread t = Thread.currentThread();
		t.setName("shit");
		System.out.println(t);
		Thread.sleep(1000);
		System.out.print("after sleep");
	}

}
