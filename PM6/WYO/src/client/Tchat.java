package client;


public class Tchat extends Conversation {
	
	private User u1;
	private User u2;

	public Tchat(int id, String nom, User u1, User u2) {
		super(id, nom);
		this.u1 = u1;
		this.u2 = u2;
		
	}



	@Override
	public void supprimerConversation() {
		// TODO Auto-generated method stub
	}



	@Override
	public void creerConversation() {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
