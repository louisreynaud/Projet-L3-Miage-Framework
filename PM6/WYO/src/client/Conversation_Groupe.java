package client;

import java.util.ArrayList;

/**
 * Classe h�ritant de Conversation, ajoute la notion de groupe dans la conversation.
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


	/**
	 * m�thode permettant de supprimer une conversation de groupe de la base de donn�es.
	 */
	public void supprimerConversation() {
			
	}
	
	/**
	 * m�thode permettant d'ajouter une conversation de groupe � la base de donn�es.
	 */
	public void creerConversation() {
		
	}

}
