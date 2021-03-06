package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyPlane {
	int x,y;
	public static final int Y_DJ=15;
	int width = 15;
	int height = 20;
	MainConsole mc;
	public Random r;
	boolean live = true;
	Rectangle rd = new Rectangle(x,y,width,height);
	
	public EnemyPlane(int x,int y,MainConsole mc) {
		this.x = x;
		this.y = y;
		this.mc = mc;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x, y, width, height);
		move();
	}
	
	public void move() {
		y = y + Y_DJ;
	}
	

	
	public boolean lives() {
		return live;
	}
	
	public Rectangle getRectange() {
		return  rd;
	}
	
	public boolean zhuangJi(Plane b) {
		if(this.rd.intersects(b.rp) && this.lives() == false && b.lives() == false) {
			live = false;
			return true;
		}	
		return false;
	}
}