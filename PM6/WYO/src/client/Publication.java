package client;

public class Publication extends Conversation{

	private int idPublication;
	private String titrePublication;
	private String descriptionPublication;
	
	public Publication(int id, String nom, String description){
		this.idConversation = id;
		this.titrePublication = nom;
		this.descriptionPublication = description;
	}

}
