package client;

public class Personne_Organisation extends User {
	protected String nomOrganisation;
	
	public Personne_Organisation(String login, String password, String nom, String prenom,String org) {
		this.loginUser = login;
		this.passwordUser = password;
		this.nomUser = nom;
		this.prenomUser = prenom ;
		this.setNomOrganisation(org);
	}

	public String getNomOrganisation() {
		return nomOrganisation;
	}

	public void setNomOrganisation(String nomOrganisation) {
		this.nomOrganisation = nomOrganisation;
	}

	
}
