package client;

import java.util.ArrayList;

/**
 * Classe héritant de Conversation. Représente un tchat entre deux utilisateurs.
 * @author louis
 *
 */
public class Tchat extends Conversation {
	
	private User u1; // utilisateur créateur de la conversation. Autrement dit l'expéditeur du premier message.
	private User u2; // Utilisateur ajouté à la conversation.

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
