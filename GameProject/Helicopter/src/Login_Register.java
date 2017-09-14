import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_Register extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	JLabel lblLogininstead = new JLabel("login ?");
	JButton btnRegister = new JButton("Register\r\n");
	JButton btnLogin = new JButton("Login");
	JButton btnCancel = new JButton("Cancel\r\n");
	private final JLabel lblRegisterInstead = new JLabel("Register ?");
	private JPasswordField passwordField;
	private Logger logger = Logger.getLogger(Login_Register.class);

	/**
	 * Launch the application.
	 * 
	 * /** Create the frame.
	 */
	public Login_Register() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 401, 252);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Password");
		lblUsername.setForeground(new Color(65, 105, 225));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(30, 91, 97, 23);
		contentPane.add(lblUsername);

		JLabel label = new JLabel("UserName");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(65, 105, 225));
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(30, 43, 97, 23);
		contentPane.add(label);

		nameField = new JTextField();
		nameField.setBounds(169, 43, 192, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginUser();
			}
		});

		btnLogin.setBounds(169, 164, 89, 23);
		contentPane.add(btnLogin);
		btnRegister.setEnabled(false);
		btnRegister.setVisible(false);
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterUser();

			}
		});

		btnRegister.setBounds(169, 164, 89, 23);
		contentPane.add(btnRegister);
		btnRegister.setEnabled(false);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});

		btnCancel.setBounds(272, 164, 89, 23);
		contentPane.add(btnCancel);

		lblLogininstead.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRegister.setEnabled(false);
				btnLogin.setEnabled(true);
				btnRegister.setVisible(false);
				btnLogin.setVisible(true);
				lblRegisterInstead.setEnabled(true);
				lblRegisterInstead.setVisible(true);
				lblLogininstead.setEnabled(false);
				lblLogininstead.setVisible(false);
			}
		});

		lblLogininstead.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblLogininstead.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogininstead.setBounds(42, 167, 85, 14);
		contentPane.add(lblLogininstead);
		lblRegisterInstead.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRegister.setEnabled(true);
				btnLogin.setEnabled(false);
				btnRegister.setVisible(true);
				btnLogin.setVisible(false);
				lblRegisterInstead.setEnabled(false);
				lblRegisterInstead.setVisible(false);
				lblLogininstead.setEnabled(true);
				lblLogininstead.setVisible(true);
			}
		});
		lblRegisterInstead.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblRegisterInstead.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterInstead.setBounds(30, 167, 108, 14);
		lblRegisterInstead.setEnabled(true);
		lblRegisterInstead.setVisible(true);
		lblLogininstead.setEnabled(false);
		lblLogininstead.setVisible(false);

		contentPane.add(lblRegisterInstead);

		passwordField = new JPasswordField();
		passwordField.setBounds(169, 91, 192, 23);
		contentPane.add(passwordField);

		passwordField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (lblLogininstead.isVisible() == true) {
						RegisterUser();
					} else if (lblRegisterInstead.isVisible() == true) {
						LoginUser();
					}
				}
			}
		});

		nameField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (lblLogininstead.isVisible() == true) {
						RegisterUser();
					} else if (lblRegisterInstead.isVisible() == true) {
						LoginUser();
					}
				}
			}
		});

	}

	private void RegisterUser() {
		logger.debug("Registering User");
		String name = nameField.getText();
		String pwd = passwordField.getText();
		String messageT = "Registration successful !!";
		String messageF = "Something Went Wrong,Please try Again";
		User user = new User();
		user.setName(name);
		user.setPassword(pwd);
		try {
			userMethods.isUserExist(user);
			if (userMethods.isUserExist(user) == false) {
				if (userMethods.RegisterUser(user) == true) {
					JOptionPane.showMessageDialog(this, messageT);
					nameField.setText("");
					passwordField.setText("");
					// MainScreen.mntmGame.setEnabled(true);
					logger.info(user.getName() + "Registered");

				}
			} else if (userMethods.isUserExist(user) == true) {
				JOptionPane.showMessageDialog(this, "User Already Exists");
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			try {
				userMethods.RegisterUser(user);
				JOptionPane.showMessageDialog(this, messageT);
				nameField.setText("");
				logger.info(user.getName() + "Registered");
				passwordField.setText("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				StringWriter sw = new StringWriter();
				PrintWriter p = new PrintWriter(sw);
				e.printStackTrace(p);
				logger.error(sw.toString());
				// e.printStackTrace(p);
			}
			// JOptionPane.showMessageDialog(this, messageF +"Following
			// Exception Raised" + e1);
			nameField.setText("");
			passwordField.setText("");

		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			PrintWriter p = new PrintWriter(sw);
			e.printStackTrace(p);
			logger.error(sw.toString());
			e.printStackTrace(p);
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			PrintWriter p = new PrintWriter(sw);
			e.printStackTrace(p);
			logger.error(sw.toString());
			e.printStackTrace(p);
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			PrintWriter p = new PrintWriter(sw);
			// e1.printStackTrace(p);
			logger.error(sw.toString());
			e.printStackTrace(p);
			// e.printStackTrace();
		}

	}

	private void LoginUser() {
		logger.debug("logging in user");
		String name = nameField.getText();
		String pwd = passwordField.getText();
		String messageT = "Login successful !!";
		String messageF = "Something Went Wrong,Please try Again";
		User user = new User();
		user.setName(name);
		user.setPassword(pwd);
		try {
			userMethods.LoginUser(user);
			if (userMethods.LoginUser(user) == true) {
				JOptionPane.showMessageDialog(this, messageT);
				this.setVisible(false);
				this.dispose();
				nameField.setText("");
				passwordField.setText("");
				logger.info(user.getName() + "logged in");
				MainScreen.getMntmGame().setEnabled(true);
				MainScreen.getMntmLoginregister().setEnabled(false);
				MainScreen.getMntmSignout().setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(this, messageF);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			PrintWriter p = new PrintWriter(sw);
			e1.printStackTrace(p);
			logger.error(sw.toString());
			JOptionPane.showMessageDialog(this, messageF);
			nameField.setText("");
			passwordField.setText("");
		} catch (ClassNotFoundException e) {
			StringWriter sw = new StringWriter();
			PrintWriter p = new PrintWriter(sw);
			e.printStackTrace(p);
			logger.error(sw.toString());
			e.printStackTrace();
		}
	}
}
