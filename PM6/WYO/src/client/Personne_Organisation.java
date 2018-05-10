package client;

/**
 * Classe h�ritant de User. Repr�sente un utilisateur membre d'une organisation.
 * @author louis
 *
 */
public class Personne_Organisation extends User {
	protected String nomOrganisation;
	
	/**
	 * Constructeur de la classe.
	 * @param login
	 * @param password
	 * @param nom
	 * @param prenom
	 * @param org
	 */
	public Personne_Organisation(String login, String password, String nom, String prenom,String org) {
		this.loginUser = login;
		this.passwordUser = password;
		this.nomUser = nom;
		this.prenomUser = prenom ;
		this.setNomOrganisation(org);
	}
	
	/**
	 * M�thode retournant le nom de l'organisation.
	 * @return
	 */
	public String getNomOrganisation() {
		return nomOrganisation;
	}
	
	/**
	 * M�thode mettant � jour le nom de l'organisation.
	 * @param nomOrganisation
	 */
	public void setNomOrganisation(String nomOrganisation) {
		this.nomOrganisation = nomOrganisation;
	}

	
}
