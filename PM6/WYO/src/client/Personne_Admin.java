package client;

/**
 * Classe h�ritant de Personne_Organisation. Repr�sente un Administrateur d'une organisation.
 * @author louis
 *
 */
public class Personne_Admin extends Personne_Organisation {

	/**
	 * Constructeur de la classe
	 * @param login
	 * @param password
	 * @param nom
	 * @param prenom
	 * @param org
	 */
	public Personne_Admin(String login, String password, String nom, String prenom, int org) {
		super(login, password, nom, prenom, org);
	}
	
}
	
