package client;

public abstract class User {
	protected String loginUser;
	protected String passwordUser;
	protected String nomUser;
	protected String prenomUser;
	public String getLogin() {return loginUser;}
	public String getPassword() {return passwordUser;}
	public String getNom() {return nomUser;}
	public String getPrenom() {return prenomUser;}
	public void setLogin(String login) {this.loginUser = login;}
	public void setPassword(String password) {this.passwordUser = password;}
	public void setNom(String nom) {this.nomUser = nom;}
	public void setPrenom(String prenom) {this.prenomUser = prenom;}		
}
