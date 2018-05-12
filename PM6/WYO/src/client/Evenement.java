package client;

import java.util.*;

/**
 * Classe h�ritant de Publication, repr�sente le concept d'Evenement.
 * @author louis
 *
 */
public class Evenement extends Publication{
	
	private int nbParticipants;
	private int participe;
	private ArrayList<User> participants;	//liste des participants � l'evenement.
	
	
	/**
	 * Constructeur de la classe.
	 * @param id
	 * @param titre
	 * @param nbParticipants
	 * @param description
	 */
	public Evenement(int id, String titre, int nbParticipants, String description){
		setId(id);
		setTitre(titre);
		setDescription(description);
		this.nbParticipants = nbParticipants;
	}
	
	public Evenement (String titre, String desc, boolean p )
	{
		this.titrePublication = titre;
		this.descriptionPublication = desc;
		if (p == true) { this.setParticipe(1);}
		else {this.setParticipe(0);}			
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

	public int getParticipe() {
		return participe;
	}

	public void setParticipe(int participe) {
		this.participe = participe;
	}

}

