package client;

import java.util.ArrayList;

import database.ConnectionManager;

import java.sql.*;

/**
 * Classe abstraite reprï¿½sentant une conversation gï¿½nï¿½rale.
 * @author louis
 *
 */
public abstract class Conversation {
	Connection conn ;
	protected int idConversation;   
	protected String nomConversation;
	protected ArrayList<Message> listMsg; //liste contenant les messages de la conversation.	
	
	/**
	 * mï¿½thode retournant l'id de la conversation
	 * @return int idConversation
	 */
	public int getIdConversation() {
		return this.idConversation;
	}
	
	/**
	 * mï¿½thode retournant le nom de la conversation
	 * @return String nomConversation
	 */
	public String getNomConversation() {
		return this.nomConversation;
	}
	
	/**
	 * mï¿½thode retournant la liste des messages de la conversation
	 * @return ArrayList<Message>
	 */
	public ArrayList<Message> getListMsg(){
		return this.listMsg;
	}
	
	/**
	 * mï¿½thode mettant ï¿½ jour l'id de la conversation avec le paramï¿½tre.
	 * @param id
	 */
	public void setIdConversation(int id) {
		this.idConversation = id;
	}
	
	/**
	 * mï¿½thode mettant ï¿½ jour le nom de la conversation avec le paramï¿½tre.
	 * @param nomConversation
	 */
	public void setNomConversation(String nomConversation) {
		this.nomConversation = nomConversation;
	}
	
	/**
	 * mï¿½thode mettant ï¿½ jour la liste des messages de la conversation avec le paramï¿½tre.
	 * @param listMsg
	 */
	public void setListMsg(ArrayList<Message> listMsg) {
			this.listMsg = listMsg;
	}	
	
	/**
	 * mï¿½thode ajoutant les ï¿½lï¿½ments en paramï¿½tres dans la liste des messages de la conversation.  
	 * @param listMsg
	 */
	public void setListMsg(Message... listMsg) {
		for(int msg=0; msg<listMsg.length; msg++){
			this.listMsg.add(listMsg[msg]);

		}
	}
	
	/**
	 * Méthode permettant de supprimer une conversation de la base de donnée
	 */
	public void supprimerConversation() {
		// TODO Auto-generated method stub
	}


	/**
	 * Méthode permettant de supprimer une conversation de la base de données.
	 */
	public void creerConversation() {
		// TODO Auto-generated method stub
	}
}
