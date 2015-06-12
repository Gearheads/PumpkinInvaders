package invaders;

import java.awt.Image;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missile {
	
	private Image image;
	private int x;
	private int y;
	private int width;
	private int height;
	boolean visible;
	
	public Missile(int x, int y) {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("missile.jpg"));
		image = ii.getImage();
		visible = true;
		width = image.getWidth(null);
		height = image.getHeight(null);
		this.x = x;
		this.y = y;
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
	public void setVisible(boolean visable) {
		this.visible = visable;
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y , width, height);
	}
	public void move() {
		y -= 5;
		if (y < 0) {
			visible = false;
		}
	}
}