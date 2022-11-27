package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.security.PublicKey;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Global;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * @author Andréas CASTELLO
 * @version 1
 * Arene
 * date : 14/10/2021
 */
public class Arene extends JFrame implements Global{

	private JPanel contentPane;
	private JPanel jpnJeu;
	private JPanel jpnMurs;
	private JTextField txtSaisie;

	/**
	 * Create the frame.
	 */
	public Arene() {
		setTitle("Arena");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, L_ARENE+3*MARGE, H_ARENE + H_CHAT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		jpnJeu = new JPanel();
		jpnJeu.setBounds(0, 0, L_ARENE, H_ARENE);
		jpnJeu.setOpaque(false);
		contentPane.add(jpnJeu);
		jpnJeu.setLayout(null);
		
		jpnMurs = new JPanel();
		jpnMurs.setOpaque(false);
		jpnMurs.setBounds(0, 0, L_ARENE, H_ARENE);
		contentPane.add(jpnMurs);
		jpnMurs.setLayout(null);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, L_ARENE, H_ARENE);
		lblFond.setIcon(new ImageIcon(FONDARENE));
		contentPane.add(lblFond);
		
		txtSaisie = new JTextField();
		txtSaisie.setBounds(0, H_ARENE, L_ARENE, H_SAISIE);
		contentPane.add(txtSaisie);
		txtSaisie.setColumns(10);
		
		JScrollPane jspChat = new JScrollPane();
		jspChat.setBounds(0, H_ARENE + H_SAISIE, L_ARENE, H_CHAT - H_SAISIE - 7*MARGE);
		contentPane.add(jspChat);
		//chat vertical
		jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JTextArea txtChat = new JTextArea();
		jspChat.setViewportView(txtChat);
	}
	//ajout de mur
	public void ajoutMur (JLabel mur) {
		jpnMurs.add(mur);
		jpnMurs.repaint();
	}
	
	public void ajoutPanelMurs (JPanel panelMur) {
		jpnMurs.add(panelMur);
		jpnMurs.repaint();
		contentPane.requestFocus();
	}
	
	public JPanel getJPanel() {
		return jpnMurs;
	}
	
}
