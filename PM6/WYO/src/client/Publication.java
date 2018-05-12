package client;

/**
 * Classe h�ritant de Conversation. Repr�sente une Publication.
 * @author louis
 *
 */
public abstract class Publication extends Conversation{

	protected int idPublication;
	protected String titrePublication;
	protected String descriptionPublication;
	protected Personne_Organisation po;
	
	public int getIdPublication(){return this.idPublication;}
	
	public String getTitrePublication(){return this.titrePublication;}
	
	public String getDescriptionPublication(){return this.descriptionPublication;}
	
	public Personne_Organisation getAuteur() {return this.po;}
	
	public void setId(int id){this.idPublication = id;}
	
	public void setTitre(String titre){this.titrePublication = titre;}
	
	public void setDescription(String description){this.descriptionPublication = description;}
	 
	public void setAuteur(Personne_Organisation po) {this.po = po;}
}
