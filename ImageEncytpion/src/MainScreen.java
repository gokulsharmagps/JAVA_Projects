import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private EncryptionScreen f1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEncryption = new JButton("Encryption");
		btnEncryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				f1 = new EncryptionScreen();
				f1.setVisible(true);
				
			}
		});
		btnEncryption.setBounds(103, 64, 208, 23);
		contentPane.add(btnEncryption);
		
		JButton btnNewButton = new JButton("Decryption");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecryptionScreen desc= new DecryptionScreen();
				desc.setVisible(true);
			}
		});
		btnNewButton.setBounds(106, 160, 205, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblChooseYourProcess = new JLabel("Choose Your Process");
		lblChooseYourProcess.setBounds(145, 11, 126, 14);
		contentPane.add(lblChooseYourProcess);
	}

}
