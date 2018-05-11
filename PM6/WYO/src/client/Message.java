package client;
import java.sql.*;

/**
 * Classe repr�sentant le concept de message. Ils sont compos�s d'un id, d'un libell�, d'un corps, d'une date d'envoi et d'un auteur.
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
	 * @param i 
	 * @param libMsg
	 * @param corpsMsg
	 * @param dateMsg
	 * @param u
	 */
	public Message(int i, String libMsg, String corpsMsg, Date dateMsg, User u){
		this.idMessage = i;
		this.libMessage = libMsg;
		this.corpsMessage = corpsMsg;
		this.date_envoi = dateMsg;
		this.auteur = u;
	}
	public Message( String libMsg, String corpsMsg, Date dateMsg, User u){
		this.libMessage = libMsg;
		this.corpsMessage = corpsMsg;
		this.date_envoi = dateMsg;
		this.auteur = u;
	}
	/**
	 * méthode retournant l'id du message
	 * @return id_message
	 */
	public int getIdMessage() {return this.idMessage;}
	/**
	 * méthode permet de mettre a jout l'id du message
	 * @param id
	 */
	public void setIdMessage(int id) {this.idMessage = id;}
	/**
	 * M�thode retournant le libell� du message.
	 * @return
	 */
	public String getLib() {
		return libMessage;
	}
	
	/**
	 * M�thode retournant le corps du message.
	 * @return
	 */
	public String getCorps() {	
		return corpsMessage;
	}
	
	/**
	 * M�thode retournant le date d'envoi du message.
	 * @return
	 */
	public Date getDate_envoi() {
		return date_envoi;
	}
	
	/**
	 * M�thode retournant l'auteur du message.
	 * @return
	 */
	public User getAuteur() {
		return this.auteur;
	}
	
	/**
	 * M�thode mettant � jour le libell� du message.
	 * @param libMessage
	 */
	public void setLib(String libMessage) {
		this.libMessage = libMessage;
	}
	
	/**
	 * M�thode mettant � jour le corps du message.
	 * @param corpsMessage
	 */
	public void setCorps(String corpsMessage) {	
		this.corpsMessage = corpsMessage;
	}
	
	/**
	 * M�thode mettant � jour la date d'envoi du message.
	 * @param date_envoi
	 */
	public void setDate_envoi(Date date_envoi) {
		this.date_envoi = date_envoi;
	}
	
	/**
	 * M�thode mettant � jour l'auteur du message.
	 * @param a
	 */
	public void setAuteur(User a) {
		this.auteur = a ;
	}	
}
