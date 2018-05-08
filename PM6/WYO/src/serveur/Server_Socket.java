package serveur;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server_Socket {

	private int port;
	private List<PrintStream> clients;
	private ServerSocket server;
// last think I m goine to code 
<<<<<<< HEAD
	/*public static void main(String[] args) throws IOException {
=======
	public static void main(String[] args) throws IOException {
>>>>>>> branch 'master' of https://github.com/louisreynaud/Projet-L3-Miage-Framework
		new Server_Socket(12345).run();
	}
<<<<<<< HEAD
*/
=======

>>>>>>> branch 'master' of https://github.com/louisreynaud/Projet-L3-Miage-Framework
	public Server_Socket(int port) {
		this.port = port;
		this.clients = new ArrayList<PrintStream>();
	}

	public void run() throws IOException {
		server = new ServerSocket(port) {
			protected void finalize() throws IOException {
				this.close();
			}
		};
		System.out.println("Port 12345 is now open.");

		while (true) {
			// accepts a new client
			Socket client = server.accept();
			System.out.println("Connection established with client: " + client.getInetAddress().getHostAddress());
			
			// add client message to list
			this.clients.add(new PrintStream(client.getOutputStream()));
			
			// create a new thread for client handling
			new Thread(new ClientHandler(this, client.getInputStream())).start();
		}
	}

	void broadcastMessages(String msg) {
		for (PrintStream client : this.clients) {
			client.println(msg);
		}
	}
}

class ClientHandler implements Runnable {

	private Server_Socket server;
	private InputStream client;

	public ClientHandler(Server_Socket server, InputStream client) {
		this.server = server;
		this.client = client;
	}

	@Override
	public void run() {
		String message;
		
		// when there is a new message, broadcast to all
		Scanner sc = new Scanner(this.client);
		while (sc.hasNextLine()) {
			message = sc.nextLine();
			server.broadcastMessages(message);
		}
		sc.close();
	}
}
