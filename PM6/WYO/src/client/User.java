package client;

/**
 * Classe abstraite représentant les utilisateurs.
 * @author louis
 *
 */
public abstract class User {
	
	protected String loginUser; // Login est un identifiant unique
	protected String passwordUser;
	protected String nomUser;
	protected String prenomUser;
	
	/**
	 * méthode retournant l'identifiant de l'utilisateur.
	 * @return
	 */
	public String getLogin() {
		return loginUser;
	}
	
	/**
	 * méthode retournant le mot de passe de l'utilisateur.
	 * @return
	 */ String getPassword() {
		return passwordUser;
	}
	
	/**
	 * méthode retournant le nom de l'utilisateur.
	 * @return
	 */
	public String getNom() {
		return nomUser;
	}
	
	/**
	 * méthode retournant le prénom de l'utilisateur.
	 * @return
	 */
	public String getPrenom() {
		return prenomUser;
	}
	
	/**
	 * méthode mettant à jour l'identifiant de l'utilisateur.
	 * @param login
	 */
	public void setLogin(String login) {
		this.loginUser = login;
	}
	
	/**
	 * méthode mettant à jour le mot de passe de l'utilisateur.
	 * @param password
	 */
	public void setPassword(String password) {
		this.passwordUser = password;
	}
	
	/**
	 * méthode mettant à jour le nom de l'utilisateur.
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nomUser = nom;
	}
	
	/**
	 * méthode mettant à jour le prénom de l'utilisateur.
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenomUser = prenom;
	}
}

