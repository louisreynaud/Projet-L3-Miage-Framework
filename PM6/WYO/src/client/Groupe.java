
package client;

import java.util.ArrayList;

/**
 * Classe repr�sentant des groupes d'utilisateurs.
 *
 */
public class Groupe {
	
	protected ArrayList<User> list_user;	// liste des utilisateurs membres du groupe.
	protected int id_groupe;
	protected String nom_groupe;
	protected User createur;
	/**
	 * Constructeur de la classe
	 * @param id
	 * @param nom
	 * @param login_createur
	 */
	public Groupe (String nom, User createur){
		this.nom_groupe = nom;
		this.createur = createur;
	}
	
	/**
	 * M�thode ajoutant un utilisateur � la liste des utilisateurs du groupe.
	 * @param login_user
	 */
	public void ajouter_user(User login_user){
		this.list_user.add(login_user);
	}
	
	/**
	 * M�thode retirant un utilisateur de la liste des utilisateurs du groupe.
	 * @param login_user
	 */
	public void retirer_user(User login_user){
		this.list_user.remove(login_user);
	}
	
	public int getIdGroupe() {return this.id_groupe;}
	public String getNomGroupe() {return this.nom_groupe;}
	public User getCreateur() {return this.createur;}
	public void setNomGroupe(String n) {this.nom_groupe = n;}
	public void setCreateurGroupe(User u) {this.createur = u;}
}
