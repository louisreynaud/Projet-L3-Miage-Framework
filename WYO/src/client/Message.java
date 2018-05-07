package client;

public class Message {

	//private final int idMessage;
	private String libMessage;
	private String corpsMessage;
	
	public Message(String lib, String corps) {

		//SELECT MAX(id_msg) FROM message
		
		this.libMessage = lib;
		this.corpsMessage = corps;
	}
	
	/*
	public void ajouterMessage(String lib, String corps) {
		// INSERT INTO Message (lib, corps) VALUES this.libMessage, this.corpsMessage;
		// ^ QUOTER tous les éléments String !!!
		
		
	}
	*/
	/*
	public void supprimerMessage(int id) {
		// DELETE FROM Message WHERE id = id;
		
	}
	*/

/*
	public int getId() {
		return idMessage;
	}
*/

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
