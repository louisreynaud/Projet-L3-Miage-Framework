package client;

import java.util.ArrayList;

/**
 * Classe h�ritant de Publication. Repr�sente les topics.
 * @author louis
 *
 */
public class Topic extends Publication {
	
	/**
	 * Constructeur de la classe.
	 * @param id
	 * @param nom
	 * @param description
	 * @param listMSG
	 */
	public Topic(int id, String titre, String description, ArrayList<Message> listMSG){
		setId(id);
		setTitre(titre);
		setDescription(description);
		this.setListMsg(listMsg);
	}
	
}
