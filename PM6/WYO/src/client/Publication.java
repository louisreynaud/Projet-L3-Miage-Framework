package client;

/**
 * Classe héritant de Conversation. Représente une Publication.
 * @author louis
 *
 */
public abstract class Publication extends Conversation{

	private int idPublication;
	private String titrePublication;
	private String descriptionPublication;
	
	public int getId(){return this.idPublication;}
	
	public String getTitre(){return this.titrePublication;}
	
	public String getDescription(){return this.descriptionPublication;}
	
	public void setId(int id){this.idPublication = id;}
	
	public void setTitre(String titre){this.titrePublication = titre;}
	
	public void setDescription(String description){this.descriptionPublication = description;}
	 
	
	
}
