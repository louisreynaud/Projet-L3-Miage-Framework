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
		this.setU1(u1);
		this.setU2(u2);	
	}
	public Tchat( User u1, User u2) {
		this.setU1(u1);
		this.setU2(u2);	
	}

	public User getU1() {
		return u1;
	}
	public void setU1(User u1) {
		this.u1 = u1;
	}
	public User getU2() {
		return u2;
	}
	public void setU2(User u2) {
		this.u2 = u2;
	}	
}

