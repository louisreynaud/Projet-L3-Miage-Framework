package client;

import java.util.ArrayList;

/**
 * Classe héritant de Conversation, ajoute la notion de groupe dans la conversation.
 * @author louis
 *
 */
public class Conversation_Groupe extends Conversation {
	
	private Groupe group;
	
	/**
	 * Constructeur de la classe.
	 * @param id
	 * @param nom
	 * @param g
	 */
	public Conversation_Groupe(int id, String nom, Groupe g) {
		this.setIdConversation(id);
		this.setNomConversation(nom);
		this.setListMsg(new ArrayList<Message>());
		this.group = g;
		creerConversation();
	}

}
