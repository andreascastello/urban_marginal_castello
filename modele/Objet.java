package modele;

import javax.swing.ImageIcon;

/**
 * @author Andréas CASTELLO
 * @version 1
 * Objet
 * date : 19/10/2021
 */
public abstract class Objet {
		
	// propriétés
		protected Integer posX,posY;
		protected Label label;
		
	// Getters
		public Integer getPosX() {
			return posX;
		}
		
		public Integer getPosY() {
			return posY;
		}
		
		public Label getLabel() {
			return label;
		}
		
		/**
		* contrôle si l'objet actuel touche l'objet passé en paramètre
		* @param objet
		* @return vrai si les 2 objets se touchent
		*/
		public boolean toucheObjet (Objet objet) {
			if (objet.label==null) {
				return false ;
			}else{
				if (objet.label.getjLabel()==null) {
					return false ;
				}else{
					int l_obj = objet.label.getjLabel().getWidth() ;
					int h_obj = objet.label.getjLabel().getHeight() ;
					int l_this = this.label.getjLabel().getWidth() ;
					int h_this = this.label.getjLabel().getHeight() ;
					return(!((this.posX+l_this<objet.posX ||
							  this.posX>objet.posX+l_obj) || 
							 (this.posY+h_this<objet.posY ||
							 this.posY>objet.posY+h_obj))) ;
					}
			}
		}
}
