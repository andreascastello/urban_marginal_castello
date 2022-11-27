package controleur;

import vue.Arene;
import vue.ChoixJoueur;
import vue.EntreeJeu;

import java.net.ServerSocket;
import java.nio.file.ClosedFileSystemException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;
/**
 * @author Andréas CASTELLO
 * @version 1
 * Controle
 * date : 30/09/2021
 */

public class Controle implements Global{
	
	// propriérés
	private EntreeJeu frmEntreeJeu;
	private Jeu leJeu;
	private Arene frmArene;
	private ChoixJoueur frmChoixJoueur;
	private Connection connection;
	// demarrage
	public static void main(String[] args) {
		new Controle();
	}

	// constructeur
	private Controle() {
		this.frmEntreeJeu = new EntreeJeu(this);
		this.frmEntreeJeu.setVisible(true);
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
		if (leJeu instanceof JeuServeur) {
			leJeu.setConnection(connection);
		}
	}
	
	public void receptionInfo (Connection connection,Object info) {
		leJeu.reception(connection, info);
	}
	/* -----------------------------------------------EVENEMENT VUE--------------------------------------------------*/
	
	public void evenementVue(JFrame uneFrame, Object info) {
		if(uneFrame instanceof EntreeJeu){
			evenementEntreeJeu(info);
		}
		if (uneFrame instanceof ChoixJoueur) {
			evenementChoixJoueur(info);
		}
	}

	private void evenementChoixJoueur(Object info) {
		((JeuClient)leJeu).envoi(connection, info);
		frmChoixJoueur.dispose();
		frmArene.setVisible(true);	
	}

	private void evenementEntreeJeu(Object info) {
		if ((String)info == "serveur") {
			new ServeurSocket(this, PORT);
			
			// choix serveur
			this.leJeu = new JeuServeur(this);
			this.frmEntreeJeu.dispose();
			
			// lancement de l'arene
			this.frmArene = new Arene();
			// on place 20 murs aleatoires
			((JeuServeur)leJeu).constructionMurs(); //P52 gestion des joueurs
			this.frmArene.setVisible(true);
		}
		else {
			if ((new ClientSocket((String)info, PORT, this)).isConnexionOk()) {
				// choix client
				this.leJeu = new JeuClient(this);
				leJeu.setConnection(connection);
				this.frmEntreeJeu.dispose();
				
				// lancement de l'arene
				this.frmArene = new Arene();
				
				// nouveau joueur
				this.frmChoixJoueur = new ChoixJoueur(this);
				this.frmChoixJoueur.setVisible(true);
			}
		}
	}
	/* ---------------------------------------------EVENEMENT MODELE-------------------------------------------------*/
	public void evenementJeuServeur(String ordre, Object info) {
		if (ordre == "ajout mur") {
			frmArene.ajoutMur((JLabel)info);
		}
		else if (ordre == "envoi panel murs") {
			((JeuServeur)leJeu).envoi(((Connection)info), frmArene.getJPanel());
		}
	}
	
	public void evenementJeuClient(String ordre, Object info) {
		if (ordre == "envoi panel murs") {
			frmArene.ajoutPanelMurs((JPanel)info);
		}
	}
	
	public void evenementModele (Object unJeu, String ordre, Object info) {
		if (unJeu instanceof JeuServeur) {
			// serveur
			evenementJeuServeur(ordre,info);
		}
		else if (unJeu instanceof JeuClient) {
			// client
			evenementJeuClient(ordre,info);
		}
	}
	
	
}