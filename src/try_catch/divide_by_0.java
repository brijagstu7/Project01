package try_catch;

public class divide_by_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//this block contains codes in work.
			int a = 0;
			int d = 5 / a;
			System.out.print("this won't print.");
		} catch (Exception e/*if such 
		exception occurs*/) {
			// TODO Auto-generated catch block
			//this block contains what to do 
			//after exception occurs
			System.out.print("division by 0.\n");
			e.printStackTrace();
			
		}
		//you can also add more catches for 
		//more sorts of exceptions.
		//each sort of exception is a class
	}

}
