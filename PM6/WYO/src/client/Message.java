package client;
import java.sql.*;

public class Message {
	private String libMessage;
	private String corpsMessage;
	private Date date_envoi;
	private User auteur;
	
	
	public Message(String libMsg, String corpsMsg, Date dateMsg, User u){
		this.libMessage = libMsg;
		this.corpsMessage = corpsMsg;
		this.date_envoi = dateMsg;
		this.auteur = u;
	}
	
	public String getLib() {return libMessage;}
	public String getCorps() {	return corpsMessage;}
	public Date getDate_envoi() {return date_envoi;}	
	public User getAuteur() {return this.auteur;}
	public void setLib(String libMessage) {this.libMessage = libMessage;}
	public void setCorps(String corpsMessage) {	this.corpsMessage = corpsMessage;}
	public void setDate_envoi(Date date_envoi) {this.date_envoi = date_envoi;}
	public void setAuteur(User a) {this.auteur = a ;}	
}
