package vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import csi.grp6.Application;
import csi.grp6.Client;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ui.FriendsWindow;
import ui.LoginWindow;
import ui.Window;

public class AccueilEmploye extends Window {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilEmploye frame = new AccueilEmploye();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccueilEmploye() {

	}

	@Override
	protected void initializeComponents() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 533, 355);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAccueilAdmin = new JLabel("Accueil Employe");
		lblAccueilAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccueilAdmin.setBounds(195, 11, 175, 14);
		panel.add(lblAccueilAdmin);
		
		JButton btnNewButton = new JButton("Contacter Employ\u00E9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Application.showWindow(FriendsWindow.class);
				dispose();
				
			}
		});
		btnNewButton.setBounds(186, 105, 150, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Contacter Services");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ContacterServices serv = new ContacterServices();
				serv.setVisible(true);
				hide();
			}
		});
		btnNewButton_1.setBounds(186, 165, 150, 23);
		panel.add(btnNewButton_1);
		
	}

}
