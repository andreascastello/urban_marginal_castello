package modele;

import java.util.Set;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

import controleur.Controle;
import outils.connexion.Connection;

public abstract class Jeu{
	
	// propriétés
	protected Controle controle;
	
	// la reception d'une connection pour communiquer avec un ordi distant
	public abstract void setConnection(Connection connection);
	
	// la reception de l'information de un ordi distant
	public abstract void reception(Connection conneciton,Object info);
	
	// l'envoie de l'information a un ordi distant
	public void envoi(Connection conneciton,Object info) {
		conneciton.envoi(info);
	}
	
	// deconnection
	public abstract void deconnection(Connection connection);
}
