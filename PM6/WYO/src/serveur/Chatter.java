package serveur;

import client.ChatClient3IF;


/**
 * Une classe utilisée par le programme serveur pour garder
 * Détails des clients connectés commandés
 * @author ESSAKKAY Nabil
 * Affectation RMI 
 *
 */
public class Chatter {

	public String name;
	public ChatClient3IF client;
	
	//constructor
	public Chatter(String name, ChatClient3IF client){
		this.name = name;
		this.client = client;
	}

	
	//getters and setters
	public String getName(){
		return name;
	}
	public ChatClient3IF getClient(){
		return client;
	}
	
	
}
