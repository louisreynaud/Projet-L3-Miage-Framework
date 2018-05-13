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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import client.Groupe_Organisation;
import client.Personne_Organisation;
import client.Personne_Publique;
import client.User;
import ui.Window;

import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import database.ConnectionManager;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Employes extends Window {

	private JPanel contentPane;
	private JTable table;
	private JTextField fieldNom;
	private JTextField fieldPrenom;
	private JTextField fieldEmail;
	private JTextField fieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employes frame = new Employes();
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
	public Employes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 333);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JLabel lblGestionDesEmploys = new JLabel("Gestion des Employ\u00E9s");
		lblGestionDesEmploys.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		Connection conn = ConnectionManager.DbConnector();
		
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
		
		JButton btnNewButton_1 = new JButton("Services");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Services sc= new Services();
				sc.setVisible(true);
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
							.addPreferredGap(ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
							.addComponent(lblGestionDesEmploys, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(150)
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
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(10, 22, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1.setBounds(10, 47, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adresse Email");
		lblNewLabel_2.setBounds(10, 72, 80, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mot de Passe");
		lblNewLabel_3.setBounds(10, 97, 64, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Service");
		lblNewLabel_4.setBounds(10, 122, 46, 14);
		panel.add(lblNewLabel_4);
		
		fieldNom = new JTextField();
		fieldNom.setBounds(113, 19, 86, 20);
		panel.add(fieldNom);
		fieldNom.setColumns(10);
		
		fieldPrenom = new JTextField();
		fieldPrenom.setBounds(113, 44, 86, 20);
		panel.add(fieldPrenom);
		fieldPrenom.setColumns(10);
		
		fieldEmail = new JTextField();
		fieldEmail.setBounds(113, 69, 86, 20);
		panel.add(fieldEmail);
		fieldEmail.setColumns(10);
		
		fieldPassword = new JTextField();
		fieldPassword.setBounds(113, 94, 86, 20);
		panel.add(fieldPassword);
		fieldPassword.setColumns(10);

		JComboBox<Integer> listeServices = new JComboBox<Integer>();
		listeServices.setBounds(113, 119, 86, 20);
		panel.add(listeServices);


		ArrayList<Groupe_Organisation> orgs = ConnectionManager.SelectOrganisations_db();
		for (int i=0; i<orgs.size(); i++) {
			listeServices.addItem(orgs.get(i).getIdGroupe());
		}

		
		JButton btnNewButton_2 = new JButton("Ajouter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fieldEmail.getText() != null && fieldPassword.getText() != null && fieldNom.getText() != null && fieldPrenom.getText() != null && listeServices.getSelectedItem() != null) {

					Personne_Organisation po = new Personne_Organisation(fieldEmail.getText(), fieldPassword.getText(), fieldNom.getText(), fieldPrenom.getText(), (int) listeServices.getSelectedItem());
					ConnectionManager.AddUserOrganisation_db(po);
			
				}
			}
		});
		btnNewButton_2.setBounds(130, 153, 69, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modifier");
		btnNewButton_3.setBounds(207, 153, 80, 23);
		panel.add(btnNewButton_3);
		
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					Personne_Publique u = new Personne_Publique(
							table.getValueAt(table.getSelectedRow(), 3).toString(),
							table.getValueAt(table.getSelectedRow(), 4).toString(),
							table.getValueAt(table.getSelectedRow(), 1).toString(),
							table.getValueAt(table.getSelectedRow(), 2).toString());
					u.setId((int) table.getValueAt(table.getSelectedRow(), 0));
					ConnectionManager.DeleteUserto_db(u);
					
				
				}
			}
		});
		

		
		table = new JTable();
		ArrayList<Personne_Organisation> users = ConnectionManager.SelectUsers_db();
		Object[][] tableData = new Object[users.size()][6];
		for (int i=0; i<users.size(); i++) {
			tableData[i][0] = users.get(i).getId();
			tableData[i][1] = users.get(i).getNom();
			tableData[i][2] = users.get(i).getPrenom();
			tableData[i][3] = users.get(i).getLogin();
			tableData[i][4] = users.get(i).getPassword();
			tableData[i][5] = users.get(i).getOrganisation();
		}
		
		table.setModel(new DefaultTableModel(
			tableData,
			new String[] {
				"ID", "Nom", "Pr\u00E9nom", "Adresse Email", "Mot de Passe", "Service"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(82);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		JLabel lblGestionDesServices = new JLabel("Gestion des Services");
		
		


		
	}

	@Override
	protected void initializeComponents() {
		// TODO Auto-generated method stub
		
	}
}
