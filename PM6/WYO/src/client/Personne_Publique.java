package client;

/**
 * Classe héritant de User. Représente une personne publique.
 * @author louis
 *
 */
public class Personne_Publique extends User {
	
	/**
	 * Constructeur de la classe. 
	 */
	public Personne_Publique(String login, String password, String nom, String prenom) {
		setLogin(login);
		setPassword(password);
		setNom(nom);
		setPrenom(prenom);
	}
}
