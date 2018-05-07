package client;

import java.util.ArrayList;

public class Groupe {
	
	private ArrayList<String> list_id_user;
	
	private int id_groupe;
	
	private String nom_groupe;
	
	public Groupe(int id, String nom, String id_createur){
		this.id_groupe = id;
		this.nom_groupe = nom;
		ajouter_user(id_createur);
	}
	
	public void ajouter_user(String id_user){
		this.list_id_user.add(id_user);
	}
	
	public void retirer_user(String id_user){
		this.list_id_user.remove(id_user);
	}

}
