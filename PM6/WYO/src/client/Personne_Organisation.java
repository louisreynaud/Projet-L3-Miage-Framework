package client;

/**
 * Classe h�ritant de User. Repr�sente un utilisateur membre d'une organisation.
 * @author louis
 *
 */
public class Personne_Organisation extends User {
	protected int organisation;
	
	/**
	 * Constructeur de la classe.
	 * @param login
	 * @param password
	 * @param nom
	 * @param prenom
	 * @param org
	 */
	public Personne_Organisation(String login, String password, String nom, String prenom,int org) {

		this.loginUser = login;
		this.passwordUser = password;
		this.nomUser = nom;
		this.prenomUser = prenom ;
		this.organisation = org;
	}
	/**
	 * M�thode retournant le nom de l'organisation.
	 * @return
	 */
	public int getOrganisation() {
		return organisation;
	}
	
	/**
	 * M�thode mettant � jour le nom de l'organisation.
	 * @param org
	 */
	public void setOrganisation(int org) {
		this.organisation = org;
	}

	
}
