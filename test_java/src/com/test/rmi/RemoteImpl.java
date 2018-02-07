package com.test.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteImpl extends UnicastRemoteObject implements RemoteInterface {

	private static final long serialVersionUID = 1L;

	protected RemoteImpl() throws RemoteException {
		super();
	}

	public long getPerfectTime() throws RemoteException {
		return System.currentTimeMillis();
	}

	public static void main(String[] args) {
//		System.setSecurityManager(new RMISecurityManager());
		try {
			LocateRegistry.createRegistry(60000);
			RemoteImpl impl = new RemoteImpl();
			Naming.bind("//localhost:60000/RemoteImpl", impl);
			System.out.println("RemoteImpl is ready to work.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
