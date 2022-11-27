package modele;

import java.io.Serializable;

import javax.swing.JLabel;

/**
 * @author Andréas CASTELLO
 * @version 1
 * Label
 * date : 19/10/2021
 */
public class Label implements Serializable{

	// propriétés
		private static Integer nbLabel;
		private Integer numLabel;
		private JLabel jLabel;
		
	// Getters
		public static Integer getNbLabel() {
			return nbLabel;
		}

		public Integer getNumLabel() {
			return numLabel;
		}

		public JLabel getjLabel() {
			return jLabel;
		}
	// Setters
		public static void setNbLabel(Integer nbLabel) {
			Label.nbLabel = nbLabel;
		}
		
	// constructeur
		public Label(Integer numLabel, JLabel jLabel) {
			this.numLabel = numLabel;
			this.jLabel = jLabel;
		}
		
}
