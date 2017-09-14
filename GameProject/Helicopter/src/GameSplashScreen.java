import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class GameSplashScreen extends JFrame {
	private JPanel contentPane; // JPanel class type ka object instantiated
	private Timer timer;
	private JLabel lblNewLabel_1 = new JLabel("Game 2017");
	private JProgressBar progressBar = new JProgressBar();
	private Logger logger = Logger.getLogger(GameSplashScreen.class);
	private static MainScreen ms = new MainScreen();
	private static GameSplashScreen frame = new GameSplashScreen();

	public static MainScreen getMs() {
		return ms;
	}

	public static GameSplashScreen getframe() {
		return frame;
	}

	public static void main(String[] args) {

		frame.setVisible(true);
		frame.doAnimation(); // custom made function //defined below
	}

	/**
	 * Further instances being written
	 * 
	 */

	boolean isVisible = false;
	int color = 1;
	Color colorValue; // object of color class
	int progressValue = 1;

	void doAnimation() {
		timer = new Timer(10, (e) -> {
			if (progressValue >= 100) {
				timer.stop();
				// MainScreen ms= new MainScreen();
				// ms.setVisible(true);
				CreateMainScreen();
				GameSplashScreen.this.setVisible(false);

			}

			progressBar.setValue(progressValue);

			progressValue++;

			if (isVisible) {

				switch (color) {

				case 1:

					colorValue = Color.RED;

					break;

				case 2:

					colorValue = Color.GREEN;

					break;

				case 3:

					colorValue = Color.YELLOW;

					break;

				case 4:

					colorValue = Color.BLUE;

					break;

				case 5:

					colorValue = Color.ORANGE;

					break;

				case 6:

					colorValue = Color.BLACK;

					break;

				case 7:

					colorValue = Color.WHITE;

					break;

				}

				color++;

				if (color >= 7) {

					color = 1;

				}

				lblNewLabel_1.setForeground(colorValue);

			}

			lblNewLabel_1.setVisible(isVisible);

			isVisible = !isVisible;

		});

		timer.start();

	}

	/**
	 * 
	 * Create the frame.
	 * 
	 */

	public GameSplashScreen() {
		logger.debug("SplashScreen Constructor called");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setEnabled(false);
		setType(Type.UTILITY);
		// Logger logger= Logger.getLogger(GameSplashScreen.class);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		setBounds(100, 100, 555, 398);

		contentPane = new JPanel();

		setLocationRelativeTo(null);

		contentPane.setBackground(new Color(102, 204, 204));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");

		lblNewLabel.setIcon(new ImageIcon(GameSplashScreen.class.getResource("Helicopter.gif")));

		lblNewLabel.setBounds(21, 16, 479, 235);

		contentPane.add(lblNewLabel);

		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 32));

		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel_1.setBounds(132, 262, 276, 35);

		contentPane.add(lblNewLabel_1);

		progressBar.setFont(new Font("Lucida Grande", Font.BOLD, 28));

		progressBar.setStringPainted(true);

		progressBar.setBounds(22, 316, 478, 39);

		contentPane.add(progressBar);

		UIManager.put("ProgressBar.background", Color.ORANGE);

		UIManager.put("ProgressBar.foreground", Color.BLUE);

		UIManager.put("ProgressBar.selectionBackground", Color.RED);

		UIManager.put("ProgressBar.selectionForeground", Color.GREEN);

	}

	public void CreateMainScreen() {
		logger.debug("Creating MainScreen");

		ms.setVisible(true);
	}
}
