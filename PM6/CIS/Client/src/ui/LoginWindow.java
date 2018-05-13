package ui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bean.Account;
import bean.ChatRequest;
import bean.ChatResult;
import bo.ResourceManager;
import csi.grp6.Application;
import csi.grp6.Client;
import database.ConnectionManager;
import utils.Security;
import view.FitImageJLabel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import vues.AccueilAdmin;
import vues.AccueilEmploye;
import vues.Conversation; 

public class LoginWindow extends ProcessingWindow implements ActionListener {
    private static Statement stm;
    private static ResultSet rs;
	private static final long serialVersionUID = -4733559679077400789L;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblDontHaveAn;
	private JButton btnRegister;
	private JLabel lblServerAddress;

	public LoginWindow() {
	}

	private boolean checkInput() {
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());
		return Security.checkValidUsername(username) && Security.checkValidPassword(password);
	}

	@Override
	public void initializeComponents() {
		setResizable(false);
		setTitle("Login");
		getContentPane().setLayout(null);

		FitImageJLabel lblNewLabel = new FitImageJLabel();
		lblNewLabel.setBounds(10, 11, 340, 247);
		lblNewLabel.setIcon(new ImageIcon(ResourceManager.getInstance().getImageByName("login-banner.png")));
		getContentPane().add(lblNewLabel);

		usernameField = new JTextField();
		usernameField.setBounds(451, 92, 112, 20);
		usernameField.addActionListener(this);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(451, 123, 112, 20);
		passwordField.addActionListener(this);
		getContentPane().add(passwordField);

		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(384, 95, 57, 14);
		getContentPane().add(lblUsername);
		lblUsername.requestFocus();

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(384, 126, 57, 14);
		getContentPane().add(lblPassword);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(451, 161, 112, 23);
		btnLogin.addActionListener(this);
		getContentPane().add(btnLogin);

		lblDontHaveAn = new JLabel("Don't have an account?");
		lblDontHaveAn.setBounds(384, 210, 127, 14);
		getContentPane().add(lblDontHaveAn);

		btnRegister = new JButton("Register");
		btnRegister.setBounds(451, 235, 112, 23);
		btnRegister.addActionListener(this);
		getContentPane().add(btnRegister);

		lblServerAddress = new JLabel("Server address...");
		lblServerAddress.setForeground(Color.GRAY);
		lblServerAddress.setBounds(10, 309, 201, 14);
		lblServerAddress.setText("Server at " + Client.getInstance().getRemoteAddress());
		getContentPane().add(lblServerAddress);

		setSize(586, 363);
	}

	@Override
	protected void onWindowClosing() {
		super.onWindowClosing();
		Application.exitIfNotWindowActived();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRegister)) {
			Application.showWindow(RegisterWindow.class);
			dispose();
		} else {
			if (checkInput()) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				Account account = new Account();
				account.setPassword(password);
				account.setUsername(username);
				ChatRequest request = new ChatRequest(ChatRequest.CODE_LOGIN, account);
				doInBackground(request, "Authenticating...");
				/* String login = LoginAdmin();
				String mdp = MdpAdmin();
				if (username.equals(login) &&  password.equals(mdp)) {
					AccueilAdmin conv= new AccueilAdmin();
					conv.setVisible(true);
					hide();
				}else {
					JOptionPane.showMessageDialog(LoginWindow.this, "Personne organisation!");
				}*/
				
			} else {
				JOptionPane.showMessageDialog(LoginWindow.this, "Re-enter username and password!");
			}
		}
	}

	@Override
	protected void doneBackgoundTask(ChatResult result) {
		if (result.getCode() == ChatResult.CODE_ADMIN) {
			Client.getInstance().setMyUsername(usernameField.getText());
			Client c = Client.getInstance();
			Application.showWindow(AccueilAdmin.class);
			dispose();
		}
		else if (result.getCode() == ChatResult.CODE_OK) {
			Client.getInstance().setMyUsername(usernameField.getText());
			Client c = Client.getInstance();
			Application.showWindow(AccueilEmploye.class);
			dispose();
		} 
		else {
			MessageBox.showMessageBoxInUIThread(LoginWindow.this, "Login error: " + result.getExtra(), MessageBox.MESSAGE_ERROR);
			setVisible(true);
		}
	}
	
	public static String LoginAdmin() {
		
        PreparedStatement pst =null;
        String login=null;
        String sql="select * from Utilisateur where id_user IN (select id_user from Utilisateur_Admin ) ";        
        try
        {
           
            ResultSet rs = null;
            rs = ConnectionManager.executeSelect(sql);
            
            while(rs.next())
            {
                login= rs.getString("login");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return login;
	}
	public static String MdpAdmin() {
		
        PreparedStatement pst =null;
        String mot_de_passe=null;
        String sql="select * from Utilisateur where id_user IN (select id_user from Utilisateur_Admin ) ";        
        try
        {
           
            ResultSet rs = null;
            rs = ConnectionManager.executeSelect(sql);
     
            while(rs.next())
            {
                mot_de_passe=rs.getString("mot_de_passe");
                System.out.println(mot_de_passe);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return mot_de_passe;
	}
}
