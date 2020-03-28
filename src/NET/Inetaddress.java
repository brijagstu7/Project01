package NET;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inetaddress {
	static void p(Object ob) {
		System.out.print(ob);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress address = null;
		try {
			
			address = InetAddress.getLocalHost();
			p(address);
			address = InetAddress.getByName
					("www.ibm.com");
			p("\n"+address);
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
