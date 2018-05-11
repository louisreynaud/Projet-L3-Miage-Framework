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

<<<<<<< HEAD
	public Tchat(int id, User u1, User u2) {
=======
	/**
	 * Constructeur de la classe.
	 * @param id
	 * @param nom
	 * @param u1
	 * @param u2
	 */
	public Tchat(int id, String nom, User u1, User u2) {
>>>>>>> branch 'master' of https://github.com/louisreynaud/Projet-L3-Miage-Framework.git
		this.setIdConversation(id);
		this.setU1(u1);
		this.setU2(u2);	
	}
	public Tchat( User u1, User u2) {
		this.setU1(u1);
		this.setU2(u2);	
	}

<<<<<<< HEAD
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
	public void supprimerConversation() {
		// TODO Auto-generated method stub
	}
	public void creerConversation() {
		// TODO Auto-generated method stub
	}

=======
>>>>>>> branch 'master' of https://github.com/louisreynaud/Projet-L3-Miage-Framework.git
}

