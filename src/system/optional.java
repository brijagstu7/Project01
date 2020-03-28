package system;

import java.util.Optional;

/**
 * this class demonstrate the function Optional
 * Optional can be used on all occasions
 * used for avoiding NullPointerException
 */
public class optional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional op = Optional.empty();
		System.out.println(op.isPresent());
		
		String str = "123";
		op.of(str);
		System.out.println(op);
	}

}
