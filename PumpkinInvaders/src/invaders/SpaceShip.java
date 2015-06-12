package invaders;

import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class SpaceShip {
	
	private String ship = "ship.jpg";
	private Image image;
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean visible;
	private ArrayList missiles;
	
	public SpaceShip() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(ship));
		image = ii.getImage();			//image of ship
		missiles = new ArrayList();		//list of missiles
		visible = true;					//if the ship is visible
		width = image.getWidth(null);
		height = image.getHeight(null);
		x = 400;						//starting x position
		y = 550;						//starting y position
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
	public ArrayList getMissiles() {
		return missiles;
	}	
	public void fire() {
		missiles.add(new Missile(x+35, y));
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			fire();
		}
		if (key == KeyEvent.VK_LEFT) {
			if (x >= 0) {
				x -= 7;
			}
		}
		if (key == KeyEvent.VK_RIGHT) {
			if (x <= 750) {
				x += 7;
			}
		}
		if (key == KeyEvent.VK_UP) {
			//y -= 1;
		}
		if (key == KeyEvent.VK_DOWN){
			//y += 1;
		}
	}
}
