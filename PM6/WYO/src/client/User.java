package client;

/**
 * Classe abstraite repr�sentant les utilisateurs.
 * @author louis
 *
 */
public abstract class User {
	protected int idUser;
	protected String loginUser;
	protected String passwordUser;
	protected String nomUser;
	protected String prenomUser;
	
	
	public int getId() {
		return this.idUser;
	}
	
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
	 */ 
	public String getPassword() {
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
	
	/**
	 * méthode mettant a jour l'id de l'utilisateur
	 * @param id : id du user
	 */
	public void setId(int id) {
		this.idUser  =id;
	}

}

