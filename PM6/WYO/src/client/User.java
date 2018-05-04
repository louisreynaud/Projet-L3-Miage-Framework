package client;

public abstract class User {
	
	private String loginUser;
	private String passwordUser;
	private String nomUser;
	private String prenomUser;
	

	public String getLogin() {
		return loginUser;
	}

	public void setLogin(String login) {
		this.loginUser = login;
	}

	public String getPassword() {
		return passwordUser;
	}

	public void setPassword(String password) {
		this.passwordUser = password;
	}

	public String getNom() {
		return nomUser;
	}

	public void setNom(String nom) {
		this.nomUser = nom;
	}

	public String getPrenom() {
		return prenomUser;
	}

	public void setPrenom(String prenom) {
		this.prenomUser = prenom;
	}
	
	
	
	public  void seConnecter(){}
	
	public  void seDeconnecter(){}
	
	public void sInscrire(){}
	
	public abstract void modifierProfil();
	
	public abstract void cloreProfil();
	
	

}
