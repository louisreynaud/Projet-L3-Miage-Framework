package vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client.Groupe_Organisation;
import database.ConnectionManager;
import ui.Window;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class ContacterServices extends Window {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContacterServices frame = new ContacterServices();
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
	public ContacterServices() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 641, 370);
		contentPane.add(panel);
		
		JLabel lblContacterServices = new JLabel("Contacter Services ");
		lblContacterServices.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conversation conv= new Conversation();
				conv.setVisible(true);
				hide();
				
			}
		});
		
		JButton btnContacterEmp = new JButton("Contacter Employ\u00E9");
		
		JButton btnContacter = new JButton("Contacter");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(251)
					.addComponent(lblContacterServices))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnRetour)
					.addPreferredGap(ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
					.addComponent(btnContacterEmp)
					.addGap(113))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(85)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnContacter)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(lblContacterServices))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRetour)
							.addComponent(btnContacterEmp)))
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnContacter)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		
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
				"Nom Service", "Selectionner le service"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(97);
		table.getColumnModel().getColumn(1).setPreferredWidth(39);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
	}

	@Override
	protected void initializeComponents() {
		// TODO Auto-generated method stub
		
	}

}
