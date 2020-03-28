package NET.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

interface AddServerIntf extends Remote {
	double add(double d1, double d2) throws RemoteException;
}


public class AddClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "rmi://"+args[0]+"/AddServer";
		try {
			AddServerIntf a = (AddServerIntf) Naming.lookup(url);
			
			double d1 = Double.parseDouble(args[1]);
			double d2 = Double.parseDouble(args[2]);
			
			System.out.println(d1+" plus "+d2+" is "+a.add(d1, d2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
