import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Timer;

import org.apache.log4j.Logger;

public class Board extends JPanel implements GameConstants {
	Player player;
	Camera camera;
	boolean isCollison = false;
	EnemyBird Birds[] = new EnemyBird[40];
	// private int score=100;
	Cloud BlackClouds[] = new Cloud[40];
	Snitch Snitchs[] = new Snitch[15];
	Spells spell;
	printScore score;
	// boolean isPowerUp=false;
	private Logger logger = Logger.getLogger(Board.class);

	public Board() {
		setSize(GWidth, GHeight);
		setFocusable(true);
		camera = new Camera();
		loadImage();
		isCollison = false;
		player = new Player();

		prepareBird();
		prepareSnitch();
		spell = new Spells(player);
		prepareBlackCloud();
		gameLoop();

		score = new printScore();

		// new MP3Player(new File("Hedwig.mp3")).play();

	}

	void bindEvent() {
		this.setFocusable(true);
		this.requestFocusInWindow();
		// camera.moveBackground();
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					player.isJump = false;
					// player.Slow();
					// while(!player.isJump){
					// player.movePlayerDown();
					// }
				} else if (e.getKeyCode() == KeyEvent.VK_Q) {
					spell.isRandomizing = true;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					player.isJump = true;
					player.movePlayerUp();
				}
				//
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// player.movePlayerRight();
					camera.right();
					// Birds[20].fastleft();
				}

				// }
				// @Override
				// public void keyPressed(KeyEvent e){
				else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.movePlayerLeft();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT && e.getKeyCode() == KeyEvent.VK_UP) {
					player.movePlayerLeft();
					player.movePlayerUp();

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_UP) {
					camera.right();
					player.movePlayerUp();
					Birds[40].left();
					BlackClouds[40].left();

				} else if (e.getKeyCode() == KeyEvent.VK_E) {
					spell.isPowerUp = true;
					spell.isVisible = true;

				} else if (e.getKeyCode() == KeyEvent.VK_Q) {
					spell.isRandomizing = false;
					spell.isPowerUp = true;
					spell.isVisible = true;

				}

			}
		});

	}

	private void prepareBird() {
		logger.debug("Demon Constructor called");
		String bird = "demon1.png";
		int posx = GWidth - 300;
		int posy = GHeight - 300;
		// Random r = new Random();
		int Low = 90;
		int High = 450;
		int min = 300;
		int max = 600;

		for (int i = 0; i < Birds.length; i++) {
			// bird=GameConstants.BirdImage[i];
			bird = "demon1.png";
			Birds[i] = new EnemyBird(posx, posy, bird);
			// posx+=r.nextInt(max-min) + min;
			// posy=r.nextInt(High);
			posx += 600;
			posy = 450 - (ThreadLocalRandom.current().nextInt(Low, High + 1) + Low);
		}

		for (int i = 20; i <= 39; i++) {
			bird = "blackCloud1.gif";
			// blackCloud=GameConstants.BlackCloudImage[i];
			Birds[i] = new EnemyBird(posx, posy, bird);
			// posx+=r.nextInt(max-min) + min;
			// posy=r.nextInt(High);
			// posy+=600;
			posx = posx + 550;
			if (i % 2 == 0) {
				posy = GameConstants.Top;
			} else {
				posy = GameConstants.Floor;
			}

		}
		logger.debug("Demons Constructed");
	}

	private void prepareSnitch() {
		logger.debug("Snitch constructor called");
		String snitch = "snitch.gif";
		int posx = GWidth - 300;
		int posy = GHeight - 300;
		// Random r = new Random();
		int Low = 90;
		int High = 450;
		int min = 300;
		int max = 600;

		for (int i = 0; i < 15; i++) {
			// bird=GameConstants.BirdImage[i];
			snitch = "snitch.gif";
			Snitchs[i] = new Snitch(posx, posy, snitch);
			// posx+=r.nextInt(max-min) + min;
			// posy=r.nextInt(High);
			posx += 1100;
			posy = 450 - (ThreadLocalRandom.current().nextInt(Low, High + 1) + Low);
		}
		logger.debug("snitch constructed");
	}

	private void prepareBlackCloud() {
		logger.debug("Clouds Constructor called");
		String blackCloud = "blackCloud1.gif";
		int posx = GWidth - 300;
		int posy = GHeight - 300;
		// Random r = new Random();
		int Low = 20;
		int High = 250;
		int min = 300;
		int max = 600;

		for (int i = 0; i <= 19; i++) {
			blackCloud = "blackCloud1.gif";
			// blackCloud=GameConstants.BlackCloudImage[i];
			BlackClouds[i] = new Cloud(posx, posy, blackCloud);
			// posx+=r.nextInt(max-min) + min;
			// posy=r.nextInt(High);
			// posy+=600;
			posx = posx + 750;
			posy = (ThreadLocalRandom.current().nextInt(Low, High + 1) + Low);
		}

		for (int i = 20; i <= 39; i++) {
			blackCloud = "blackCloud1.gif";
			// blackCloud=GameConstants.BlackCloudImage[i];
			BlackClouds[i] = new Cloud(posx, posy, blackCloud);
			// posx+=r.nextInt(max-min) + min;
			// posy=r.nextInt(High);
			// posy+=600;
			posx = posx + 450;
			if (i % 2 == 0) {
				posy = GameConstants.Top;
			} else {
				posy = GameConstants.Floor;
			}

		}
		logger.debug("Clouds Constructed");
	}

	private Timer timer;

	private void gameLoop() {
		timer = new Timer(Delay, (e) -> {
			repaint();
			// snitchCollision();
			// camera.right();
		});
		timer.start();
	}

	private Image image;

	void loadImage() {
		try {
			image = ImageIO.read(Board.class.getResource("Background.png")).getSubimage(camera.getX(), 0, GWidth,
					GHeight);
			// image = new
			// ImageIcon(Board.class.getResource("Background.jpg")).getImage();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D twoD = (Graphics2D) g;
		drawBackgrond(twoD);
		camera.right();
		player.drawPlayer(twoD);
		player.movePlayerDown();

		// checkCollision();
		// player.Slow();

		for (EnemyBird bird : Birds) {
			// bird.drawBird(twoD);
			// bird.left();
			if (bird.isVisible) {
				bird.drawBird(twoD);
				bird.left();
				// spell.OutOfFrame(player, Birds);
				bird.move();
				// bird.move();
			}
		}

		for (Cloud blackCloud : BlackClouds) {
			blackCloud.drawCloud(twoD);
			blackCloud.left();
			blackCloud.move();
		}

		for (Snitch snitch : Snitchs) {
			snitch.drawSnitch(twoD);
			snitch.move();
			snitch.moveSnitch();
			if (snitch.isVisible) {
				score.playerSnitchCollision(player, snitch);
			}
		}

		if (spell.isPowerUp && spell.isVisible) {
			spell.drawSpell(twoD, player);
			spell.spellCollision(Birds);
		}

		if (player.getY() >= GameConstants.Floor) {
			score.gameOver(twoD);
			System.out.println("GameOver");
			score.gameOver(twoD);
			// new MP3Player(new File("Hedwig.mp3")).stop();
			timer.stop();
		} else {
			isCollison = false;
		}
		if (player.getY() <= GameConstants.Top + 10) {
			player.isJump = false;
			System.out.println("top");
			player.setY(GameConstants.Top);
			// player.restrictTop();
		}
		// snitch.Collision(player);

		score.playerCollision(Birds, BlackClouds, player, twoD);
		// score.drawExpression(twoD, player);
		score.printingScore(twoD);

		if (score.getScore() <= 0) {
			score.setScore(0);
			score.gameOver(twoD);
			// new MP3Player(new File("Hedwig.mp3")).stop();
			timer.stop();
		}

		if (camera.getX() >= 19000) {
			camera.setX(1000);
		}

	}

	private void drawBackgrond(Graphics2D g) {

		loadImage();
		g.drawImage(image, 0, 0, GWidth, GHeight, null);

	}

}
