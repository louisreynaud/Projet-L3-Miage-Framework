package client;

import java.util.ArrayList;

/**
 * Classe h�ritant de Conversation. Repr�sente un tchat entre deux utilisateurs.
 * @author louis
 *
 */
public class Tchat extends Conversation {
	
	private User u1; // utilisateur cr�ateur de la conversation. Autrement dit l'exp�diteur du premier message.
	private User u2; // Utilisateur ajout� � la conversation.

	/**
	 * Constructeur de la classe.
	 * @param id
	 * @param nom
	 * @param u1
	 * @param u2
	 */
	public Tchat(int id, String nom, User u1, User u2) {
		this.setIdConversation(id);
		this.setNomConversation(nom);
		this.setListMsg(new ArrayList<Message>());
		this.u1 = u1;
		this.u2 = u2;
		
	}

}
