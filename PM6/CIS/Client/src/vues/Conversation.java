package vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import csi.grp6.Application;
import ui.FriendsWindow;
import ui.LoginWindow;
import ui.RegisterWindow;
import ui.Window;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Conversation extends Window {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversation frame = new Conversation();
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
	public Conversation() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 473, 283);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConversation = new JLabel("Conversation");
		lblConversation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConversation.setBounds(192, 33, 112, 32);
		panel.add(lblConversation);
		
		JButton btnNewButton = new JButton("Contacter un employ\u00E9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Application.showWindow(FriendsWindow.class);
				dispose();
				
			}
		});
		btnNewButton.setBounds(169, 120, 139, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Contacter un Service");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContacterServices cnserv= new ContacterServices();
				cnserv.setVisible(true);
				hide();
			}
		});
		btnNewButton_1.setBounds(169, 187, 139, 23);
		panel.add(btnNewButton_1);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(0, 0, 65, 23);
		panel.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccueilAdmin acad = new AccueilAdmin();
				acad.setVisible(true);
				hide();
				
			}
		});
	}

	@Override
	protected void initializeComponents() {
		// TODO Auto-generated method stub
		
	}

}
