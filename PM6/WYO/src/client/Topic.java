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
	public Topic(int id, String titre, ArrayList<Message> listMSG){
		this.idPublication = id;
		this.titrePublication = titre;		
		this.setListMsg(listMsg);
	}
	public Topic(String titre, Personne_Organisation po){
		this.titrePublication = titre;
		this.po = po;
	}
}
