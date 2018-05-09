package serveur;

import client.ChatClient3IF;


/**
�* Une classe utilis�e par le programme serveur pour garder
�* D�tails des clients connect�s command�s
�* @author ESSAKKAY Nabil
�* Affectation RMI 
�*
�*/
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
