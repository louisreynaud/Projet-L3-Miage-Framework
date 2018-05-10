package client;

import java.util.*;

/**
 * Classe h�ritant de Publication, repr�sente le concept d'Evenement.
 * @author louis
 *
 */
public class Evenement extends Publication{
	
	private int nbParticipants;
	private ArrayList<User> participants;	//liste des participants � l'evenement.
	
	
	/**
	 * Constructeur de la classe.
	 * @param id
	 * @param nom
	 * @param nbParticipants
	 * @param description
	 */
	public Evenement(int id, String nom, int nbParticipants, String description){
		super(id, nom, description);
		this.nbParticipants = nbParticipants;
	}
	
	/**
	 * M�thode ajoutant un utilisateur � la liste des participants de l'evenement.
	 * @param actualUser
	 */
	public void accepterEvent(User actualUser){
		participants.add(actualUser);
	}
	
	/**
	 * M�thode retirant un utilisateur de la liste des participants de l'evenement.
	 * @param actualUser
	 */
	public void refuserEvent(User actualUser){
		participants.remove(actualUser);
	}
}

