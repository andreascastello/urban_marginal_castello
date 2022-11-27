package modele;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.AttributeSet.FontAttribute;
import java.awt.Font;

import modele.Label;
import outils.connexion.Connection;
import vue.ChoixJoueur;
import controleur.Global;
import modele.JeuServeur;
/**
 * @author Andréas CASTELLO
 * @version 1
 * Controle
 * date : 30/09/2021
 */

public class Joueur extends Objet implements Global{
	
	// propriétés
	private String pseudo;
	private int numPerso;
	private Label messages;
	
	// Constructeur
	public Joueur() {
		
	}
	
	public void initPerso(String pseudo, int numPerso, Hashtable<Connection, Joueur> lesJoueurs, ArrayList<Mur> lesMurs) {
		this.pseudo = pseudo;
		this.numPerso = numPerso;
		
		//label
		Label label = new Label(Label.getNbLabel(), new JLabel());
		Label.setNbLabel(Label.getNbLabel()+1);
		label.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
		label.getjLabel().setVerticalAlignment(SwingConstants.CENTER);
		
		//message
		messages = new Label(Label.getNbLabel(), new JLabel());
		Label.setNbLabel(Label.getNbLabel()+1);
		messages.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
		messages.getjLabel().setFont(new Font("Dialog", Font.PLAIN,8));
		premierePosition(lesJoueurs, lesMurs);
	}

	public Label getMessages() {
		return messages;
	}
	
	private Boolean toucheJoueur(Hashtable<Connection, Joueur> lesJoueurs){
		for (Joueur unJoueur : lesJoueurs.values()) {
			if(!unJoueur.equals(this)){
				//gestion des collisions entre les joueurs
				if(toucheObjet(unJoueur)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private Boolean toucheMur(ArrayList<Mur> lesMurs) {
		for (Mur unMur : lesMurs) {
			if(toucheObjet(unMur)) {
				//gestion des collisions avec les murs
				return true;
			}
		}
		return false;
	}
	
	private void premierePosition (Hashtable<Connection, Joueur> lesJoueurs, ArrayList<Mur> lesMurs) {
		for (Joueur unJoueur : lesJoueurs.values()) {
			if(!unJoueur.equals(this)){
				//generation aleatoire des joueurs
				unJoueur.getLabel().getjLabel().setBounds(0, 0, L_PERSO, H_PERSO);
				do {
					posX = (int) Math.round(Math.random() * (L_ARENE - L_PERSO));
					posY = (int) Math.round(Math.random() * (H_ARENE - H_PERSO - H_MESSAGE));
				} while(unJoueur.toucheJoueur(lesJoueurs) || unJoueur.toucheMur(lesMurs));
			}
		}
	}
}
