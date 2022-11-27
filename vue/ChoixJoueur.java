package vue;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;
import controleur.Global;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * @author Andréas CASTELLO
 * @version 1
 * Controle
 * date : 05/10/2021
 */
public class ChoixJoueur extends JFrame implements Global{

	private JPanel contentPane;
	private JTextField textPseudo;
	private Integer numPerso;
	private JLabel lblPersonnage;
	private Controle controle;
	
	private void affichePerso() {
		lblPersonnage.setIcon(new ImageIcon(PERSO + numPerso + MARCHE + 1 + "d" + DROITE + ".gif"));
	}
	
	private void lblPrecedent_clic() {
		numPerso = ((numPerso +1)%NBPERSOS)+1;
		affichePerso();
	}
	private void lblSuivant_clic() {
		numPerso = (numPerso%NBPERSOS)+1;
		affichePerso();
	}
	private void lblGo_clic() {
		if (textPseudo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Le Pseudo est obligatoire");
			textPseudo.requestFocus();
		}
		else {
			controle.evenementVue(this, PSEUDO + SEPARE + textPseudo.getText() + SEPARE + numPerso);
		}
	}
	
	private void souris_normal() {
		contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	private void souris_doigt() {
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * Create the frame.
	 */
	public ChoixJoueur(Controle controle){
		
		setTitle("choice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPrecedent_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				souris_normal();
			}
		});
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				souris_normal();
			}
		});
		
		lblPersonnage = new JLabel("");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(142, 113, 119, 124);
		contentPane.add(lblPersonnage);
		
		textPseudo = new JTextField();
		textPseudo.setBounds(142, 243, 119, 20);
		contentPane.add(textPseudo);
		textPseudo.setColumns(10);
		lblGo.setBounds(310, 197, 68, 66);
		contentPane.add(lblGo);
		
		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				souris_normal();
			}
		});
		lblSuivant.setBounds(290, 145, 46, 41);
		contentPane.add(lblSuivant);
		lblPrecedent.setBounds(55, 145, 46, 41);
		contentPane.add(lblPrecedent);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275);
		lblFond.setIcon(new ImageIcon(FONDCHOIX));
		contentPane.add(lblFond);
		
		//focus sur la zone de txt
		textPseudo.requestFocus();
		
		//valorisation de controle
			this.controle = controle;
			
		//initialisation et affichage d'un personnage
		numPerso = 1;
		affichePerso();
	}
}
