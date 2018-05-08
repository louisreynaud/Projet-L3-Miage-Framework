package client;

public class Message {

	private final int idMessage;
	private String libMessage;
	private String corpsMessage;
	
	public Message(String lib, String corps, int id) {
		//TODO
		//ADD ....
		//SELECT MAX(id_msg) FROM message
		this.idMessage = id;
		this.libMessage = lib;
		this.corpsMessage = corps;
		
	}
	
	
	public void creerMessage() {}
	public void supprimerMessage() {}


	public int getId() {
		return idMessage;
	}


	public String getLib() {
		return libMessage;
	}


	public void setLib(String libMessage) {
		this.libMessage = libMessage;
	}


	public String getCorps() {
		return corpsMessage;
	}


	public void setCorps(String corpsMessage) {
		this.corpsMessage = corpsMessage;
	}
	
	
}
