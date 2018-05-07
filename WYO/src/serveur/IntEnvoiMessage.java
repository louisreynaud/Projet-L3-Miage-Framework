package serveur;

import java.rmi.*;

public interface IntEnvoiMessage extends Remote {
	
	public String envoyerOK() throws RemoteException;

}
