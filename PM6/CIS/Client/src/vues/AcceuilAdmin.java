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
import ui.LoginWindow;
import ui.Window;

public class AcceuilAdmin extends Window {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceuilAdmin frame = new AcceuilAdmin();
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
	public AcceuilAdmin() {

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
		
		JLabel lblAcceuilAdmin = new JLabel("Acceuil Admin");
		lblAcceuilAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAcceuilAdmin.setBounds(195, 11, 175, 14);
		panel.add(lblAcceuilAdmin);
		
		JButton btnNewButton = new JButton("Employ\u00E9s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Employes emp= new Employes();
				emp.setVisible(true);
				hide();
				
			}
		});
		btnNewButton.setBounds(208, 105, 105, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Services");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Services serv = new Services();
				serv.setVisible(true);
				hide();
			}
		});
		btnNewButton_1.setBounds(208, 165, 105, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Conversation");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conversation conv = new Conversation();
				conv.setVisible(true);
				hide();
				
			}
		});
		btnNewButton_2.setBounds(208, 227, 105, 23);
		panel.add(btnNewButton_2);
		
	}

}
