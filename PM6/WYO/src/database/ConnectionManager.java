package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import client.Groupe_Organisation;
import client.Message;
import client.Personne_Admin;
import client.Personne_Organisation;
import client.Personne_Publique;
import client.Tchat;
import client.User;

public class ConnectionManager {
	/**
	 * Méthode permet la connexion à la base de données
	 * @return Connection
	 */
	public static Connection DbConnector()
    {   
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/lenovo/git/Projet-L3-Miage-Framework/PM6/WYO/cisdatabase.sqlite3");
            return conn;   
            }catch(Exception e){
                System.out.println(e);
              return null;
                }        
    }
	/**
	 * Méthode permet d'ajouter un message à la base de données.
	 * @param msg  de type Message
	 * @param conn de type Connection
	 */
	public static void AddMsg_db(Message msg,Connection conn) {
		conn = ConnectionManager.DbConnector();
		PreparedStatement pst = null;
		String query="insert into Message (lib_msg,corps_msg,date_envoi,id_user) values (? , ? , ? , ?);";
	    try{
            pst = conn.prepareStatement(query);
            pst.setString(1, msg.getLib());
            pst.setString(2, msg.getCorps());
            pst.setString(3, msg.getDate_envoi().toString());
            pst.setInt(5, msg.getAuteur().getId());
            pst.executeUpdate();
            conn.close();
            System.out.println("Message ajouté dans la base");
        }catch(Exception e){System.out.println("Erreur d'ajout dans la base, l'Exception est : " + e.getMessage());}
	}
	/**
	 * Méthode permet d'ajouter un Tchat dans la base de données.
	 * @param tchat
	 * @param conn
	 */
	
	public static void AddTchat_db(Tchat tchat,Connection conn) {
		conn = ConnectionManager.DbConnector();
		PreparedStatement pst = null;
	    String query="insert into Tchat (id_user1, id_user2) values (? , ?);";
	    try{
            pst = conn.prepareStatement(query);
            pst.setInt(1, tchat.getU1().getId());
            pst.setInt(2, tchat.getU2().getId());
            pst.executeUpdate();
            conn.close();
            System.out.println("Tchat ajouté dans la base");
        }catch(Exception e){System.out.println("Erreur dans la base, l'Exception est : " + e.getMessage());}
	}
	
	/**
	 * Méthode permet d'enregistrer les échanges de messages dans un tchat
	 * @param tchat
	 * @param msg
	 * @param conn
	 */
	public static void AddEchangeTchat_db(Tchat tchat,Message msg, Connection conn){
		conn = ConnectionManager.DbConnector();
		PreparedStatement pst = null;
	    String query="insert into EchangeTchat (id_tchat, id_msg) values (? , ?);";
	    try{
            pst = conn.prepareStatement(query);
            pst.setInt(1, tchat.getIdConversation());
            pst.setInt(2, msg.getIdMessage());
            pst.executeUpdate();
            conn.close();
            System.out.println("Echange ajouté dans la base");
        }catch(Exception e){System.out.println("Erreur d'ajout dans la base, l'Exception est : " + e.getMessage());}
		
	}
	
	/**
	 * Méthode permet d'ajouter une personne publique dans la base de données.
	 * @param pp de type Personne_Publique
	 * @param conn
	 */
	public static void AddUserPublic_bd(Personne_Publique pp, Connection conn) {
		conn = ConnectionManager.DbConnector();
		PreparedStatement pst = null;
		ResultSet rs;
		int id;
	    String query="insert into Utilisateur (nom_user, prenom_user, login, mot_de_passe) values (?, ? , ? , ?);";
	    try{
	    	 pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, pp.getNom());
            pst.setString(2, pp.getPrenom());
            pst.setString(3, pp.getLogin());
            pst.setString(4, pp.getPassword());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
            	id = rs.getInt(1);
            	AddUserPublicto_bd(id, conn);
            }else {System.out.println("out of boundries!!!!");}
            rs.close();
            pst.close();
            conn.close();
            System.out.println("User ajouté dans la table Utilisateur");
        }catch(Exception e){System.out.println("Erreur d'ajout dans la base, l'Exception est : " + e.getMessage());}
	}
	
	/**
	 * Méthode utilisé pour récupérer l'id et l'enregistrer parmis les personne publique
	 * @param id : Id de l'utilisateur
	 * @param conn
	 */
	public static void AddUserPublicto_bd(int id,Connection conn)
	{
		PreparedStatement pst = null;
		try{
            pst = conn.prepareStatement("insert into Utilisateur_Publique (id_user) values (?);");
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("User ajouté dans la table Utilisateur_Publique");
        }catch(Exception e){System.out.println("Erreur d'ajout dans la base des user pub, l'Exception est : " + e.toString());}
	}
	/**
	 * Méthode permet d'ajouter une personne publique dans la base de données.
	 * @param po de type Personne_Organisation
	 * @param conn
	 */
	public static void AddUserOrganisation_bd(Personne_Organisation po, Connection conn) {
		conn = ConnectionManager.DbConnector();
		PreparedStatement pst = null;
		ResultSet rs;
		int id;
	    String query="insert into Utilisateur (nom_user, prenom_user, login, mot_de_passe) values (? , ?, ? , ? );";
	    try{
	    	 pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, po.getNom());
            pst.setString(2, po.getPrenom());
            pst.setString(3, po.getLogin());
            pst.setString(4, po.getPassword());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
            	id = rs.getInt(1);
            	AddUserOrgto_bd(id, po.getOrganisation(),conn);
            }else {System.out.println("out of boundries!!!!");}
            rs.close();
            pst.close();
            conn.close();
            System.out.println("User ajouté dans la table Utilisateur");
        }catch(Exception e){System.out.println("Erreur d'ajout dans la base, l'Exception est : " + e.getMessage());}
	}
	
	/**
	 * Méthode utilisé pour récupérer l'id et l'enregistrer parmis les personne Admin
	 * @param id : Id de l'utilisateur
	 * @param conn
	 */
	public static void AddUserOrgto_bd(int id, int org , Connection conn)
	{
		PreparedStatement pst = null;
		try{
            pst = conn.prepareStatement("insert into Utilisateur_Organisation (id_user,id_organisation) values ( ? , ? );");
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("User ajouté dans la table Utilisateur Organisation ");
        }catch(Exception e){System.out.println("Erreur d'ajout dans la base des user Org, l'Exception est : " + e.toString());}
	}
	public static void AddUserAdmin_bd(Personne_Admin pa, Connection conn) {
		conn = ConnectionManager.DbConnector();
		PreparedStatement pst = null;
		ResultSet rs;
		int id;
	    String query="insert into Utilisateur (nom_user, prenom_user, login, mot_de_passe) values (? , ?, ? , ? );";
	    try{
	    	 pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, pa.getNom());
            pst.setString(2, pa.getPrenom());
            pst.setString(3, pa.getLogin());
            pst.setString(4, pa.getPassword());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
            	id = rs.getInt(1);
            	AddUserAdminto_bd(id, pa.getOrganisation(),conn);
            }else {System.out.println("out of boundries!!!!");}
            rs.close();
            pst.close();
            conn.close();
            System.out.println("User ajouté dans la table Utilisateur");
        }catch(Exception e){System.out.println("Erreur d'ajout dans la base, l'Exception est : " + e.getMessage());}
	}
	
	/**
	 * Méthode utilisé pour récupérer l'id et l'enregistrer parmis les personne Admin
	 * @param id : Id de l'utilisateur
	 * @param conn
	 */
	public static void AddUserAdminto_bd(int id, int org , Connection conn)
	{
		PreparedStatement pst = null;
		try{
            pst = conn.prepareStatement("insert into Utilisateur_Admin (id_user,id_organisation) values ( ? , ? );");
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("User ajouté dans la table Utilisateur Admin ");
        }catch(Exception e){System.out.println("Erreur d'ajout dans la base des user Admin, l'Exception est : " + e.toString());}
	}

	/**
	 * Méthode utilisé pour modifier un utilisateur quelconque
	 * @param id : Id de l'utilisateur
	 * @param conn
	 */
	public static void ModifyUserto_bd(User u,Connection conn)
	{
		PreparedStatement pst = null;
		try{
            pst = conn.prepareStatement("update utilisateur set nom_user = ?, prenom_user = ?, login = ?, mot_de_passe = ? where id_user = ?;");
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setString(3, u.getLogin());
            pst.setString(4, u.getPassword());
            pst.setInt(5, u.getId());
            pst.executeUpdate();
            System.out.println("User modifi� dans la table Utilisateur");
        }catch(Exception e){System.out.println("Erreur modification dans la base des user, l'Exception est : " + e.toString());}
	}
	

	/**
	 * Méthode utilisé pour modifier une organisation
	 * @param id : Id de l'utilisateur
	 * @param conn
	 */
	public static void ModifyOrganisationto_bd(Groupe_Organisation grp,Connection conn)
	{
		PreparedStatement pst = null;
		try{
            pst = conn.prepareStatement("update organisation set nom_groupe = ? where id_organisation = ?;");
            pst.setString(1, grp.getNom_groupe());
            pst.setInt(2, grp.getId_groupe());
            pst.executeUpdate();
            System.out.println("Grp modifi� dans la table Organisation");
        }catch(Exception e){System.out.println("Erreur modification dans la base des organisations, l'Exception est : " + e.toString());}
	}
	
	

	/**
	 * Méthode utilisé pour supprimer un utilisateur quelconque donn�
	 * @param id : Id de l'utilisateur
	 * @param conn
	 */
	public static void DeleteUserto_bd(User u,Connection conn)
	{
		PreparedStatement pst = null;
		try{
            pst = conn.prepareStatement("delete from utilisateur where id_user = ?;");
            pst.setInt(1, u.getId());
            pst.executeUpdate();
            System.out.println("User supprim� dans la table Utilisateur");
        }catch(Exception e){System.out.println("Erreur suppression dans la base des user, l'Exception est : " + e.toString());}
	}

	
	
	/**
	 * Méthode utilisé pour supprimer une organisation donn�e
	 * @param id : Id de l'utilisateur
	 * @param conn
	 */
	public static void DeleteOrganisationto_bd(Groupe_Organisation grp,Connection conn)
	{
		PreparedStatement pst = null;
		try{
            pst = conn.prepareStatement("delete from organisation where id_organisation = ?;");

            pst.setInt(1, grp.getId_groupe());
            pst.executeUpdate();
            System.out.println("Grp supprim� dans la table Organisation");
        }catch(Exception e){System.out.println("Erreur suppression dans la base des organisations, l'Exception est : " + e.toString());}
	}
	

	/**
	 * Méthode utilisé pour s�lectionner tous les utilisateurs
	 * @param id : Id de l'utilisateur
	 * @param conn
	 */
	public static User[] SelectUsers_bd(Connection conn)
	{
		PreparedStatement pst = null;
		User[] users;
		int i=0;
		try{
            pst = conn.prepareStatement("select * from utilisateur;");
            ResultSet res = pst.executeQuery();
            users = new User[res.getFetchSize()];
            while(res.next()) {
            	users[res.getRow()] = (User) res.getObject(res.getRow());
            }
            
            System.out.println("Users s�lectionn�s dans la table Utilisateur");
            return users;
        }catch(Exception e){System.out.println("Erreur suppression dans la base des user, l'Exception est : " + e.toString());}
		return null;
	}
	
	
	/**
	 * Méthode utilisé pour s�lectionner toutes les organisations
	 * @param id : Id de l'utilisateur
	 * @param conn
	 */
	public static Groupe_Organisation[] SelectOrganisations_bd(Connection conn)
	{
		PreparedStatement pst = null;
		Groupe_Organisation[] orgs;
		int i=0;
		try{
            pst = conn.prepareStatement("select * from organisation;");
            ResultSet res = pst.executeQuery();
            orgs = new Groupe_Organisation[res.getFetchSize()];
            while(res.next()) {
            	orgs[res.getRow()] = (Groupe_Organisation) res.getObject(res.getRow());
            }
            
            System.out.println("Organisations s�lectionn�s dans la table Organisation");
            return orgs;
        }catch(Exception e){System.out.println("Erreur suppression dans la base des organisations, l'Exception est : " + e.toString());}
		return null;
	}
	
	
		

}
