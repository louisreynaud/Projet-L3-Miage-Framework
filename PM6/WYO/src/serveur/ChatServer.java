package serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Vector;

import client.ChatClient3IF;

/**
 * 
 *
 */
public class ChatServer extends UnicastRemoteObject implements ChatServerIF {
	String line = "---------------------------------------------\n";
	private Vector<Chatter> chatters;
	private static final long serialVersionUID = 1L;
	
	//Constructor
	public ChatServer() throws RemoteException {
		super();
		chatters = new Vector<Chatter>(10, 1);
	}
	
	//-----------------------------------------------------------
	/**
	* M�THODES LOCALES
	*/	
	public static void main(String[] args) {
		startRMIRegistry();	
		String hostName = "localhost";
		String serviceName = "GroupChatService";
		
		if(args.length == 2){
			hostName = args[0];
			serviceName = args[1];
		}
		
		try{
			ChatServerIF hello = new ChatServer();
			Naming.rebind("rmi://" + hostName + "/" + serviceName, hello);
			System.out.println("Group Chat RMI Server is running...");
		}
		catch(Exception e){
			System.out.println("Server had problems starting");
		}	
	}

	
	/**
	* D�marrer le registre RMI
	*/
	public static void startRMIRegistry() {
		try{
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			System.out.println("RMI Server ready");
		}
		catch(RemoteException e) {
			e.printStackTrace();
		}
	}
		
	
	//-----------------------------------------------------------
	/*
	 *   REMOTE METHODS
	 */
	
	/**
	* Renvoyer un message au client
	*/
	public String sayHello(String ClientName) throws RemoteException {
		System.out.println(ClientName + " sent a message");
		return "Hello " + ClientName + " from group chat server";
	}
	

	/**
	* Envoyer une cha�ne (le dernier message, la plupart du temps)
	* � tous les clients connect�s
	*/
	public void updateChat(String name, String nextPost) throws RemoteException {
		String message =  name + " : " + nextPost + "\n";
		sendToAll(message);
	}
	
	/**
	* Recevoir une nouvelle r�f�rence distante client
	*/
	@Override
	public void passIDentity(RemoteRef ref) throws RemoteException {	
		//System.out.println("\n" + ref.remoteToString() + "\n");
		try{
			System.out.println(line + ref.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}//end passIDentity

	
	/**
	* Recevoir un nouveau client et afficher les d�tails sur la console
	* envoyer pour enregistrer la m�thode
	*/
	@Override
	public void registerListener(String[] details) throws RemoteException {	
		System.out.println(new Date(System.currentTimeMillis()));
		System.out.println(details[0] + " a rejoint la session de discussion");
		System.out.println(details[0] + "'s hostname : " + details[1]);
		System.out.println(details[0] + "'sRMI service : " + details[2]);
		registerChatter(details);
	}

	
	/**
	* enregistrer l'interface des clients et le stocker dans une r�f�rence pour
	* les futurs messages � envoyer, c'est-�-dire les autres messages des membres de la session de chat.
	* envoyer un message de test pour confirmation / test de connexion
	* @param d�tails
	*/
	private void registerChatter(String[] details){		
		try{
			ChatClient3IF nextClient = ( ChatClient3IF )Naming.lookup("rmi://" + details[1] + "/" + details[2]);
			
			chatters.addElement(new Chatter(details[0], nextClient));
			
			nextClient.messageFromServer("[Server] : Hello " + details[0] + " you are now free to chat.\n");
			
			sendToAll("[Server] : " + details[0] + " has joined the group.\n");
			
			updateUserList();		
		}
		catch(RemoteException | MalformedURLException | NotBoundException e){
			e.printStackTrace();
		}
	}
	
	/**
	* Mettre � jour tous les clients en invoquant � distance leur
	* updateUserList M�thode RMI
	*/
	private void updateUserList() {
		String[] currentUsers = getUserList();	
		for(Chatter c : chatters){
			try {
				c.getClient().updateUserList(currentUsers);
			} 
			catch (RemoteException e) {
				e.printStackTrace();
			}
		}	
	}
	

	/**
	* g�n�rer un tableau String des utilisateurs actuels
	* @revenir
	*/
	private String[] getUserList(){
		// generate an array of current users
		String[] allUsers = new String[chatters.size()];
		for(int i = 0; i< allUsers.length; i++){
			allUsers[i] = chatters.elementAt(i).getName();
		}
		return allUsers;
	}
	

	/**
	* Envoyer un message � tous les utilisateurs
	* @param nouveauMessage
	*/
	public void sendToAll(String newMessage){	
		for(Chatter c : chatters){
			try {
				c.getClient().messageFromServer(newMessage);
			} 
			catch (RemoteException e) {
				e.printStackTrace();
			}
		}	
	}

	
	/**
	* supprimer un client de la liste, informer tout le monde
	*/
	@Override
	public void leaveChat(String userName) throws RemoteException{
		
		for(Chatter c : chatters){
			if(c.getName().equals(userName)){
				System.out.println(line + userName + " left the chat session");
				System.out.println(new Date(System.currentTimeMillis()));
				chatters.remove(c);
				break;
			}
		}		
		if(!chatters.isEmpty()){
			updateUserList();
		}			
	}
	

	/**
	* Une m�thode pour envoyer un message priv� aux clients s�lectionn�s
	* Le tableau entier contient les index (� partir du vecteur chatters)
	* des clients � envoyer le message �
	*/
	@Override
	public void sendPM(int[] privateGroup, String privateMessage) throws RemoteException{
		Chatter pc;
		for(int i : privateGroup){
			pc= chatters.elementAt(i);
			pc.getClient().messageFromServer(privateMessage);
		}
	}
	
}//END CLASS



