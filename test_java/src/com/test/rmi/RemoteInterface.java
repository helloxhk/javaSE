package com.test.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程接口
 * @author xhk
 */
public interface RemoteInterface extends Remote {
	long getPerfectTime() throws RemoteException;
}
