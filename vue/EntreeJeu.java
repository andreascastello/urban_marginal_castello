package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Author : Andréas CASTELLO
 * vs : 1
 * EntreeJeu
 * date : 28/09/2021
 */

public class EntreeJeu extends JFrame {
//def properties
	private JPanel contentPane;
	private JTextField txtIp;
	private Controle controle;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EntreeJeu frame = new EntreeJeu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * clic sur le bouton Start pour lancer le serveur
	 */
	private void btnStart_click() {
		controle.evenementVue(this, "serveur");
	}
	
	/**
	 * clic sur le bouton Connect pour se connecter au serveur
	 */
	private void btnConnect_clic() {
		controle.evenementVue(this, txtIp.getText());
	}
	
	/**
	 * clic sur le bouton exit pour quitter
	 */
	private void btnExit_clic() {
		System.exit(0);
	}
	/**
	 * Create the frame.
	 * @param controle 
	 */
	public EntreeJeu(Controle controle) {
		setTitle("Urban Marginal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnStart_click();
			}
				
		});
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStart.setBounds(305, 40, 89, 23);
		contentPane.add(btnStart);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnConnect_clic();
			}

		});
		btnConnect.setBounds(305, 113, 89, 23);
		contentPane.add(btnConnect);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnExit_clic();
			}
			
		});
		btnExit.setBounds(305, 147, 89, 23);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("Start a server");
		lblNewLabel.setBounds(28, 44, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblConnectAExi = new JLabel("Connect an existing server");
		lblConnectAExi.setBounds(28, 85, 165, 14);
		contentPane.add(lblConnectAExi);
		
		JLabel lblNewLabel_1 = new JLabel("IP server :");
		lblNewLabel_1.setBounds(28, 117, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		txtIp = new JTextField();
		txtIp.setText("127.0.0.1");
		txtIp.setBounds(88, 114, 86, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
		
		this.controle = controle;
	}
}
