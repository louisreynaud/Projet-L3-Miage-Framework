package client;

import java.util.ArrayList;

public abstract class Conversation {

	protected String nomConversation;
	protected ArrayList<Message> listMsg;
	
	public Conversation(String nom) {
		this.setNom(nom);
		this.listMsg = new ArrayList<Message>();
	}

	/*
	public int getId() {
		return idConversation;
	}
	*/


	public String getNom() {
		return nomConversation;
	}

	public void setNom(String nomConversation) {
		this.nomConversation = nomConversation;
	}
	
	/*
	public void envoyerMessage(String contenu) { // TODO doit être réécrit pour Publication
		Message m = new Message(null, contenu);
		
	}*/
	public abstract void supprimerConversation() ;
	
	
	public void ajouterMessage(Message m) {
		listMsg.add(m);
		
	}
	
	public void supprimerMessage(int index) {
		listMsg.remove(index);
	}
	
	
	
	
}
