package client;
import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import serveur.ChatServerIF;

/**
 *
 */
public class ChatClient3  extends UnicastRemoteObject implements ChatClient3IF {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7468891722773409712L;
	ClientRMIGUI chatGUI;
	private String hostName = "localhost";
	private String serviceName = "GroupChatService";
	private String clientServiceName;
	private String name;
	protected ChatServerIF serverIF;
	protected boolean connectionProblem = false;

	
	/**
	* constructeur de classe,
* note peut également utiliser un constructeur surchargé avec
* un port non passé en argument à super
* @throws RemoteException
*/
	public ChatClient3(ClientRMIGUI aChatGUI, String userName) throws RemoteException {
		super();
		this.chatGUI = aChatGUI;
		this.name = userName;
		this.clientServiceName = "ClientListenService_" + userName;
	}

	
	/**
	* Enregistrez notre propre service / interface d'écoute
	* rechercher l'interface RMI du serveur, puis envoyer nos coordonnées
	* @throws RemoteException
	*/
	public void startClient() throws RemoteException {		
		String[] details = {name, hostName, clientServiceName};	

		try {
			Naming.rebind("rmi://" + hostName + "/" + clientServiceName, this);
			serverIF = ( ChatServerIF )Naming.lookup("rmi://" + hostName + "/" + serviceName);	
		} 
		catch (ConnectException  e) {
			JOptionPane.showMessageDialog(
					chatGUI.frame, "The server seems to be unavailable\nPlease try later",
					"Connection problem", JOptionPane.ERROR_MESSAGE);
			connectionProblem = true;
			e.printStackTrace();
		}
		catch(NotBoundException | MalformedURLException me){
			connectionProblem = true;
			me.printStackTrace();
		}
		if(!connectionProblem){
			registerWithServer(details);
		}	
		System.out.println("Client Listen RMI Server is running...\n");
	}


	/**
	* passer notre nom d'utilisateur, nom d'hôte et nom de service RMI à
	* le serveur pour enregistrer son intérêt à rejoindre le chat
	* @param détails
	*/
	public void registerWithServer(String[] details) {		
		try{
			serverIF.passIDentity(this.ref);//now redundant ??
			serverIF.registerListener(details);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	//=====================================================================
	/**
	* Recevoir une chaîne du serveur de discussion
	* c'est la méthode RMI des clients, qui sera utilisée par le serveur
	* pour nous envoyer des messages
	*/
	@Override
	public void messageFromServer(String message) throws RemoteException {
		System.out.println( message );
		chatGUI.textArea.append( message );
		//make the gui display the last appended text, ie scroll to bottom
		chatGUI.textArea.setCaretPosition(chatGUI.textArea.getDocument().getLength());
	}

	/**
	* Une méthode pour mettre à jour l'affichage des utilisateurs
	* actuellement connecté au serveur
	*/
	@Override
	public void updateUserList(String[] currentUsers) throws RemoteException {

		if(currentUsers.length < 2){
			chatGUI.privateMsgButton.setEnabled(false);
		}
		chatGUI.userPanel.remove(chatGUI.clientPanel);
		//chatGUI.setClientPanel(currentUsers);
		chatGUI.clientPanel.repaint();
		chatGUI.clientPanel.revalidate();
	}

}//end class













