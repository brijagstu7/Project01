package try_catch;

public class throw_exceptions {

	static void ThrowsDemo() throws Exception {
		//throws means noticing the user of current 
		//method to handle the exception
		throw new Exception("shit");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//throw an exception, even if nothing
			//wrong
			int a;
			throw new ArithmeticException();
		}catch(Exception e){
			System.out.print("found an exception\n");
		}
		
		//ThrowsDemo();//this could make a bug
		try {
			ThrowsDemo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}finally {
			System.out.print("finally means "
					+ "subsequent process "
					+ "after try/catch.");
			//finally runs despite a return in 
			//try/catch.
		}
	}

}
