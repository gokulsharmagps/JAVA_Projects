import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import org.apache.log4j.Logger;

public class printScore extends Sprite {
	int score = 100;
	private Logger logger = Logger.getLogger(Login_Register.class);

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void playerCollision(EnemyBird b[], Cloud c[], Player p, Graphics2D g) {
		for (int i = 0; i <= 39; i++) {
			int xD = Math.abs(b[i].getX() - p.getX());
			int yD = Math.abs(b[i].getY() - p.getY());
			int xC = Math.abs(c[i].getX() - p.getX());
			int yC = Math.abs(c[i].getY() - p.getY());
			if (xD <= (p.getW()) && yD <= (p.getH())) {
				if (b[i].isVisible == true) {
					score = score - 20;
					drawExpression(g, p);
				}
			}
			if (xC <= (p.getW()) && yC <= (p.getH())) {
				score = score - 10;
				drawExpression(g, p);
			}
		}

	}

	public void printingScore(Graphics2D g) {
		String message = "Score : " + Integer.toString(score);
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 32));
		g.drawString(message, GameConstants.GWidth / 2 + 250, 100);
	}

	public void playerSnitchCollision(Player p, Snitch s) {
		int xS = Math.abs(s.getX() - p.getX());
		int yS = Math.abs(s.getY() - p.getY());
		int width = Math.max(p.getW(), s.getW());
		int height = Math.max(p.getH(), s.getH());
		if (xS <= (width) && yS <= (height)) {
			s.isVisible = false;
			score = score + 50;
			s = null;
			System.gc();
		}
	}

	public void drawExpression(Graphics2D g, Player p) {

		String message = "aaahhh !!!";
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 32));
		g.drawString(message, p.getX() + 50, (p.getY() - 50));

	}

	public void gameOver(Graphics2D twoD) {
		String message = "Game Over";
		twoD.setColor(Color.RED);
		twoD.setFont(new Font("Arial", Font.BOLD, 32));
		twoD.drawString(message, GameConstants.GWidth / 2 - message.length() - 100, GameConstants.GHeight / 2);
		GameSplashScreen.getframe();
		GameSplashScreen.getMs().setVisible(true);
		GameSplashScreen.getframe();
		GameSplashScreen.getMs().setFocusableWindowState(false);
		GameSplashScreen.getframe();
		GameSplashScreen.getMs();
		MainScreen.getMntmGame().setEnabled(true);
		GameSplashScreen.getframe();
		GameSplashScreen.getMs();
		MainScreen.getMntmLoginregister().setEnabled(false);
		GameSplashScreen.getframe();
		GameSplashScreen.getMs();
		MainScreen.getMntmSignout().setEnabled(true);
		logger.info("Game ended with score- " + score);
	}
}
