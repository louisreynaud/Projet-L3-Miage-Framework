package client;
import java.sql.*;

/**
 * Classe représentant le concept de message. Ils sont composés d'un id, d'un libellé, d'un corps, d'une date d'envoi et d'un auteur.
 * @author louis
 *
 */
public class Message {

	private /*final*/ int idMessage;
	private String libMessage;
	private String corpsMessage;
	private Date date_envoi;
	private User auteur;
	
	/**
	 * Constructeur de la classe.
	 * @param libMsg
	 * @param corpsMsg
	 * @param dateMsg
	 * @param u
	 */
	public Message(String libMsg, String corpsMsg, Date dateMsg, User u){
		this.libMessage = libMsg;
		this.corpsMessage = corpsMsg;
		this.date_envoi = dateMsg;
		this.auteur = u;
	}
	
	/**
	 * Méthode retournant le libellé du message.
	 * @return
	 */
	public String getLib() {
		return libMessage;
	}
	
	/**
	 * Méthode retournant le corps du message.
	 * @return
	 */
	public String getCorps() {	
		return corpsMessage;
	}
	
	/**
	 * Méthode retournant le date d'envoi du message.
	 * @return
	 */
	public Date getDate_envoi() {
		return date_envoi;
	}
	
	/**
	 * Méthode retournant l'auteur du message.
	 * @return
	 */
	public User getAuteur() {
		return this.auteur;
	}
	
	/**
	 * Méthode mettant à jour le libellé du message.
	 * @param libMessage
	 */
	public void setLib(String libMessage) {
		this.libMessage = libMessage;
	}
	
	/**
	 * Méthode mettant à jour le corps du message.
	 * @param corpsMessage
	 */
	public void setCorps(String corpsMessage) {	
		this.corpsMessage = corpsMessage;
	}
	
	/**
	 * Méthode mettant à jour la date d'envoi du message.
	 * @param date_envoi
	 */
	public void setDate_envoi(Date date_envoi) {
		this.date_envoi = date_envoi;
	}
	
	/**
	 * Méthode mettant à jour l'auteur du message.
	 * @param a
	 */
	public void setAuteur(User a) {
		this.auteur = a ;
	}	
}
