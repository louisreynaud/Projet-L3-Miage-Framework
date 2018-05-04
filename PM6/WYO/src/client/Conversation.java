package client;

public abstract class Conversation {

	private int idConversation;
	private String nomConversation;
	
	public Conversation(int id, String nom) {
		this.setId(id);
		this.setNom(nom);
		
	}

	public int getId() {
		return idConversation;
	}

	public void setId(int idConversation) {
		this.idConversation = idConversation;
	}

	public String getNom() {
		return nomConversation;
	}

	public void setNom(String nomConversation) {
		this.nomConversation = nomConversation;
	}
	
	
	public void envoyerMessage(String contenu) {
		Message m = new Message(null, contenu);
		
	}
	
	public String afficherMessage(Message m) {
		return null;
	}
	
	
	/*
	 * creerConversation() : A l'aide des outils (socket/RMI) 
	 * 
	 */
	public abstract void creerConversation();
	
	public void supprimerConversation() {
		
		
	}
	
	
	
	
}
