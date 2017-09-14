import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class EnemyBird extends Sprite {

	public EnemyBird(int x, int y, String imageName) {
		this.y = y;
		this.x = x;
		h = w = 150;
		xspeed = 30;
		fastspeed = 30;
		speed = 20;
		isCollison = false;
		top = false;
		isVisible = true;
		img = new ImageIcon(EnemyBird.class.getResource(imageName)).getImage();
		// movePlayerDown();
	}

	public void drawBird(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, w, h, null);
	}

	public void left() {
		x = x - xspeed;
	}

	// public void movePlayerDown(){
	// if(!isJump)
	// {
	// y=y+downspeed;
	// }
	// }
	public void move() {
		y = y + speed;
		if (y <= GameConstants.Top) {
			speed = 30;
		} else if (y >= GameConstants.Floor)
			speed = -30;
	}

}
