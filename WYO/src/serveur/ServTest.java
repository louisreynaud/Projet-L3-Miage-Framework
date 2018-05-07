package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServTest extends UnicastRemoteObject implements IntEnvoiMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1251865714909276171L;

	protected ServTest() throws RemoteException {
		super();
	}


	@Override
	public String envoyerOK() throws RemoteException {
		return "OK!";
	}

}
