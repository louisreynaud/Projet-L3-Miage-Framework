package client;

import java.util.*;

public class Evenement extends Publication{
	
	private int nbParticipants;
	private ArrayList<User> participants;

	public Evenement(int id, String nom, int nbParticipants, String description){
		super(id, nom, description);
		this.nbParticipants = nbParticipants;
	}
	
	public void accepterEvent(User actualUser){
		participants.add(actualUser);
	}
	
	public void refuserEvent(User actualUser){
		participants.remove(actualUser);
	}
}

