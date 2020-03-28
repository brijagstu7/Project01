package NET.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class AddServerImpl extends UnicastRemoteObject implements AddServerIntf{

	protected AddServerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double add(double d1, double d2) throws RemoteException{
		// TODO Auto-generated method stub
		return d1 + d2;
	}
	
}


public class AddServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddServerImpl a;
		try {
			a = new AddServerImpl();
			Naming.rebind("AddServer", a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
