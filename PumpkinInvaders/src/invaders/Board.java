package invaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
	
	Timer t = new Timer(5, this);	//makes timer
	private boolean game;			//says whether or not the game is over
	private SpaceShip ship;			//declare SpaceShip object
	private ArrayList pumpkins;		//list of invading pumpkins
	private int[][] pos = {{700,0}, {572,0}, {444,0}, 
							{316, 0}, {188,0}};	//list of invading pumpkins positions
	
	public Board() {
		addKeyListener(new TAdapter());	//allows for key presses
		setFocusable(true);				//needed for key presses
		setBackground(Color.BLACK);		//sets background to be black
		ship = new SpaceShip();			//new SpaceShip object
		initPumpkins();					//adds the pumpkins to the arraylist
		game = true;					
		t.start();						//starts timer
	}
	public void initPumpkins() {
		pumpkins = new ArrayList();
		for(int i = 0; i < pos.length; i++) {
			pumpkins.add(new Pumpkins(pos[i][0], pos[i][1]));
		}
	}
	public void paint (Graphics g) {	//used in order to draw pictures
		super.paint(g);					//needed
		if(game) {
			Graphics2D g2d = (Graphics2D) g;	//used for 2D graphics
		
			ArrayList missile = ship.getMissiles();
			for(int i = 0;i < missile.size(); i++) {
				Missile m = (Missile)missile.get(i);
				g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
			}
			if (ship.isVisible()){
				g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this);	//draws the ship
			}
			for(int i = 0; i < pumpkins.size(); i++) {
				Pumpkins p = (Pumpkins)pumpkins.get(i);
				if(p.isVisible()) {
					g2d.drawImage(p.getImage(), p.getX(), p.getY(), this);
				}
			}
		} 
		else if(!game && pumpkins.size() == 0) {
			g.setColor(Color.WHITE);
			Font f = new Font("Times New Roman", Font.BOLD, 81);
			g.setFont(f);
			g.drawString("YOU WIN!", 200, 300);
		}
		else {
			g.setColor(Color.WHITE);
			Font f = new Font("Times New Roman", Font.BOLD, 81);
			g.setFont(f);
			g.drawString("GAME OVER", 150, 300);
		}
		Toolkit.getDefaultToolkit().sync();			//synchronizes graphics state
        g.dispose();								//gets rid of graphics
	}
	public void actionPerformed(ActionEvent e) {	//used for key presses
		if(pumpkins.size() == 0) {
			game = false;
		}
		ArrayList missile = ship.getMissiles();
		for(int i = 0; i < missile.size(); i++) {
			Missile m = (Missile)missile.get(i);
			if(m.isVisible()) {
				m.move();
			} else {
				missile.remove(i);
			}
		}
		for(int i = 0; i < pumpkins.size(); i++) {
			Pumpkins p = (Pumpkins)pumpkins.get(i);
			if(p.isVisible()) {
				p.move();
			} else {
				pumpkins.remove(i);
			}
		}
		checkCollision();
		repaint();	//re-makes the images
	}
	public void checkCollision() {
		Rectangle shipRect = ship.getBounds();
		for(int i=0; i < pumpkins.size(); i++) {
			Pumpkins p =(Pumpkins)pumpkins.get(i);
			Rectangle pumpRect = p.getBounds();
			if(shipRect.intersects(pumpRect)) {
				ship.setVisible(false);
				p.setVisible(false);
				game = false;
			}
		}
		ArrayList missile = ship.getMissiles();
		for(int i=0; i < missile.size(); i++) {
			Missile m =(Missile)missile.get(i);
			Rectangle mRect = m.getBounds();
			for(int j=0; j < pumpkins.size(); j++) {
				Pumpkins p = (Pumpkins)pumpkins.get(j);
				Rectangle pumpRect = p.getBounds();
				if(mRect.intersects(pumpRect)) {
					m.setVisible(false);
					p.setVisible(false);
				}
			}
		}
	}
	private class TAdapter extends KeyAdapter {	//used for key presses
		public void keyPressed(KeyEvent e) {
			ship.keyPressed(e);
		}
	}
}


