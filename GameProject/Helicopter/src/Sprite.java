import java.awt.Image;

public class Sprite {
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected int xspeed;
	protected Image img;
	protected boolean isJump = false;
	protected int fastspeed;
	public boolean isCollison;
	protected int speed;
	boolean top;
	public boolean isVisible = false;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getXspeed() {
		return xspeed;
	}

	public void setXspeed(int xspeed) {
		this.xspeed = xspeed;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public int getFastspeed() {
		return fastspeed;
	}

	public void setFastspeed(int fastspeed) {
		this.fastspeed = fastspeed;
	}

	public boolean isCollison() {
		return isCollison;
	}

	public void setCollison(boolean isCollison) {
		this.isCollison = isCollison;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public int getUpspeed() {
		return upspeed;
	}

	public void setUpspeed(int upspeed) {
		this.upspeed = upspeed;
	}

	public int getDownspeed() {
		return downspeed;
	}

	public void setDownspeed(int downspeed) {
		this.downspeed = downspeed;
	}

	public boolean isPowerUp() {
		return isPowerUp;
	}

	public void setPowerUp(boolean isPowerUp) {
		this.isPowerUp = isPowerUp;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	protected int upspeed;
	protected int downspeed;
	public boolean isPowerUp;
	public int value;
}
