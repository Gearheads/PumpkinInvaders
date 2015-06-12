package invaders;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Pumpkins {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean visible;
	private Image image;
	private String direction;
	private String LEFT = "left";
	private String RIGHT = "right";
	private String DOWN = "down";
	
	public Pumpkins (int x, int y) {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("evil_pumpkin.jpg"));
		image = ii.getImage();
		visible = true;
		width = image.getWidth(null);
		height = image.getHeight(null);
		direction = "left";
		this.x = x;
		this.y = y;
	}
	public void move() {
		if(direction.equals(LEFT) && x > 0) {
			x -= 1;
		}
		else if(direction.equals(RIGHT) && x < 700) {
			x += 1;
		}
		else if(direction.equals(LEFT) && x <= 0 || direction.equals(RIGHT) && x >= 700) {
			direction = DOWN;
		}
		else if(direction.equals(DOWN) && x <= 0 && y < 462) {
			y += 128;
			direction = RIGHT;
		}
		else if(direction.equals(DOWN) && x >= 700 && y < 462) {
			y += 128;
			direction = LEFT;
		}
	}
	public Image getImage() {
		return image;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
}