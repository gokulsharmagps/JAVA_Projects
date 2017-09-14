import java.awt.Graphics2D;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

public class Snitch extends Sprite {

	public Snitch(int x, int y, String imageName) {
		int Low = 100;
		int High = 300;
		int generate = ThreadLocalRandom.current().nextInt(Low, High + 1) + Low;
		this.y = y;
		this.x = x;
		h = w = 100;
		xspeed = 50;
		speed = 10;
		isCollison = false;
		img = new ImageIcon(Snitch.class.getResource("snitch.gif")).getImage();
		// movePlayerDown();
		isVisible = true;
	}

	public void drawSnitch(Graphics2D g) {
		// TODO Auto-generated method stub
		if (isVisible) {

			g.drawImage(img, x, y, w, h, null);
		}
	}

	public void moveSnitch() {
		// int Low= -10;
		// int High= +30;
		// speed=ThreadLocalRandom.current().nextInt(Low, High + 1)+Low;
		// x=x+speed;
		x = x - xspeed;
		// y=y-speed;
	}

	public void move() {
		y = y + speed;
		if (y <= GameConstants.Top) {
			speed = 50;
		} else if (y >= GameConstants.Floor)
			speed = -50;
	}

}
