package client;

import java.util.ArrayList;

public class Tchat extends Conversation {
	
	private User u1;
	private User u2;

	public Tchat(int id, User u1, User u2) {
		this.setIdConversation(id);
		this.setU1(u1);
		this.setU2(u2);	
	}
	public Tchat( User u1, User u2) {
		this.setU1(u1);
		this.setU2(u2);	
	}

	public User getU1() {
		return u1;
	}
	public void setU1(User u1) {
		this.u1 = u1;
	}
	public User getU2() {
		return u2;
	}
	public void setU2(User u2) {
		this.u2 = u2;
	}	
	public void supprimerConversation() {
		// TODO Auto-generated method stub
	}
	public void creerConversation() {
		// TODO Auto-generated method stub
	}

}

