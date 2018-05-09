package client;

import java.util.ArrayList;

public class Groupe {
	
	private ArrayList<String> list_id_user;
	
	private int id_groupe;
	
	private String nom_groupe;
	
	public Groupe(int id, String nom, String login_createur){
		this.id_groupe = id;
		this.nom_groupe = nom;
		ajouter_user(login_createur);
	}
	
	public void ajouter_user(String login_user){
		this.list_id_user.add(login_user);
	}
	
	public void retirer_user(String login_user){
		this.list_id_user.remove(login_user);
	}

}
