package client;

/**
 * Classe abstraite repr�sentant les utilisateurs.
 * @author louis
 *
 */
public abstract class User {
	
	protected String loginUser; // Login est un identifiant unique
	protected String passwordUser;
	protected String nomUser;
	protected String prenomUser;
	
	/**
	 * m�thode retournant l'identifiant de l'utilisateur.
	 * @return
	 */
	public String getLogin() {
		return loginUser;
	}
	
	/**
	 * m�thode retournant le mot de passe de l'utilisateur.
	 * @return
	 */ String getPassword() {
		return passwordUser;
	}
	
	/**
	 * m�thode retournant le nom de l'utilisateur.
	 * @return
	 */
	public String getNom() {
		return nomUser;
	}
	
	/**
	 * m�thode retournant le pr�nom de l'utilisateur.
	 * @return
	 */
	public String getPrenom() {
		return prenomUser;
	}
	
	/**
	 * m�thode mettant � jour l'identifiant de l'utilisateur.
	 * @param login
	 */
	public void setLogin(String login) {
		this.loginUser = login;
	}
	
	/**
	 * m�thode mettant � jour le mot de passe de l'utilisateur.
	 * @param password
	 */
	public void setPassword(String password) {
		this.passwordUser = password;
	}
	
	/**
	 * m�thode mettant � jour le nom de l'utilisateur.
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nomUser = nom;
	}
	
	/**
	 * m�thode mettant � jour le pr�nom de l'utilisateur.
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenomUser = prenom;
	}
}

