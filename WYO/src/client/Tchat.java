package client;


public class Tchat extends Conversation {
	
	private User u1;
	private User u2;

	public Tchat(String nom, User u1, User u2) {
		super(nom);
		this.u1 = u1;
		this.u2 = u2;
		
	}



	@Override
	public void supprimerConversation() {
		// TODO Auto-generated method stub
	}


	
	
	

}
