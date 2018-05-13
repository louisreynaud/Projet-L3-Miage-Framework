package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import client.Message;
import client.Personne_Admin;
import client.Personne_Organisation;
import client.Personne_Publique;
import client.Tchat;
import client.User;
import client.Groupe_Organisation;

public class testConnection {

	public testConnection() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = null ;
		conn = ConnectionManager.DbConnector();
		if (conn == null)
		{System.out.println("Pas de connexion :(");}
		else
		{System.out.println("the link is good :D ");
		System.out.println(conn.toString());}
		Date d = new Date(5, 9, 2010);
		Personne_Admin u1 = new Personne_Admin("fafafafafaf", "123456", "daef","nass",1);
		Personne_Publique pp = new Personne_Publique("oihouh", "123456", "bourret","aurelien");
		//Tchat t = new Tchat(u1,u2);
		//Message msg = new Message("test","hello poto",d,u1);
		PreparedStatement pst = null;
		String query="insert into Utilisateur (nom_user, prenom_user, login, mot_de_passe) values (?, ? , ? , ? , ?);";
		int id_user = 0;
		//ConnectionManager.AddUserAdmin_bd(u1, conn);
		Groupe_Organisation o = new Groupe_Organisation ("Stark's Industries");
		//ConnectionManager.AddUserPublic_db(pp, conn);
		
		ArrayList<Personne_Organisation> users = ConnectionManager.SelectUsers_db();
		System.out.println(users.get(0).getLogin());
		//ConnectionManager.AddOrganisation_bd(o, conn);
		/*  try{
            pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, pp.getNom());
            pst.setString(2, pp.getPrenom());
            pst.setString(3, pp.getLogin());
            pst.setString(4, pp.getPassword());
            pst.executeUpdate();
            id_user = pst.getGeneratedKeys().getInt(1);
            conn.close();
            System.out.println("User ajouté dans la table Utilisateur" + " id du user est : " + id_user );
        }catch(Exception e){System.out.println("Erreur d'ajout dans la base, l'Exception est : " + e.getMessage());}		
		
		
		
	    //String query="insert into Message (lib_msg,corps_msg,date_envoi,id_user) values (? , ? , ? , ?);";
		
	    try{
            pst = conn.prepareStatement(query);
            pst.setString(1, msg.getLib());
            pst.setString(2, msg.getCorps());
            pst.setString(3, msg.getDate_envoi().toString());
            pst.setInt(4, msg.getAuteur().getId());
            pst.executeUpdate();
            conn.close();
            System.out.println("Message ajouté dans la base");
        }catch(Exception e){System.out.println("Erreur d'ajout du message dans la base, l'Exception est : " + e.getMessage());}*/
	}

}
	

