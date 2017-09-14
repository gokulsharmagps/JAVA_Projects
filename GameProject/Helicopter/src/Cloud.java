import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Cloud extends Sprite {

	public Cloud(int x, int y, String imageName) {
		this.y = y;
		this.x = x;
		h = w = 80;
		xspeed = 60;
		fastspeed = 30;
		speed = 20;
		isCollison = false;
		top = false;
		img = new ImageIcon(Cloud.class.getResource(imageName)).getImage();
		// movePlayerDown();
	}

	@Override
	public int getW() {
		return w;
	}

	@Override
	public int getH() {
		return h;
	}

	public void drawCloud(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, w, h, null);
	}

	public void left() {
		x = x - xspeed;
	}

	public void move() {
		y = y + speed;
		if (y <= GameConstants.Top) {
			speed = 5;
		} else if (y >= GameConstants.Floor)
			speed = -5;
	}

}
