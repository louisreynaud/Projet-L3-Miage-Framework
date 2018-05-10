package client;

import java.util.ArrayList;

/**
 * Classe abstraite représentant une conversation générale.
 * @author louis
 *
 */
public abstract class Conversation {

	protected int idConversation;   
	protected String nomConversation;
	protected ArrayList<Message> listMsg; //liste contenant les messages de la conversation.	
	
	/**
	 * méthode retournant l'id de la conversation
	 * @return int idConversation
	 */
	public int getIdConversation() {
		return this.idConversation;
	}
	
	/**
	 * méthode retournant le nom de la conversation
	 * @return String nomConversation
	 */
	public String getNomConversation() {
		return this.nomConversation;
	}
	
	/**
	 * méthode retournant la liste des messages de la conversation
	 * @return ArrayList<Message>
	 */
	public ArrayList<Message> getListMsg(){
		return this.listMsg;
	}
	
	/**
	 * méthode mettant à jour l'id de la conversation avec le paramètre.
	 * @param id
	 */
	public void setIdConversation(int id) {
		this.idConversation = id;
	}
	
	/**
	 * méthode mettant à jour le nom de la conversation avec le paramètre.
	 * @param nomConversation
	 */
	public void setNomConversation(String nomConversation) {
		this.nomConversation = nomConversation;
	}
	
	/**
	 * méthode mettant à jour la liste des messages de la conversation avec le paramètre.
	 * @param listMsg
	 */
	public void setListMsg(ArrayList<Message> listMsg) {
			this.listMsg = listMsg;
	}	
	
	/**
	 * méthode ajoutant les éléments en paramètres dans la liste des messages de la conversation.  
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
