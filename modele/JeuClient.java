package modele;

import javax.swing.JPanel;

import controleur.Controle;
import outils.connexion.Connection;

public class JeuClient extends Jeu{
	private Connection connection;
	
	//constructeur
	public JeuClient(Controle controle) {
		super.controle = controle;
	}
	
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void reception(Connection connection, Object info) {
		if (info instanceof JPanel) {
			//affichage des murs coté client
			controle.evenementModele(this, "envoi panel murs", info);
		}
		
	}

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}

}
