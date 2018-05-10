package ui;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

import bean.ChatRequest;
import bean.ChatResult;
import utils.Security;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PasswordWindow extends ProcessingWindow implements ActionListener {
	private static final long serialVersionUID = -3095916920393941474L;
	private JPasswordField passwordField;
	private JPasswordField repasswordField;
	private JButton btnLookGood;
	private JButton btnCancel;

	@Override
	protected void initializeComponents() {
		setResizable(false);
		setTitle("Plus de Securite ");
		getContentPane().setLayout(null);

		JLabel lblNewPassword = new JLabel("Nw password:");
		lblNewPassword.setBounds(10, 14, 74, 14);
		getContentPane().add(lblNewPassword);

		JLabel lblConfirm = new JLabel("Confirmer:");
		lblConfirm.setBounds(10, 41, 74, 14);
		getContentPane().add(lblConfirm);

		passwordField = new JPasswordField();
		passwordField.setBounds(94, 11, 224, 20);
		passwordField.addActionListener(this);
		getContentPane().add(passwordField);

		repasswordField = new JPasswordField();
		repasswordField.setBounds(94, 38, 224, 20);
		repasswordField.addActionListener(this);
		getContentPane().add(repasswordField);

		btnLookGood = new JButton("C Bon");
		btnLookGood.setBounds(130, 138, 89, 23);
		btnLookGood.addActionListener(this);
		getContentPane().add(btnLookGood);

		btnCancel = new JButton("Quitter");
		btnCancel.setBounds(229, 138, 89, 23);
		btnCancel.addActionListener(this);
		getContentPane().add(btnCancel);

		setSize(335, 200);
	}

	private boolean checkPasswordInput() {
		String password = new String(passwordField.getPassword());
		String cpassword = new String(repasswordField.getPassword());
		return Security.checkValidPassword(password) && password.equals(cpassword);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnCancel)) {
			dispose();
		} else {
			if (checkPasswordInput()) {
				ChatRequest request = new ChatRequest(ChatRequest.CODE_CHANGE_PASSWORD,
						new String(passwordField.getPassword()));
				doInBackground(request);
			} else {
				MessageBox.showMessageBoxInUIThread(this, "Confirmer le mot de passe ne correspond pas au nouveau mot de passe", MessageBox.MESSAGE_ERROR);
			}
		}
	}

	@Override
	protected void doneBackgoundTask(ChatResult result) {
		if (result.getCode() == ChatResult.CODE_OK) {
			MessageBox.showMessageBoxInUIThread(this, "Password changer!", MessageBox.MESSAGE_INFO);
			dispose();
		} else {
			MessageBox.showMessageBoxInUIThread(this, "Le mot de passe n'a pas chang�!", MessageBox.MESSAGE_ERROR);
			setVisible(true);
		}
	}

}
