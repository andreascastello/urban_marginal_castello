package outils.connexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author Andr�as CASTELLO
 * @version 1
 * ServeurSocket
 * date : 01/10/2021
 */

public class ServeurSocket extends Thread{

	// properties
	private Object leRecepteur;
	private ServerSocket serverSocket;
	
	// constructor
	public ServeurSocket (Object leRecepteur, int port) {
		
		//valorise le recepteur
		this.leRecepteur = leRecepteur;
		
		// creation de socket server d'�coute des clients
		try {
			this.serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("erreur grave cr�ation socket serveur : "+e);
			System.exit(0);
		}
		// d�marrage du thread d'�coute, attente d'un client
		this.start();
	}
	
	public void run() {
		Socket socket;
		
		while(true) {
			
			try {
				System.out.println("Le server attend...");
				socket = serverSocket.accept();
				System.out.println("Le client s'est connect� !");
				new Connection(socket, leRecepteur);
			} catch (IOException e) {
				System.out.println("erreur sur l'objet serverSocket : "+e);
				System.exit(0);
			}
		}
	}
}
