package system;

public class runtime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getRuntime before using. cannot instantiate.
		Runtime r = Runtime.getRuntime();
		double mem1;
		//total memory for JVM.
		mem1 = r.totalMemory();
		System.out.println(mem1/1024.0/1024);//64M?
		System.out.println(r.availableProcessors());
		System.out.println(r.freeMemory());
		
	}

}
