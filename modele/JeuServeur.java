package modele;

import java.util.ArrayList;
import java.util.Hashtable;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connection;

public class JeuServeur extends Jeu implements Global{
	
	//propriétés
	private ArrayList<Mur> lesMurs = new ArrayList<Mur>();
	private Hashtable<Connection, Joueur> lesJoueurs = new Hashtable<Connection, Joueur>();
	
	//constructeur
	public JeuServeur(Controle controle) {
		super.controle = controle;
		Label.setNbLabel(0);
	}
	
	public void constructionMurs() {
		for (Integer i = 0; i < NBMURS; i++) {
			lesMurs.add(new Mur());
			controle.evenementModele(this,"ajout mur", lesMurs.get(i).getLabel().getjLabel());
		}
	}
	
	@Override
	public void setConnection(Connection connection) {
		lesJoueurs.put(connection, new Joueur());
		controle.evenementModele(this, "envoi panel murs", connection);
	}

	@Override
	public void reception(Connection connection, Object info) {
		// decomposition de l'information sous forme de tableau
		String [] infos = ((String)info).split(SEPARE);
		switch (Integer.parseInt(infos[0])) {
			case PSEUDO:
				lesJoueurs.get(connection).initPerso(infos[1], Integer.parseInt(infos[2]),lesJoueurs,lesMurs);
				break;
		}
	}

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}
	
}
