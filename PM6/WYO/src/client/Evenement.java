package client;

import java.util.*;

/**
 * Classe héritant de Publication, représente le concept d'Evenement.
 * @author louis
 *
 */
public class Evenement extends Publication{
	
	private int nbParticipants;
	private ArrayList<User> participants;	//liste des participants à l'evenement.
	
	
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
	 * Méthode ajoutant un utilisateur à la liste des participants de l'evenement.
	 * @param actualUser
	 */
	public void accepterEvent(User actualUser){
		participants.add(actualUser);
	}
	
	/**
	 * Méthode retirant un utilisateur de la liste des participants de l'evenement.
	 * @param actualUser
	 */
	public void refuserEvent(User actualUser){
		participants.remove(actualUser);
	}
}

