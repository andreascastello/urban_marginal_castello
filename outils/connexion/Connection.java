package outils.connexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import controleur.Controle;

import javax.management.ObjectName;
import javax.swing.JOptionPane;

/**
 * @author Andréas CASTELLO
 * @version 1
 * Connection
 * date : 01/10/2021
 */

public class Connection extends Thread{
	
	// properties
	private Object leRecepteur;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	
	// constructor
	public Connection(Socket socket, Object leRecepteur) {
		this.leRecepteur = leRecepteur;
		
		// creation de canal de sortie pour envoyer les info
		try {
			this.out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("erreur de creation du canal out : "+e);
			System.exit(0);
		}
		
		// creation de canal d'entrée pour recevoir les info
		try {
			this.in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("erreur de creation du canal in : "+e);
			System.exit(0);
		}
		
		// demarrage du thread d'écoute attente d'un message
		this.start();
		
		//envoi de l'instance de connection vers le recepteur
		((controleur.Controle)this.leRecepteur).setConnection(this);
	}
	
	public void envoi(Object unObjet) {
		try {
			out.writeObject(unObjet);
			// vider le cash
			out.flush();
		} catch (IOException e) {
			System.out.println("erreur d'envoi sur le canal out : "+e);
		}
	}
	
	public void run (){
		Boolean inOK = true;
		Object reception;
		
		while(inOK) {
			try {
				reception = in.readObject();
				((controleur.Controle)this.leRecepteur).receptionInfo(this, reception);
			} catch (ClassNotFoundException e) {
				System.out.println("erreur de class reception : "+e);
				System.exit(0);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "l'ordinateur distant s'est déconnecté");
				inOK = false;
				
				try {
					in.close();
				} catch (IOException e1) {
					System.out.println("la fermeture du canal s'est mal passée : "+e);
				}
			}
		}
	}
	
}
