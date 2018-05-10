
package client;

import java.util.ArrayList;

/**
 * Classe représentant des groupes d'utilisateurs.
 * @author louis
 *
 */
public class Groupe {
	
	private ArrayList<User> list_user;	// liste des utilisateurs membres du groupe.
	
	private int id_groupe;
	
	private String nom_groupe;
	
	/**
	 * Constructeur de la classe
	 * @param id
	 * @param nom
	 * @param login_createur
	 */
	public Groupe(int id, String nom, User login_createur){
		this.id_groupe = id;
		this.nom_groupe = nom;
		ajouter_user(login_createur);
	}
	
	/**
	 * Méthode ajoutant un utilisateur à la liste des utilisateurs du groupe.
	 * @param login_user
	 */
	public void ajouter_user(User login_user){
		this.list_user.add(login_user);
	}
	
	/**
	 * Méthode retirant un utilisateur de la liste des utilisateurs du groupe.
	 * @param login_user
	 */
	public void retirer_user(User login_user){
		this.list_user.remove(login_user);
	}

}
