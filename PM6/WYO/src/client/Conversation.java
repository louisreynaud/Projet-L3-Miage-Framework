package client;

import java.util.ArrayList;

import database.ConnectionManager;

import java.sql.*;

/**
 * Classe abstraite repr�sentant une conversation g�n�rale.
 * @author louis
 *
 */
public abstract class Conversation {
	Connection conn ;
	protected int idConversation;   
	protected String nomConversation;
	protected ArrayList<Message> listMsg; //liste contenant les messages de la conversation.	
	
	/**
	 * m�thode retournant l'id de la conversation
	 * @return int idConversation
	 */
	public int getIdConversation() {
		return this.idConversation;
	}
	
	/**
	 * m�thode retournant le nom de la conversation
	 * @return String nomConversation
	 */
	public String getNomConversation() {
		return this.nomConversation;
	}
	
	/**
	 * m�thode retournant la liste des messages de la conversation
	 * @return ArrayList<Message>
	 */
	public ArrayList<Message> getListMsg(){
		return this.listMsg;
	}
	
	/**
	 * m�thode mettant � jour l'id de la conversation avec le param�tre.
	 * @param id
	 */
	public void setIdConversation(int id) {
		this.idConversation = id;
	}
	
	/**
	 * m�thode mettant � jour le nom de la conversation avec le param�tre.
	 * @param nomConversation
	 */
	public void setNomConversation(String nomConversation) {
		this.nomConversation = nomConversation;
	}
	
	/**
	 * m�thode mettant � jour la liste des messages de la conversation avec le param�tre.
	 * @param listMsg
	 */
	public void setListMsg(ArrayList<Message> listMsg) {
			this.listMsg = listMsg;
	}	
	
	/**
	 * m�thode ajoutant les �l�ments en param�tres dans la liste des messages de la conversation.  
	 * @param listMsg
	 */
	public void setListMsg(Message... listMsg) {
		for(int msg=0; msg<listMsg.length; msg++){
			this.listMsg.add(listMsg[msg]);
	}	

	}
}
