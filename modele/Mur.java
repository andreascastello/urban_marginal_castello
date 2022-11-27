package modele;
/**
 * @author Andréas CASTELLO
 * @version 1
 * Mur
 * date : 19/10/2021
 */

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Global;
import vue.Arene;

public class Mur extends Objet implements Global{

	// constructeur
	public Mur () {
		
	// position des murs aleatoires dans l'air de jeu
		super.posX = (int) Math.round(Math.random() * (L_ARENE - L_MURS));
		super.posY = (int) Math.round(Math.random() * (H_ARENE - H_MURS));
		
	// creation du jLabel avec : Alignement, position, taille et image 
		super.label = new Label(-1, new JLabel());
		super.label.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
		super.label.getjLabel().setVerticalAlignment(SwingConstants.CENTER);
		super.label.getjLabel().setBounds(posX, posY, L_MURS, H_MURS);
		super.label.getjLabel().setIcon(new ImageIcon(MUR));
	}
}
