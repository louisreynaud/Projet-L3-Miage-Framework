package client;

import java.util.ArrayList;

public class Tchat extends Conversation {
	
	private User u1;
	private User u2;

	public Tchat(int id, String nom, User u1, User u2) {
		this.setIdConversation(id);
		this.setNomConversation(nom);
		this.setListMsg(new ArrayList<Message>());
		this.u1 = u1;
		this.u2 = u2;
		
	}



	public void supprimerConversation() {
		// TODO Auto-generated method stub
	}



	public void creerConversation() {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
