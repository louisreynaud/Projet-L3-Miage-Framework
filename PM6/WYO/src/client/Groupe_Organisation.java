package client;

/**
 * Classe héritant de Groupe, représente le concept de Groupe d'Organisation.
 * @author louis
 *
 */
public class Groupe_Organisation extends Groupe {

	/**
	 * Constructeur de la classe. 
	 * @param id
	 * @param nom
	 * @param login_createur
	 */
	public Groupe_Organisation(int id, String nom, Personne_Organisation login_createur) {
		super(id, nom, login_createur);
	}

}
