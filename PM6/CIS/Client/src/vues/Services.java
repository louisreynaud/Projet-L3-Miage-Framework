package vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client.Groupe_Organisation;
import client.Personne_Organisation;
import database.ConnectionManager;
import ui.Window;

import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Services extends Window {

	private JPanel contentPane;
	private JTable table;
	private JTextField fieldService;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Services frame = new Services();
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
	public Services() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 333);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JLabel lblGestionDesEmploys = new JLabel("Gestion des Services");
		lblGestionDesEmploys.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccueilAdmin acad = new AccueilAdmin();
				acad.setVisible(true);
				hide();
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JButton btnNewButton = new JButton("Conversation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conversation conv= new Conversation();
				conv.setVisible(true);
				hide();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Employ\u00E9s");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employes emp= new Employes();
				emp.setVisible(true);
				hide();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Supprimer");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnRetour)
							.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
							.addComponent(lblGestionDesEmploys, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(159)
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_4))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRetour)
							.addComponent(btnNewButton)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblGestionDesEmploys)))
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addGap(24))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_4)
							.addGap(30))))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom du Service");
		lblNewLabel.setBounds(10, 53, 80, 14);
		panel.add(lblNewLabel);
		
	
		JLabel lblNewLabel_4 = new JLabel("Adress Email Employé");
		lblNewLabel_4.setBounds(10, 101, 111, 14);
		panel.add(lblNewLabel_4);
		
		fieldService = new JTextField();
		fieldService.setBounds(142, 50, 117, 20);
		panel.add(fieldService);
		fieldService.setColumns(10);
	
		JButton btnNewButton_2 = new JButton("Ajouter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				
				ConnectionManager.AddOrganisation_db(new Groupe_Organisation(null, null), conn);
			}
		});
		btnNewButton_2.setBounds(130, 153, 69, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modifier");
		btnNewButton_3.setBounds(207, 153, 80, 23);
		panel.add(btnNewButton_3);
		
		JComboBox listemploye = new JComboBox();
		listemploye.setBounds(142, 98, 117, 17);
		panel.add(listemploye);
		
		table = new JTable();
		Connection conn = null;
		Groupe_Organisation[] orgs = ConnectionManager.SelectOrganisations_db(conn);
		Object[][] tableData = new Object[orgs.length][2];
		for (int i=0; i<orgs.length; i++) {
			tableData[i][0] = orgs[i].getNomGroupe();
		}
		table.setModel(new DefaultTableModel(
			tableData,
			new String[] {
				"Nom du Service",  "Adress Email Employé"
			}
		));
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		JLabel lblGestionDesServices = new JLabel("Gestion des Services");
		
		
	}

	@Override
	protected void initializeComponents() {
		// TODO Auto-generated method stub
		
	}
}
