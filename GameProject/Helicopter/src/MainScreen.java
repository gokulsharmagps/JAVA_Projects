import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private Logger logger = Logger.getLogger(MainScreen.class);

	@Override
	public JPanel getContentPane() {
		return contentPane;
	}

	public static JMenuItem getMntmGame() {
		return mntmGame;
	}

	public static JMenuItem getMntmLoginregister() {
		return mntmLoginregister;
	}

	public static JMenuItem getMntmSignout() {
		return mntmSignout;
	}

	private static JMenuItem mntmGame = new JMenuItem("HarryPotter");
	private static JMenuItem mntmLoginregister = new JMenuItem("Login_Register");
	private static JMenuItem mntmSignout = new JMenuItem("SignOut");

	public MainScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\JAVA\\IDE\\Helicopter\\images\\Screenshot (62).png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				String ObjButtons[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(MainScreen.this, "Are you sure you want to exit ?",
						"Confirmation Required", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						ObjButtons, ObjButtons[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 894, 622);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("F:\\JAVA\\IDE\\Helicopter\\images\\MainBg.png"));
		lblNewLabel.setBounds(0, 0, 895, 621);
		contentPane.add(lblNewLabel);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu game = new JMenu("Game");
		menuBar.add(game);
		mntmGame.setEnabled(false);
		game.addSeparator();
		mntmSignout.setEnabled(false);

		mntmGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("Game Started");
				GameFrame obj = new GameFrame();
				Toolkit.getDefaultToolkit().sync();
				obj.loadBoard();
				setVisible(false);

			}
		});

		mntmLoginregister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login_Register loginReg = new Login_Register();
				loginReg.setVisible(true);

			}
		});
		game.add(mntmLoginregister);
		game.add(mntmGame);

		mntmSignout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainScreen.mntmLoginregister.setEnabled(true);
				MainScreen.mntmGame.setEnabled(false);
				MainScreen.mntmSignout.setEnabled(false);
			}
		});
		game.add(mntmSignout);

		logger.debug("MainScreen Constructed");

	}
}
