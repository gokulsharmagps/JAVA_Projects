import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Spells extends Sprite {
	boolean isRandomizing;
	public int value;

	public Spells(Player p) {
		y = p.getY();
		x = p.getX();
		isVisible = false;
		h = 100;
		w = 200;
		speed = 10;
		isCollison = false;
		isPowerUp = false;
		isRandomizing = true;
		img = new ImageIcon(Player.class.getResource("spell.png")).getImage();
		// movePlayerDown();
	}

	public void drawSpell(Graphics2D g, Player p) {
		g.drawImage(img, p.getX() + 75, p.getY() - 10, w, h, null);
		isVisible = false;
		String message = "Expecto Petronum";
		int Low = 0;
		int High = 6;
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 24));
		g.drawString(message, p.getX() + 50, (p.getY() - 10));
		isPowerUp = false;
	}

	public void spellCollision(EnemyBird b[]) {
		for (int i = 0; i <= 39; i++) {
			int xS = Math.abs(b[i].getX() - x);
			int yS = Math.abs(b[i].getY() - y);
			int width = Math.max(w, b[i].getW());
			int height = Math.max(h, b[i].getH());
			if (xS <= (width) && yS <= (height)) {
				System.out.println("SpellColl");
				b[i].isVisible = false;

			}

		}
	}

}
