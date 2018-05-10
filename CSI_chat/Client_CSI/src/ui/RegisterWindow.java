package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import bean.ChatRequest;
import bean.ChatResult;
import bean.RegisterInfo;
import bo.ResourceManager;
import csi.grp6.Application;
import utils.Security;
import view.FitImageJLabel;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RegisterWindow extends ProcessingWindow implements ActionListener {
	private static final long serialVersionUID = 8048354185743030788L;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField repasswordField;
	private JTextField dispNameField;
	private JButton btnTake;
	private JButton btnCancel;

	public RegisterWindow() {
	}
	
	@Override
	protected void onWindowClosing() {
		super.onWindowClosing();
		Application.showWindow(LoginWindow.class);
	}

	@Override
	protected void initializeComponents() {
		setResizable(false);
		setTitle("Register");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(129, 29, 77, 14);
		panel.add(lblUsername);

		usernameField = new JTextField();
		usernameField.setBounds(216, 26, 188, 20);
		panel.add(usernameField);
		usernameField.requestFocus();
		usernameField.setColumns(10);
		usernameField.addActionListener(this);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(129, 62, 77, 14);
		panel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(216, 59, 188, 20);
		passwordField.addActionListener(this);
		panel.add(passwordField);

		JLabel lblRepassword = new JLabel("Re-mot de passe:");
		lblRepassword.setBounds(129, 93, 77, 14);
		panel.add(lblRepassword);

		repasswordField = new JPasswordField();
		repasswordField.setBounds(216, 90, 188, 20);
		repasswordField.addActionListener(this);
		panel.add(repasswordField);

		JLabel lblDisplayName = new JLabel("Afficher un nom:");
		lblDisplayName.setBounds(129, 124, 77, 14);
		panel.add(lblDisplayName);

		dispNameField = new JTextField();
		dispNameField.setBounds(216, 121, 188, 20);
		dispNameField.addActionListener(this);
		panel.add(dispNameField);
		dispNameField.setColumns(10);

		btnTake = new JButton("Valider");
		btnTake.setBounds(216, 195, 89, 23);
		btnTake.addActionListener(this);
		panel.add(btnTake);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(315, 195, 89, 23);
		btnCancel.addActionListener(this);
		panel.add(btnCancel);

	/*	FitImageJLabel avatarField = new FitImageJLabel();
		avatarField.setBounds(10, 26, 109, 109);
		avatarField.setIcon(new ImageIcon(ResourceManager.getInstance().getImageByName("avatar.png")));
		panel.add(avatarField);*/

		setSize(430, 264);
	}

	private boolean checkInput() {
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());
		String repassword = new String(repasswordField.getPassword());
		String dispName = dispNameField.getText();

		if (!Security.checkValidUsername(username))
			return false;
		if (!Security.checkValidPassword(password) || !password.equals(repassword))
			return false;
		return Security.checkValidDisplayName(dispName);
	}

	private ChatRequest getChatRequest(final String username, final String password, final String dispname) {
		RegisterInfo info = new RegisterInfo();
		info.setUsername(username);
		info.setPassword(password);
		info.setDisplayName(dispname);
		return new ChatRequest(ChatRequest.CODE_REGISTER, info);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnCancel)) {
			dispose();
		} else {
			if (checkInput()) {
				ChatRequest request = getChatRequest(usernameField.getText().trim(),
						new String(passwordField.getPassword()), dispNameField.getText().trim());
				doInBackground(request);
			} else {
				MessageBox.showMessageBoxInUIThread(this, "Entrez à nouveau une valeur valide dans les champs!", MessageBox.MESSAGE_ERROR);
			}
		}
	}

	@Override
	protected void doneBackgoundTask(ChatResult result) {
		if (result.getCode() == ChatResult.CODE_OK) {
			MessageBox.showMessageBoxInUIThread(this, "Inscription est réussi!", MessageBox.MESSAGE_INFO);
			dispose();
		} else {
			MessageBox.showMessageBoxInUIThread(this, "Inscription est réussi!", MessageBox.MESSAGE_ERROR);
			setVisible(true);
		}
	}
}
