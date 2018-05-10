package database;

import java.sql.Connection;

public class testConnection {

	public testConnection() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Connection cnx = ConnectionManager.DbConnector();
		if (cnx == null)
		{System.out.println("KO");}
		else
		{System.out.println("OK");}

	}

}
