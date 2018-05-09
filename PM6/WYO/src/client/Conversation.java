package client;

import java.util.ArrayList;

public abstract class Conversation {
	protected int idConversation;
	protected String nomConversation;
	protected ArrayList<Message> listMsg;
	public int getIdConversation() {return this.idConversation;}
	public String getNomConversation() {return this.nomConversation;}
	public ArrayList<Message> getListMsg(){return this.listMsg;}
	public void setIdConversation(int id) {this.idConversation = id;}
	public void setNomConversation(String nomConversation) {this.nomConversation = nomConversation;}
	public void setListMsg(ArrayList<Message> listMsg) {this.listMsg = listMsg;}	
}
