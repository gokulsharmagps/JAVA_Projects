import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Player extends Sprite {

	public Player() {
		y = GameConstants.Floor - 200;
		x = 150;
		h = w = 100;
		upspeed = 12;
		downspeed = 18;
		speed = 10;
		isCollison = false;
		img = new ImageIcon(Player.class.getResource("Harry1.png")).getImage();
		// movePlayerDown();
	}

	public void drawPlayer(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, w, h, null);
	}

	public void movePlayerUp() {
		if (isJump = true) {
			y = y - upspeed;
		}
	}

	public void movePlayerDown() {
		if (!isJump) {
			y = y + downspeed;
		}
	}

	// public void restrictTop(){
	// y=y+1;
	// restrictTop();
	// }

	// public void movePlayerRight(){
	// x=x+speed;
	// }
	public void movePlayerLeft() {
		if (x > 150) {
			x = x - speed;
		}

	}
}
// }

// public void Slow() {
// for(int i=downspeed;i>=10;i--){
// y=y+i;
// }
//
// }
