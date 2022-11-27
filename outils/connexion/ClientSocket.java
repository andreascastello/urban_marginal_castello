package outils.connexion;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * @author Andréas CASTELLO
 * @version 1
 * ClientSocket
 * date : 01/10/2021
 */
public class ClientSocket {

	// properties
		boolean connexionOk;
	
	// constructor
	public ClientSocket(String ip, int port, Object leRecepteur) {
		connexionOk = false;
		
		try {
			Socket socket = new Socket(ip, port);
			System.out.println("Connexion au serveur réussi");
			connexionOk = true;
			new Connection(socket, leRecepteur);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Serveur non disponible");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "IP incorrecte");
		}
		
	}
	// getter return la connexion
	public boolean isConnexionOk() {
		return connexionOk;
	}
	
}
