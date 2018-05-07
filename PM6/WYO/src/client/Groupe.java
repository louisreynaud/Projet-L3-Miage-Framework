package client;

import java.util.ArrayList;

public class Groupe {
	
	private ArrayList<Integer> list_id_user;
	
	private int id_groupe;
	
	private String nom_groupe;
	
	public Groupe(int id, String nom, int id_createur){
		this.id_groupe = id;
		this.nom_groupe = nom;
		ajouter_user(id_createur);
	}
	
	public void ajouter_user(int id_user){
		this.list_id_user.add(id_user);
	}
	
	public void retirer_user(int id_user){
		this.list_id_user.remove(id_user);
	}

}
