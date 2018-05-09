package client;

import java.util.ArrayList;

public class Conversation_Groupe extends Conversation {
	
	private Groupe g;
	

	public Conversation_Groupe(int id, String nom, Groupe g) {
		this.setIdConversation(id);
		this.setNomConversation(nom);
		this.setListMsg(new ArrayList<Message>());
		this.g = g;

	}



	public void supprimerConversation() {
		// TODO Auto-generated method stub
		
	}

	public void creerConversation() {
		// TODO Auto-generated method stub
		
	}

}
