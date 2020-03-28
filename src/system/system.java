package system;


public class system {
	
	public void test() {
		long r = System.currentTimeMillis();
		for(long i=0;i<1000000000l;i++);
		System.out.println((System.currentTimeMillis()-r));
	}
	
}
