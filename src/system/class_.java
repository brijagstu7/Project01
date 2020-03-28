package system;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*
 * Reflect means telling something about a class.
 * 
 * Class is a class that encapsulate information about 
 * a certain class.
 */


//Factory classes returns any instances with the name given.
class factory<T>{
	private factory(){};
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static<T> T get(String str) {
		T obj = null;
		try {
			obj = (T)Class.forName(str).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}


public class class_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class c = factory.get("java.awt.Dimension").getClass();
		
		Constructor cons[] = c.getConstructors();
		
		for(Constructor i: cons) {
			System.out.println(i);
		}
		
		Method m[] = c.getMethods();
		
		for(Method i: m) {
			System.out.println(i);
		}
		
		
	}

}
