package controleur;

/**
 * @author Andréas CASTELLO
 * @version 1
 * Global
 * date : 07/10/2021
 */

public interface Global {
	
	//raccourcis pour le chemin
	public static final String
		SEPARATOR 		= "//",
		CHEMIN 			= "media" + SEPARATOR,
		CHEMINFONDS 	= CHEMIN + "fonds" + SEPARATOR,
		FONDCHOIX 		= CHEMINFONDS + "fondchoix.jpg",
		CHEMINPERSOS 	= CHEMIN + "personnages" + SEPARATOR,
		PERSO 			= CHEMINPERSOS + "perso",
		MARCHE 			= "marche",
		TOUCHE 			= "touche",
		MORT 			= "mort",
		SEPARE 			= "~",
		FONDARENE 		= CHEMINFONDS + "fondarene.jpg",
		CHEMINMURS		= CHEMIN + "murs" + SEPARATOR,
		MUR				= CHEMINMURS + "mur.gif"; // image du mur
	
	public static final int
		PORT 		= 6666,
		GAUCHE 		= 0,
		DROITE 		= 1,
		NBPERSOS 	= 3,
		H_PERSO 	= 44,
		L_PERSO 	= 39,
		PSEUDO 		= 0,
		H_ARENE 	= 600,
		L_ARENE 	= 800,
		H_CHAT 		= 200,
		H_SAISIE 	= 25,
		MARGE 		= 5, // écart entre les differents objets
		NBMURS 		= 20,
		H_MURS 		= 35,
		L_MURS 		= 34,
		H_MESSAGE	= 8;
}